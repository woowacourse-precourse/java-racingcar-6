package racingcar.Controller;

import racingcar.Service.CarService;

public class GameController {
    CarService carService = new CarService();
    public void run(){
        init();
        start();
        end();
    }
    private void init(){
        carService.set();
    }
    private void start(){
    }
    private void end(){

    }
}
