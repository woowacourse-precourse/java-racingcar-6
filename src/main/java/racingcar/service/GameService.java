package racingcar.service;

import racingcar.utils.ServiceOutputManager;

public class GameService {
    CarManager carManager;

    ServiceOutputManager serviceOutputManager = new ServiceOutputManager();


    public void execute(String cars, int number) {
        carManager = new CarManager(cars);
        for (int i = 0; i < number; i++) {
            carManager.goOrStop();
            carManager.getState();
        }
        String winnerList = carManager.getWinnerList();
        serviceOutputManager.winnerPrint(winnerList);

    }
}
