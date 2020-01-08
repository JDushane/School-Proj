package functions;

import java.util.ArrayList;

/**
 * Provides implementation of the mathematical sum
 * @Author Jackson Dushane
 */
public class Sum extends Function {
    public Function[] sumAll;

    /**
     * Takes an unlimited amount of term parameters in order to construct an array of functions
     * to be added together
     *
     * Also applies simplification in order to make the end result cleaner
     * @param terms
     */
    public Sum(Function... terms){
        double sumAdded = 0;
        ArrayList<Function> exes = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].isConstant()){
                sumAdded += terms[i].evaluate(69);
            }
            else{
                exes.add(terms[i]);
            }
        }
        sumAll = new Function[1 + exes.size()];

        for (int i = 0; i < exes.size(); i++) {
            sumAll[i] = exes.get(i);
        }

        sumAll[sumAll.length-1] = new Constant(sumAdded);

        ArrayList<Function> simplyfyed = new ArrayList<>();
        for (int i = 0; i < sumAll.length; i++) {
            if (sumAll[i].evaluate(1) != 0){
                simplyfyed.add(sumAll[i]);
            }
        }

        sumAll = simplyfyed.toArray(Function[]::new);
    }

    /**
     * Evaluates the product @ value X
     * @param value for X
     * @returns a double of the evaluation
     */
    @Override
    public double evaluate(double value) {
        double total = 0;
        for (Function term: sumAll) {
            total += term.evaluate(value);
        }
        return total;
    }

    /**
     * Checks if any of the terms are constant
     * If so, the product isnt constant
     * @returns a boolean on the state of the sum
     */
    @Override
    public boolean isConstant() {
        for (Function term : sumAll) {
            if (!term.isConstant()){
                return false;
            }
        }
        return true;
    }

    /**
     * Takes the derivative of all of the sums and adds them together
     * @returns a functional derivative
     */
    @Override
    public Function derivative() {
        Function[] derivlist = new Function[sumAll.length];
        for (int i = 0; i < sumAll.length; i++) {
            derivlist[i] = sumAll[i].derivative();
        }
        return new Sum(derivlist);
    }

    /**
     * Implementation of the trapezoidal rule in java form
     * https://en.wikipedia.org/wiki/Numerical_integration#Methods_for_one-dimensional_integrals
     * @param lower
     * @param upper
     * @param granul
     * @return a double of the integrals value
     */
    @Override
    public double integral(double lower, double upper, double granul) {
        double area = 0;
        for (int i = 0; i < sumAll.length; i++) {
            area += sumAll[i].integral(lower, upper, granul);
        }
        return area;
    }

    /**
     * Provides a string format of the sum
     * @returns a string of the sum
     */
    @Override
    public String toString() {
        String sumString = "";
        for (int i = 0; i < sumAll.length; i++) {
            if (i+1 == sumAll.length){
                sumString += sumAll[i].toString();
            }
            else sumString += sumAll[i].toString() + " + ";
        }
        if (sumAll.length > 1){
            sumString = "( " + sumString + " )";
        }
        return sumString;
    }
}
