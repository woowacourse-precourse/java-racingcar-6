package game;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static exception.Validator.validateCarNameLength;
import static exception.Validator.validateNaturalNumber;

public class Game {
    public void start() {
        getCarNameInput();
        getRoundInput();
    }

    private void getCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = readLine().split(",");
        validateCarNameLength(carNameList);
    }

    private void getRoundInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        final int COUNT = Integer.parseInt(readLine());
        validateNaturalNumber(COUNT);

        System.out.println();
    private boolean canCarMoveForward(int number) {
        final int MIN_FORWARD_COUNT = 4;

        return number >= MIN_FORWARD_COUNT;
    }

    }
}
