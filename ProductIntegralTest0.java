package functions;

public class ProductIntegralTest0 {

    public static Variable var = Variable.X;

    public static Function prodTest = new Product(new Constant(10), var, var);

    public static void main(String[] args){
        System.out.println(prodTest.integral(0,5, 10000));
    }
}
