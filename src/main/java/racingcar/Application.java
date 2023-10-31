package racingcar;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));

        System.out.println("시도할 회수는 몇회인가요?");
        int rounds = Integer.parseInt(Console.readLine());

        try {
            InputValidator.validateCarNames(carNames);
            InputValidator.validateNumberOfRounds(rounds);

            RacingGame racingGame = new RacingGame(carNames, rounds);
            racingGame.start();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
