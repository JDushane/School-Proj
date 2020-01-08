package functions;

/**
 * Provides for the use of an independent variable
 * @Author Jackson Dushane
 */
public class Variable extends Function {

    public final static Variable X = new Variable();

    private Variable(){}

    /**
     * Evaluates X @ X
     * @param value for X
     * @return
     */
    @Override
    public double evaluate(double value) {
        return value;
    }

    /**
     * Variables can never be constant
     * @returns false
     */
    @Override
    public boolean isConstant() {
        return false;
    }

    /**
     * Takes the derivative of a singular variable
     * @return
     */
    @Override
    public Function derivative() {
        return new Constant(1);
    }

    /**
     * Computes a simple version of the trapezoidal rule on X
     * @param lower
     * @param upper
     * @param granul
     * @returns definite integral value
     */
    @Override
    public double integral(double lower, double upper, double granul) {
        return (upper-lower) * ((X.evaluate(lower) + X.evaluate(upper))/2);
    }

    /**
     * @returns variable x in string form
     */
    @Override
    public String toString() {
        return "x";
    }
}
