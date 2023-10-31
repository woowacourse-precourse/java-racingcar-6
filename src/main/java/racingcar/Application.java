package racingcar;

import racingcar.repository.CarRaceResultsSave;
import racingcar.util.CarRacingStarts;
import racingcar.util.FinalWinner;
import racingcar.util.PickRandomNumber;
import racingcar.view.Input;
import racingcar.view.OutPut;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현

        PickRandomNumber pickRandomNumber = new PickRandomNumber();
        FinalWinner finalWinner = new FinalWinner();
        Input input = new Input();

        CarRacingStarts carRacingStarts = new CarRacingStarts(pickRandomNumber);
        CarRaceResultsSave carRaceResultsSave = new CarRaceResultsSave(carRacingStarts);

        OutPut outPut = new OutPut(carRaceResultsSave, carRacingStarts, finalWinner, input);

        outPut.racingGuide();

    }
}
