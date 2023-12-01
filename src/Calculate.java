import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter base");
        double base = scanner.nextDouble();

        System.out.println("Enter power");
        double power = scanner.nextDouble();

        Calculate calculate = new Calculate();
        double result = calculate.getPow(base,power);
        System.out.println(result);


    }



    public double getPow(double x, double y){
        if(y > 0){
             return x * getPow(x,y-1);
        }else {
            return 1.0;
        }

//        double t = 0.0;
//        if (y > 0) {
//            t *= x;
//            return t * getPow(x,y - 1);
//        } else {
//            return 0.0;
//        }


//        for (int i = 0; i < y; i++) {
//            double total = x * x;
//            total += total;
//            System.out.println(total);
//
//        }
    }
}
