package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ROUND_RESULT = "%s : %s";
    private static final String DISTANCE_RESULT = "-";

    public static void printResultMessage(){
        System.out.println(RESULT_MESSAGE);
    }

    public static void printRoundResult(List<Car> carList){
        for (Car car : carList){
            System.out.printf(ROUND_RESULT, car.getCarName(), DISTANCE_RESULT.repeat(car.getDistance()));
            System.out.println();
        }
    }
}
