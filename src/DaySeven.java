package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaySeven {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-seven.txt");
        Scanner scan = new Scanner(f);
        String[] data = scan.nextLine().split(",");
        List<Integer> positions = new ArrayList<>();
        for (String s : data) {
            positions.add(Integer.parseInt(s));
        }
        int answer = findAnswer(positions);
        System.out.println(answer);
    }

    public static int findAnswer(List<Integer> input) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i : input) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int smallestSum = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int sum = 0;
            for (int c : input) {
                sum += serie(Math.abs(c - i));
                if (sum > smallestSum) break;
            }
            smallestSum = Math.min(smallestSum, sum);
        }
        return smallestSum;
    }

    public static int serie(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i;
            i--;
        }
        return sum;
    }
}
