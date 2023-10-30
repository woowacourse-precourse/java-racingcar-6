package racingcar.domain;

import racingcar.util.RandomUtil;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getSize() {
        return cars.size();
    }

    public void moveCars() {
        List<Car> carList = this.getCars();
        carList.forEach(car -> {
            int random = RandomUtil.createRandom();
            if (isMove(random)) {
                car.accountDistance();
            }
        });
    }

    public void printMoves() {
        for (Car car : cars) {
            car.printMove();
            System.out.println();
        }
    }
    public boolean isMove(int random) {
        if (random < 4) {
            return false;
        }
        return true;
    }
}
