package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Template {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-one.txt");
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
        Iterator<String> it = input.iterator();
        while (it.hasNext()) {

        }
        return answer;
    }
}