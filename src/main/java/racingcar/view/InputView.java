package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String[] inputRacingCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = readLine().split(",");
        for (String name : names) {
            isValidNameLength(name);
        }
        return names;
    }

    public void isValidNameLength(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5글자 이하만 가능합니다.");
        }
    }
}
