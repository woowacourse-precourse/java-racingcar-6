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

public class RacingGame implements GameInterface{
    private static final int END_TIME = 0;
    private final Input input;
    private final Output output;
    private final Racing racing;
    public RacingGame(Output output, Racing racing) {
        this.output = new OutputView();
        this.racing = new RandomLogicRace();
        this.input = new InputView();
    }

    @Override
    public void play() {
        Cars cars = Cars.of(input.getCarInput());
        int time = getTime();
        competing(time, cars);

    }

    private void competing(int time, Cars cars) {
        while(isCounting(time)){
            racing.race(cars);
            output.showPlaying(new CarsOutputDto(cars));
            time--;
        }
    }

    private static boolean isCounting(int time) {
        return time > END_TIME;
    }

    private int getTime() {
        return input.getTimeInput().time();
    }


}
