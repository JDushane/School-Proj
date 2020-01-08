package functions;

/**
 * Provides the transcendental cosine function
 * @Author Jackson Dushane
 */
public class Cosine extends Function {

    public Function cosInt;

    /**
     * Takes a specific function to 'go into' the cosine function
     * @param cosInt , internal cosine function
     */
    public Cosine(Function cosInt){
        this.cosInt = cosInt;
    }

    /**
     * Finds the cosine value of the specific cosine object
     * @param value for X
     * @returns a double value of the cosine of the internal function
     */
    @Override
    public double evaluate(double value) {
        return Math.cos(cosInt.evaluate(value));
    }

    /**
     * Checks if the cosine is constant by checking its internal
     * @returns a boolean on the status of the cosine object
     */
    @Override
    public boolean isConstant() {
        return cosInt.isConstant();
    }

    /**
     * Provides a derivative of the cosine object using the chain rule
     * @returns a functional derivative
     */
    @Override
    public Function derivative() {
        if (cosInt.isConstant()){
            return new Constant(0);
        }
        else {
            return new Product(cosInt.derivative(),
                    new Constant(-1),
                    new Sine(cosInt));
        }
    }

    /**
     * Computes the definite integral of the cosine using the trapezoidal rule
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
     * Takes a cosine function and returns a string of it
     * @returns string of cosine function
     */
    @Override
    public String toString() {
        return "cos( " + cosInt.toString() + " )";
    }
}
