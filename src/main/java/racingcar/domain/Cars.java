package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.NumberGenerator;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carList) {
        for (String carName : carList) {
            cars.add(new Car(carName));
        }
    }

    public void racing(NumberGenerator numberGenerator) {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate()) == true)
                .forEach(car -> car.move(true));
    }

    //포지션이 가장 큰 자동차 이름 리스트를 반환하는 메서드
    public List<String> getFurthestCarNameList() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public void printCarsStatus() {
        cars.stream().forEach(Car::printCarStatus);
    }

    // 현재 List<Car> cars를 깊은 복사로 복사한 값을 반환하는 메서드
    public List<Car> getCurrentCarList() {
        return cars.stream().map(car -> new Car(car.getName(), car.getPosition()))
                .collect(Collectors.toUnmodifiableList());
    }
}
