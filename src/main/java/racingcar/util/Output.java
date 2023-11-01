package racingcar.util;

import racingcar.car.Car;
import racingcar.car.Cars;
import racingcar.car.Cars;

import java.util.List;

public class Output {


    public static void printWaitCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printWaitTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printAnnounce() {
        System.out.println("실행 결과");
    }

    public static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + convertDash(car.getDistance()));
        }
    }

    public static void printSpace() {
        System.out.println();
    }


    private static String convertDash(int position) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static void printGameWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
