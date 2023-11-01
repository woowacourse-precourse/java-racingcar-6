package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private final Validator validator = new Validator();

    private final static String COMMA = ",";

    public List<String> InputCarName() {
        String cars = Console.readLine();
        validator.checkCarNameInputForm(cars);
        StringTokenizer carsDivision = new StringTokenizer(cars, COMMA);

        List<String> carNameList = new ArrayList<>();
        while (carsDivision.hasMoreTokens()) {
            String carName = carsDivision.nextToken();
            carNameList.add(carName);
            validator.checkCarNameForm(carName);
        }

        validator.checkDuplicateCarName(carNameList);
        validator.checkCarNum(carNameList);
        return carNameList;
    }

    public int InputTryNum() {
        String tryNumInput = Console.readLine();
        validator.checkTryNumType(tryNumInput);

        int tryNum = Integer.parseInt(tryNumInput);
        validator.checkTryNum(tryNum);
        return tryNum;
    }
}
