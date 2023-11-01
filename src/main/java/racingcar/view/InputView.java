package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;

/*
 *   사용자의 입력을 담당
 * */
public class InputView {

    public CarNames carNames() {
        String input = Console.readLine();
        return CarNames.fromInput(input);
    }

    public MoveCount moveCount() {
        String input = Console.readLine();
        System.out.println();
        return MoveCount.fromInput(input);
    }
}
