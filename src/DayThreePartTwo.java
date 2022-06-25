package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayThreePartTwo {

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
        List<String> oxygen = new ArrayList<>();
        List<String> co2 = new ArrayList<>();
        for (String s : input) {
            oxygen.add(s);
            co2.add(s);
        }
        int index = 0;
        while (oxygen.size() > 1) {
            if (index >= oxygen.size()) {
                if (oxygen.get(0).endsWith("0")) oxygen.remove(0);
                else oxygen.remove(1);
            }
            int count = 0;
            int common = 0;
            for (String s : oxygen)
                if (s.charAt(index) == '1') count++;
            if (oxygen.size()%2 == 0 && count == oxygen.size() / 2) common = 1;
            if (count > oxygen.size() / 2) common = 1;
            List<String> toRemove = new ArrayList<>();
            for (String o : oxygen) {
                if (o.charAt(index) != Character.forDigit(common, 2)) toRemove.add(o);
            }
            for (String r : toRemove) oxygen.remove(r);
            index++;
        }
        index = 0;
        while (co2.size() > 1) {
            int count = 0;
            int common = 0;
            for (String s : co2)
                if (s.charAt(index) == '1') count++;
            if (co2.size()%2 == 0 && count == co2.size() / 2) common = 1;
            if (count > co2.size() / 2) common = 1;
            List<String> toRemove = new ArrayList<>();
            for (String c : co2) {
                if (c.charAt(index) == Character.forDigit(common, 2)) toRemove.add(c);
            }
            for (String r : toRemove) co2.remove(r);
            index++;
        }
        return Integer.parseInt(oxygen.get(0), 2) * Integer.parseInt(co2.get(0), 2);
    }
}