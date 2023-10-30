package racingcar.View;

import static racingcar.Message.OutputMessage.*;

import java.util.List;
import racingcar.Domain.Car;

public class OutputView {

    public void printResult(List<Car> cars){
        System.out.println(printResultMessage());
        System.out.println(printRaceResult(cars));
    }

    public String printResultMessage(){
        return RESULT_MESSAGE;
    }

    public String printRaceResult(List<Car> cars) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : cars) {
            raceResult.append(car.getName()).append(CAR_DELIMITER).append(RACE_MARK.repeat(car.getPosition())).append("\n");
        }
        return raceResult.toString();
    }
}