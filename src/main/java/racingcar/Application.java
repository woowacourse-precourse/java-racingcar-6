package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame racingCarGame = new RacingCarGame();

        String carsName = racingCarGame.getCarsName();
        String[] carName = racingCarGame.extractCarName(carsName);
        CustomArrayList<Car> carList = racingCarGame.generateCars(carName);
        int numberOfRace = racingCarGame.getNumberOfRace();
        racingCarGame.repeatCarRace(carList, numberOfRace);
        List<Car> winner = racingCarGame.decideWinner(carList);
        racingCarGame.printOutWinner(winner);
    }
}
