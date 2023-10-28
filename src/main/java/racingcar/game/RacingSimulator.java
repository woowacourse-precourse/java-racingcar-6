package racingcar.game;

import java.util.ArrayList;
import java.util.List;
import racingcar.game.car.RacingCar;
import racingcar.game.car.engin.CarEngineV1;
import racingcar.game.inputgenerateManager.InputGenerateManager;

public class RacingSimulator {

    private final InputGenerateManager inputGenerateManager;


    List<RacingCar> racingCarList = new ArrayList<>();

    public RacingSimulator(InputGenerateManager inputGenerateManager) {
        this.inputGenerateManager = inputGenerateManager;
    }

    public List<RacingCar> nameToRacingCar(List<String> racingCarNameList) {

        for (String racingCarName : racingCarNameList) {
            RacingCar racingCar = new RacingCar(racingCarName, new CarEngineV1(inputGenerateManager));
            racingCarList.add(racingCar);
        }

        return racingCarList;
    }

    public void roundStart(List<RacingCar> racingCarList, Integer count) {
        for (RacingCar racingCar : racingCarList) {
            for (int i = 0; i < count; i++) {
                racingCar.drive();
            }
        }
    }
}
