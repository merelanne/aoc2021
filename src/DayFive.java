package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayFive {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-five.txt");
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
        int[][] points = new int[1000][1000];
        Iterator<String> it = input.iterator();
        while (it.hasNext()) {
            String[] coords = it.next().split(" -> ");
            String[] from = coords[0].split(",");
            String[] to = coords[1].split(",");
//            System.out.println(from[0] + "," + from[1] + " -> " + to[0] + "," + to[1]);
            if (from[0].equals(to[0])) {
                int fromY = Integer.parseInt(from[1]);
                int toY = Integer.parseInt(to[1]);
                if (fromY < toY) {
                    for (int i = fromY; i <= toY; i++) {
                        points[Integer.parseInt(from[0])][i]++;
                    }
                } else {
                    for (int i = fromY; i >= toY; i--) {
                        points[Integer.parseInt(from[0])][i]++;
                    }
                }
            }
            else if (from[1].equals(to[1])) {
                int fromX = Integer.parseInt(from[0]);
                int toX = Integer.parseInt(to[0]);
                if (fromX < toX) {
                    for (int i = fromX; i <= toX; i++) {
                        points[i][Integer.parseInt(from[1])]++;
                    }
                } else {
                    for (int i = fromX; i >= toX; i--) {
                        points[i][Integer.parseInt(from[1])]++;
                    }
                }
            }
        }
        int answer = 0;
        for (int[] row : points) {
            for (int value : row) if (value >= 2) answer++;
        }
        return answer;
    }
}
