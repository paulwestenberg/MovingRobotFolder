import java.util.*;

public class MovingRobot {
    public int posX=0;
    public int posY=0;
    public String direction="North";
    //for the pen 
    //if true -> pen down (writing)
    //if false -> pen up (not writing)
    public boolean penStatus=false;

    //default array will be a 10*10

    int[][] floorArrays = new int[10][10];

    void initializeArray(int n){
        floorArrays = new int[n][n];
        posX = 0;
        posY = 0;
        direction = "North";
        penStatus = false;
    }

    void turnRight(){
        if (direction.equals("North")){
            setDirection("East");
        }
        else if(direction.equals("East")){
            setDirection("South");
        }
        else if(direction.equals("South")){
            setDirection("West");
        }
        else if(direction.equals("West")){
            setDirection("North");
        }
    }

    void turnLeft(){
        if (direction.equals("North")){
            setDirection("West");
        }
        else if(direction.equals("West")){
            setDirection("South");
        }
        else if(direction.equals("South")){
            setDirection("East");
        }
        else if(direction.equals("East")){
            setDirection("North");
        }
    }

    void printArray(){
        int n = floorArrays.length;
        String[][] tempArray = new String[n][n];
        for (int i=0; i<floorArrays.length; i++){
            for (int j=0; j<floorArrays.length; j++){
                if (floorArrays[i][j] == 0){
                    tempArray[i][j] = " ";
                }
                else {
                    tempArray[i][j] = "*";
                }
            }
        }

        for (int i=tempArray.length-1; i>=0; i--){
            System.out.print(i + " ");
            for (int j=0; j<tempArray.length; j++){
                System.out.print(tempArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int j=0; j<tempArray.length; j++){
            System.out.print(j + " ");
        }
        System.out.println();
    }

    String printCurrentStatus(){
        String penStatusString;
        if (penStatus){
            penStatusString = "down";
        }
        else{
            penStatusString = "up";
        }
        return "Position: " + posX + ", " + posY + " - Pen: "+ penStatusString + " - Facing: " + direction;
    }

    void move(int s){
        String warningMsg = "Error - Robot out of bounds";
        //robot moves up:
        if (direction.equals("North")){
            if (posX+s>= floorArrays.length){
                System.out.println(warningMsg);
            }
            else {
                if (penStatus){
                    floorArrays[posX][posY] = 1;
                    for (int index=0; index<s; index++){
                        setPosX(posX+1);
                        floorArrays[posX][posY] = 1;
                    }
                }
                else{
                    for (int index=0; index<s; index++){
                        setPosX(posX+1);
                    }
                }
            }
        }
        //robot moves left:
        else if(direction.equals("West")){
            if (posY-s<0){
                System.out.println(warningMsg);
            }
            else {
                if (penStatus){
                    floorArrays[posX][posY] = 1;
                    for (int index=0; index<s; index++){
                        setPosY(posY-1);
                        floorArrays[posX][posY] = 1;
                    }
                }
                else{
                    for (int index=0; index<s; index++){
                        setPosY(posY-1);
                    }
                }
            }
        }
        //robot moves down:
        else if(direction.equals("South")){
            if (posX-s<0){
                System.out.println(warningMsg);
            }
            else {
                if (penStatus){
                    floorArrays[posX][posY] = 1;
                    for (int index=0; index<s; index++){
                        setPosX(posX-1);
                        floorArrays[posX][posY] = 1;
                    }
                }
                else{
                    for (int index=0; index<s; index++){
                        setPosX(posX-1);
                    }
                }
            }
        }
        //robot moves right:
        else if(direction.equals("East")){
            if (posY+s>= floorArrays.length){
                System.out.println(warningMsg);
            }
            else {
                if (penStatus){
                    floorArrays[posX][posY] = 1;
                    for (int index=0; index<s; index++){
                        setPosY(posY+1);
                        floorArrays[posX][posY] = 1;
                    }
                }
                else{
                    for (int index=0; index<s; index++){
                        setPosY(posY+1);
                    }
                }
            }
        }
    }
    
    //setters:
    public void setPosX(int i){
        posX=i;
    }
    public void setPosY(int j){
        posY=j;
    }
    public void setPenStatus(boolean k){
        penStatus=k;
    }
    public void setDirection(String d){
        direction = d;
    }

    //check if integer:
    public boolean isStringInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex)
        {
            return false;
        }
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello Robot");
        MovingRobot myRobot = new MovingRobot();
        String commandEntered;

        do{
            System.out.println("Enter Desired Command:");
            commandEntered = sc.nextLine();
            String[] mixedStringArray = commandEntered.split(" ");

            //set pen up code
            if (commandEntered.equals("U") || commandEntered.equals("u")){
                myRobot.setPenStatus(false);
            }

            //set pen down code
            else if (commandEntered.equals("D") || commandEntered.equals("d")){
                myRobot.setPenStatus(true);
            }

            //turn right code
            else if (commandEntered.equals("R") || commandEntered.equals("r")){
                myRobot.turnRight();
            }

            //turn left code
            else if (commandEntered.equals("L") || commandEntered.equals("l")){
                myRobot.turnLeft();
            }

            //print array code
            else if (commandEntered.equals("P") || commandEntered.equals("p")){
                myRobot.printArray();
            }

            //print current status of robot
            else if (commandEntered.equals("C") || commandEntered.equals("c")){
                System.out.println(myRobot.printCurrentStatus());
            }

            //move forward code
            else if (mixedStringArray[0].equals("M") || mixedStringArray[0].equals("m")){

                //move forward by s spaces where s is:
                if (myRobot.isStringInt(mixedStringArray[1])){
                    int s = Integer.parseInt(mixedStringArray[1]);
                    myRobot.move(s);
                }
                //need to set exception for s not being an integer
                else{
                    System.out.println("Invalid Command");
                }
            }

            //Initialize new array code:
            else if (mixedStringArray[0].equals("I") || mixedStringArray[0].equals("i")){
                //initialize array of size n
                if (myRobot.isStringInt(mixedStringArray[1])){
                    int n = Integer.parseInt(mixedStringArray[1]);
                    myRobot.initializeArray(n);
                }
                //need to set exception for n not being an integer
                else{
                    System.out.println("Invalid Command");
                }
            }

            //Quit program code:
            else if (commandEntered.equals("Q") || commandEntered.equals("q")){
                //do nothing - this is simply to skip the invalid command prompt
            }

            //Any other command is invalid:
            else {
                System.out.println("Invalid Command");
            }
        }
        while(!(commandEntered.equals("Q") || commandEntered.equals("q")));

        System.out.println("Program Terminated");
        System.out.println("Thank you for participating");
    }

}
