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
        validateEachNameLength(carNames);
        return carNames;
    }

    private static void validateComma(String input){
        int lastIndex = input.length() - 1;
        if(input.charAt(lastIndex) == ','){
            throw new IllegalArgumentException("마지막 글자가 콤마가 될 수 없습니다!");
        }
    }

    private static void validateEachNameLength(List<String> names){
        boolean findIllegalLength = names.stream().anyMatch(s -> s.length() >= 1 && s.length() <= 5);
        if(findIllegalLength){
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자 이하여야 합니다.");
        }
    }
}
