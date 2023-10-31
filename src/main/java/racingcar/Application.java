package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Car[] car;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();

    }

    public static void start(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void makeCar(){
        ArrayList<String> names = getName();
        int count = getCount();
        car = new Car[names.size()];

        for(int i = 0; i < names.size(); i++){
            car[i] = new Car(names.get(i), count);
        }

    }

    public static ArrayList<String> getName(){
        ArrayList<String> list = new ArrayList<>();
        String input = Console.readLine();

        for(String i : input.split(",")){
            list.add(i);
        }

        return list;
    }

    public static int getCount(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}


