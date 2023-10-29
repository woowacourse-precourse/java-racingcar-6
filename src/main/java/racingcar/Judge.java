package racingcar;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    List<String> winner = new ArrayList<>();

    public List<String> findWinner(List<Car> cars) {
        Car car = cars.get(0);
        int maxMove = car.getMove();

        addWinner(car.getName());

        for (int i = 1; i < cars.size(); i++) {
            car = cars.get(i);
            int move = car.getMove();

            if (isLongest(move,maxMove)) {
                maxMove = move;
                winner.clear();
                addWinner(car.getName());
            }
            else if (isWinner(move,maxMove)) {
                addWinner(car.getName());
            }
        }

        return winner;
    }

    private boolean isLongest(int move, int maxMove){
        return move > maxMove;
    }

    private boolean isWinner(int move, int maxMove){
        return move == maxMove;
    }

    private void addWinner(String name){
        winner.add(name);
    }

}