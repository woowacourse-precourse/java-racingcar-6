package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RaceController {

    public void hold(){
        Race race = raceRegist();
        raceStart(race);
        raceEnd(race);
    }

    public Race raceRegist(){
        List<Car> cars = InputView.registCarName();
        int carMoveNum = InputView.registCarMoveNum();
        Race race = new Race(cars, carMoveNum);
        return race;
    }

    public void raceStart(Race race){
        RaceService raceService = new RaceService(race.getRaceRound());
        OutputView.firstComment();
        while(RaceService.remainRound > 0){
            raceService.moveCarByLogic(race);
            OutputView.showCurrentMove(race);
        }
    }

    public void raceEnd(Race race){
        List<String> winners = RaceService.findWinner(race);
        OutputView.printWinner(winners);
    }
}
