package racingcar.model;

import java.util.List;

public class Game {
    private final Cars cars;
    private final GameCount gameCount;

    public Game(List<String> names, int count){
        this.cars = new Cars(names);
        this.gameCount = new GameCount(count);
    }
    public void play(){
        cars.doRace();
        gameCount.reduceCount();
    }
    

}
