package racingcar.executionprocess;


import racingcar.executionprocess.CarRandomNum;
import racingcar.input.CarName;
import racingcar.input.NumberOfAttempts;

import java.util.ArrayList;
import java.util.List;


public class CarRace {

    public static void start() {
        printCarName();
        printNumberOfAttempts();

    }

    public static void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = CarName.input();
        System.out.println(cars);
    }

    public static void printNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        int num = NumberOfAttempts.input();
        System.out.println(num);
        System.out.println();
        System.out.println("실행 결과");
    }
}
