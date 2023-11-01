package racingcar.race;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class Race {
    private List<Car> cars;
    public Race(){
        cars = new ArrayList<>();
    }
    public void addCar(String carName){
        cars.add(new Car(carName));
    }
    public void addCars(List<String> carNames){
        for(String carName : carNames){
            addCar(carName);
        }
    }
    public void moveCars(void){
        for(Car car : cars){
            car.move();
        }
    }
    public List<String> getFastestCarNames(){
        Integer maxLocation = cars.stream()
                .map(Car::getLocation)
                .max(Integer::compareTo)
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getLocation().equals(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
    public Map<String, Integer> getEachCarNameAndLocation(List<Car> cars) {
        return cars.stream()
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getLocation,
                        (existing, replacement) -> existing, // 만약 중복 키가 있을 경우의 병합 전략. 여기서는 기존 값을 유지합니다.
                        LinkedHashMap::new
                ));
    }
}
