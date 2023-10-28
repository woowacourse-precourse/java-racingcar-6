package racingcar;

import racingcar.core.*;
import racingcar.core.io.Input;
import racingcar.core.io.Output;
import racingcar.core.io.Validator;
import racingcar.domain.CarFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        NamesParser namesParser = new NamesParser();
        Validator validator = new Validator(namesParser);

        Input input = new Input(validator);
        Output output = new Output();

        CarFactory factory = new CarFactory(namesParser);
        GameProgressSystem progressSystem = new GameProgressSystem();
        WinnerCheckSystem winnerCheckSystem = new WinnerCheckSystem();
        GameAwards gameAwards = new GameAwards(winnerCheckSystem);
        GameManager gameManager = new GameManager(input,output,factory,progressSystem,gameAwards);

        gameManager.play();
    }
}
