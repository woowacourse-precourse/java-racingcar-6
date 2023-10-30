package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class OutputView {
    private static String ONE_TURN_MESSAGE = "실행 결과";

    public static void gameStartMessage(){
        System.out.println(ONE_TURN_MESSAGE);
    }
    public static void oneTurnResult(Cars cars){
        for(Car car : cars.getCarList()){
            System.out.println(car.getName() + " : " + car.getCarDistanceChar());
        }
        System.out.println();
    }
}
