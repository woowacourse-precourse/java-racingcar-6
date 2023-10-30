package racingcar.view;

import racingcar.domain.Car;

public class OutputMessage {
    static final String BAR = "-";
    public static void printPlayOutputMessage() {
        System.out.println("실행 결과");
    }

    public static void printRacingProgressOutputMessage(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getDistance(); i++) {
            System.out.println(BAR);
        }
        System.out.println();
    }
}
