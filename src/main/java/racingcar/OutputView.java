package racingcar;

import static racingcar.constant.Constants.GAME_RESULT;
import static racingcar.constant.Constants.INPUT_NAMES;
import static racingcar.constant.Constants.INPUT_TIMES;
import static racingcar.constant.Constants.MOVEMENT;
import static racingcar.constant.Constants.RACE_WINNERS;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private void print(final String message) {
        System.out.print(message);
    }

    private void println(final String message) {
        System.out.println(message);
    }

    public void naming() {
        println(INPUT_NAMES);
    }

    public void counting() {
        println(INPUT_TIMES);
    }

    public void execution() {
        println(GAME_RESULT);
    }

    public void raceOver() {
        print(RACE_WINNERS);
    }


    public void outputOneRaceResult(List<Car> cars) {
        cars.forEach(car -> print(racingProgress(car) + "\n"));
        print("\n");
    }

    public String racingProgress(Car car) {
        return outputForm(car.getName(), car.getPosition());
    }

    public String outputForm(String name, int step) {
        return name + " : " + stepConvertor(step * MOVEMENT);
    }

    public String stepConvertor(int steps) {
        return "-".repeat(Math.max(0, steps));
    }

    public void winnerResult(String winners) {
        raceOver();
        println(winners);

    }
}
