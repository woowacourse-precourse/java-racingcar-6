package racingcar.model;

import camp.nextstep.edu.missionutils.Console;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class User {

    private List<String> carNamesList;
    private int tryCount;

    public User() {
    }

    public void inputCarNames() {
        InputView.inputCarName();

        String carNames = Console.readLine();

        String[] carNamesSplit = carNames.split(",");
        carNamesList = Arrays.asList(carNamesSplit);

        checkCarNameExceed5Digits(carNamesList);
    }

    public int inputTryCount() {
        InputView.inputTryCount();

        String tryCountString = Console.readLine();

        tryCount = Integer.parseInt(tryCountString);

        return tryCount;
    }

    public void checkCarNameExceed5Digits(List<String> userInputCarNames) {
        for(String carName : userInputCarNames) {
            if(carName.length() > 5) {
                throw new IllegalArgumentException("차 이름이 5자를 초과하였습니다.");
            }
        }
    }

    public void checkTryCountIsNumeric(String tryCountString) {
        try {
            Integer.parseInt(tryCountString);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
    }

    public List<String> getCarNamesList() {
        return carNamesList;
    }

    public int getTryCount() {
        return tryCount;
    }
}
