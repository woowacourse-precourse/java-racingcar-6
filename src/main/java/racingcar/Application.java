package racingcar;

import racingcar.input.*;
import racingcar.input.decorator.CarCollectionPrintDecoratorUserInput;
import racingcar.input.decorator.RepeatCountDecoratorUserInput;
import racingcar.race.Handler;
import racingcar.race.RacingCarHandler;
import racingcar.race.RacingInfoHandler;
import racingcar.race.RacingResultHandler;
import racingcar.race.decorator.RacingPrintDecoratorHandler;
import racingcar.vo.CarCollection;
import racingcar.vo.RacingInfo;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final Handler<RacingInfo,RacingInfo> racingInfoHandler = new RacingPrintDecoratorHandler(new RacingInfoHandler(new RacingCarHandler(), new RacingResultHandler()));
        final ConsoleUserInput consoleUserInput = new ConsoleUserInput();
        final UserInput<CarCollection> carCollectionUserInput = new CarCollectionPrintDecoratorUserInput(new CarCollectionUserInput(consoleUserInput));
        final UserInput<Integer> repeatCountUserInput = new RepeatCountDecoratorUserInput(new RepeatCountUserInput(consoleUserInput));
        final RacingCar racingCar = new RacingCar(new RacingInfoUserInput(carCollectionUserInput, repeatCountUserInput), racingInfoHandler);
        racingCar.run();
    }
}
