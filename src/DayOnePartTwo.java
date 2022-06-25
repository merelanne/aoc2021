package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayOnePartTwo {

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
        List<Integer> windows = new ArrayList();
        Iterator<String> it = input.iterator();
        int first = Integer.parseInt(it.next());
        windows.add(first);
        windows.add(first);
        windows.add(first);
        int index = 1;
        while (it.hasNext()) {
            int current = Integer.parseInt(it.next());
            windows.set(index, windows.get(index) + current);
            windows.set(index + 1, windows.get(index+1) + current);
            windows.add(current);
            index++;
        }
        for (int i = 3; i < windows.size() - 2; i++)
            if (windows.get(i) > windows.get(i-1)) answer++;
        return answer;
    }
}