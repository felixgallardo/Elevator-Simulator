import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * The Simulator class creates an array of elevators. It then has a method, sim, which
 * takes a request, number of floors, numbre of elevators and the length of the sim. Afterwards,
 * it runs the sim method which populates the elevator array based on the number of elevators,
 * assigns the elevator with requests and handles those requests. It moves the elevators according
 * to the generated source and destination floors, and dequeues requests accordingly.
 *
 * */

public class Simulator {

    static Elevator[] elevatorArray ;
    static NumberFormat formatter = new DecimalFormat("#0.00");

    /**
     * The sim method takes in four values; a request (the request the elevator is handling),
     * floorNum (the number of floors in the simulation), the numOfElevators and the
     * length of time the sim will be run.
     * @param request
     * @param floorNum
     * @param numOfElevators
     * @param simLength
     * @return
     */
    public static String sim(double request, int floorNum,
                             int numOfElevators, int simLength) {

        // set this to true if you want print statements about requests and elevators!!
        boolean debug = false;


        int waitTime = 0; //Time from when request joins queue to when it gets on elevator
        int totalReq = 0; //Total number of request
        /**
         * Here, we make a new array of elevators based on the number of elevators the user
         * would like to have in the sim, and create Elevator objects to populate the array.
         */
        elevatorArray = new Elevator[numOfElevators];
        for (int i = 0; i < numOfElevators; i++) {
            elevatorArray[i] = new Elevator();
        }
        int counter = 1;
        int reqFulfilled = 0;
        /**
         * We then create a BooleanSource object to handle probability error checking and a
         * RequestQueue object to create a linked list of requests.
         */
        BooleanSource booleanS = new BooleanSource(request);
        RequestQueue requestQ = new RequestQueue();
        Request newRequest;
        /**
         * While the counter, which we initialize up top and are incrementing, is less than
         * or equal to the length of time the user would to run the simulation, we loop
         */
        while (counter <= simLength) {
            /**
             * If RequestArrived returns true, we create a request which takes in the number of floors,
             * and set the new requests's time entered to counter.
             * We also increment our total request variable to represent the number of requests we've
             * gotten while running the simulation.
             */
            if (booleanS.requestArrived()) {
                newRequest = new Request(floorNum); //makes new request
                newRequest.setTimeEntered(counter); // sets time request made
                requestQ.enqueue(newRequest); // adds request to queue

                totalReq++;

                /*System.out.println("A request arrives from Floor " + newRequest.getSourceFloor() +
                        " to Floor " + newRequest.getDestinationFloor());*/
                //Check if elevator's idle to handle the previously made request

            }
            /**
             * We set the queue's front node as temp.
             */
            Request temp = requestQ.peek();

            //Take off request from queue and give it to elevator
            /**
             * Once the request has been made, we create a for loop which checks each of the
             * elevator's states. If they're ideal, we set the elevator's request to the
             * request that's at the front of the queue.
             */
            if (temp != null){ // check to see if there is a request waiting
            for (int i = 0; i < numOfElevators; i++) {
                //If elevator's idle, we give it a request to handle
                if (elevatorArray[i].getElevatorState() == 0) {
                    elevatorArray[i].setRequest(temp);
                    /**
                     * If the elevator's current floor isn't equal to the source floor, we set it to
                     * on the way to the source floor to pick someone up
                     */
                    if (elevatorArray[i].getCurrentFloor() != temp.getSourceFloor()) {
                        elevatorArray[i].setElevatorState(1);
                    } else {
                        //Else, the elevator is on same floor as person
                        elevatorArray[i].setElevatorState(2);
                    }

                    /*System.out.println("The request was entered at " + temp.getTimeEntered() + " and" +
                            " removed at " + counter);*/
                    /**
                     * Increment the wait time after request's been assigned and dequeue the
                     * request from the queue, as it's been handled by the elevator.
                     */

                //So since we set timeEntered = counter, counter-counter = 0.
                    waitTime += (counter - temp.getTimeEntered());
                    requestQ.dequeue(temp);

                    //Break so only the first idle elevator gets a request
                    break;
                }
            } //End for, taking request off queue
            }
            /**
             * We create a for-loop that makes sure that while there's an existing elevator,
             * we set the elevator's request to curr. We then check the elevator's
             * status; if the source elevator is below the person, we send it up. If it's
             * above, we send it down.
             */
            Request curr;
            for (int i = 0; i < numOfElevators; i++){
                //If the elevator is picking someone up
                curr = elevatorArray[i].getRequest();
                if (elevatorArray[i].getElevatorState() == 1){
                    if (elevatorArray[i].getCurrentFloor() < curr.getSourceFloor()){
                        // if elevator is below person
                        elevatorArray[i].setCurrentFloor(elevatorArray[i].getCurrentFloor()+1);
                    } else if(elevatorArray[i].getCurrentFloor() > curr.getSourceFloor()){
                        elevatorArray[i].setCurrentFloor(elevatorArray[i].getCurrentFloor()-1);
                    }

                    if (elevatorArray[i].getCurrentFloor() == curr.getSourceFloor()){
                        elevatorArray[i].setElevatorState(2);
                    }
                    /**
                     * When the elevator's dropping someone off, if the destination is below
                     * the current floor, we move the elevator down. If the destination is
                     * above the current floor, we move the elevator up.
                     */
                } else if (elevatorArray[i].getElevatorState() == 2){ // elevator dropping someone off
                    if (elevatorArray[i].getCurrentFloor() < curr.getDestinationFloor()){
                        //If elevator is below destination
                        elevatorArray[i].setCurrentFloor(elevatorArray[i].getCurrentFloor()+1);
                    } else if (elevatorArray[i].getCurrentFloor() > curr.getDestinationFloor()){
                        elevatorArray[i].setCurrentFloor(elevatorArray[i].getCurrentFloor()-1);
                    }                     /**
                     * Once all destination cases have been handled for picking up and dropping off
                     * passengers, we set the elevator to idle and the request in the array to null.
                     */
                    if (elevatorArray[i].getCurrentFloor() == curr.getDestinationFloor()){
                        //Person has arrived
                        elevatorArray[i].setElevatorState(0);
                        //Remove request because it's finished
                        elevatorArray[i].setRequest(null);
                        reqFulfilled++;
                    }


                } //End drop off
            } //End elevator moving


            /**
             * An if that allows us to print out the information of test-values to make sure
             * the simulation's running properly.
             */
            if (debug){
                System.out.println("Current time is " + counter);
                String elevatorInfo = ""; //Holds information about elevators
                //Print out request queue
                System.out.println("Requests: " + requestQ + "\n");

                //Builds elevatorInfo
                for (int i = 0; i < elevatorArray.length; i++){
                    elevatorInfo+= "[" + elevatorArray[i].getCurrentFloor() + ", ";
                    switch (elevatorArray[i].getElevatorState()){
                        case 0: elevatorInfo+= "Idle, "; break;
                        case 1: elevatorInfo += "To source, "; break;
                        case 2: elevatorInfo += "To destination,"; break;
                    }
                    // checks to see if there is a request so it doesn't try to print null
                    if (elevatorArray[i].getRequest() != null){
                        elevatorInfo+= elevatorArray[i].getRequest().toString() + "]";
                    } else {
                        elevatorInfo+= " ---]";
                    }

                }
                System.out.println("Elevators: " + elevatorInfo + "\n\n" );

            } //End debug
            counter++;
        }//End of while
        /**
         * After formatting the information with the previous if, we return a string containing
         * the total wait time, total requests and the average wait time based on the
         * total wait time and total requests.
         */
        /*
        System.out.println("Total wait time: " + waitTime + "\n");
        System.out.println("Total requests: " + totalReq);
        System.out.println("Total requests fulfilled: " + reqFulfilled);*/

        double avgTime=0;
        if (reqFulfilled !=0){
            avgTime = (double)waitTime/(double)reqFulfilled;
        }
        return "Total wait time: " + waitTime +"\nTotal requests fulfilled: " + reqFulfilled + "\nAverage wait time: "
                + formatter.format(avgTime);
    }
}
