package racingcar.exception;

import java.util.ArrayList;

public class InputException {
    public void checkException(ArrayList<String> carNames) {

        checkCarNameLength(carNames);
    }

    private void checkCarNameLength(ArrayList<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() >= 6) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력하세요");
            }
        }
    }

}
