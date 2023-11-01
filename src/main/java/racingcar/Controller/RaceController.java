package racingcar.Controller;

import racingcar.Service.CarService;
import racingcar.Service.RaceService;
import racingcar.domain.Car;
import racingcar.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final CarService carService = new CarService();
    private final RaceService raceService = new RaceService();

    public void gamePlay(int numberOfGames, List<Car> cars){
        System.out.println("실행 결과");

        for(int i =0;i<numberOfGames;i++){
            carService.runOneTurn(cars);
            carService.showResults(cars);
        }
    }

    public void start(){
        Race race = new Race();
        List<Car> cars = new ArrayList<>();

        cars = race.setCarNames(cars);
        int gameCount = race.setNumberOfAttempts();

        gamePlay(gameCount, cars);

        raceService.showResults(cars);
    }
}
