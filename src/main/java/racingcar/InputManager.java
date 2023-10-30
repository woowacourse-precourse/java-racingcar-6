package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

class InputManager {
    static List<String> getCarNames(){
        return getCarNames(Console.readLine());
    }

    static List<String> getCarNames(String input){
        validateComma(input);
        List<String> carNames = Arrays.asList(input.split(","));
        return carNames;
    }

    private static void validateComma(String input){
        int lastIndex = input.length() - 1;
        if(input.charAt(lastIndex) == ','){
            throw new IllegalArgumentException("마지막 글자가 콤마가 될 수 없습니다!");
        }
    }
}
