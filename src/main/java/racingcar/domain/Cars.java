package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private int maxDistance;

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
            int random = createRandom();
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
        System.out.println();
    }

    public List<String> findWinner() {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public String getWinner() {
        List<String> winner = findWinner();
        return String.join(", ", winner);
    }

    public void getMaxDistance() {
        maxDistance = 0;
        cars.forEach(car -> maxDistance = Math.max(maxDistance, car.getDistance()));
    }

    public boolean isMove(int random) {
        if (random < 4) {
            return false;
        }
        return true;
    }

    public int createRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
