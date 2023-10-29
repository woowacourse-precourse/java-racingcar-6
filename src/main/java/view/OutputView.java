package view;

import java.util.List;
import message.OutputMessages;
import model.Car;
import model.Winner;

public class OutputView {

    private static final Winner winner = new Winner();

    public static void printRacingResult(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinners(List<Car> carList) {
        System.out.println(OutputMessages.RACE_WINNERS + winner.getWinners(carList));
    }

}
