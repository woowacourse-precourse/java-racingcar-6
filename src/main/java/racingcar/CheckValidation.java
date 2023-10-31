package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckValidation {

    public void checkCarNum(ArrayList<String> carArrList) {
        if (carArrList.size() <= 1) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해주세요.");
        }
    }

    public void checkCarNameLength(ArrayList<String> carArrList) {
        for (String carName : carArrList) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
            }
            if (carName.isEmpty()) {
                throw new IllegalArgumentException("비어있는 자동차 이름이 있습니다.");
            }
        }
    }

    public void checkCarNameBlank(ArrayList<String> carArrList) {
        for (String carName : carArrList) {
            if  (carName.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 들어갈 수 없습니다.");
            }
        }
    }

    public void checkSameName(ArrayList<String> carArrayList) {
        List<String> listForCheck = new ArrayList<>();
        listForCheck = carArrayList.stream().distinct().collect(Collectors.toList());
        if (listForCheck.size() != carArrayList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다. 확인해주세요.");
        }
    }

    public void checkCycleNum(int cycleNum) {
        try {
            if (cycleNum < 1) {
                throw new IllegalArgumentException("시도할 회수는 1 이상으로 입력해야 합니다.");
            }
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다");
        }
    }
}