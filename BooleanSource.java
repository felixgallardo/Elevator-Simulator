/**
 *
 * @author Felix Gallardo
 * ID: 108496237
 * Homework #3
 * CSE 214: Recitation Section 1
 * Recitation TA: Mohammad Mahdi Javanmard
 * Grading TA: Jian Xu
 *
 * The BooleanSource class checks to see if the probability entered is greater than or equal to 0 and
 * checks whether a request has arrived by generating a number, comparing it to the probability and
 * returning true or false depending on whether the generated number is smaller than the probability.
 *
 * */

public class BooleanSource {

    private double probability;

    /**
     * The BooleanSource class houses two methods - the BooleanSource and requestArrived
     * method. The BooleanSource method checks to make sure the probability passed is between 0 and 1,
     * as if it's less than or greather than 1, the probability isn't valid and thus
     * an Illegal argument exception is thrown.
     * @param prob
     */
    public BooleanSource(double prob) {
        if ((prob < 0) || (1 < prob))
            throw new IllegalArgumentException("Illegal p: " + prob);
        probability = prob;
    }

    //Boolean that returns true or false based on probability.

    /**
     * The RequestArrived returns true or false depending on whether the number generated
     * is greater than or less than the probability variable we declared earlier.
     * @return
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }


}
