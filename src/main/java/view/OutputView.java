package view;

import java.util.List;
import model.Car;
import model.Cars;

public class OutputView {

    private static final String RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private static final String COMMA = ",";
    private static final String STATUS_SEPARATOR = " : ";

    public void displayResult() {
        System.out.println(RESULT);
    }

    public void displayFinalWinner(Cars cars) {
        List<Car> finalWinner = cars.findCarsWithMaxMovingCount();
        System.out.print(FINAL_WINNER + STATUS_SEPARATOR);
        System.out.println(String.join(COMMA, finalWinner.stream()
                .map(Car::toString)
                .toList())
        );
    }

    public void displayCurrentRacingStatus(Cars cars) {
        System.out.println(cars.getAllCarsStatus());
    }
}
