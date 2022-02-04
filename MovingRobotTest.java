import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

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

    //print array testing
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @org.junit.jupiter.api.Test
    void testPrintArray1() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(3);
        testRobot.printArray();
        assertEquals("2       \n1       \n0       \n  0 1 2", outputStreamCaptor.toString().trim());
    }
    @org.junit.jupiter.api.Test
    void testPrintArray2() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(5);
        testRobot.move(3);
        testRobot.setPenStatus(true);
        testRobot.turnRight();
        testRobot.move(4);
        testRobot.turnRight();
        testRobot.move(2);
        testRobot.printArray();
        assertEquals("4           \n3 * * * * * \n2         * \n1         * \n0           \n  0 1 2 3 4", outputStreamCaptor.toString().trim());
    }
    @org.junit.jupiter.api.Test
    void testPrintArray3() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.initializeArray(4);
        testRobot.turnRight();
        testRobot.move(1);
        testRobot.setPenStatus(true);
        testRobot.turnLeft();
        testRobot.move(3);
        testRobot.printArray();
        assertEquals("3   *     \n2   *     \n1   *     \n0   *     \n  0 1 2 3", outputStreamCaptor.toString().trim());
    }

    //move testing
    @org.junit.jupiter.api.Test
    void testMovePosXWithPenUp(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.move(5);
        assertEquals(5, testRobot.posX);
    }
    @org.junit.jupiter.api.Test
    void testMovePosYWithPenUp(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.setDirection("East");
        testRobot.move(5);
        assertEquals(5, testRobot.posY);
    }
    @org.junit.jupiter.api.Test
    void testMovePosXWithPenDown(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPenStatus(true);
        testRobot.move(5);
        assertEquals(1, testRobot.floorArrays[0][0]);
        assertEquals(1, testRobot.floorArrays[1][0]);
        assertEquals(1, testRobot.floorArrays[2][0]);
        assertEquals(1, testRobot.floorArrays[3][0]);
        assertEquals(1, testRobot.floorArrays[4][0]);
        assertEquals(1, testRobot.floorArrays[5][0]);
        assertEquals(0, testRobot.floorArrays[6][0]);
        assertEquals(5, testRobot.posX);
    }
    @org.junit.jupiter.api.Test
    void testMovePosYWithPenDown(){
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPenStatus(true);
        testRobot.setDirection("East");
        testRobot.move(5);
        assertEquals(1, testRobot.floorArrays[0][0]);
        assertEquals(1, testRobot.floorArrays[0][1]);
        assertEquals(1, testRobot.floorArrays[0][2]);
        assertEquals(1, testRobot.floorArrays[0][3]);
        assertEquals(1, testRobot.floorArrays[0][4]);
        assertEquals(1, testRobot.floorArrays[0][5]);
        assertEquals(0, testRobot.floorArrays[0][6]);
        assertEquals(5, testRobot.posY);
    }

    @org.junit.jupiter.api.Test
    void testQuitting(){
        String input = "Q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        MovingRobot.main(new String[0]);
        assertEquals("Hello Robot\n" +
                "Enter Desired Command:\n" +
                "Program Terminated\n" +
                "Thank you for participating", outputStreamCaptor.toString().trim());
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
    void setPenStatusTrue() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPenStatus(true);
        assertEquals(true, testRobot.penStatus);
    }
    @org.junit.jupiter.api.Test
    void setPenStatusFalse() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setPenStatus(false);
        assertEquals(false, testRobot.penStatus);
    }

    @org.junit.jupiter.api.Test
    void setDirection() {
        MovingRobot testRobot = new MovingRobot();
        testRobot.setDirection("West");
        assertEquals("West", testRobot.direction);
    }

}