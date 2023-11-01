package racingcar;

import racingcar.evaluator.WinnerEvaluator;
import racingcar.game.Movement;
import racingcar.game.RacingGame;
import racingcar.printer.ResultPrinter;
import racingcar.processor.CarDataProcessor;
import racingcar.processor.Request;
import racingcar.util.Generator;

public class Application {

    public static void main(String[] args) {
        Request request = new Request();
        Generator generator = new Generator();
        WinnerEvaluator evaluator = new WinnerEvaluator();

        CarDataProcessor processor = new CarDataProcessor(request);
        Movement movement = new Movement(generator);
        ResultPrinter printer = new ResultPrinter(evaluator);

        RacingGame racingGame = new RacingGame(processor, movement, printer);
        racingGame.run();
    }
}
