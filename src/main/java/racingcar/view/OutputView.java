package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    private static final String GAME_RESULT_TITLE = "실행 결과";
    private static final String GAME_WINNER_FORMAT = "최종 우승자 : %s\n";
    private static final String ONE_STEP = "-";
    private static final String COLON = "%s : ";

    public void printResultTitle(){
        System.out.println(GAME_RESULT_TITLE);
    }

    public void printStatus(List<Car> cars){
        for(Car car: cars){
            System.out.printf(COLON, car.getName());
            System.out.println(ONE_STEP.repeat(car.getStep()));
        }

    }

    public void printWinner(String winner){
        System.out.printf(GAME_WINNER_FORMAT, winner);
    }

}
