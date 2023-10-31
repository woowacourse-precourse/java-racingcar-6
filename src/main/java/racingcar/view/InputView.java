package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.SplitCarName;

public class InputView {

    public String[] inputCarNames(){
        String carNames = Console.readLine();
        return SplitCarName.splitCarNames(carNames);
    }
}
