package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.Validator.validateCarNames;

public class Racing {
    private final List<Car> carList;
    private Racing(List<Car> cars) {
        this.carList = cars;
    }

    public Racing registerCarList(){
        String names = Console.readLine();
        validateCarNames(names);

        List<Car> cars = makeCarList(names.split(","));

        return new Racing(cars);
    }

    private List<Car> makeCarList(String[] names){
        List<Car> cars = new ArrayList<>();
        for(String name : names){
            cars.add(new Car(name));
        }
        return cars;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Car car : carList){
            sb.append(car.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
