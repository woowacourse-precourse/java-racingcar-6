package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> carNames = new ArrayList<String>();
    private int tryCnt;

    public int getTryCnt() {
        String input = Console.readLine();
        return validateTryCnt(input);
    }
    private int validateTryCnt(String input) {
        try{
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public List<String> getCarNames() {
        String input = Console.readLine();
        return splitCarNames(input);
    }

    private List<String> splitCarNames(String input) {

        String[] nameArray = input.split(",");

        for (String name : nameArray) {
            validateCarNameAndAdd(name);
        }
        return carNames;
    }

    private void validateCarNameAndAdd(String name) {
        if (name.length() <= 5) {
            carNames.add(name);
        } else {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
    }
}
