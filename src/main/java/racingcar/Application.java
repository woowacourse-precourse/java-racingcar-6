package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = prepareForRacing();
        startRacing(game);
    }

    private static Game prepareForRacing() {
        User user = new User();
        String carNames = user.inputCarNames();
        List<Car> carList = user.getCarList(carNames);
        int racingCount = user.inputRacingCount();

        return new Game(carList, racingCount);
    }

    private static void startRacing(Game game) {
        game.printStartPlaying();
        game.playRacing();
        List<String> winnerList = game.getWinnerList();
        game.printWinners(winnerList);
    }
}
