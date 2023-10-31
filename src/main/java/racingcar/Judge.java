package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    List<Car> winner = new ArrayList<>();

    public List<Car> findWinner(List<Car> cars) {
        Car car = cars.get(0);
        int maxMove = car.getMove();

        addWinner(car);

        for (int i = 1; i < cars.size(); i++) {
            car = cars.get(i);
            int move = car.getMove();

            if (isLongest(move,maxMove)) {
                maxMove = move;
                winner.clear();
                addWinner(car);
            }
            else if (isAlsoWinner(move,maxMove)) {
                addWinner(car);
            }
        }

        return winner;
    }

    private boolean isLongest(int move, int maxMove){
        return move > maxMove;
    }

    private boolean isAlsoWinner(int move, int maxMove){
        return move == maxMove;
    }

    private void addWinner(Car car){
        winner.add(car);
    }

}