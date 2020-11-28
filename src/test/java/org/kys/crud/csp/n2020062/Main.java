package org.kys.crud.csp.n2020062;

import java.util.Scanner;

/**
 * @author liuyunkun
 * @date 2020/11/25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] lineArr = line.split(" ");
        int n = Integer.parseInt(lineArr[0]);
        int a = Integer.parseInt(lineArr[1]);
        int b = Integer.parseInt(lineArr[2]);

        int[] aArr = new int[n];
        int[] bArr = new int[n];

        for (int i = 0; i < (a + b); i++) {
            line = scanner.nextLine();
            lineArr = line.split(" ");

            int index = Integer.parseInt(lineArr[0]) - 1;
            int value = Integer.parseInt(lineArr[1]);

            if (i < a) {
                aArr[index] = value;
            } else {
                bArr[index] = value;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += aArr[i] * bArr[i];
        }

        System.out.println(result);
    }
}
