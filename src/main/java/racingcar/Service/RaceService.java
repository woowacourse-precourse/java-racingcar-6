package racingcar.Service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.*;

public class RaceService {
    private static final String CONVERT_ERROR_MESSAGE = "문자열을 List타입으로 변환할 수 없습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "입력된 이름이 없습니다.";
    private static final String DISTINGUISH_ERROR_MESSAGE = "이름을 쉼표(,)로 구분할 수 없습니다.";
    static final String EXCEED_ERROR_MESSAGE = "최대 이름 글자수를 초과하였습니다.";
    static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름을 입력하셨습니다.";
    private static final int MAX_SPELLING_COUNT = 5;



    public void checkCarNamesValidation(String inputCarNames) {
        /*
        * 예외상황
        * 1. 이름이 주어지지 않았을때
        * 2. 쉼표(,)로 구분 할 수 없을때(쉼표(,)가 없을때,쉼표(,)만 있을때)
        * 3. 이름 글자수가 5 초과일때
        * 4. 중복된 이름이 있을때
        * */

        List<String> carNameList = new ArrayList<>();
        try {
            carNameList = Arrays.stream(inputCarNames.split(",")).toList();
        } catch (IllegalArgumentException e) {
            System.out.println(CONVERT_ERROR_MESSAGE);
        }
        if (isEmptyInput(inputCarNames)){
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
        if (!splitValidation(inputCarNames,carNameList)){
            throw new IllegalArgumentException(DISTINGUISH_ERROR_MESSAGE);
        }
        if (!SpellingCountValidation(carNameList)) {
            throw new IllegalArgumentException(EXCEED_ERROR_MESSAGE);
        }
        if (isDuplicateName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }

    }

    private boolean splitValidation(String inputCarNames, List<String> carNameList) {
        return inputCarNames.contains(",") && carNameList.size()>0;
    }

    private boolean isEmptyInput(String inputCarNames) {
        return inputCarNames.equals("");
    }

    public boolean isDuplicateName(List<String> carNames) {
        Set<String> carSet = new HashSet<>();
        for (String name : carNames) {
            carSet.add(name);
        }
        return carSet.size() != carNames.size();
    }

    public boolean SpellingCountValidation(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_SPELLING_COUNT) {
                return false;
            }
        }
        return true;
    }

    public int RandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String winnerResult(List<Car> cars) {
        cars.sort(((o1, o2) -> o2.getLocation() - o1.getLocation()));
        int maxNum = cars.get(0).getLocation();
        List<String> members = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxNum) {
                members.add(car.getName());
            }
        }
        return String.join(", ", members);
    }



}
