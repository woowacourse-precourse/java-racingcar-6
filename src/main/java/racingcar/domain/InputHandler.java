package racingcar.domain;

import java.util.List;
import racingcar.utils.Utils;
import racingcar.validate.Validator;

public class InputHandler {

    public static Race setCars(){
        String carNameString = InputOutputMessage.carInput();
        List<String> carNameList = Utils.toStringList(carNameString);
        Race racingCars = new Race(carNameList);

        Validator.ValidateRightNamesString(carNameString);
        Validator.ValidateRightNameSize(carNameList);
        Validator.ValidateDuplicate(carNameList);

        return racingCars;
    }

    public static int setRoundNumber(){
        String roundNumberString = InputOutputMessage.roundInput();
        int roundNumber = Integer.parseInt(roundNumberString);

        Validator.ValidateRoundNumberType(roundNumberString);

        return roundNumber;
    }
}
