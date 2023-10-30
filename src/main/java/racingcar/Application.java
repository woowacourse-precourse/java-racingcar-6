package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNames = Console.readLine();
        if (isNotValidInput(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 영어 또는 한글만 가능합니다. 쉼표(,)로 구분하여 두 대 이상 입력해주세요.");
        }

        Set<Car> carSet = makeCarSet(carNames);
        if (isDuplicateName(carNames, carSet)) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
        }

        int tryCount = askTryCount();
        for (int i = 0; i < tryCount; i++) {
            playRound(carSet);
        }

        List<String> winners = findWinners(carSet);
        printFinalResult(winners);
    }

    public static Set<Car> makeCarSet(String carNames) {
        return Stream.of(carNames.split(","))
                .distinct()
                .map(Car::new)
                .collect(Collectors.toSet());
    }

    public static boolean isDuplicateName(String carNames, Set<Car> carSet) {
        System.out.println(carNames.split(",").length);
        System.out.println(carSet.size());
        return carNames.split(",").length != carSet.size();
    }

    public static int askTryCount() {
        System.out.println("시도할 횟수는 몇회인가요?");

        int tryCount = 0;
        try {
            tryCount = Integer.parseInt(Console.readLine());
            if (tryCount < 1) {
                throw new IllegalArgumentException("시도할 횟수는 1회 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
        return tryCount;
    }

    public static void playRound(Set<Car> carSet) {
        for (Car car : carSet) {
            moveForward(car);
            printRoundResult(car);
        }
        System.out.println();
    }

    public static void printRoundResult(Car car) {
        System.out.println(car.name + " : " + "-".repeat(car.position));
    }

    public static void moveForward(Car car) {
        car.moveForward();
    }

    public static List<String> findWinners(Set<Car> carSet) {
        int maxPosition = carSet.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carSet.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public static void printFinalResult(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    public static boolean isNotValidInput(String input) {
        String regex = "^[A-Za-z가-힣]{1,5}(,[A-Za-z가-힣]{1,5}){1,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return !matcher.matches();
    }
}