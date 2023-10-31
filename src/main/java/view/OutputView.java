package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.Cars;

public class OutputView {
    static final String EXECUTION_RESULT = "실행 결과";
    static final String FINAL_WINNER = "최종 우승자 : ";

    public void printResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + car.getNowPlace());
        }
        System.out.println();
    }

    public void printWinner(Cars cars) {
        List<Car> winners = cars.getWinner();
        String winnersAndDelimiter = "";
        if (getMultipleWinners(winners)) {
            winnersAndDelimiter = winners.stream().map(Car::getName)
                    .collect(Collectors.joining(", "));
            System.out.print(FINAL_WINNER + winnersAndDelimiter);
        }

    }

    public boolean getMultipleWinners(List<Car> winners) {
        if (winners.size() == 1) {
            System.out.print(FINAL_WINNER + winners.get(0).getName());
            return false;
        }
        return true;
    }
}
