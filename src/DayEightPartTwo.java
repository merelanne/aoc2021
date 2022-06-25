package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEightPartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-eight.txt");
        Scanner scan = new Scanner(f);
        List<String> data = new ArrayList<>();
        while (scan.hasNext()) data.add(scan.nextLine());
        int answer = findAnswer(data);
        System.out.println(answer);
    }

    public static int findAnswer(List<String> input) {
        int sum = 0;
        for (String s : input) {
            String[] split = s.split(" \\| ");
            String[] outputs = split[1].split(" ");
            String[] inputs = split[0].split(" ");
            String[] config = findConfig(inputs);
            sum += countNums(outputs, config);
        }
        return sum;
    }

    public static String[] findConfig(String[] input) {
        String one = "11";
        String two = "22222";
        String three = "333";
        String four = "4444";
        String five = "55555";
        String six = "666666";
        String seven = "777";
        String eight = "abcdefg";
        String nine = "999999";
        String zero = "000000";
        for (String s : input) {
            if (s.length() == 2) one = s;
            else if (s.length() == 3) seven = s;
            else if (s.length() == 4) four = s;
            else if (s.length() == 7) eight = s;
        }
        for (String s : input) {
            if (s.length() == 5) {
                if (overlap(s, one) == 2) three = s;
                else if (overlap(s, four) == 3) five = s;
                else if (overlap(s, four) == 2) two = s;
            } else if (s.length() == 6) {
                if (overlap(s, seven) == 2) six = s;
                else if (overlap(s, four) == 4) nine = s;
                else if (overlap(s, four) == 3) zero = s;
            }
        }
        String[] output = new String[10];
        output[0] = zero;
        output[1] = one;
        output[2] = two;
        output[3] = three;
        output[4] = four;
        output[5] = five;
        output[6] = six;
        output[7] = seven;
        output[8] = eight;
        output[9] = nine;
        return output;
    }

    public static int overlap(String one, String two) {
        int ol = 0;
        for (int i = 0; i < one.length(); i++) {
            if (two.contains(Character.toString(one.charAt(i)))) ol++;
        }
        return ol;
    }

    public static int countNums(String[] s, String[] combis) {
        StringBuilder value = new StringBuilder();
        for (String o : s) {
            if (o.length() == 2) value.append('1');
            else if (o.length() == 4) value.append('4');
            else if (o.length() == 3) value.append('7');
            else if (o.length() == 7) value.append('8');
            else if (o.length() == 6) {
                if (overlap(o, combis[6]) == 6) value.append('6');
                else if (overlap(o, combis[9]) == 6) value.append('9');
                else value.append('0');
            } else if (o.length() == 5) {
                if (overlap(o, combis[2]) == 5) value.append('2');
                else if (overlap(o, combis[3]) == 5) value.append('3');
                else value.append('5');
            }
        }
        return Integer.parseInt(value.toString());
    }
}
