package racingcar.domain;

import racingcar.view.OutputView;

public class CarName {
    String carName;

    public CarName(String carName) {
        validateCarNameLengthExceed(carName);
        validateCarNameLengthZero(carName);
        this.carName = carName;
    }

    public void printOnTurnResult() {
        OutputView.printCarNameOnTurnResult(carName);
    }

    private void validateCarNameLengthExceed(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘어갈 수 없습니다.");
        }
    }

    private void validateCarNameLengthZero(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백이 될 수 없습니다.");
        }
    }
}
