package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameHost racingCarHost;
        System.out.println(GAME_PROGRESS_STATEMENT.INPUT_CAR_NAME);
        racingCarHost = GameHost.addCars(inputCarNames());
        System.out.println(GAME_PROGRESS_STATEMENT.TRY_COUNT);
        final int moveCount = inputMoveCount();

        for (int i = 1; i <= moveCount; i++) {
            racingCarHost.playOneTurn();
        }
        System.out.println(GAME_PROGRESS_STATEMENT.GAME_RESULT);
        System.out.println(GAME_PROGRESS_STATEMENT.WINNER);
    }

    private static int inputMoveCount() {
        return 0;
    }

    private static Collection<Car> inputCarNames() {
        String carNames = Console.readLine();
        return extractCarNames(carNames);
    }

    private static Collection<Car> extractCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).map(Car::new).collect(Collectors.toList());
    }
}
