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

    public void setCar(String carNameListString) {
        List<String> carNameList = validationCarName(carNameListString);
        setCarList(carNameList);
    }

    public void setFinalRaceCount(String finalRaceCount) {
        try {
            this.finalRaceCount = Integer.parseInt(finalRaceCount);
            validationFinalRaceCount();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~2,147,483,647 사이의 값으로 입력해주세요.");
        }
    }

    private void validationFinalRaceCount() {
        if (finalRaceCount < 1) {
            throw new IllegalArgumentException("1~2,147,483,647 사이의 값으로 입력해주세요.");
        }
    }

    private List<String> validationCarName(String carNameListString) {
        checkCarNameListIsEmpty(carNameListString);
        checkCarNameIsNull(carNameListString);
        checkCarNameListSize(carNameListString);
        return checkCarNameDuplicate(carNameListString);
    }

    private void setCarList(List<String> carNameList) {
        this.carList = carNameList.stream()
                .map(Car::new)
                .collect(Collectors.toList());
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

    private void checkCarNameListSize(String carNameListString) {
        String[] carNames = carNameListString.split(",");

        if (carNames.length <= 1) {
            throw new IllegalArgumentException("경주할 자동차의 이름은 2개 이상 입력해야 합니다.");
        }

    }

    private List<String> checkCarNameDuplicate(String carNameListString) {
        String[] carNames = carNameListString.split(",");
        List<String> carNameList = new ArrayList<>(Arrays.asList(carNames));
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }

        return carNameList;
    }

    private void checkCarNameIsNull(String carNameListString) {
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
