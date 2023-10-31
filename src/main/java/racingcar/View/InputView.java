package racingcar.View;
import static racingcar.Message.InputMessage.*;
import static racingcar.Message.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Exception.CarException;
import racingcar.Exception.RaceException;

public class InputView {
    CarException carException = new CarException();
    RaceException raceException = new RaceException();
    public String inputCar(){
        System.out.println(CAR_NAME_MESSAGE);
        String carsName = Console.readLine();
        try {
            return carException.checkExceptionCar(carsName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int inputRaceTime(){
        System.out.println(TIMES_MESSAGE);
        String raceTime = Console.readLine();
        try {
            return raceException.checkExceptionRace(raceTime);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
