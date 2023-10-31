package racingcar;

import racingcar.repository.CarRaceResultsSave;
import racingcar.race.Car;
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

        Car car = new Car(pickRandomNumber);
        CarRaceResultsSave carRaceResultsSave = new CarRaceResultsSave(car);

        OutPut outPut = new OutPut(carRaceResultsSave, car, finalWinner, input);

        outPut.racingGuide();

    }
}
