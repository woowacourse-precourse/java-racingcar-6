package view;

import camp.nextstep.edu.missionutils.Console;
import util.CarNameValidation;
import util.TryCountValidation;

public class InputView {
    public String[] inputCarName() {
        return Console.readLine().split(",");
    }

    public int inputTryCount() {
        int tryCount = Integer.parseInt(Console.readLine());
        TryCountValidation.checkTryCountValidation(tryCount);
        return tryCount;
    }
}
