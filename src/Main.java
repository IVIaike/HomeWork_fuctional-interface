import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {

        Predicate<Integer>predicate1 = new Predicate<Integer>() {

            @Override
            public boolean test(Integer integer) {
                if (integer < 0) {
                    return false;
                }
                return true;
            }
        };

        Predicate<Integer> isPositive = x -> x>0;
        System.out.println(isPositive.test(3));
        System.out.println(isPositive.test(-3));

        Consumer<String>consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hi! " + s + "!");
            }
        };

        Consumer<String>consumer2 = s -> System.out.println("Hi! " + s + "!");

        Function<Double, Long>function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double, Long>function1 = Double -> Double.longValue();
        Function<Double, Long>function2 = Double -> Math.round(Double);

        Supplier<Double> supplier = new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random()*100;
            }
        };

        Supplier<Double>supplier1 = () -> Math.random()*100;

        System.out.println(ternaryOperator(condition, function3,function4));

    }

    int s = 3;
    private static Function<Integer,Integer> function3 = s -> s+s+s;
    private static Function<Integer,Integer> function4 = s -> s*s;
    private static Predicate<Integer>condition = s -> s>0;


    private static Function<Integer, Integer> ternaryOperator(Predicate<Integer> condition, Function<Integer, Integer> function3, Function<Integer, Integer> function4) {
        return s -> {
            if (condition.test(s)) {
                return function3.apply(s);
            } else if (condition.test(s)) {
                return function4.apply(s);
            }
            return s;
        };
    }
}