package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validation.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Input {
    private final Validation validation = new Validation();

    private final static String COMMA = ",";

    public List<String> InputCarName() {
        String cars = Console.readLine();
        validation.checkCarNameInputForm(cars);
        StringTokenizer carsDivision = new StringTokenizer(cars, COMMA);

        List<String> carNameList = new ArrayList<>();
        while (carsDivision.hasMoreTokens()) {
            String carName = carsDivision.nextToken();
            carNameList.add(carName);
            validation.checkCarNameForm(carName);
        }

        validation.checkDuplicateCarName(carNameList);
        validation.checkCarNum(carNameList);
        return carNameList;
    }

    public int InputTryNum() {
        String tryNumInput = Console.readLine();
        validation.checkTryNumType(tryNumInput);

        int tryNum = Integer.parseInt(tryNumInput);
        validation.checkTryNum(tryNum);
        return tryNum;
    }
}
