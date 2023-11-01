package racingcar.domain;

import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;

public class CarRepository {
    private List<Car> cars = new Vector<>();

    public List<Car> getCars() {
        return cars;
    }

    //player 추가 로직
    public void addCar(Car car){
        cars.add(car);
    }

    //player 중복 검증 로직

    public boolean isCarIn(String carName){
        // 존재하는 자동차 이름 set
        Set<String> carNameSet = cars.stream().map(Car::getName)
                .collect(Collectors.toSet());
        //존재 여부 검사
        return carNameSet.contains(carName);
    }
}
