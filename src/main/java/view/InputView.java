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
        return carNameList;
    }

    public String getTryCount() {
        System.out.println(InputMessages.REQUEST_TRY_COUNT);
        String tryCount = Console.readLine();
        System.out.println();
        return tryCount;
    }
}
