package functions;

public abstract class Function {

    /**
     * Represents variable as a value and solves the function @ value
     * @param value for X
     * @return Evaluated value
     */
    public abstract double evaluate(double value);

    /**
     * Basically checks if a function has a variable or not
     * @returns a Boolean depending on the status of the constant
     */
    public abstract boolean isConstant();

    /**
     * Gives the user the first derivative of the functions provided
     * @return Function
     */
    public abstract Function derivative();

    /**
     * Returns the first integral of a function
     * @param lower
     * @param upper
     * @param granul
     * @return Function
     */
    public abstract double integral(double lower,double upper,double granul);

    /**
     * Its a toString
     * @return take a guess
     */
    @Override
    public abstract String toString();

}
