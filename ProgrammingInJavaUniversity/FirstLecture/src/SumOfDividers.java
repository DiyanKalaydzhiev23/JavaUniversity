public class SumOfDividers {
    public static int getDividersSum(int n) {
        int sum = 0;

        for (int num = 1; num < n; num++) {
            if (n % num == 0) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int sum = getDividersSum(12);
        System.out.println(sum);
    }
}
