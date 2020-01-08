package functions;

public class TrigTest {
    static Variable var = Variable.X;
    static Function sinu = new Sine(var);
    static Function sinudiv = sinu.derivative();

    public static void main(String[] args){
        System.out.println(sinu);
        System.out.println(sinudiv);
    }
}
