import java.util.ArrayList;
import java.util.List;

public class CarGenerator {
    public static List<Car> generateCar(String userInput){
        String[] carNames = userInput.split(",");

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
