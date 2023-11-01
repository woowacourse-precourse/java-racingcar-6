package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;
    private static final int FORWARD_CONDITION = 4;
    private static final int MIN_VALUE = -1;
    private final GameRepository gameRepository = new GameRepository();

    // 라운드 진행
    public void playRound(Game game) {
        moveCarsForwardRandomly(game);
        game.increaseCurrentTrial();
    }

    // 우승자 목록 반환
    public List<String> getWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = getMaxPosition(cars);
        return getWinningCarNames(cars, maxPosition);
    }

    public Boolean isGameFinished(Game game) {
        return gameRepository.isGameFinished(game);
    }

    // 게임 저장
    public long saveGame(Game game) {
        return gameRepository.saveGame(game);
    }

    private List<String> getWinningCarNames(List<Car> cars, int maxPosition) {
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winningCarNames.add(car.getName());
            }
        }
        return winningCarNames;
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = MIN_VALUE;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private void moveCarsForwardRandomly(Game game) {
        for (Car car : game.getCars()) {
            if (FORWARD_CONDITION <= generateRandomNumber()) {
                car.moveForward(1);
            }
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
    }

}
