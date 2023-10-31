package domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CarService {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;
    private static final int STANDARD_FOR_GO = 4;
    private Cars cars;

    void setCars(Cars cars) {
        this.cars = cars;
    }

    public void setCars(List<String> names) {
        cars = new Cars(names);
    }

    public List<Car> getCars() {
        return cars.getAll();
    }

    public void playRound() {
        for (int i = 0; i < cars.size(); i++) {
            if (decideGo(getRandomNumber())) {
                cars.go(i);
                continue;
            }
            cars.stop(i);
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }

    boolean decideGo(int condition) {
        return condition >= STANDARD_FOR_GO;
    }

    public List<Car> decideWinner() {
        int max = cars.getMaxPosition();

        List<Car> winner = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.getPosition(i) == max) {
                winner.add(cars.getCar(i));
            }
        }
        return winner;
    }
}
