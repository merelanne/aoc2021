package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-four.txt");
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
        List<Board> boards = new ArrayList<>();
        Iterator<String> it = input.iterator();
        String d = it.next();
        String[] drawn = d.split(",");
        while (it.hasNext()) {
            it.next();
            Board b = new Board();
            for (int row = 0; row < 5; row++) {
                String[] r = it.next().split("[ ]{1,}");
                if (r[0].isEmpty()) {
                    for (int i = 0; i < 5; i++)
                        r[i] = r[i+1];
                }
                for (int c = 0; c < 5; c++) {
                    b.addField(row, c, Integer.parseInt(r[c]));
                }
            }
            boards.add(b);
        }
        for (int i = 0; i < 4; i++) {
            for (Board b : boards)
                b.markField(Integer.parseInt(drawn[i]));
        }
        int index = 3;
        Board winning = null;
        while (winning == null) {
            index++;
            for (Board b : boards)
                b.markField(Integer.parseInt(drawn[index]));
            winning = checkWinBoards(boards);
        }
        return winning.getSumUnmarked() * Integer.parseInt(drawn[index]);
    }

    public static Board checkWinBoards(List<Board> boards) {
        for (Board b : boards) if (b.checkWin()) return b;
        return null;
    }

    public static class Board {
        int[][] fields;
        boolean[][] marks;

        public Board() {
            this.fields = new int[5][5];
            this.marks = new boolean[5][5];;
        }

        public void addField(int r, int c, int v) {
            this.fields[r][c] = v;
        }

        public void markField(int val) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (fields[row][col] == val) {
                        marks[row][col] = true;
                    }
                }
            }
        }

        public boolean checkWin() {
            for (int row = 0; row < 5; row++) if (checkWinRow(row)) return true;

            for (int col = 0; col < 5; col++) if (checkWinCol(col)) return true;
            return false;
        }

        public boolean checkWinRow(int r) {
            for (boolean b : marks[r]) if (!b) return false;
            return true;
        }

        public boolean checkWinCol(int c) {
            for (boolean[] l : marks) if (!l[c]) return false;
            return true;
        }

        public int getSumUnmarked() {
            int sum = 0;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (!marks[row][col]) {
                        sum += fields[row][col];
                    }
                }
            }
            return sum;
        }

        public String toString() {
            StringBuilder b = new StringBuilder();
            for (int[] row : fields) {
                b.append('[');
                for (int c : row) {
                    b.append(Integer.toString(c));
                    b.append(',');
                }
                b.deleteCharAt(b.length() - 1);
                b.append("]\n");
            }
            return b.toString();
        }
    }

}


