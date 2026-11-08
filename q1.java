
import java.util.Stack;
import java.util.Arrays;

public class q1 {

    public static int[] priceStreak(int[] price) {

        int n = price.length;
        int[] streak = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Remove previous days with price <= today's price
            while (!stack.isEmpty() &&
                   price[stack.peek()] <= price[i]) {

                stack.pop();
            }

            // Calculate streak
            if (stack.isEmpty()) {
                streak[i] = i + 1;
            } else {
                streak[i] = i - stack.peek();
            }

            // Push today's index
            stack.push(i);
        }

        return streak;
    }

    public static void main(String[] args) {

        int[] price = {100, 80, 60, 70, 60, 75, 85};

        int[] result = priceStreak(price);

        System.out.println(Arrays.toString(result));
    }
}
