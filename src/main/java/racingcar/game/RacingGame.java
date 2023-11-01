package racingcar.game;

import java.util.List;
import racingcar.domain.Car;
import racingcar.message.Console;
import racingcar.printer.ResultPrinter;
import racingcar.processor.CarDataProcessor;

public class RacingGame {

    private final CarDataProcessor processor;
    private final Movement movement;
    private final ResultPrinter printer;

    public RacingGame(CarDataProcessor processor, Movement movement, ResultPrinter printer) {
        this.processor = processor;
        this.movement = movement;
        this.printer = printer;
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
