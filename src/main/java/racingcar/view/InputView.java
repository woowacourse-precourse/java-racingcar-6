package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Constant;

public class InputView {

    public static String inputCalNames(){
        System.out.println(Constant.INPUT_CAR_NAMES);
        return Console.readLine();
    }

    public static String inputRepetitions(){
        System.out.println(Constant.INPUT_REPETITIONS);
        return Console.readLine();
    }
}
