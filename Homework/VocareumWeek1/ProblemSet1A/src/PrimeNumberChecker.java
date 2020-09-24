public class PrimeNumberChecker{
    public static int isPrime(int num){
        if (num%2==0) {
            return 0;
        }

        for (int i=2;i<num;i++) {
            if (num%i==0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        isPrime(4);
    }
}
