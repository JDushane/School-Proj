import functions.Constant;
import functions.Function;
import functions.Sum;
import functions.Variable;

public class FunctionTest1 {

    /** Tests Part1
     * Creates a constant, creates a variable
     *
     * @param args
     */
    public static void main(String[] args){
        System.out.println("Declaring constants and variables:");
        System.out.println("Expecting: (69 + 69), (x + x) and (420 + x)");

        Function f1 = new Sum(new Constant(69), new Constant(69));
        Variable var = Variable.X;
        Function f2 = new Sum(var, var);
        Function f3 = new Sum(new Constant(420), var);

        System.out.println(f1); //Tests constant and sum creation and toString
        System.out.println(f2); //Tests variable and sum creation and toString
        System.out.println(f3); //Mixes prior 2 tests

        System.out.println("Evaluation Testing, x @ 30");
        System.out.println(f1.evaluate(30));
        System.out.println(f2.evaluate(30));
        System.out.println(f3.evaluate(30));

        System.out.println("Derivative Testing");
        System.out.println(f1.derivative());
        System.out.println(f2.derivative());
        System.out.println(f3.derivative());

    }

}
