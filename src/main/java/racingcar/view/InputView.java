package racingcar.view;

import static racingcar.system.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestCarNamesInput(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine();
        return carNames;
    }

    public String requestRepeatTimesInput(){
        System.out.println(INPUT_REPEAT_TIMES_MESSAGE);
        String repeatTimes = Console.readLine();
        return repeatTimes;
    }
}
