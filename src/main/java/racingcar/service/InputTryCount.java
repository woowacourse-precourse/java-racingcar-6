package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.ErrorMessage;

public class InputTryCount {
    public static int setInputTryCount() {
        int tryCount = 0;
        String input = Console.readLine();
        tryCount = Integer.parseInt(input);
        checkNumber(tryCount);
        return tryCount;
    }

    public static void checkNumber(int tryCount){
        if(tryCount<1){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUM_ERROR);
        }
    }
}
