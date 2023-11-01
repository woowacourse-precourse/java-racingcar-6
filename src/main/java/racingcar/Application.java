package racingcar;

import racingcar.domain.RaceingCar;
import static racingcar.domain.Verification.checkEqualsAndThrowException;
import static racingcar.domain.Verification.throwCarNameLengthException;
import static racingcar.view.Output.carName;
import static racingcar.view.input.inputCarName;
import static racingcar.view.input.inputNumberCarsRace;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class Application {

    public static int repeat = 0;
    private ArrayList<Car> cars;
    public static void main(String[] args) {
        carName(inputCarName());
        repeat = inputNumberCarsRace();


    }


}
