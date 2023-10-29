package view;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String inputName() {
        String inputName = readLine();
        return inputName;
    }

    public String inputTryNumber() {
        String inputTryNumber = readLine();
        return inputTryNumber;
    }
}
