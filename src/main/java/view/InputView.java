package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import message.InputMessages;

public class InputView {

    public List<String> getCarNames() {
        System.out.println(InputMessages.REQUEST_CAR_NAMES);
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.asList(carNames.split(","));
        System.out.println("carNameList = " + carNameList);
        return carNameList;
    }

    public void getTryCount() {
    }
}
