package racingcar.Controller;

import racingcar.Service.CarService;
import racingcar.Service.GameService;

public class GameController {
    CarService carService = new CarService();
    GameService gameService = new GameService();
    public void run(){
        init();
        start();
        end();
    }
    private void init(){
        carService.set();
        gameService.set();
    }
    private void start(){
    }
    private void end(){

    }
}
