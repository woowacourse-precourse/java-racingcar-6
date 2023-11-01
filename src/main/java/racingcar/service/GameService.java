package racingcar.service;

import racingcar.model.Car;
import racingcar.utils.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class GameService {
    private volatile static GameService INSTANCE;

    private GameService() {
    }

    public static GameService getInstance() {
        if (INSTANCE == null) {
            synchronized (GameService.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameService();
        }
    }

    public String doTurns(List<Car> cars, final int tries) {
        StringBuilder sb = new StringBuilder();

        try {
            for (int turn = 0; turn < tries; turn++) {
                sb.append(doTurnCars(cars)).append("\n");
            }
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_MEMORY_OF_TRIES.getErrorMessage());
        }

        return sb.toString();
    }

    public String getWinnersList(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        StringJoiner joiner = new StringJoiner(", ");

        for (Car winner : winners) {
            joiner.add(winner.getName());
        }

        return joiner.toString();
    }

    private String doTurnCars(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            car.doTurn();
            sb.append(car.getNowMoveStatus());
        }

        return sb.toString();
    }

    private List<Car> getWinners(List<Car> cars) {
        Collections.sort(cars);

        List<Car> winners = new ArrayList<Car>();
        int maxMove = -1;
        for (Car car : cars) {
            if (!car.isWinner(maxMove))
                break;

            maxMove = car.getMove();
            winners.add(car);
        }

        return winners;
    }
}
