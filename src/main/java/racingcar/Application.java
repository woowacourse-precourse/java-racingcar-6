package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String[] cars_name;
        Integer[] cars_race;
        int n;
        String input;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input=Console.readLine();
        cars_name=input.split(",");
        cars_race=new Integer[cars_name.length];
        for (int i=0;i<cars_race.length;i++){
            cars_race[i]=0;
        }
        System.out.println("시도할 회수는 몇회인가요?");
        n= Integer.parseInt(Console.readLine());
    }
}
