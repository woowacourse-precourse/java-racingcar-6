package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;

public class Chicken_Dinner extends Play{
    public Chicken_Dinner(List<Car> car_name, int round) {
        super(car_name, round);
    }

    private Car Get_Winner_Position(Car car, Car other) {
        if(car.Position_Comparator(other)) {
            return car;
        }
        return other;
    }

    private Car Find_Winner_Position() {
        return car.stream().reduce(this::Get_Winner_Position).orElseThrow();
    }

    public List<Car> Find_Winner(){
        Car WinnerCar = Find_Winner_Position();
        return  car.stream().filter(car -> car.Same_Position_Check(WinnerCar)).collect(Collectors.toList());
    }
}
