package functions;

import java.util.ArrayList;

/**
 * Provides implementation of the mathematical product
 * @Author Jackson Dushane
 */
public class Product extends Function {
    public Function[] prodAll;

    /**
     * Takes an unlimited amount of term parameters in order to construct an array of functions
     * to be multiplied together
     *
     * Also applies simplification in order to make the end result cleaner
     * @param terms
     */
    public Product(Function... terms){
        double prodAdded = 1;
        ArrayList<Function> exes = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            if (terms[i].isConstant()){
                prodAdded *= terms[i].evaluate(69);
            }
            else{
                exes.add(terms[i]);
            }
        }
        prodAll = new Function[exes.size()+1];

        for (int i = 0; i < exes.size(); i++) {
            prodAll[i] = exes.get(i);
        }

        prodAll[prodAll.length-1] = new Constant(prodAdded);

        for (int i = 0; i < prodAll.length; i++) {
            if (prodAll[i].evaluate(1) == 0){
                prodAll = new Function[0];
        }
        }

        ArrayList<Function> simplyfyed = new ArrayList<>();
        for (int i = 0; i < prodAll.length; i++) {
            if (prodAll[i].evaluate(2) != 1){
                simplyfyed.add(prodAll[i]);
            }
        }

        prodAll = simplyfyed.toArray(Function[]::new);

    }

    /**
     * Evaluates the product @ value X
     * @param value for X
     * @returns a double of the evaluation
     */
    @Override
    public double evaluate(double value) {
        double total = 1;
        for (Function term: prodAll) {
            total *= term.evaluate(value);
        }
        return total;
    }

    /**
     * Checks if any of the terms are constant
     * If so, the product isnt constant
     * @returns a boolean on the state of the product
     */
    @Override
    public boolean isConstant() {
        for (Function term : prodAll) {
            if (!term.isConstant()){
                return false;
            }
        }
        return true;
    }

    /**
     * Applies the product rule in order to provide the derivative of a function
     * @returns a functional derivative
     */
    @Override
    public Function derivative(){
        ArrayList<Function> derivAlist = new ArrayList<>();
        for (int i = 0; i < prodAll.length; i++) {
            if (!prodAll[i].isConstant()){
                Function[] sumaderiv = new Function[prodAll.length];

                for (int j = 0; j < prodAll.length; j++) {
                    sumaderiv[j] = prodAll[j];
                    if (i == j){
                        sumaderiv[j] = prodAll[j].derivative();
                    }
                }
                derivAlist.add(new Product(sumaderiv));
            }
        }
        Function[] productRulend = derivAlist.toArray(Function[]::new);
        return new Sum(productRulend);
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
        double deltaX = (upper - lower) / granul;
        double total = 0.5 * (this.evaluate(lower) + this.evaluate(upper));
        for (int i = 1; i < granul; i++) {
            double x = lower + deltaX * i;
            total = total + this.evaluate(x);
        }
        return total * deltaX;
    }

    /**
     * Provides a string format of the product
     * @returns a string of the product
     */
    @Override
    public String toString() {
        String prodString = "";
        for (int i = 0; i < prodAll.length; i++) {
            if (i+1 == prodAll.length){
                prodString += prodAll[i].toString();
            }
            else prodString += prodAll[i].toString() + " * ";
        }
        if (prodAll.length > 1){
            prodString = "( " + prodString + " )";
        }
        return prodString;
    }
}
