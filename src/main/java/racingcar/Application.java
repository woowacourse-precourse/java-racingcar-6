package racingcar;

import racingcar.repository.SaveCarRaceResults;
import racingcar.util.CarRacingStarts;
import racingcar.util.PickRandomNumber;
import racingcar.view.Input;
import racingcar.view.OutPut;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        PickRandomNumber pickRandomNumber = new PickRandomNumber();
        Input input = new Input();

        CarRacingStarts carRacingStarts = new CarRacingStarts(pickRandomNumber);
        SaveCarRaceResults saveCarRaceResults = new SaveCarRaceResults(carRacingStarts);
        OutPut outPut = new OutPut(input, saveCarRaceResults);

        outPut.racingGuide();

    }
}
