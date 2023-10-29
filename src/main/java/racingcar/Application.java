package racingcar;
import racingcar.domain.Car;
import racingcar.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<String> carsList = new ArrayList<>();
    static List<Car> cars = new ArrayList<>();
    static int gameNumber;

    public static void main(String[] args) {
        User user = new User();
        carsList = user.getCars();
        gameNumber = user.gameNumber;
        createCars();
        playGame();
    }
    public static void createCars() {
        for(int i=0; i<carsList.size(); i++) {
            Car car = new Car();
            car.carName = carsList.get(i);
            cars.add(car);
        }
    }
    public static void playGame() {
        while(gameNumber != 0) {
            driveCar();
            gameNumber--;
        }
    }
    public static void driveCar() {
        for(int i=0; i<cars.size(); i++) {
            (cars.get(i)).drive();
        }
    }
}
