package racingcar;

import racingcar.name.Name;
import racingcar.name.go;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Name names = new Name();
        go wow = new go();
        String[] listlist = names.NameList(names.getName());
        ArrayList<String> winners = new ArrayList<>();

        int[] distance = new int[listlist.length];
        for (int i = 0; i < listlist.length; i++){
            distance[i]=0;
        }
        if (Arrays.toString(listlist).equals("[]")) {
            return;
        }
        else {
            int repeat = wow.getRepeat();
            System.out.println("실행 결과");
            int max = 0;
            while (max < repeat) {
                for (int i = 0; i < listlist.length; i++) {
                    int number = wow.WhatIsNumber();
                    if (number >= 4) {
                        distance[i]++;
                        if (max < distance[i]) {
                            max = distance[i];
                        }
                        if (distance[i] >= repeat) {
                            winners.add(listlist[i]);
                        }
                    }
                    System.out.printf("%s : %s%n",listlist[i],"-".repeat(distance[i]));
                }
                System.out.println();
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i < winners.size()-1) {
                System.out.print(", ");
            }
        }
    }
}
