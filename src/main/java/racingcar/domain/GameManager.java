package racingcar.domain;

import java.util.List;

public class GameManager {
    private static GameManager gameManager = null;
    private int attemptNumber;
    private List<Car> carImplList;


    private GameManager(int attemptNumber, List<Car> carImplList) {
        this.attemptNumber = attemptNumber;
        this.carImplList =carImplList;
    };

    public static GameManager create(int attemptNumber, List<Car> carImplList) {
        if(gameManager == null){
            gameManager = new GameManager(attemptNumber, carImplList);
        }
        return gameManager;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public List<Car> getCarImplList() {
        return carImplList;
    }
}
