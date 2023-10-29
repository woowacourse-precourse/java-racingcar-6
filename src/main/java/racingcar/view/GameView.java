package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validate.UserInputValidation;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class GameView {
    private final static String COMMA = ",";
    private final static String DASH = "-";

    public List<String> getCarNames(final UserInputValidation<List<String>> userInputValidation) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();

        List<String> carNames = Arrays.stream(userInput.split(COMMA)).toList();

        if (!userInputValidation.validate(carNames)) throw new IllegalArgumentException();
        return carNames;
    }

    public int getRoundNumber(final UserInputValidation<String> userInputValidation) {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = Console.readLine();

        if (!userInputValidation.validate(userInput)) throw new IllegalArgumentException();
        return Integer.parseInt(userInput);
    }


    public void printRoundResult(final Queue<List<Car>> roundSnapshots) {
        System.out.println("\n실행 결과");
        StringBuilder sb = new StringBuilder();
        while (!roundSnapshots.isEmpty()) {
            List<Car> roundSnapshot = roundSnapshots.poll();
            addRoundResult(roundSnapshot, sb);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private void addRoundResult(final List<Car> roundSnapshot, final StringBuilder sb) {
        for (Car car : roundSnapshot) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(DASH.repeat(car.getMoveCount()))
                    .append("\n");
        }
    }

    public void printGameWinner(final List<String> winnerCarNames) {
        String winnerCarsNameToString = String.join(COMMA, winnerCarNames);
        System.out.println("최종 우승자 : " + winnerCarsNameToString);
    }
}
