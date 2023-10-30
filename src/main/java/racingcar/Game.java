package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void startGame() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> validCarNames = this.getCarName();
    }

    private List<String> getCarName() {
        String input = Console.readLine();
        return splitCarNames(input);
    }
    private List<String> splitCarNames(String input) {

        String[] nameArray = input.split(",");
        List<String> validCarNames = new ArrayList<>();

        for (String name : nameArray) {
            if (this.validateName(name)) {
                validCarNames.add(name);
            }
        }
        return validCarNames;
    }
    private boolean validateName(String name) {
        if (name.length() <= 5) {
            return true;
        }else {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
        }
    }


}
