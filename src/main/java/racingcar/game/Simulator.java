package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.Car;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

public class Simulator {

    private final InputGenerateManager inputGenerateManager;

    public Simulator(InputGenerateManager inputGenerateManager) {
        this.inputGenerateManager = inputGenerateManager;
    }

    public List<Car> nameToRacingCar(List<String> racingCarNameList) {
        List<Car> carList = new ArrayList<>();

        for (String racingCarName : racingCarNameList) {
            Car car = new Car(racingCarName, new CarEngineV1(inputGenerateManager));
            carList.add(car);
        }

        return carList;
    }

    public Round perRound(List<Car> carList) {
        List<Car> tempList = new ArrayList<>();
        for (Car car : carList) {
            car.drive();
            tempList.add(car);
        }
        return new Round(tempList);
    }
}
