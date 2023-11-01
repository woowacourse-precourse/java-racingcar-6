package racingcar.service;


import java.util.List;
import racingcar.controller.InputResolver;
import racingcar.domain.Car;


public class GameService {
    private final InputResolver inputResolver;
    private final CarService carService;

    public GameService(InputResolver inputResolver, CarService carService) {
        this.inputResolver = inputResolver;
        this.carService = carService;
    }

    public void game(){
        settingGame();
    }

    private void settingGame() {
        List<Car> carList = carService.createCarList();
        int count = inputResolver.preprocessCount();
    }



}
