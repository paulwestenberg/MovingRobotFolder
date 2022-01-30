import static org.junit.jupiter.api.Assertions.*;

class MovingRobotTest {

    //turn right testing:
    @org.junit.jupiter.api.Test
    void testTurnRightNorth(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="North"){
            testRobot.turnRight();
            assertEquals("East", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnRightEast(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="East"){
            testRobot.turnRight();
            assertEquals("South", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnRightSouth(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="South"){
            testRobot.turnRight();
            assertEquals("West", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnRightWest(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="South"){
            testRobot.turnRight();
            assertEquals("West", testRobot.direction);
        }
    }

    //turn left testing:
    @org.junit.jupiter.api.Test
    void testTurnLeftNorth(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="North"){
            testRobot.turnLeft();
            assertEquals("West", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnLeftWest(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="West"){
            testRobot.turnLeft();
            assertEquals("South", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnLeftSouth(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="South"){
            testRobot.turnLeft();
            assertEquals("East", testRobot.direction);
        }
    }

    @org.junit.jupiter.api.Test
    void testTurnLeftEast(){
        MovingRobot testRobot = new MovingRobot();
        if (testRobot.direction=="East"){
            testRobot.turnLeft();
            assertEquals("North", testRobot.direction);
        }
    }

    //current status testing:
    @org.junit.jupiter.api.Test
    void testCurrentStatus1(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPosX(3);
        testRobot.setPosY(5);
        testRobot.setDirection("East");
        testRobot.setPenStatus(true);
        assertEquals("Position: 3, 5 - Pen: down - Facing: East", testRobot.printCurrentStatus());
    }

    @org.junit.jupiter.api.Test
    void testCurrentStatus2(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPosX(2);
        testRobot.setPosY(1);
        testRobot.setDirection("South");
        testRobot.setPenStatus(false);
        assertEquals("Position: 2, 1 - Pen: up - Facing: South", testRobot.printCurrentStatus());
    }

    //initialize array testing:
    @org.junit.jupiter.api.Test
    void testInitializeArrayLength() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        assertEquals(5, testRobot.floorArrays.length);
    }

    @org.junit.jupiter.api.Test
    void testInitializeArrayPosX() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        assertEquals(0, testRobot.posX);
    }

    @org.junit.jupiter.api.Test
    void testInitializeArrayPosY() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        assertEquals(0, testRobot.posY);
    }

    @org.junit.jupiter.api.Test
    void testInitializeArrayDirection() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        assertEquals("North", testRobot.direction);
    }

    @org.junit.jupiter.api.Test
    void testInitializeArrayPenStatus() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        assertEquals(false, testRobot.penStatus);
    }

    @org.junit.jupiter.api.Test
    void printArray() {

    }

    //setters testing:
    @org.junit.jupiter.api.Test
    void setPosX() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPosX(5);
        assertEquals(5, testRobot.posX);
    }

    @org.junit.jupiter.api.Test
    void setPosY() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPosY(5);
        assertEquals(5, testRobot.posY);
    }

    @org.junit.jupiter.api.Test
    void setPenStatus() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPenStatus(true);
        assertEquals(true, testRobot.penStatus);
    }

    @org.junit.jupiter.api.Test
    void setDirection() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setDirection("West");
        assertEquals("West", testRobot.direction);
    }

}