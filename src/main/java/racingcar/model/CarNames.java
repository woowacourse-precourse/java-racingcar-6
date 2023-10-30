package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNames {

    private static List<CarName> carNames;

    public CarNames() {
        carNames = new ArrayList<>();
    }

    public void saveCarNames(String carNames) {
        validateCarNames(carNames);
        List<String> list = splitByComma(carNames);
        toCarNameList(list);
    }

    private void validateCarNames(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("사용자는 최대 2명 이상입니다.");
        }
    }

    private List<String> splitByComma(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void toCarNameList(List<String> list) {
        List<CarName> carNameList = new ArrayList<>();
        list.forEach((name) -> carNameList.add(new CarName(name)));
    }
}
