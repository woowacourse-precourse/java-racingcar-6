package racingcar.model;

import java.util.List;

public class CarNames {

    private final String CAR_NAME_ERROR_MESSAGE = "[ERROR] 5자리를 초과한 자동차 이름이 입력되었습니다.";

    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        validateNameLength(carNames);
        this.carNames = carNames;
    }

    public List<String> getNames() {
        return this.carNames;
    }

    public void validateNameLength(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
            }
        }
    }


}
