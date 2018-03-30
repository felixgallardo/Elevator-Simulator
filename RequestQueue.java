
/**
 *
 * @author Felix Gallardo
 * ID: 108496237
 * Homework #3
 * CSE 214: Recitation Section 1
 * Recitation TA: Mohammad Mahdi Javanmard
 * Grading TA: Jian Xu
 *
 * The RequestQueue method creates the linked lists and holds the methods which allow
 * us to utilize the linked list. Among those methods are the enqueue, dequeue, size,
 * peek, isEmpty and toString methods.
 *
 * */

import java.util.*;

public class RequestQueue extends LinkedList {
    /**
     * Here, we declare the linked list's head and tail as request objects.
     */
    private Request head;
    private Request tail;
   // private Request cursor;

    /**
     * A Linked List is created by the name of "data".
     */
    LinkedList<Request> data = new LinkedList<Request>();

    /**
     * The RequestQueue method sets the linked list's head and tail
     * equal to null, so we always start off with an empty list.
     */
    public RequestQueue() {
        head = null;
        tail = null;
       // cursor = null;
    }

    /**
     * The enqueue method takes in a request object and adds that object
     * to our linked list.
     * @param request
     */
    public void enqueue(Request request) {
        data.add(request);
    }

    /**
     * The enqueue method takes in an object and removes that object from
     * the linked list.
     * @param dequeueReq
     * @return
     */
    public Request dequeue(Request dequeueReq) {
        data.remove(dequeueReq);
        return dequeueReq;
    }

    /**
     * The peek method allows us to see the object that's at the front
     * of the linked list without changing it.
     * @return
     */
    public Request peek(){
        return  data.peek();
    }

    /**
     * The size method allows us to check the size of the linked list.
     * @return
     */
    public int size() {
        return data.size();
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     * @return
     */
    public boolean isEmpty() {
        if (data.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * The toString method loops through the list and adds the data from every
     * node to a String variable, temp. Temp is then returned.
     * @return
     */
    @Override
    public String toString(){
        String temp = "";
        for (int i = 0; i < data.size(); i++){
            temp += data.get(i) + " ";
        }
        return temp;
    }
}
