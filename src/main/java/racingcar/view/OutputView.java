package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.Constant;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class OutputView {
    public void askToInsertCarNameList() {
        System.out.println(Constant.INSERT_CAR_NAME_LIST_DIRECTION);
    }

    public void askToInsertNumberOfGames() {
        System.out.println(Constant.INSERT_NUMBER_OF_GAMES_DIRECTION);
    }

    public void printExecutionStartSign() {
        System.out.println();
        System.out.println(Constant.EXECUTION_START_SIGN);
    }

    public void printCarStatus(CarList carList) {
        List<Car> cars = carList.getCarList();
        for (Car car : cars) {
            printCarNameAndDistance(car);
        }
        System.out.println();
    }

    private void printCarNameAndDistance(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println(convertCarDistanceValueToDistanceSymbol(car.getDistance()));
    }

    private String convertCarDistanceValueToDistanceSymbol(Long distance) {
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < distance; i++) {
            sb.append(Constant.CAR_DISTANCE_VALUE_SYMBOL);
        }
        return sb.toString();
    }

    public void printFinalWinner(CarList mostDistanceCarList) {
        System.out.print(Constant.FINAL_WINNER_ANNOUNCEMENT_SIGN);
        String finalWinnerResult = mostDistanceCarList.getCarList()
                .stream().map(Car::getName)
                .collect(Collectors.joining(Constant.FINAL_WINNER_DUPLICATE_DELIMITER));
        System.out.println(finalWinnerResult);
    }
}
