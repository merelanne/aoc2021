package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-two.txt");
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
        int horizontal = 0;
        int depth = 0;
        Iterator<String> it = input.iterator();
        while (it.hasNext()) {
            String[] set = it.next().split(" ");
            if (set[0].equals("forward")) horizontal += Integer.parseInt(set[1]);
            if (set[0].equals("up")) depth -= Integer.parseInt(set[1]);
            if (set[0].equals("down")) depth += Integer.parseInt(set[1]);
        }
        return depth*horizontal;
    }
}