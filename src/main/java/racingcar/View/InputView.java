package racingcar.View;

import static racingcar.Message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.CarException;
import racingcar.Exception.RaceException;

public class InputView {
    CarException carException = new CarException();
    RaceException raceException = new RaceException();

    public String inputCar() {
        System.out.println(CAR_NAME_MESSAGE);
        try {
            String carsName = Console.readLine();
            return carException.checkExceptionCar(carsName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int inputRaceTime() {
        System.out.println(TIMES_MESSAGE);
        try {
            String raceTime = Console.readLine();
            return raceException.checkExceptionRace(raceTime);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
