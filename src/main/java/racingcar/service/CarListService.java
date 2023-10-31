package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.Util.Verification.verifyCarName;
import static racingcar.Util.Verification.verifyDuplication;

public class CarListService {
    public static String[] getCarNames(){
        String inputCarName = Console.readLine();
        String[] carArray = inputCarName.split(",");

        for(int i = 0; i < carArray.length; i++){
            verifyCarName(carArray[i]);
        }
        verifyDuplication(carArray);

        return carArray;
    }
}
