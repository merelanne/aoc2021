package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayNinePartTwo {
    static List<char[]> covered;

    public static void main(String[] args) throws FileNotFoundException {
        covered = new ArrayList<>();
        File f = new File("inputs/day-nine.txt");
        Scanner scan = new Scanner(f);
        List<String> data = new ArrayList<>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            data.add(line);
            covered.add(line.toCharArray());
        }
        int answer = findAnswer(data);
        scan.close();
        System.out.println(answer);
    }

    public static int findAnswer(List<String> input) {
        int[] basins = {0, 0, 0};
        for (int x = 0; x < input.size(); x++) {
            for (int y = 0; y < input.get(x).length(); y++) {
                if (covered.get(x)[y] == '.') continue;
                int size = basinSize(input, x, y);
                int smallest = findMinIndex(basins);
                if (size > basins[smallest]) basins[smallest] = size;
            }
        }
        return basins[0] * basins[1] * basins[2];
    }

    public static int basinSize(List<String> input, int x, int y) {
        if (x < 0 || x >= input.size() || y < 0 || y >= input.get(x).length() || covered.get(x)[y] == '.') return 0;
        char[] covered_x = covered.get(x);
        covered_x[y] = '.';
        covered.set(x, covered_x);

        if (input.get(x).charAt(y) == '9') return 0;
        return 1 + basinSize(input, x + 1, y) + basinSize(input, x, y + 1) + basinSize(input, x - 1, y) + basinSize(input, x, y - 1);        
    }

    public static int findMinIndex(int[] input) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int index = 0; index < input.length; index++) {
            if (input[index] < min) {
                min = input[index]; 
                minIndex = index;
            }
        }
        return minIndex;
    }
}
