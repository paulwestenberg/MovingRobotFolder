import java.util.*;

public class MovingRobot {
    public int posX=0;
    public int posY=0;
    public String direction="North";
    //for the pen 
    //if true -> pen down (writing)
    //if false -> pen up (not writing)
    public boolean PenStatus=false;

    int[][] floorArrays = new int[10][10];

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
        return PenStatus;
    }
    public String getDirection(){
        return direction;
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

                if (myRobot.direction.equals("North")){
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
                else if(myRobot.direction.equals("West")){
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
                else if(myRobot.direction.equals("South")){
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
                else if(myRobot.direction.equals("East")){
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
