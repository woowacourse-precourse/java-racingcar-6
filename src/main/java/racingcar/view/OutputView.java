package racingcar.view;


import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String RACING_ROAD = "-";
    private static int maxPosition;
    private static List<String> winners;

    public static void printRacingProcess(String carName, int position) {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(RACING_ROAD);
        }
        System.out.println();
    }

    public static void printWinner() {
        findWinner();
        addWinner();
        System.out.println("\n최종 우승자 : " + String.join(DELIMITER, winners));
    }

    private static void findWinner() {
        maxPosition = 0;
        for (Car car : Cars.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }

    private static void addWinner() {
        winners = new ArrayList<>();
        for (Car car: Cars.cars) {
            if (isWinner(car)) {
                winners.add(car.getName());
            }
        }
    }

    private static boolean isWinner(Car car) {
        return car.getPosition() == maxPosition;
    }
}