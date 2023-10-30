package racingcar;

import java.util.List;

public class RacingGameController {
    private final CarService carService = new CarService();
    private final RacingGameService racingGameService = new RacingGameService();

    private RacingGame gameInitialize(){
        List<String> nameList = racingGameService.getCarNameList();
        List<Car> carList = carService.createCars(nameList);
        int playCount = racingGameService.getPlayCount();

        return racingGameService.raceSetting(carList, playCount);
    }

    public void racingGame(){
        RacingGame racingGame = gameInitialize();
        racingGameService.play(racingGame);
        racingGameService.printWinner(racingGame);
    }
}
