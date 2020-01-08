package functions;

/**
 * Constant provides a function to emulate a specific value i.e 4.
 * @Author Jackson Dushane
 */

public class Constant extends Function {

    private double constantVal;

    /**
     * Constructor for the constant class, takes a double to represent a constant value
     * @param constantVal
     */
    public Constant(double constantVal){
        this.constantVal = constantVal;
    }

    /**
     * Provides the double value for the constant at hand
     * @param value for X // can be any value for constant
     * @return a double of the constants value
     */
    @Override
    public double evaluate(double value) {
        return constantVal;
    }

    /**
     * Returns if this constant is a constant
     * @return a boolean if this constant is a constant
     */
    @Override
    public boolean isConstant() {
        return true;
    }

    /**
     * Provides the derivative of any constant, 0
     * @returns a new Constant of the value of a derivative
     */
    @Override
    public Function derivative() {
        return new Constant(0);
    }

    /**
     * Takes the definite integral of a constant, parameters specify bounds
     * @param lower
     * @param upper
     * @param granul //Unnecessary for constant
     * @return double value of integral of constant
     */
    @Override
    public double integral(double lower, double upper, double granul) {
        return (constantVal*upper) - (constantVal*lower);
    }

    /**
     * Shows the constant in string form
     * @returns value of constant as a string
     */
    @Override
    public String toString() {
        return String.valueOf(constantVal);
    }
}
