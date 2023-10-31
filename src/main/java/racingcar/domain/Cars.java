package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Car들을 배열에 저장하는 domain
 */
public class Cars {
    private final List<Car> cars = new ArrayList<Car>();

    /**
     * 매개변수를 배열에 추가
     *
     * @param car 추가할 Car 객체
     */
    public void addCar(Car car) {
        this.cars.add(car);
    }

    /**
     * car들 각각 이동 실행
     */
    public void move() {
        cars.stream().filter(car -> car.isCanMove()).forEach(car -> {
            car.move();
        });
    }

    /**
     * cars객체 가져온다.
     *
     * @return List<Car>
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * 가장많이 이동한 자동차의 이름들을 반환하는 메서드
     *
     * @return List<String>
     */
    public List<String> getWinner() {
        int distance = cars.stream().map(Car::getDistance).max(Integer::compare).get(); // 최댓값의 거리를 구한뒤
        return cars.stream().filter(car -> car.getDistance() == distance).map(Car::getName)
                .toList(); //거리량이 일치하는 Car들의 이름을 배열에 담아 반환
    }
}
