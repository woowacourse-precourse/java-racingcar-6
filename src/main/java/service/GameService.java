package service;

import camp.nextstep.edu.missionutils.Randoms;

import domain.Car;
import domain.Game;
import repository.GameRepository;

public class GameService {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;

    private final GameRepository gameRepository = new GameRepository();

    public void play(Game game) {
        moveForwardByRandomNumber(game);
        game.increaseCurrentTrial();
    }

    private void moveForwardByRandomNumber(Game game) {
        for(Car car : game.getCarList()) {
            if(FORWARD_CONDITION <= getRandomNumber()) {
                car.moveForward(1);
            }
        }
    }

    public Boolean isEnd(Game game) {
        return gameRepository.isEnd(game);
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public Long save(Game game) {
        return gameRepository.save(game);
    }
}
