package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_INTRODUCTION = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static final String COLON = " : ";

    public void printResultIntroduction(){
        System.out.println(RESULT_INTRODUCTION);
    }

    public void printEachGameResult(List<Car> cars){
        for(Car car : cars){
            System.out.println(car.getName() + COLON + car.getCarMovedResult());
        }
    }
}
