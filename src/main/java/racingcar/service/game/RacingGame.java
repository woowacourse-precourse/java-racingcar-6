package racingcar.service.game;

import racingcar.domain.Cars;
import racingcar.dto.input.TimeInputDto;
import racingcar.dto.output.CarsOutputDto;
import racingcar.service.input.Input;
import racingcar.service.input.InputView;
import racingcar.service.output.Output;
import racingcar.service.output.OutputView;
import racingcar.service.race.Racing;
import racingcar.service.race.RandomLogicRace;
import racingcar.util.message.Printer;

public class RacingGame implements GameInterface{
    private static final int END_TIME = 0;
    private final Input input;
    private final Output output;
    private final Racing racing;
    public RacingGame() {
        this.output = new OutputView();
        this.racing = new RandomLogicRace();
        this.input = new InputView();
    }

    @Override
    public void play() {
        Cars cars = getCars();
        int time = getTime();
        competing(time, cars);
        resulting(cars);
    }

    private void resulting(final Cars cars) {
        output.showResult(new CarsOutputDto(cars));
    }

    private void competing( int time, final Cars cars) {
        printRaceResult();
        competeIteration(time, cars);
    }

    private static void printRaceResult() {
        Printer.switchLine();
        Printer.raceResult();
    }

    private void competeIteration(int time, Cars cars) {
        while(isCounting(time)){
            oneTimeCompeting(cars);
            time--;
        }
    }

    private void oneTimeCompeting(Cars cars) {
        racing.race(cars);
        output.showPlaying(new CarsOutputDto(cars));
        Printer.switchLine();
    }

    private static boolean isCounting(final int time) {
        return time > END_TIME;
    }

    private Cars getCars() {
        return Cars.of(input.getCarInput());
    }

    private int getTime() {
        return input.getTimeInput().time();
    }


}
