package racingcar.Exception;

import java.util.List;
import racingcar.Util.StringToList;

public class CarNameException {
    private final StringToList stringToList = new StringToList();
    private static final String BLANK = " ";

    public void validateCarNameInput(String carNameInput) throws IllegalArgumentException {
        List<String> carNameList = stringToList.analysisCarNames(carNameInput);
        checkCarNameIsOutOfRangeAndBlank(carNameList);

        checkInputIsEmpty(carNameInput);
    }
    private void checkCarNameIsOutOfRangeAndBlank(List<String> carNameList) {
        for (String carName : carNameList) {
            checkIntervalBlank(carName);
        }
    }
    private void checkInputIsEmpty(String carNameInput) {
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
    private void checkIntervalBlank(String carName) {
        if (carName.contains(BLANK)) {
            throwBlankException();
        }
    }

    private void throwBlankException() {
        throw new IllegalArgumentException("자동차 이름안에는 공백이 있어서는 안됩니다.");
    }
}
