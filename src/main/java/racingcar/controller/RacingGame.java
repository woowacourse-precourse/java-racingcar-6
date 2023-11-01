package racingcar.controller;

import static racingcar.constant.Console.INIT;
import static racingcar.constant.Console.INPUT_DELIMITER;
import static racingcar.constant.Console.TRY;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ExceptionType;
import racingcar.constant.Game;
import racingcar.constant.Validator;
import racingcar.domain.Race;

public class RacingGame {
    private Race race;
    private static final RacingGame instance = new RacingGame();

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return instance;
    }

    public void start() {
        System.out.println(INIT.message());
        String[] carNames = nameInputRequest();
        System.out.println(TRY.message());
        int totalRound = roundInputRequest();

        race = new Race(totalRound);
        race.entry(carNames);

        race.start();
        race.printWinner();
    }

    private String[] nameInputRequest() {
        String[] inputs = Console.readLine().split(INPUT_DELIMITER.message());

        if (inputs.length < Game.MIN_PLAYER.is()) {
            throw new IllegalArgumentException(ExceptionType.MEMBER.message());
        }

        for (String input : inputs) {
            Validator.NAME.validate(input);
        }

        return inputs;
    }

    private int roundInputRequest() {
        String input = Console.readLine();

        Validator.NUMBER.validate(input);

        return Integer.parseInt(input);
    }
}
