package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManageRace {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public void setRace() {
        String carNames = inputCarName();
        List<String> carNameList = stringToList(carNames);
        checkValidNames(carNameList);
        int tryCount = inputTryCount();

        startRace(new Race(carNameList, tryCount));
    }

    private void startRace(Race race) {
        race.start();
    }

    private String inputCarName() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return Console.readLine();
    }

    public List<String> stringToList(String carNames) {
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            carNameList.add(carName);
        }
        return carNameList;
    }

    public void checkValidNames(List<String> carNameList) {
        Set<String> set = new HashSet(carNameList);
        if (carNameList.size() != set.size()) {
            throw new IllegalArgumentException();
        }
        for (String carName : set) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int inputTryCount() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
        String tryCount = Console.readLine();
        checkValidCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    public void checkValidCount(String tryCount) {
        for (char c : tryCount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        if (tryCount.charAt(0) == '0') {
            throw new IllegalArgumentException();
        }
    }
}
