package racingcar.controller;
import racingcar.domain.Car;
import racingcar.domain.Racing;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

import java.util.List;

public class RacingCarController {

    private final static RacingCarView racingCarView = new RacingCarView();
    private final static RacingCarService racingCarService = new RacingCarService();

    public void startRacingCar(){

        String cars = racingCarView.inputStartRacingCar();
        final List<Car> racingCarList = racingCarService.getRacingCarsList(cars);

        String racingCarCount = racingCarView.inputRacingCarTryCount();

        startRace(racingCarCount, racingCarList);
    }

    public void startRace(String racingCarCount, List<Car> racingCarList) {
        if (racingCarService.startRace(racingCarCount, racingCarList)!=null){
            final Racing racingGame = racingCarService.startRace(racingCarCount, racingCarList);

            raceRound(racingGame);

            racingCarService.updateWinnerList(racingGame);
            racingCarView.printWinner(racingGame.getWinnerList());
        }
    }

    public void raceRound(Racing racingGame){
        for (int i=0; i<racingGame.getRacingCount(); i++){
            racingCarService.startRacingRound(racingGame);
            racingCarView.printAheadCount(racingGame.getRacingCarList());
        }
    }

}
