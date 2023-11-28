package racingcar.Service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Util.CheckNumberException;

public class InputTryNumberService {
    
    public int input(){
        String input = Console.readLine();
        CheckNumberException.numberValidation(input);
        return Integer.parseInt(input);
    }
}
