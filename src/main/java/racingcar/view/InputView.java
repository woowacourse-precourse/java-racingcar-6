package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.CountValidator;

import java.util.Arrays;
import java.util.List;

import static racingcar.view.PrintMessage.*;

public class InputView {

    public static List<String> inputCarName(){
        System.out.println(CAR_INPUT);
        String carName = Console.readLine();

        List<String> carNameList = splitCarName(carName);

        CarNameValidator.checkLength(carNameList);
        CarNameValidator.checkDuplicated(carNameList);

        return carNameList;
    }

    public static List<String> splitCarName(String carName){
        List<String> carNameList = Arrays.
                stream(carName.split(DELIMITER)).
                toList();

        return carNameList;
    }

    public static int inputCount(){
        System.out.println(COUNT_INPUT);
        String count = Console.readLine();

        int countNumber = CountValidator.checkNumber(count);
        CountValidator.checkNegativeNumber(countNumber);

        return countNumber;
    }
}
