package racingcar;
import racingcar.name.Name;
import racingcar.name.go;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Name names = new Name();
        go wow = new go();
        String[] listlist = names.NameList(names.getName());

        int[] distance = new int[listlist.length];
        for (int i = 0; i < listlist.length; i++){
            distance[i]=0;
            System.out.println(listlist[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
//        System.out.println(Arrays.toString(distance));
//        System.out.println(Arrays.toString(listlist));
        System.out.println(wow.WhatIsNumber());


    }
}
