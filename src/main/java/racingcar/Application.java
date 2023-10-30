package racingcar;

import racingcar.core.*;
import racingcar.core.io.Input;
import racingcar.core.utils.NamesParser;
import racingcar.core.io.Output;
import racingcar.core.utils.Validator;
import racingcar.domain.CarFactory;

public class Application {
    public static void main(String[] args) {
        NamesParser namesParser = new NamesParser();
        Validator validator = new Validator();

        Input input = new Input(validator,namesParser);
        Output output = new Output();

        CarFactory factory = new CarFactory();
        Game game = new Game();
        WinnerCheckSystem winnerCheckSystem = new WinnerCheckSystem();
        GameAwards gameAwards = new GameAwards(winnerCheckSystem);
        GameManager gameManager = new GameManager(input,output,factory,game,gameAwards);

        gameManager.play();
    }
}
