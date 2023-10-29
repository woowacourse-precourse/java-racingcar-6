package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
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
        List<String> carNameList = new ArrayList<>();

        String carNames = Console.readLine();
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            carName = carName.replaceAll(" ", "");
            if (carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches("[a-zA-Z]")) {
                throw new IllegalArgumentException();
            }
            carNameList.add(carName);
        }
        return carNameList;
    }

    static int inputTryTimes() throws IllegalArgumentException {
        int tryTimes = 0;
        try {
            tryTimes = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }
        if (tryTimes == 0) {
            throw new IllegalArgumentException();
        }
        return tryTimes;
    }
}
