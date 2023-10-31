package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.CarNameException;
import racingcar.exception.RoundException;

public class Input {
    public static String[] carName() {
        String carNameAll = Console.readLine();
        String[] carNameUnit = carNameAll.split(",");
        for (String name : carNameUnit){
            CarNameException.carNameLengthException(name);
            CarNameException.blankException(name);
        }
        CarNameException.carNameSameException(carNameUnit);

        return carNameUnit;
    }

    public static int gameRound() {
        String round = Console.readLine();
        return RoundException.noIntRoundException(round);
    }


}
