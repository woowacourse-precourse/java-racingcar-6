package racingcar.Exception;

import java.util.List;
import racingcar.Util.StringToList;

public class CarNameException {
    private final StringToList stringToList = new StringToList();
    private static final int MINIMUM_CARNAME_LENGTH = 1;
    private static final int MAXIMUM_CARNAME_LENGTH = 5;
    private static final String BLANK = " ";

    public void validateCarNameInput(String carNameInput) throws IllegalArgumentException {
        List<String> carNameList = stringToList.analysisCarNames(carNameInput);
        checkCarNameIsOutOfRangeAndBlank(carNameList);
        checkCarNameIsDuplication(carNameList);

        checkInputIsEmpty(carNameInput);
        checkLastInputIsComma(carNameInput);
    }

    private void checkCarNameIsOutOfRangeAndBlank(List<String> carNameList) {
        for (String carName : carNameList) {
            checkLength(carName);
            checkIntervalBlank(carName);
        }
    }

    private void checkCarNameIsDuplication(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                carNamesComparison(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private void carNamesComparison(String firstUsedCarName, String nextUsedCarName) {
        if (firstUsedCarName.equals(nextUsedCarName)) {
            throw new IllegalArgumentException("같은 이름을 가진 자동차가 있습니다.");
        }
    }

    private void checkInputIsEmpty(String carNameInput) {
        if (carNameInput.isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkLastInputIsComma(String carNameInput) {
        if (carNameInput.lastIndexOf(",") == carNameInput.length() - 1) {
            throwUnderMinLengthException();
        }
    }

    private void checkLength(String carName) {
        if (MAXIMUM_CARNAME_LENGTH < carName.length()) {
            throwOverMaxLengthException();
        }
        if (carName.length() < MINIMUM_CARNAME_LENGTH) {
            throwUnderMinLengthException();
        }
    }

    private void throwUnderMinLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + MINIMUM_CARNAME_LENGTH + "글자 이상이어야 합니다.");
    }

    private void throwOverMaxLengthException() {
        throw new IllegalArgumentException("자동차 이름은 " + MAXIMUM_CARNAME_LENGTH + "글자 이하여야 합니다.");
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