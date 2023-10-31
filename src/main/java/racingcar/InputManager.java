package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public String readNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String enteredNames = readLine();
        if (!Validation.validNames(enteredNames))
            throw new IllegalArgumentException("영어와 쉼표로만 입력해주세요.");

        return enteredNames;
    }

    public int readNumberOfTimes() {
        return 0;
    }
}
