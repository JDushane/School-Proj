import functions.*;

/**
 * Tests all facets of the project, from constant to cosine, evaluate to toString
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        //Constant Tests
        Constant ex = new Constant(55);
        System.out.println("Testing Constant Construction, Expecting 55: " + ex.toString());
        System.out.println("Testing Constant Evaluation, Expecting 55: " + ex.evaluate(55));
        System.out.println("Testing Constant Derivative, Expecting 0: " + ex.derivative());
        System.out.println("Testing Constant Integral, Expecting 110: " + ex.integral(0,2,1000));

        //Variable Tests
        Variable var = Variable.X;
        System.out.println("Testing variable construction, expecting x: " + var.toString());
        System.out.println("Testing variable evaluation, expection 55: " + var.evaluate(55));
        System.out.println("Testing Variable derivative, expecting 1: " + var.derivative());
        System.out.println("Testing variable integral, expecting 2: " + var.integral(0,2,1000));

        //Sum Integral Test
        Sum summy = new Sum(var, var, ex);
        System.out.println("Testing sum construction, expecting ( x + x + 55 ): " + summy.toString());
        System.out.println("Testing sum evaluation, expecting 165: " + summy.evaluate(55));
        System.out.println("Testing sum derivative, expecting 2: " + summy.derivative());
        System.out.println("Testing sum integral, expecting 114: " + summy.integral(0,2,100000));

        //Product Tests
        Product proddy = new Product(var, var, ex);
        System.out.println("Testing product construction, expecting ( x * x * 55 ): " + proddy.toString());
        System.out.println("Testing product evaluation, expecting 166375: " + proddy.evaluate(55));
        System.out.println("Testing product derivative, expecting ( x * 110): " + proddy.derivative());
        System.out.println("Testing product integral, expecting 146.6666666740009: "
                + proddy.integral(0,2,100000));

        //Sine Tests
        Sine siney = new Sine(proddy);
        System.out.println("Testing sine construction, expecting sin(x * x * 55): " + siney.toString());
        System.out.println("Testing sine evaluation, expecting 0.5690428961919003:" + siney.evaluate(55));
        System.out.println("Testing sine derivative, expecting " +
                "( ( ( x * 55.0 ) + ( x * 55.0 ) ) * cos( ( x * x * 55.0 ) ) ): " + siney.derivative());
        System.out.println("Testing sine integral, expecting 0.07996992634539629: "
                + siney.integral(0,2,100000));

        //Cosine Tests
        Cosine cosiney = new Cosine(proddy);
        System.out.println("Testing cosine construction, expecting cos(x * x * 55): " + cosiney.toString());
        System.out.println("Testing cosine evaluation, expecting -0.8223078391293215: " + cosiney.evaluate(55));
        System.out.println("Testing cosine derivative, expecting  ( ( ( x * 55.0 ) + ( x * 55.0 ) ) * sin( ( x * x * 55.0 ) ) * -1.0 ): "
                + cosiney.derivative());
        System.out.println("Testing cosine integral, expecting 0.08488993801701103: "
                + cosiney.integral(0,2,100000));
    }
}
