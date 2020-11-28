package org.kys.crud.csp.n2020092;

import java.util.Scanner;

/**
 * @author liuyunkun
 * @date 2020/11/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] arr = line.split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int t = Integer.parseInt(arr[2]);
        int[] area = new int[4];
        area[0] = Integer.parseInt(arr[3]);
        area[1] = Integer.parseInt(arr[4]);
        area[2] = Integer.parseInt(arr[5]);
        area[3] = Integer.parseInt(arr[6]);

        int passCount = 0, stayCount = 0;
        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            arr = line.split(" ");

            boolean passFlag = false;
            boolean stayFlag = false;
            int continuousCount = 0;
            // 遍历每一个点
            for (int j = 0; j < t; j++) {
                int x = Integer.parseInt(arr[2 * j]);
                int y = Integer.parseInt(arr[2 * j + 1]);

                //判断当前点是否经过危险区域
                if (x >= area[0] && x <= area[2] && y >= area[1] && y <= area[3]) {
                    passFlag = true;
                    continuousCount++;
                } else {
                    if (continuousCount >= k) {
                        stayFlag = true;
                        break;
                    }
                    continuousCount = 0;
                }
            }

            if (continuousCount >= k) {
                stayFlag = true;
            }

            if (passFlag) {
                passCount++;
            }

            if (stayFlag) {
                stayCount++;
            }

        }

        System.out.println(passCount);
        System.out.println(stayCount);
    }
}
