package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.enums.GameConstant;
import racingcar.enums.OutputMessage;

public class Cars {
    private List<Car> carList;
    private List<Integer> movedCount;
    private Integer carListSize;

    public Cars(List<String> carNameList) {
        this.carList = new ArrayList<>();
        this.movedCount = new ArrayList<>();

        for(String carName : carNameList) {
            Car car = new Car(carName);

            this.carList.add(car);
            this.movedCount.add(0);
        }

        this.carListSize = this.carList.size();
    }

    public void moveAll(List<Integer> randomNumbers) {
        for (int i = 0; i < this.carListSize; ++i) {
            Car car = this.carList.get(i);
            Integer randomNumber = randomNumbers.get(i);

            Boolean moved = car.move(randomNumber);

            increaseMovedCount(moved, i);
        }
    }

    private void increaseMovedCount(Boolean moved, Integer index) {
        if (moved) {
            Integer currentCount = movedCount.get(index);

            movedCount.set(index, currentCount + 1);
        }
    }

    public List<String> getMaximumMovedCarNameList() {
        Integer maximumCount = Collections.max(this.movedCount);
        List<String> carNameList = new ArrayList<>();

        for (int i = 0; i < this.carListSize; ++i) {
            Integer currentMoved = this.movedCount.get(i);

            if (currentMoved.equals(maximumCount)) {
                Car currentCar = this.carList.get(i);
                carNameList.add(currentCar.toString());
            }
        }

        return carNameList;
    }

    public Integer size() {
        return this.carListSize;
    }

    public String getForwardResultMessageAll() {
        String result = "";

        for (Car car : this.carList) {
            result += car.getForwardResultMessage();
            result += OutputMessage.LINE_FEED.getMessage();
        }

        return result;
    }

    @Override
    public String toString() {
        String delimiter = GameConstant.DELIMITER.getContent();
        List<String> carNames = this.carList
                .parallelStream()
                .map(Car::toString)
                .collect(Collectors.toList());

        return String.join(delimiter, carNames);
    }
}
