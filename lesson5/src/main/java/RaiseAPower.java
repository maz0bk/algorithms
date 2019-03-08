public class RaiseAPower {

    public static double power(int base, int power){
        if (power == 0 && base ==0) {
            throw new ArithmeticException("ноль в нулевой степени...");
        }
        if(power <0){
            return 1/powerRecursion(base,-power);
        }
        if (power == 0) {
            return 1;
        }

        return powerRecursion(base,power);
    }

    private static double powerRecursion(int base, int power) {
        if (power <= 1) {
            return (double) base;
        }
        return base * powerRecursion(base,--power);
    }

    public static void main(String[] args) {
        System.out.println(power(-2,3));
    }
}
