package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {

    public void play() {
        String carNames = inputCarNames();
        List<String> carNameList = parseCarNamesToList(carNames);
        List<Integer> moveCountList = new ArrayList<>(Collections.nCopies(carNameList.size(), 0));
        int trialTimes = inputTrialTimes();

        System.out.println("실행 결과");
        for (int i = 0; i < trialTimes; i++) {
            moveForward(moveCountList);
            printCurrentPosition(carNameList, moveCountList);
        }

        String winner = findWinner(carNameList, moveCountList);
        System.out.println("최종 우승자 : " + winner);
    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static List<String> parseCarNamesToList(String carNames) {
        List<String> carNameList = Arrays.stream(carNames.split(","))
                .filter(name -> name.length() <= 5)
                .collect(Collectors.toList());

        carNamesValidation(carNames, carNameList);

        return carNameList;
    }

    private static void carNamesValidation(String carNames, List<String> carNameList) {
        checkHasOverFiveChar(carNames, carNameList);
        checkHasEmptyName(carNames, carNameList);
    }

    private static void checkHasOverFiveChar(String carNames, List<String> carNameList) {
        if (carNameList.size() != carNames.split(",").length) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private static void checkHasEmptyName(String carNames, List<String> carNameList) {
        if (carNameList.size() != countChar(carNames, ',') + 1) {
            throw new IllegalArgumentException("자동차 이름을 빈 문자열로 정할 수 없습니다.");
        }
    }

    private static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }


    private static int inputTrialTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTrialTimes = Console.readLine();
        return checkIsPositiveInteger(inputTrialTimes);
    }

    private static int checkIsPositiveInteger(String inputTrialTimes) {
        try {
            int trialTimes = Integer.parseInt(inputTrialTimes);
            if (trialTimes <= 0) {
                throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
            }
            return trialTimes;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 회수는 양의 정수여야 합니다.");
        }
    }

    private static void moveForward(List<Integer> moveCountList) {
        for (int i = 0; i < moveCountList.size(); i++) {
            moveOrNot(moveCountList, i);
        }
    }

    private static void moveOrNot(List<Integer> moveCountList, int i) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            move(moveCountList, i);
        }
    }

    private static void move(List<Integer> moveCountList, int i) {
        Integer currentValue = moveCountList.get(i);
        moveCountList.set(i, currentValue + 1);
    }

    private static void printCurrentPosition(List<String> carNameList, List<Integer> moveCountList) {
        for (int i = 0; i < carNameList.size(); i++) {
            System.out.println(carNameList.get(i) + " : " + "-".repeat(moveCountList.get(i)));
        }
        System.out.println();
    }

    private static String findWinner(List<String> carNameList, List<Integer> moveCountList) {

        int max = getMax(moveCountList);
        List<Integer> maxIndices = getMaxIndices(moveCountList, max);

        return getWinner(carNameList, maxIndices);
    }

    private static int getMax(List<Integer> moveCountList) {
        return moveCountList.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static List<Integer> getMaxIndices(List<Integer> moveCountList, int max) {
        return IntStream.range(0, moveCountList.size())
                .filter(i -> moveCountList.get(i) == max)
                .boxed()
                .toList();
    }

    private static String getWinner(List<String> carNameList, List<Integer> maxIndices) {
        String winner = maxIndices.stream()
                .map(index -> carNameList.get(index))
                .collect(Collectors.joining(", "));
        return winner;
    }

}


