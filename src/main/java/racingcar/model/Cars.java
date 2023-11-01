package racingcar.model;

import java.util.List;

import java.util.stream.Collectors;
import racingcar.util.Validate;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        Validate.carNamesDuplicate(cars);
        Validate.carNameIsOne(cars);

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
    }

    /**
     * 우승자의 이름들를 반환하는 함수
     *
     * @param position : Car member 들의 이름을 구하기 위한 조건
     * @return List<String> : member 들의 이름
     */
    public List<String> getWinner(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .map(Car::getMember)
                .collect(Collectors.toList());
    }

    /**
     * 현재 멤버들 중 가장 많이 전진한 position 값 반환
     *
     * @return int: Cars의 멤버 중 가장 높은 position을 반환
     */
    public int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
