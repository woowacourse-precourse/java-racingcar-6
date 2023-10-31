package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

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
                throw new IllegalArgumentException("[ERROR] 5자리를 초과한 자동차 이름이 입력되었습니다.");
            }
        }
    }


}
