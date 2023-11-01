package racingcar.View;

import static racingcar.Message.ExceptionMessage.NULL_ERROR;
import static racingcar.Message.InputMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.CarException;
import racingcar.Exception.RaceException;
import racingcar.Message.ExceptionMessage;

public class InputView {
    CarException carException = new CarException();
    RaceException raceException = new RaceException();

    public String inputCar(){
        System.out.println(CAR_NAME_MESSAGE);
        String carsName = Console.readLine();
        return carException.checkExceptionCar(carsName);
    }

    public int inputRaceTime() {
        System.out.println(TIMES_MESSAGE);
        String raceTime = Console.readLine();
        return raceException.checkExceptionRace(raceTime);
    }
}
