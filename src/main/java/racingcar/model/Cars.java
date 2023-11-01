package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.Output;

public class Cars {
    private final List<Car> carList = new ArrayList<>();

    private List<String> winnerList;
    private int topPosition = 0;

    public Cars(String inputCarNames) {
        String[] carNameArr = inputCarNames.split(",");

        validateDuplicateName(carNameArr);

        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
    }

    public void run() {
        this.carList.forEach(car -> {
            car.move();
            Output.printRunResult(car);
        });

        Output.printBlankLine();
    }

    public void handleWinnerResult() {
        setWinnerList();

        Output.printWinnerResult(this.winnerList);
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinnerList() {
        return this.winnerList;
    }

    private void validateDuplicateName(String[] carNameArr) {
        long distinctCount = Arrays.stream(carNameArr)
                                   .distinct()
                                   .count();

        if (distinctCount < carNameArr.length) {
            throw new IllegalArgumentException();
        }
    }

    private void setWinnerList() {
        setTopPosition();

        this.winnerList = this.carList.stream()
                                      .filter(car -> car.getPosition() == this.topPosition)
                                      .map(Car::getName)
                                      .toList();


    }

    private void setTopPosition() {
        this.topPosition = this.carList.stream()
                                       .mapToInt(Car::getPosition)
                                       .max()
                                       .orElse(0);
    }

}
