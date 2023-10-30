package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameRepository {

    private static List<CarName> nameList;

    public CarNameRepository() {
        nameList = new ArrayList<>();
    }

    public void saveCarNames(String carNames) {
        validateCarNames(carNames);
        List<String> stringNameList = splitByComma(carNames);
        toCarNameList(stringNameList);
    }

    private void validateCarNames(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("사용자는 최대 2명 이상입니다.");
        }
    }

    private List<String> splitByComma(String carNames) {
        return Arrays.stream(carNames.split(",")).toList();
    }

    private void toCarNameList(List<String> StringNamelist) {
        StringNamelist.forEach((name) -> nameList.add(new CarName(name)));
    }

    public List<CarName> findCarNames() {
        return nameList;
    }

    @Override
    public String toString() {
        String result = "";
        for (CarName name : nameList) {
            result += name.toString() + ",";
        }
        return result.substring(0, result.length() - 1);
    }
}
