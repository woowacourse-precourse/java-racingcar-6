package racingcar;

public class Game {
    Player player = new Player();
    Cars cars = new Cars();

    public void run() {
        String[] carNames = player.inputCarName();
        cars.setCarList(carNames);
        int round = player.inputNumberTimes();
        cars.raceStart(round);
        cars.printWinner();
    }

}
