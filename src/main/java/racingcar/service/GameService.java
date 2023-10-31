package racingcar.service;

import racingcar.model.Car;

import java.util.*;

public class GameService {
    private static GameService INSTANCE;

    private GameService() {
    }

    public static GameService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameService();
        }

        return INSTANCE;
    }

    public String doTurns(List<Car> cars, final int tries) {
        StringBuilder sb = new StringBuilder();

        for (int turn = 0; turn < tries; turn++) {
            sb.append(doTurnCars(cars)).append("\n");
        }

        return sb.toString();
    }

    public String getWinnersList(List<Car> cars) {
        List<Car> winners = getWinners(cars);
        StringBuilder sb = new StringBuilder();

        for (Car winner : winners) {
            sb.append(winner.getName()).append(", ");
        }
        sb.substring(0, sb.length() - 3);

        return sb.toString();
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

        List<Car> winners = new LinkedList<Car>();
        ListIterator<Car> carsIterator = cars.listIterator();
        int maxMove = -1;
        while (carsIterator.hasNext()) {
            Car car = carsIterator.next();

            if (!car.isWinner(maxMove))
                break;

            maxMove = car.getMove();
            winners.add(car);
        }

        return winners;
    }
}
