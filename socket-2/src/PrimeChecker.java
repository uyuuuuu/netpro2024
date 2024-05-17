public class PrimeChecker {
    public static boolean isPrime(int n) {
        if (n<=1) {
            return false;
        }
        if (n<=3) {
            return true;
        }

        // 2と3の倍数以外の奇数を確認
        if (n%2 == 0 || n%3 == 0) {
            return false;
        }

        // 6k ± 1の形の数のみを確認
        for (int i=5; i*i<=n; i+=6) {
            if (n%i == 0 || n%(i+2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 17;
        if (isPrime(n)) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
