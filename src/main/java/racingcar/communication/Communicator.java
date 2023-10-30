package racingcar.communication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import racingcar.game.GameProgress;
import racingcar.game.car.Car;

public class Communicator {
    private static final String EXIT_MESSAGE = "시스템을 종료합니다.";
    private static final String TRIALS_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String CARS_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String RESULT_BEGIN_MESSAGE = "실행 결과";
    private static final String INPUT_SPLITTER = ",";
    private static final String WINNER_DELIMITER = ", ";

    public static List<String> instructInputCars() {
        printStart();
        String carsInput = Console.readLine();
        return Arrays.stream(carsInput.split(INPUT_SPLITTER))
                .map(String::strip)
                .toList();
    }

    public static int instructInputTrials() {
        printInputTrials();
        return Integer.parseInt(Console.readLine());
    }

    public static void printResult(List<GameProgress> gameResult) {
        System.out.println(RESULT_BEGIN_MESSAGE);
        gameResult.forEach(Communicator::printProgress);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::displayName)
                .collect(Collectors.joining(WINNER_DELIMITER));
        System.out.println(WINNER_MESSAGE + winnerNames);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
        printExit();
    }

    private static void printProgress(GameProgress gameProgress) {
        System.out.println(gameProgress.convertResultToString() + System.lineSeparator());
    }

    private static void printExit() {
        System.out.println(EXIT_MESSAGE);
    }

    private static void printInputTrials() {
        System.out.println(TRIALS_INPUT_MESSAGE);
    }

    private static void printStart() {
        System.out.println(CARS_INPUT_MESSAGE);
    }
}
