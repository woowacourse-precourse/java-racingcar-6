package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        racingGame();

    }

    private static void racingGame () {
        String carNames = inputCarNames();
        int trialTimes = inputTrialTimes();
        List<String> carNameList = parseCarNamesToList(carNames);
        List<Integer> moveCountList = new ArrayList<>(Collections.nCopies(carNameList.size(), 0));

        for (int i = 0; i < trialTimes; i++) {
            moveForward(moveCountList);
        }

    }

    private static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }

    private static int inputTrialTimes() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static List<String> parseCarNamesToList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
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
}
