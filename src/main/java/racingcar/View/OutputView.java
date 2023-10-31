package racingcar.View;

import static racingcar.Message.OutputMessage.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.Domain.Car;
import racingcar.Domain.Race;

public class OutputView {

    public void printResult(List<Car> cars){
        printResultMessage();
        printRaceResult(cars);
    }

    public void printResultMessage(){
        System.out.println(RESULT_MESSAGE);;
    }

    public void printRaceResult(List<Car> cars) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : cars) {
            raceResult.append(car.getName()).append(CAR_DELIMITER).append(RACE_MARK.repeat(car.getPosition())).append("\n");
        }
        System.out.println(raceResult);;
    }

    public void printWinner(List<Car> cars){
        if (cars.size()>1){
            printWinners(cars);
        } else printSoleWinner(cars);
    }

    public void printSoleWinner(List<Car> car){
        System.out.println(car.get(0).getName());
    }

    public void printWinners(List<Car> cars){
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners.add(car.getName());
        }
        String resultWinners = String.join(WINNER_DELIMITER,winners);
        System.out.println(resultWinners+WINNER_MESSAGE);
    }
}