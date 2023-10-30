package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static final int MIN_GAME_NUMBERS = 1;
    private Cars carList;
    private int numberGames;

    public Cars progressGame() {
        carList.allCarsForward();
        return this.carList;
    }

    public Cars getWinner() { // 이것만 하면 끝난다.
        List<Car> winnerCars = new ArrayList<>();
        return new Cars(winnerCars);
    }

    public void validateNumberGames(int numberGames) {
        if (numberGames < MIN_GAME_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    public void initGame(String[] carsName, int numberGames) {
        validateNumberGames(numberGames);
        List<Car> inputCars = new ArrayList<>();
        for (String carName : carsName) {
            inputCars.add(new Car(carName));
        }
        this.carList = new Cars(inputCars);
        this.numberGames = numberGames;
    }


}
