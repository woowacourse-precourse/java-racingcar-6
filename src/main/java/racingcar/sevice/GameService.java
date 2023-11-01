package racingcar.sevice;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.OutputView;

public class GameService {

    private static final int MIN_RANDOM_VALUE = 1;
    private static final int MAX_RANDOM_VALUE = 9;
    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public void createGame(List<Car> cars, int finalAttemptCnt) {
        this.game = new Game(cars, finalAttemptCnt);
    }

    public void playSingleRoundGame() {
        moveCarsByRandomNumber();
        addCurrentAttempt();
    }

    public void printCurrentGameResult() {
        OutputView.printCarScore(game.getCars());
    }

    public void moveCarsByRandomNumber() {
        for (Car car : game.getCars()) {
            if (checkMove(getRandomNumber())) {
                car.move();
            }
        }

    }


    public boolean isFinalAttepmt() {
        return game.getCurrentAttemptCnt() == game.getFinalAttemptCnt();
    }


    public void addCurrentAttempt() {
        game.increaseCurrentAttemptCnt();
    }


    public int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
    }


    public boolean checkMove(int num) {
        if (num >= 4) {
            return true;
        }
        return false;
    }


    public List<String> getGameWinner() {

        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : game.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        return winners;
    }


    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : game.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


}
