package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEight {
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
        for (String s : input) sum += countNums(s);
        return sum;
    }

    public static int countNums(String s) {
        int sum = 0;
        String[] split = s.split(" \\| ");
        String[] outputs = split[1].split(" ");
        System.out.println(split.length);
        for (String o : outputs)
            if (o.length() == 2 || o.length() == 4 || o.length() == 7 || o.length() == 3) sum++;
        return sum;
    }
}
