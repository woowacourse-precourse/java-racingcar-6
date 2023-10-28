package racingcar;

import java.util.List;

public class ResultView {
    public static void printCarPosition(Car car) {
        System.out.println(car.nameAndPosition());
    }

    public static void printLineBreak() {
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        String winners = Race.findWinners(cars);
        System.out.print("최종 우승자 : " + winners);
    }

    public static void printResultNotification() {
        System.out.println("실행 결과");
    }
}
