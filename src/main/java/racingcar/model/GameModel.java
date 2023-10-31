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

    public String getWinnerCars(){
        List<Car> winnersCar = carList.getWinner();
        return this.carList.getWinnersName(winnersCar);
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
