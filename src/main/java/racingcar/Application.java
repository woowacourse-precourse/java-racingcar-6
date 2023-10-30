package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

        Map<String, Integer> carMap = makeCarMap(carNames);

        int tryCount = askTryCount();
        for (int i = 0; i < tryCount; i++) {
            playRound(carMap);
        }

        List<String> winners = findWinners(carMap);
        printFinalResult(winners);
    }

    public static Map<String, Integer> makeCarMap(String carNames) {
        Map<String, Integer> carMap;
        try {
            carMap = Stream.of(carNames.split(","))
                    .collect(Collectors.toMap(carName -> carName, position -> 0));
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("중복된 이름의 자동차가 존재합니다.");
        }
        return carMap;
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

    public static void playRound(Map<String, Integer> carMap) {
        for (String carName : carMap.keySet()) {
            moveForward(carMap, carName);
            printRoundResult(carMap, carName);
        }
        System.out.println();
    }

    public static void printRoundResult(Map<String, Integer> carMap, String carName) {
        System.out.println(carName + " : " + "-".repeat(carMap.get(carName)));
    }

    public static void moveForward(Map<String, Integer> carMap, String carName) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            carMap.put(carName, carMap.get(carName) + 1);
        }
    }

    public static List<String> findWinners(Map<String, Integer> carMap) {
        List<String> winners = new ArrayList<>();
        int maxScore = Collections.max(carMap.values());
        for (String carName : carMap.keySet()) {
            if (carMap.get(carName) == maxScore) {
                winners.add(carName);
            }
        }
        return winners;
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