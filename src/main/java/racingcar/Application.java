package racingcar;

import racingcar.race.Race;
import racingcar.util.CarRacingStarts;
import racingcar.util.PickRandomNumber;
import racingcar.view.Input;
import racingcar.view.OutPut;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PickRandomNumber pickRandomNumber = new PickRandomNumber();
        CarRacingStarts carRacingStarts = new CarRacingStarts(pickRandomNumber);

        Input input = new Input();
        OutPut outPut = new OutPut(carRacingStarts, input);

        Race race = new Race(carRacingStarts, outPut);
        OutPut run = new OutPut(carRacingStarts, input);

        run.racingGuide();

    }
}
