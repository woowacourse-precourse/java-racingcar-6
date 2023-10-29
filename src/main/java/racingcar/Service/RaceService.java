package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.*;

public class RaceService {
    private static final String DISTINGUISH_ERROR_MESSAGE = "이름을 쉼표(,)로 구분할 수 없습니다.";
    static final String EXCEED_ERROR_MESSAGE = "최대 이름 글자수를 초과하였습니다.";
    static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름을 입력하셨습니다.";
    private static final int MAX_SPELLING_COUNT = 5;


    public void checkCarNamesValidation(String inputCarNames) {

        List<String> carNameList = new ArrayList<>();
        try {
            carNameList = Arrays.stream(inputCarNames.split(",")).toList();
        } catch (IllegalArgumentException e) {
            System.out.println(DISTINGUISH_ERROR_MESSAGE);
        }
        if (!CountOfNameSpelling(carNameList)) {
            throw new IllegalArgumentException(EXCEED_ERROR_MESSAGE);
        }
        if (!isDuplicateName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    public boolean isDuplicateName(List<String> carNames) {
        Set<String> carSet = new HashSet<>();
        for (String name : carNames) {
            carSet.add(name);
        }
        return carSet.size() == carNames.size();
    }

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String winnerResult(List<Car> cars) {
        Collections.sort(cars, ((o1, o2) -> o2.getLocation() - o1.getLocation()));
        int maxNum = cars.get(0).getLocation();
        List<String> members = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxNum) {
                members.add(car.getName());
            }
        }
        return String.join(", ", members);
    }

    public boolean CountOfNameSpelling(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_SPELLING_COUNT) {
                return false;
            }
        }
        return true;
    }

}
