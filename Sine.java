package functions;

/**
 * Provides the transcendental sine function
 * @Author Jackson Dushane
 */
public class Sine extends Function {

    public Function sinInt;

    /**
     * Constructs a sine function
     * @param sint , internal sine function
     */
    public Sine(Function sint){
        sinInt = sint;
    }

    /**
     * Finds the sine value of the specific cosine object
     * @param value for X
     * @returns a double value of the sine of the internal function
     */
    @Override
    public double evaluate(double value) {
        return Math.sin(sinInt.evaluate(value));
    }

    /**
     * Checks if the cosine is constant by checking its internal
     * @returns a boolean on the status of the sine object
     */
    @Override
    public boolean isConstant() {
        return sinInt.isConstant();
    }

    /**
     * Provides a derivative of the sine object using the chain rule
     * @returns a functional derivative
     */
    @Override
    public Function derivative() {
        if (sinInt.isConstant()){
            return new Constant(0);
        }
        else {
            return new Product(sinInt.derivative(), new Cosine(sinInt));
        }
    }

    /**
     * Computes the definite integral of the sine using the trapezoidal rule
     * @param lower bound
     * @param upper bound
     * @param granul amount of trapezoids to measure with
     * @returns double of the integrals value
     */
    @Override
    public double integral(double lower, double upper, double granul) {
        double deltaX = (upper - lower) / granul;
        double total = 0.5 * (this.evaluate(lower) + this.evaluate(upper));
        for (int i = 1; i < granul; i++) {
            double x = lower + deltaX * i;
            total = total + this.evaluate(x);
        }
        return total * deltaX;
    }

    /**
     * Takes a sine function and returns a string of it
     * @returns string of cosine function
     */
    @Override
    public String toString() {
        return "sin( " + sinInt.toString() + " )";
    }
}
