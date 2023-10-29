package racingcar;

import java.util.List;

public class Game {

    public void play(){
        Player player = new Player();
        List<Car> cars = player.getCarList();
        int times = player.getTimes();

        Judge judge = new Judge();
        List<String> winner = judge.findWinner(cars);

        Result result = new Result();
        result.print(cars,times,winner);
    }

}