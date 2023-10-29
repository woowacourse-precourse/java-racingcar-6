package racingcar;

import java.util.List;

public class InputAndOutput {
    static void outputMessage(String message) {
        System.out.println(message);
    }

    static void outputRaceResult(List<Car> carList) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : carList) {
            raceResult.append(car.getName()).append(" : ").append(car.getGoOrStopRecord().toString()).append("\n");
        }
        System.out.println(raceResult.toString());
    }

    static void outputRaceWinner(List<Car> carList) {

    }

    static List<String> inputCarNames() throws IllegalArgumentException {
        return null;
    }

    static int inputTryTimes() throws IllegalArgumentException {
        return 0;
    }
}
