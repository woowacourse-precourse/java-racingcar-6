package view;

import java.util.List;
import java.util.stream.Collectors;
import model.Car;
import model.Cars;
import model.Winners;

public class OutputView {
    static final String EXECUTION_RESULT = "실행 결과";
    static final String FINAL_WINNER = "최종 우승자 : ";
    static final String DELIMITER = ", ";
    static final String SYMBOL = "-";

    public void printResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + printSymbol(car));
        }
        System.out.println();
    }

    public String printSymbol(Car car){
        return  SYMBOL.repeat(car.getNowPlace());
    }

    public void printWinner(Winners winners) {
        if (winners.isMultiple()) {
            System.out.print(FINAL_WINNER + addDelimiter(winners.getWinners()));
            return;
        }
        System.out.println(FINAL_WINNER + winners.getOne());
    }
    public String addDelimiter(List<Car> car){
        return car.stream().map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
