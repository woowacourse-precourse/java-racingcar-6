package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> carList;

    public void setStatus(List<Car> carList) {
        this.carList = carList;
    }

    public void move() {
        IntStream.range(0, carList.size())
                .forEach(i -> carList.get(i).move(RandomNumber.create()));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
