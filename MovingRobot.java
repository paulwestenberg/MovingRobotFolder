import java.util.*;

public class MovingRobot {
    public int posX=0;
    public int posY=0;

    //for the pen 
    //if true -> pen down (writing)
    //if false -> pen up (not writing)
    public boolean PenStatus=false;

    int[][] floorArrays = new int[3][3];

    void createArray(int n){
        
    }
    void initializeArray(){
        for (int i=0; i<floorArrays.length; i++){
            for (int j=0; j<floorArrays.length; j++){
                floorArrays[i][j] = 0;
            }
        }
    }
    void printArray(){
        for (int i=floorArrays.length-1; i>=0; i--){
            System.out.print(i + " ");
            for (int j=0; j<floorArrays.length; j++){
                System.out.print(floorArrays[i][j] + " ");
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int j=0; j<floorArrays.length; j++){
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
        PenStatus=k;
    }

    //getters:
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public boolean getPenStatus(){
        return PenStatus;
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

            if (commandEntered.equals("U") || commandEntered.equals("u")){
                myRobot.setPenStatus(false);
            }
            else if (commandEntered.equals("D") || commandEntered.equals("d")){
                myRobot.setPenStatus(true);
            }
            else if (commandEntered.equals("R") || commandEntered.equals("r")){
                //turn right code
            }
            else if (commandEntered.equals("L") || commandEntered.equals("l")){
                //turn left code
            }
            else if (commandEntered.equals("P") || commandEntered.equals("p")){
                myRobot.printArray();
                //print array code
            }
            else if (commandEntered.equals("C") || commandEntered.equals("c")){
                //print current position of pen and wether it is up or down
            }
            else if (mixedStringArray[0].equals("M") || mixedStringArray[0].equals("m")){
                //move forward by s spaces where s is:
                int s = Integer.parseInt(mixedStringArray[1]);
                //need to set exception for s not being an integer
            }
            else if (mixedStringArray[0].equals("I") || mixedStringArray[0].equals("i")){
                //initialize the array of size n where n is:
                int n = Integer.parseInt(mixedStringArray[1]);
                //need to set exception for n not being an integer
                myRobot.initializeArray();
            }
            else if (commandEntered.equals("Q") || commandEntered.equals("q")){
                //do nothing - this is simply to skip the invalid command prompt
            }
            else {
                System.out.println("Invalid Command");
            }
        }
        while(!(commandEntered.equals("Q") || commandEntered.equals("q")));

        //System.out.println(myRobot.getPenStatus());
        System.out.println("Program Terminated");
        System.out.println("Thank you for participating");
    }


}
