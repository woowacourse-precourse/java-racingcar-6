package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printInputCarNameMessage();
        final String carNames = readCarNames();
        final List<String> carNameList = getCarNameListFromCarNames(carNames);
        final List<Car> carList = getCarList(carNameList);
        printInputTryCountMessage();
        final int tryCount = readTryCount();
        printNewLine();
        printExecutionResult();
        for(int i = 0; i < tryCount; i++) {
            moveForward(carList);
            printCarNameAndDistanceStringInCarList(carList);
            printNewLine();
        }
        printWinnersFromCarList(carList);
        Console.close();
    }

    public static void printInputCarNameMessage() {
        final String STRING_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        System.out.println(STRING_INPUT_CAR_NAME);
    }

    public static String readCarNames() {
        final String carNames = Console.readLine();
        return carNames;
    }

    public static List<String> getCarNameListFromCarNames(final String carNames) {
        final String DELIMITER_CAR_NAMES = ",";
        final String[] carNamesSplittingByDelimiter = carNames.split(DELIMITER_CAR_NAMES);
        final List<String> carNameList = Arrays.asList(carNamesSplittingByDelimiter);
        return Collections.unmodifiableList(carNameList);
    }

    public static void printInputTryCountMessage() {
        final String STRING_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
        System.out.println(STRING_INPUT_TRY_COUNT);
    }

    public static int readTryCount() {
        final String tryCount = Console.readLine();
        try {
            final int tryCountConvertedToInt = Integer.parseInt(tryCount);
            return tryCountConvertedToInt;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printExecutionResult() {
        final String STRING_EXECUTION_RESULT = "실행 결과";
        System.out.println(STRING_EXECUTION_RESULT);
    }

    public static List<Car> getCarList(final List<String> carNameList) {
        final List<Car> carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(carList);
    }

    public static void moveForward(final List<Car> carList) {
        carList.stream().forEach(Car::moveForward);
    }

    public static void printCarNameAndDistanceStringInCarList(final List<Car> carList) {
    }

    public static List<Car> getCarListWithLongestDistance(final List<Car> carList) {
        final int longestDistance = getLongestDistanceFromCarList(carList);
        final List<Car> carListWithLongestDistance = filterCarListWithLongestDistance(carList, longestDistance);
        return Collections.unmodifiableList(carListWithLongestDistance);
    }

    private static int getLongestDistanceFromCarList(final List<Car> carList) {
        int longestDistance = carList.stream().mapToInt(Car::getDistance).max().orElse(0);
        return longestDistance;
    }

    private static List<Car> filterCarListWithLongestDistance(final List<Car> carList, final int longestDistance) {
       return carList.stream()
                .filter(car -> car.getDistance() == longestDistance)
                .collect(Collectors.toList());
    }

    public static String getWinnersFromCarList(final List<Car> carList) {
        final List<Car> carListWithLongestDistance = getCarListWithLongestDistance(carList);
        final List<String> winnerList = carListWithLongestDistance.stream()
                .map(Car::getName).collect(Collectors.toList());
        final String STRING_WINNER_DELIMITER = ", ";
        final String winners = String.join(STRING_WINNER_DELIMITER, winnerList);
        return winners;
    }

    public static void printWinnersFromCarList(final List<Car> carList) {
        final String STRING_WINNER_MESSAGE = "최종 우승자 : ";
        String winners = getWinnersFromCarList(carList);
        System.out.print(STRING_WINNER_MESSAGE);
        System.out.println(winners);
    }
}
