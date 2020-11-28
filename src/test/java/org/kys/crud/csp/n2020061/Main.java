package org.kys.crud.csp.n2020061;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyunkun
 * @date 2020/11/23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] lineArr = line.split(" ");

        int pointCount = Integer.parseInt(lineArr[0]);
        int hrCount = Integer.parseInt(lineArr[1]);

        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            line = scanner.nextLine();
            lineArr = line.split(" ");
            int x = Integer.parseInt(lineArr[0]);
            int y = Integer.parseInt(lineArr[1]);
            String type = lineArr[2];
            if ("A".equalsIgnoreCase(type)) {
                listA.add(new int[]{x, y});
            } else {
                listB.add(new int[]{x, y});
            }
        }

        String[] resultArr = new String[hrCount];
        for (int i = 0; i < hrCount; i++) {
            line = scanner.nextLine();
            lineArr = line.split(" ");
            int n1 = Integer.parseInt(lineArr[0]);
            int n2 = Integer.parseInt(lineArr[1]);
            int n3 = Integer.parseInt(lineArr[2]);

            HashSet<Boolean> resultA = new HashSet<>();
            listA.forEach(e -> {
                resultA.add((n1 + n2 * e[0] + n3 * e[1]) > 0);
            });
            HashSet<Boolean> resultB = new HashSet<>();
            listB.forEach(e -> {
                resultB.add((n1 + n2 * e[0] + n3 * e[1]) > 0);
            });

            if (resultA.size() == 1 && resultB.size() == 1) {
                resultArr[i] = "Yes";
            } else {
                resultArr[i] = "No";
            }
        }

        for (int i = 0; i < resultArr.length; i++) {
            System.out.println(resultArr[i]);
        }
    }
}
