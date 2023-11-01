package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final int NAME_SIZE = 5;
    private final Exception exception = new Exception();

    public String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public List<String> validateInputCarNames(String names) {
        if (!names.contains(",")) {
            exception.checkCountCarNames();
        }

        String[] inputNames = names.split(",");
        List<String> carNames = new ArrayList<>();
        for (int i = 0; i < inputNames.length; i++) {
            if (inputNames[i].contains(" ")) {
                exception.checkSpace();
            }
            if (inputNames[i].length() > NAME_SIZE) {
                exception.checkLengthCarName();
            }
            if (carNames.contains(inputNames[i])) {
                exception.checkDuplicate();
            }
            carNames.add(inputNames[i]);
        }
        return carNames;
    }

    public String inputCounts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public int validateInputCounts(String counts) {
        if (counts.length() < 1) {
            exception.checkNothing();
        }
        for (char ch : counts.toCharArray()) {
            if (!Character.isDigit(ch)) {
                exception.checkIsDigit();
            }
        }
        return Integer.parseInt(counts);
    }

}