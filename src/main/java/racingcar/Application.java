package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Judgement;
import racingcar.domain.User;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<String> carsList = new ArrayList<>();
    static List<Car> cars = new ArrayList<>();
    static List<String> carsStatus = new ArrayList<>();
    static int gameNumber;

    public static void main(String[] args) {
        User user = new User();
        user.InitialSetting();
        carsList = user.getCars();
        gameNumber = user.gameNumber;
        createCars();
        playGame();
        printResult();
    }

    public static void createCars() {
        for (int i = 0; i < carsList.size(); i++) {
            Car car = new Car();
            car.carName = carsList.get(i);
            cars.add(car);
        }
    }

    public static void playGame() {
        System.out.println("\n실행결과");
        while (gameNumber != 0) {
            driveCar();
            gameNumber--;
            System.out.printf("\n");
        }
    }

    public static void driveCar() {
        for (int i = 0; i < cars.size(); i++) {
            (cars.get(i)).drive();
        }
    }

    public static void setCarsStatus() {
        for (int i = 0; i < cars.size(); i++) {
            String carStatus = (cars.get(i)).status;
            carsStatus.add(carStatus);
        }
    }

    public static void printResult() {
        setCarsStatus();
        Judgement judgement = new Judgement();
        judgement.makeJudge(cars);
    }
}
