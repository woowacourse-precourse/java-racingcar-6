package racingcar.domain;

import java.util.List;

public class Referee {
    private int numOfGame;
    private  List<Car> cars;

    public void setNumOfGame(int numOfGame) {
        this.numOfGame = numOfGame;
    }

    public int getNumOfGame() {
        return numOfGame;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
