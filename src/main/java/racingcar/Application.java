package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameHost racingCarHost;
        announce(GAME_PROGRESS_STATEMENT.INPUT_CAR_NAME);
        racingCarHost = GameHost.addCars(inputCarNames());
        announce(GAME_PROGRESS_STATEMENT.TRY_COUNT);
        final int MOVING_FORWARD = inputMovingForward();

        announce(GAME_PROGRESS_STATEMENT.GAME_RESULT);
        for (int i = 1; i <= MOVING_FORWARD; i++) {
            racingCarHost.playOneTurn();
            System.out.println();
        }

        announce(GAME_PROGRESS_STATEMENT.WINNER);
        announce(racingCarHost.announceWinner());
    }

    private static int inputMovingForward() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("반복횟수는 정수로 입력하세요");
        }
    }

    private static Collection<Car> inputCarNames() {
        String carNames = Console.readLine();
        return extractCarNames(carNames);
    }

    private static Collection<Car> extractCarNames(String carNames) {
        return Arrays.stream(carNames.split(",")).map(Car::new).collect(Collectors.toList());
    }

    private static void announce(GAME_PROGRESS_STATEMENT statement) {
        System.out.print(statement.getValue());
    }

    private static void announce(String statement) {
        System.out.println(statement);
    }
}
