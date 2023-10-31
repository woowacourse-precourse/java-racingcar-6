package racingcar;

import racingcar.common.Prompt;
import racingcar.common.Validator;
import racingcar.engine.RacingCarGame;
import racingcar.engine.manager.Referee;
import racingcar.engine.mapper.RacingCarMapper;

public class Application {
    public static void main(String[] args) {
        Prompt prompt = new Prompt();
        Validator validator = new Validator();
        RacingCarMapper racingCarMapper = new RacingCarMapper();
        Referee referee = new Referee();
        RacingCarGame game = new RacingCarGame(prompt, validator, referee, racingCarMapper);

        game.start();
    }
}
