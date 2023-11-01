package racingcar.service;

import racingcar.utils.ServiceOutputManager;

public class GameService {
    CarManager carManager;

    static final ServiceOutputManager serviceOutputManager = new ServiceOutputManager();


    public void execute(String cars, int times) {
        carManager = new CarManager(cars);
        trial(times);
        String winnerList = carManager.getWinnerList();
        serviceOutputManager.winnerPrint(winnerList);

    }

    private void trial(int number) {
        for (int i = 0; i < number; i++) {
            carManager.goOrStop();
            carManager.getState();
        }
    }
}
