package racingcar.view;

import static racingcar.constant.CarConstant.MAX_MOVE_COUNT;
import static racingcar.constant.CarConstant.MIN_MOVE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarName;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;
import racingcar.validator.Validator;

/*
 *   사용자의 입력을 담당
 * */
public class InputView {
    private static final int SIZE_ZERO = 0;

    public CarNames carNames() {
        String input = Console.readLine();
        //가독성 괜찮나?
        List<CarName> carNames = Arrays.stream(input.split(",")).map((carName) -> new CarName(carName)).toList();
        return CarNames.from(carNames);
    }


    public MoveCount moveCount() {
        String input = Console.readLine();
        Validator.commandToInteger(input);
        int moveCount = Integer.parseInt(input);
        Validator.commandValueInRange(moveCount, MIN_MOVE_COUNT, MAX_MOVE_COUNT);
        System.out.println();
        return new MoveCount(moveCount);
    }
}
