package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    final int COUNT_MINIMUM_CAR = 2;
    final String SEPARATOR_CAR_NAME = ",";
    final String MESSAGE_START = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";
    List<Car> carList;

    public Game() {
        carList = new ArrayList<Car>();
    }

    public void startGame() {
        System.out.print(MESSAGE_START);
        inputCarsName();
    }

    public void inputCarsName() {
        String inputNames = Console.readLine();

        if (inputNames == null) {
            throw new IllegalArgumentException(String.format("%d대 이상의 이름을 입력해야 합니다", COUNT_MINIMUM_CAR));
        }

        String[] arrayNames = inputNames.split(SEPARATOR_CAR_NAME);
        List<String> carNameList = Arrays.asList(arrayNames);

        if (!validateCarNamesLength(carNameList)) {
            throw new IllegalArgumentException(String.format("%d대 이상의 이름을 입력해야 합니다", COUNT_MINIMUM_CAR));
        }
        if (!validateCarNameDuplication(carNameList)) {
            throw new IllegalArgumentException("중복되는 이름이 있습니다.");
        }

        createCarList(carNameList);
    }

    private void createCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }

    public boolean validateCarNameDuplication(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);

        if (nameSet.size() == nameList.size()) {
            return true;
        }

        return false;
    }

    public boolean validateCarNamesLength(List<String> nameList) {
        if (nameList.size() >= COUNT_MINIMUM_CAR) {
            return true;
        }

        return false;
    }
}
