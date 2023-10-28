package racingcar;

import java.util.List;

public class Game {
    private int trial;
    private int done_trial;
    private List<Car> cars;

    public Game(List <Car> cars, int trial){
        this.cars = cars;
        this.trial = trial;
        this.done_trial = 0;
    }

    public List<Car> getCars(){
        return cars;
    }

    public void playGame(){
        this.done_trial++;
    }
}
