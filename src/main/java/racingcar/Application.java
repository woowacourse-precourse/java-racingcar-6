package racingcar;

import racingcar.utils.InputCarName;
import racingcar.utils.InputTryNumber;
import racingcar.Racingcar;
public class Application {
        public static void main(String[] args) {
            String[] carNamesArray = InputCarName.getCarNames();
            int tryNumber = InputTryNumber.getTryNumber();
            Racingcar race = new Racingcar(carNamesArray, tryNumber);
            race.startRace();
        }
    }
