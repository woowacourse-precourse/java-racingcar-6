package racingcar;

import java.util.Arrays;

public class Commentator {
    public static void printEnterCarName () {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printEnterNumberOfAttempts () {
        System.out.println("시도할 회수는 몇 회인가요?");
    }
    public static void printNowProgress (Car[] cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for (int carProgress = 0; carProgress < car.getCarPosition(); carProgress++)
                System.out.print("-");
            System.out.println("");
        }
        System.out.println("");
    }
    public static void printWinner (String winCarList) {
        System.out.print("최종 우승자 : ");
        System.out.print(winCarList);
    }
}
