package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-three.txt");
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
        Iterator<String> it = input.iterator();
        String first = it.next();
        int[] count = new int[first.length()];
        for (int i = 0; i < first.length(); i++)
            if (first.charAt(i) == '1') count[i]++;
        while (it.hasNext()) {
            String c = it.next();
            for (int i = 0; i < c.length(); i++)
                if (c.charAt(i) == '1') count[i]++;
        }
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        for (int i : count) {
            if (i >= (input.size()/2)) {
                gamma.append('1');
                epsilon.append('0');
            }
            else {
                gamma.append('0');
                epsilon.append('1');
            }
        }
        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }
}