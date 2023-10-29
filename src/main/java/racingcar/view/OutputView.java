package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.Winners;

public class OutputView {
    private static final String OUTPUT_RESULT = "실행 결과";
    private static final String OUTPUT_FINAL_WINNERS = "최종 우승자 : ";
    private static final String OUTPUT_ONE_DISTANCE = "-";
    private static final String OUTPUT_FINAL_WINNERS_DELIMITER = ", ";

    public void printResult(CarList carList) {
        System.out.println(OUTPUT_RESULT);

        printCarList(carList);
    }

    private void printCarList(CarList carList) {
        for (Car car : carList.getCarList()) {
            car.stopOrMove();
            printNameAndDistance(car);
        }
        System.out.println();
    }

    public void printNameAndDistance(Car car) {
        System.out.println(car.getName() + " : " + printDistance(car.getDistance()));
    }

    public String printDistance(int distance) {
        String temp = "";
        for (int i = 0; i < distance; i++) {
            temp += OUTPUT_ONE_DISTANCE;
        }
        return temp;
    }

    public void printWinners(Winners winners) {
        System.out.println(OUTPUT_FINAL_WINNERS + join(winners.getNames()));
    }

    public String join(List<String> input) {
        return String.join(OUTPUT_FINAL_WINNERS_DELIMITER, input);
    }
}