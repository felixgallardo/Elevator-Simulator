
/**
 *
 * @author Felix Gallardo
 * ID: 108496237
 * Homework #3
 * CSE 214: Recitation Section 1
 * Recitation TA: Mohammad Mahdi Javanmard
 * Grading TA: Jian Xu
 *
 * The Elevator class is the class which holds the currentfloor, elevatorState, a request
 * object and the different kinds of elevatorStates, including IDLE, TO_SOURCE and TO_DESTINATION.
 * As well as these variables, it holds the Elevator method which sets the Linked List we create
 * to null. Finally, the Elevator class has the accessor and mutator methods for the previously
 * defined variables.
 *
 * */

public class Elevator {

    /**
     * The variables held by the Elevator object are declared here; they allow us to
     * set the elevator's current floor and the state of the elevator (IDLE, going to
     * the source floor or destination floor).
     */
    private int currentFloor = 1;
    private int elevatorState;
    private Request request;
    final int IDLE = 0;
    final int TO_SOURCE = 1;
    final int TO_DESTINATION = 2;


    /**
     * The Elevator method sets the current request the elevator object is handling
     * as null, the state of the elevator as idle (thus not handling a request) and
     * the current floor of the elevator to 1.
     */
    public void Elevator() {
        this.request = null;
        this.elevatorState = IDLE;
        this.currentFloor = 1;
    }

    /**
     * In the setCurrentFloor method, the user passes an int variable - the currentFloor, and we
     * set the passed value as the elevator's current floor.
     * @param currentFloor
     */
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    /**
     *  In the setElevatorState method, the user passes an int variable - the elevatorState, and we
     * set the passed value as the elevator's current state, whether that's
     * idle, to source or to destination.
     * @param elevatorState
     */
    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    /**
     * In the setRequest method, the user passes a request object, request, and we
     * set the passed value as the request the elevator's currently handling.
     * @param request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * The getCurrentFloor method, the user is able to retrieve
     * the object's current floor value.
     * @return
     */
    public int getCurrentFloor() {
        return currentFloor;
    }

    /**
     * In the getElevatorState method, the user is able to retrieve the
     * elevator object's current state, whether that's idle, to source or
     * to destination.
     * @return
     */
    public int getElevatorState() {
        return elevatorState;
    }

    /**
     * In the getRequest method, the user is able to get the request the
     * elevator's handling.
     * @return
     */
    public Request getRequest() {
        return request;
    }
}
