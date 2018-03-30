
/**
 *
 * The Request class holds the information of the request that the elevator object is
 * currently handling. Among that information is the elevator's source floor (where the elevator
 * started), the elevator's destination floor (where the elevator's headed), as well as the time
 * the request was enetered (timeEntered).
 *
 * */

public class Request {

    /**
     * Here, we declare the sourceFloor (floor the elevator's coming from) variable, the
     * destinationfloor (floor the elevator's headed to) and the timeEntered variable
     * (the time the request was placed.)
     */
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered; //The time that the request was placed


    /**
        The Request constructor takes in the number of floors.
        It then generates a random source floor (as in the floor the user
        came from (1 - floorNum, inclusive), and a random destination floor that
        the user is going to (1 - floorNum, inclusive). It also makes sure
        that if the sourceFloor is equal to the destination floor, the
        sourceFloor and destinationFloor are rerolled.
     */
    public Request(int floorNum) {
        sourceFloor = (int)(Math.random() * (floorNum - 1 + 1)) + 1;
        destinationFloor = (int)(Math.random() * (floorNum - 1 + 1)) + 1;

        // rerolls source and destination if same
        while(sourceFloor == destinationFloor){
            sourceFloor = (int)(Math.random() * (floorNum - 1 + 1)) + 1;
            destinationFloor = (int)(Math.random() * (floorNum - 1 + 1)) + 1;
        }
    }

    /**
     * The setSourceFloor method takes in an int value, sourceFloor, and
     * sets the object's sourcefloor as the given value.
     * @param sourceFloor
     */
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    /**
     * The setDestinationFloor method takes in an int value, destinationFloor, and
     * sets the object's destinationFloor as the given value.
     * @param destinationFloor
     */
    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    /**
     * The setTimeEntered method takes in an int value, timeEntered, and
     * sets the object's timeEntered as the given value.
     * @param timeEntered
     */
    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    /**
     * The getSourceFloor method returns the object's sourceFloor value.
     * @return
     */
    public int getSourceFloor() {
        return sourceFloor;
    }

    /**
     * The getDestinationFloor method returns the object's destination floor.
     * @return
     */
    public int getDestinationFloor() {
        return destinationFloor;
    }

    /**
     * The getTimeEntered method returns the time the request was entered.
     * @return
     */
    public int getTimeEntered() {
        return timeEntered;
    }

    /**
     * The toString method allows us to print out the given request, including
     * the source floor, destination floor and the time entered.
     * @return
     */
    @Override
    public String toString(){
        return "(" + sourceFloor + ", " + destinationFloor + ", " + timeEntered + ")";
    }
}
