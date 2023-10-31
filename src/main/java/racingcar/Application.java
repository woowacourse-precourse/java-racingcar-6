package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static Car[] car;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
        play();
    }

    public static void start(){
        makeCar();
    }
    public static void play(){
        System.out.println("실행결과");
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
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> list = new ArrayList<>();
        String input = Console.readLine();

        for(String i : input.split(",")){
            list.add(i);
        }

        return list;
    }

    public static int getCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}


