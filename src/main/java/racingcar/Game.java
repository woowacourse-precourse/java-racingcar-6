package racingcar;

import java.util.List;

public class Game {

    public void play(){
        Player player = new Player();
        List<Car> cars = player.getCarList();
        int times = player.getTimes();

        Result result = new Result();
        Judge judge = new Judge();
        List<String> winner = judge.findWinner(cars);

        result.print(cars,times,winner);
    }

}