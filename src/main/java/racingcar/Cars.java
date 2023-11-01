package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    List<Car> cars;
    public Cars(List<String> names){
        cars = new ArrayList<>();
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void run(){
        cars.forEach(Car::move);
    }
    public String getCarStates(){
        StringBuilder sb = new StringBuilder();
        cars.forEach(car->sb.append(car.toString()).append("\n"));
        return sb.toString();
    }
    public List<String> getWinner() {
        int max = getMaxCar();
        return cars.stream().filter(car -> car.moveCount==max).map(car -> car.name).collect(Collectors.toList());
    }
    public int getMaxCar(){
        return cars.stream().max(Car::compareTo).orElseThrow(()->new RuntimeException("차량 목록이 비었습니다.")).moveCount;
    }
}
