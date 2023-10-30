package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Communicator {
    public static List<String> instructInputCars() {
        printStart();
        String carsInput = Console.readLine();
        List<String> cars = Arrays.stream(carsInput.split(","))
                .map(String::strip)
                .toList();
        Validator.validateCars(cars);
        return cars;
    }

    public static int instructInputTrials() {
        printInputTrials();
        return Integer.parseInt(Console.readLine());
    }

    public static void printResult(List<GameProgress> gameResult) {
        System.out.println("실행 결과");
        gameResult.forEach(Communicator::printProgress);
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::displayName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
        printExit();
    }

    private static void printProgress(GameProgress gameProgress) {
        System.out.println(gameProgress.convertResultToString() + System.lineSeparator());
    }

    private static void printExit() {
        System.out.println("시스템을 종료합니다.");
    }

    private static void printInputTrials() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void printStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
