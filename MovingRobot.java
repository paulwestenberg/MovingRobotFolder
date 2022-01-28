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

    //getters:
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public boolean getPenStatus(){
        return penStatus;
    }
    public String getDirection(){
        return direction;
    }
    public int getArraySize(){
        return floorArrays.length;
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
                if (myRobot.direction.equals("North")){
                    myRobot.setDirection("East");
                }
                else if(myRobot.direction.equals("East")){
                    myRobot.setDirection("South");
                }
                else if(myRobot.direction.equals("South")){
                    myRobot.setDirection("West");
                }
                else if(myRobot.direction.equals("West")){
                    myRobot.setDirection("North");
                }
            }

            //turn left code
            else if (commandEntered.equals("L") || commandEntered.equals("l")){
                if (myRobot.direction.equals("North")){
                    myRobot.setDirection("West");
                }
                else if(myRobot.direction.equals("West")){
                    myRobot.setDirection("South");
                }
                else if(myRobot.direction.equals("South")){
                    myRobot.setDirection("East");
                }
                else if(myRobot.direction.equals("East")){
                    myRobot.setDirection("North");
                }
            }

            //print array code
            else if (commandEntered.equals("P") || commandEntered.equals("p")){
                myRobot.printArray();
            }

            //print current position of pen, wether it is up or down and direction
            else if (commandEntered.equals("C") || commandEntered.equals("c")){
                String penStatus;
                if (myRobot.getPenStatus()){
                    penStatus = "down";
                }
                else{
                    penStatus = "up";
                }
                System.out.print("Position: " + myRobot.getPosX() + ", " + myRobot.getPosY() + " - ");
                System.out.print("Pen: "+ penStatus + " - ");
                System.out.println("Facing: " + myRobot.getDirection());
            }

            //move forward code
            else if (mixedStringArray[0].equals("M") || mixedStringArray[0].equals("m")){
                //move forward by s spaces where s is:
                int s = Integer.parseInt(mixedStringArray[1]);
                //need to set exception for s not being an integer
                
                String warningMsg = "Error - Robot out of bounds";

                //robot moves up:
                if (myRobot.direction.equals("North")){
                    if (myRobot.getPosX()+s>=myRobot.getArraySize()){
                        System.out.println(warningMsg);
                    }
                    else {
                        if (myRobot.getPenStatus()){
                            myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            for (int index=0; index<s; index++){
                                myRobot.setPosX(myRobot.getPosX()+1);
                                myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            }
                        }
                        else{
                            for (int index=0; index<s; index++){
                                myRobot.setPosX(myRobot.getPosX()+1);
                            }
                        }
                    }
                }
                //robot moves left:
                else if(myRobot.direction.equals("West")){
                    if (myRobot.getPosY()-s<0){
                        System.out.println(warningMsg);
                    }
                    else {
                        if (myRobot.getPenStatus()){
                            myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            for (int index=0; index<s; index++){
                                myRobot.setPosY(myRobot.getPosY()-1);
                                myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            }
                        }
                        else{
                            for (int index=0; index<s; index++){
                                myRobot.setPosY(myRobot.getPosY()-1);
                            }
                        }
                    }
                }
                //robot moves down:
                else if(myRobot.direction.equals("South")){
                    if (myRobot.getPosX()-s<0){
                        System.out.println(warningMsg);
                    }
                    else {
                        if (myRobot.getPenStatus()){
                            myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            for (int index=0; index<s; index++){
                                myRobot.setPosX(myRobot.getPosX()-1);
                                myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            }
                        }
                        else{
                            for (int index=0; index<s; index++){
                                myRobot.setPosX(myRobot.getPosX()-1);
                            }
                        } 
                    }
                }
                //robot moves right:
                else if(myRobot.direction.equals("East")){
                    if (myRobot.getPosY()+s>=myRobot.getArraySize()){
                        System.out.println(warningMsg);
                    }
                    else {
                        if (myRobot.getPenStatus()){
                            myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            for (int index=0; index<s; index++){
                                myRobot.setPosY(myRobot.getPosY()+1);
                                myRobot.floorArrays[myRobot.getPosX()][myRobot.getPosY()] = 1;
                            }
                        }
                        else{
                            for (int index=0; index<s; index++){
                                myRobot.setPosY(myRobot.getPosY()+1);
                            }
                        } 
                    }
                }
            }

            //Initialize new array code:
            else if (mixedStringArray[0].equals("I") || mixedStringArray[0].equals("i")){
                //initialize the array of size n where n is:

                int n = Integer.parseInt(mixedStringArray[1]);
                //need to set exception for n not being an integer
                myRobot.initializeArray(n);
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
