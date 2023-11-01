package view;

import static message.OutputMessages.RACE_WINNERS;

import java.util.List;
import model.Car;
import model.Winner;

public class OutputView {

    private static final Winner winner = new Winner();

    public static void printRacingResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinners(List<Car> carList) {
        System.out.println(RACE_WINNERS + winner.getWinners(carList));
    }

}
