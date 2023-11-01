package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.message.Console;
import racingcar.evaluator.WinnerEvaluator;
import racingcar.printer.ResultPrinter;
import racingcar.processor.CarDataProcessor;
import racingcar.util.Generator;
import racingcar.processor.Request;

public class RacingGame {

    private final CarDataProcessor processor;
    private final Movement movement;
    private final ResultPrinter printer;

    public RacingGame() {
        Request request = new Request();
        Generator generator = new Generator();
        WinnerEvaluator evaluator = new WinnerEvaluator();
        this.processor = new CarDataProcessor(request);
        this.movement = new Movement(generator);
        this.printer = new ResultPrinter(evaluator);
    }

    public void run() {
        List<Car> cars = processor.process();
        int gameRounds = processor.processCount();

        while (gameRounds-- > 0) {
            cars.forEach(car -> {
                movement.moveCar(car);
                Console.showCarStatus(car.getName(), car.toString());
            });

            Console.newLine();
        }

        printer.print(cars);
    }
}
