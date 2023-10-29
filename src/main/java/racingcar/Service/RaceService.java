package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RaceService {
    private static final String DISTINGUISH_ERROR_MESSAGE = "이름을 쉼표(,)로 구분할 수 없습니다.";
    static final String EXCEED_ERROR_MESSAGE = "최대 이름 글자수를 초과하였습니다.";
    private static final int MAX_SPELLING_COUNT = 5;

    public void checkCarNamesValidation(String inputCarNames) {

        if (!isSplitValue(inputCarNames)) {
            throw new IllegalArgumentException(DISTINGUISH_ERROR_MESSAGE);
        }
        if (!CountOfNameSpelling(inputCarNames)) {
            throw new IllegalArgumentException(EXCEED_ERROR_MESSAGE);
        }
    }

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String winnerResult(List<Car> cars) {
        Collections.sort(cars, ((o1, o2) -> o1.getLocation() - o2.getLocation()));
        int maxNum = cars.get(cars.size() - 1).getLocation();
        List<String> members = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxNum) {
                members.add(car.getName());
            }
        }
        return String.join(", ", members);
    }

    public boolean isSplitValue(String name) {
        try {
            List<String> list = Arrays.stream(name.split(",")).toList();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean CountOfNameSpelling(String name) {
        List<String> carNames = Arrays.stream(name.split(",")).toList();
        for (String carName : carNames) {
            if (carName.length() > MAX_SPELLING_COUNT) {
                return false;
            }
        }
        return true;
    }

}
