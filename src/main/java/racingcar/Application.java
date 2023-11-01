package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    private static final Pattern ALPHABET_AND_HANGUL_PATTERN = Pattern.compile("^[a-zA-Z가-힣]+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^-?[0-9]+$");
    private static final int MIN_VALUE_TO_MOVE_CAR = 4;
    private static final int NAME_MAX_LENGTH = 5;
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;

    public static void main(String[] args) {
        List<Integer> position = new ArrayList<>();
        List<String> cars = inputCarNames();
        int tryCount = inputTryCount();

        validatePositiveTryCount(tryCount);
        for (int i = 0; i < cars.size(); i++) {
            position.add(0);
        }
        getResult(cars, tryCount, position);
        List<String> winners = getWinners(cars, position);
        printWinners(winners);
    }

    private static List<String> inputCarNames() {
        String input = getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        validateBlank(input);
        List<String> cars = toList(input);
        validateCarNames(cars);
        return cars;
    }

    private static int inputTryCount() {
        String input = getInput("시도할 회수는 몇회인가요?");
        validateBlank(input);
        validateInputIsNumber(input);
        return Integer.parseInt(input);
    }

    private static void getResult(List<String> cars, int tryCount, List<Integer> position) {
        System.out.println("실행결과");
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars, position);
            printResult(cars, position);
        }
    }

    private static List<String> getWinners(List<String> cars, List<Integer> position) {
        int maxPosition = getMaxPosition(position);
        return getWinnerNames(cars, position, maxPosition);
    }

    private static void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    private static String getInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static List<String> toList(String input) {
        return Arrays.asList(input.split(","));
    }

    private static boolean canMoveForward() {
        int forwardRandomValue = Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
        return forwardRandomValue >= MIN_VALUE_TO_MOVE_CAR;
    }

    private static void moveCars(List<String> cars, List<Integer> position) {
        for (int i = 0; i < cars.size(); i++) {
            if (canMoveForward()) {
                position.set(i, position.get(i) + 1);
            }
        }
    }

    private static void printResult(List<String> cars, List<Integer> position) {
        for (int j = 0; j < cars.size(); j++) {
            System.out.print(cars.get(j) + " : ");
            System.out.println("-".repeat(position.get(j)));
        }
        System.out.println();
    }

    private static int getMaxPosition(List<Integer> position) {
        return position.stream()
                .mapToInt(value -> value)
                .max()
                .orElseThrow();
    }

    private static List<String> getWinnerNames(List<String> cars, List<Integer> position, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (position.get(i) == maxPosition) {
                winners.add(cars.get(i));
            }
        }
        return winners;
    }

    private static void validateBlank(String input) {
        if (input.isBlank() || input.contains(" ")) {
            throw new IllegalArgumentException("공백 또는 여백이 포함되어 있습니다.");
        }
    }

    private static void validateCarNames(List<String> cars) {
        cars.forEach(name -> {
            validateNamePattern(name);
            validateNameLength(name);
        });
        validateNoDuplicate(cars);
    }

    private static void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5자리 이하로 입력해주세요.");
        }
    }

    private static void validateNamePattern(String name) {
        if (!ALPHABET_AND_HANGUL_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException("차 이름은 영어 또는 한글만 가능합니다.");
        }
    }

    private static void validateNoDuplicate(List<String> cars) {
        long distinctCount = cars.stream()
                .distinct()
                .count();
        if (cars.size() != distinctCount) {
            throw new IllegalArgumentException("[중복 불가] 자동차 이름은 서로 다르게 입력해주세요.");
        }
    }

    private static void validateInputIsNumber(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("시도할 회수는 숫자만 가능");
        }
    }

    private static void validatePositiveTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("1 이상의 양수만 입력 가능.");
        }
    }
}
