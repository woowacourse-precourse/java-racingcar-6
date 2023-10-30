package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    public static List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Mapper.changeToListString(Console.readLine());
        Validator.carName(carNames);
        return carNames;
    }

    public static int inputMoveChance() {
        System.out.println("시도할 회수는 몇회인가요?");
        int moveNumber = Mapper.changeToInteger(Console.readLine());
        Validator.moveNumber(moveNumber);
        return moveNumber;
    }

}
