package racingcar.domain;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Game {
    private int finalRaceCount;
    private List<Car> carList;
    private int currentRaceCount;

    public Game() {}

    public void validationCarNameAndSetGame(String carNameListString) {
        checkCarNameListIsEmpty(carNameListString);
        checkCarNameIsNull(carNameListString);
        List<String> carNameList = splitCarList(carNameListString);
        checkCarNameDuplicate(carNameList);

        setCarList(carNameList);
    }

    private void setCarList(List<String> carNameList) {
        this.carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void setFinalRaceCount(int finalRaceCount) {
        this.finalRaceCount = finalRaceCount;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCurrentRaceCount() {
        currentRaceCount++;
    }

    public boolean isGameOver() {
        return finalRaceCount == currentRaceCount;
    }

    private void checkCarNameListIsEmpty(String carNameListString) {
        if (carNameListString.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하지 않았습니다.");
        }
    }

    public List<String> splitCarList(String carNameListString) {
        String[] carNames = carNameListString.split(",");

        if (carNames.length <= 1) {
            throw new IllegalArgumentException("경주할 자동차의 이름은 2개 이상 입력해야 합니다.");
        }

        return new ArrayList<>(Arrays.asList(carNames));
    }

    public void checkCarNameDuplicate(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }

    }

    public void checkCarNameIsNull(String carNameListString) {
        String[] carNames = carNameListString.split(",");
        int commaCount = 1;

        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher(carNameListString);

        while (matcher.find()) {
            commaCount++;
        }

        if (carNames.length != commaCount) {
            throw new IllegalArgumentException("이름이 없는 자동차가 존재합니다.");
        }

    }
}
