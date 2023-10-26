package view;

import java.util.List;
import model.Car;
import model.Cars;

public class OutputView {

    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COMMA = ",";
    private static final String COLON = ":";
    private static final String SPACE = " ";


    private OutputView() {
    }

    public static void displayResult() {
        System.out.println(RESULT);
    }

    public static void displayFinalWinner(Cars cars) {
        String[] finalWinner = cars.winner();
        System.out.print(FINAL_WINNER + SPACE + COLON + SPACE);
        System.out.println(String.join(COMMA, finalWinner));
    }

    public static void displayCurrentRacingStatus(Cars cars) {
        List<Car> racingCars = cars.getCars();

        for (Car car : racingCars) {
            System.out.println(car.currentRacingStatus());
        }
        System.out.println();
    }
}
