package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int finalRaceCount;
    private int currentRaceCount;
    private List<Car> carList;

    public void setCar(String carNameListString) {
        setCarList(Arrays.stream(carNameListString.split(",")).toList());
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

    public boolean isNotGameOver() {
        return finalRaceCount != currentRaceCount;
    }

}
