package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final int SOLO = 1;
    private static void printHead() {
        System.out.println("실행 결과");
    }

    public static void printScore(List<Car> cars) {
        for(Car car : cars) {
            printCarScore(car);
        }
        System.out.println(); // car 한대의 이름과 점수 출력하고 줄바꿈
    }

    public static void printWinners(List<String> carNames) {
        System.out.println("최종 우승자 : ");
        System.out.println(carNames.get(0));
        if(checkSoloWin(carNames)) {
            System.out.println();
            return;
        }
        for(int i = 1; i < carNames.size(); i++) {
            System.out.println(", ");
            System.out.println(carNames.get(i));
        }
        System.out.println();
    }

    public static void printException(String message) {
        System.out.println(message);
    }

    public static void printCarScore(Car car) {
        System.out.println(car.getName() + " : ");
        printPositionCar(car);
        System.out.println();
    }

    public static void printPositionCar(Car car) {
        for(int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static boolean checkSoloWin(List<String> carNames) {
        return carNames.size() == SOLO;
    }
}
