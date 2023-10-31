package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public void moveWithRandom(Car[] cars) {
        for (Car car : cars) {
            move(car, Randoms.pickNumberInRange(0, 9));
        }
    }

    public Car[] createCar(String[] split) {
        Car[] carList = new Car[split.length];
        for (int i = 0; i < split.length; i++) {
            carList[i] = new Car(split[i], 0);
        }

        return carList;
    }

    public void move(Car car, int go) {
        if (go >= 4) {
            car.setPos(car.getPos() + 1);
        }
    }

    public List<String> compare(Car[] cars) {

        List<Car> collect = Arrays.stream(cars).sorted(Comparator.comparing(Car::getPos).reversed())
                .collect(Collectors.toList());

        List<String> victorylist = collect.stream().filter((Car car) -> car.getPos() == collect.get(0).getPos())
                .map(v -> v.getName()).collect(Collectors.toList());

        return victorylist;
    }

}
