package Car;

import Car.Car;
import java.util.ArrayList;
import java.util.List;
import racingcar.Validator;

public class CarGenerator {
    public static List<Car> generateCar(String userInput){
        Validator.validateCarName(userInput);
        String[] carNames = userInput.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }

        return cars;
    }
}
