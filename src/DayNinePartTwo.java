package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayNinePartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-nine.txt");
        Scanner scan = new Scanner(f);
        List<String> data = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            data.add(line);
        }
        int answer = findAnswer(data);
        System.out.println(answer);
    }

    public static int findAnswer(List<String> input) {
        int answer = 0;
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(0).length(); j++) {
                if (input.get(i).charAt(j) == '9') continue; // Still don't know why I need this
                int current =  Character.digit(input.get(i).charAt(j), 10);
                if (i > 0 && current > Character.digit(input.get(i - 1).charAt(j), 10)) continue;
                if (i < input.size() - 1 && current > Character.digit(input.get(i + 1).charAt(j), 10)) continue;
                if (j > 0 && current > Character.digit(input.get(i).charAt(j - 1), 10)) continue;
                if (j < input.get(0).length() - 1 && current > Character.digit(input.get(i).charAt(j + 1), 10)) continue;
                answer += current + 1;
                System.out.println(current);
                if (current == '9') System.out.println("I; " + i + ", j: " + j);
            }
        }
        return answer;
    }
}
