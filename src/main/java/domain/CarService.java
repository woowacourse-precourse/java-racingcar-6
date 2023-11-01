package domain;

import java.util.List;

public class CarService {
    private final RemainingRound remainingRound = new RemainingRound();
    private Cars cars;

    void setCars(Cars cars) {
        this.cars = cars;
    }

    public void setCars(List<String> names) {
        cars = new Cars(names);
    }

    public void setRound(int round) {
        remainingRound.set(round);
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public void playRound() {
        remainingRound.playRound();
        cars.moveCars();
    }

    public List<Car> decideWinner() {
        return cars.decideWinner();
    }

    public boolean isEnd() {
        return remainingRound.isEnd();
    }
}
