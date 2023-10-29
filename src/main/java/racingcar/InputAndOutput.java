package racingcar;

import java.util.List;

public class InputAndOutput {
    static void outputMessage(String message) {
        System.out.println(message);
    }

    static void outputRaceResult(List<Car> carList) {
        StringBuilder raceResult = new StringBuilder();
        for (Car car : carList) {
            raceResult.append(car.getName()).append(" : ");
            for (String record : car.getGoOrStopRecord()) {
                raceResult.append(record);
            }
            raceResult.append("\n");
        }
        System.out.print(raceResult.toString());
    }

    static void outputRaceWinner(List<String> winnerList) {
        StringBuilder raceWinner = new StringBuilder();
        raceWinner.append("최종 우승자").append(" : ");
        raceWinner.append(String.join(", ", winnerList));
        System.out.println(raceWinner.toString());
    }

    static List<String> inputCarNames() throws IllegalArgumentException {
        return null;
    }

    static int inputTryTimes() throws IllegalArgumentException {
        return 0;
    }
}
