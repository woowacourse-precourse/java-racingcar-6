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
        String winners = findWinners(cars);
        System.out.print("최종 우승자 : " + winners);
    }

    private static String findWinners(List<Car> carList) {
        int maxPositionLength = 0;
        for (Car car : carList) {
            if (car.getPositionLength() > maxPositionLength) {
                maxPositionLength = car.getPositionLength();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPositionLength() == maxPositionLength) {
                winners.add(car.getName());
            }
        }
        return String.join(", ", winners);
    }

    public static void printResultNotification() {
        System.out.println("실행 결과");
    }
}
