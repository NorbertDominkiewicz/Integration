import java.util.function.Function;
public class Integral {
    private double a;
    private double b;
    private Function<Double, Double> mathFunction;
    public Integral(double a, double b, Function<Double, Double> mathFunction) {
        this.a = a;
        this.b = b;
        this.mathFunction = mathFunction;
    }
    public void trapezoidMethod(int n){
        double h;
        double result;
        h = (b - a) / n;
        result = h * (mathFunction.apply(a)/2 + (mathFunction.apply(b)/2));
        for(double i = 1; i < n; i++){
            result = result + h*(mathFunction.apply(a + (i / n) * (b - a)));
        }
        System.out.println("Trapezoid: " + result);
    }
    public static void main(String[] args) {
        Integral integral = new Integral(0.5, 1.8,x -> (Math.cos(Math.pow(x, 3) + 0.7))/(1.1 + Math.cos(0.3 * x + 0.1)));
        integral.trapezoidMethod(4);
    }
}
