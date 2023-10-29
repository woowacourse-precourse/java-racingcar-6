package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.validator.RoundCountValidator;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private Game game;
    public Game initGameRound(String inputRound, int carCount) {
        RoundCountValidator roundCountValidator = new RoundCountValidator();
        if(roundCountValidator.validateInputGameRound(inputRound)) {
            int round = Integer.parseInt(inputRound);
            game = new Game(carCount, round);
        }
        return game;
    }

    public List<String> getWinner(int carCount, Car[] car) {
        List<String> winner = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < carCount; i++) {
            if (car[i].getPosition() > max) {
                winner.clear();
                winner.add(car[i].getCarName());
                max = car[i].getPosition();
            } else if (car[i].getPosition() == max) {
                winner.add(car[i].getCarName());
            }
        }
        return winner;
    }
}
