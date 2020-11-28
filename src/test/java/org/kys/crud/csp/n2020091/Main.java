package org.kys.crud.csp.n2020091;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author liuyunkun
 * @date 2020/11/22
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] lineArr = line.split(" ");

        int positionCount = Integer.parseInt(lineArr[0]);
        int[] personPositionArr = new int[2];
        personPositionArr[0] = Integer.parseInt(lineArr[1]);
        personPositionArr[1] = Integer.parseInt(lineArr[2]);

        List<Distance> distances = new ArrayList<>();
//        TreeMap<Integer, Integer> distances = new TreeMap<>(Integer::compareTo);
        for (int i = 0; i < positionCount; i++) {
            line = scanner.nextLine();
            lineArr = line.split(" ");

//            distances.put(i + 1, getDistance(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), personPositionArr));
            Distance distance = new Distance();
            distance.setNo(i + 1);
            distance.setDistance(getDistance(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), personPositionArr));

            distances.add(distance);
        }

        distances.sort(Comparator.comparingInt(Distance::getDistance));

        for (int i = 0; i < 3; i++) {
            System.out.println(distances.get(i).getNo());
        }

    }

    private static int getDistance(int x, int y, int[] personPositionArr) {
        return (personPositionArr[0] - x)*(personPositionArr[0] - x)
                + (personPositionArr[1] - y)*(personPositionArr[1] - y);
    }
}

class Distance {
    private int no;
    private int distance;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
