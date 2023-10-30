package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.RacingGame;
import racingcar.domain.game.ResultDTO;
import racingcar.domain.game.Rounds;
import racingcar.view.View;

import java.util.List;

public class RacingGameController {

    public void play() {
        RacingGame racingGame = this.generateNewRacingGame();
        while (!racingGame.isEnd()) {
            racingGame.race();
        }
        ResultDTO result = racingGame.getResult();
        View.printResult(result);
    }

    private RacingGame generateNewRacingGame() {
        // 경주 차량의 이름을 입력받고 Cars 객체를 생성
        List<String> names = View.inputCarNames();
        Cars cars = Cars.createFromNames(names);

        // 경주 회수를 입력받고 Round 객체를 생성
        int inputRounds = View.inputRounds();
        Rounds rounds = new Rounds(inputRounds);

        return new RacingGame(cars, rounds);
    }
}
