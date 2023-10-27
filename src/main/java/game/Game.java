package game;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static exception.Validator.validateCarNameLength;

public class Game {
    public void start() {
        getCarNameInput();
    }

    private void getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNameLength(carNameList);
    }
}
