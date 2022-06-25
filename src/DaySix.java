package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class DaySix {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("inputs/day-six.txt");
        Scanner scan = new Scanner(f);
        String ages = scan.nextLine();
        BigInteger answer = findAnswer(ages);
        System.out.println(answer);
    }

    public static BigInteger findAnswer(String input) {
        BigInteger answer = BigInteger.ZERO;
        BigInteger[] fish = new BigInteger[9];
        for (int f = 0; f < fish.length; f++) fish[f] = BigInteger.ZERO;
        String[] ages = input.split(",");
        for (String s : ages) {
            fish[Integer.parseInt(s)] = fish[Integer.parseInt(s)].add(BigInteger.ONE);
        }
        for (int i = 0; i < 256; i++) {
            BigInteger producers = fish[0];
            for (int index = 1; index < fish.length; index++) {
                fish[index - 1] = fish[index];
            }
            fish[fish.length - 1] = producers;
            fish[6] = fish[6].add(producers);
        }
        for (BigInteger f : fish) answer = answer.add(f);
        return answer;
    }
}
