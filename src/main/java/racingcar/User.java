package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> carNames = new ArrayList<String>();
    private int tryCnt;

    public int getTryCnt() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return validateTryCnt(input);
    }

    private int validateTryCnt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return splitCarNames(input);
    }

    private List<String> splitCarNames(String input) {

        String[] nameArray = input.split(",");

        for (String name : nameArray) {
            if (validateCarName(name)) {
                addCarName(name);
            }
        }
        return carNames;
    }

    private boolean validateCarName(String name) {
        if (name.length() <= 5) {
            return true;
        } else {
            throw new IllegalArgumentException("5 이하 길이");
        }
    }

    private void addCarName(String name) {
        carNames.add(name);
    }
}
