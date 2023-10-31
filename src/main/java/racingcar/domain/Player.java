package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Player {

    private static final String SEPARATOR = ",";

    public List<String> inputCarNames(){
        String carNames = Console.readLine();
        List<String> names = Arrays.stream(carNames.split(SEPARATOR)).toList();
        checkUnder5Length(names);
        return names;
    }

    private void checkUnder5Length(List<String> names) {
        for (String name : names){
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputTryCnt(){
        String tryCnt = Console.readLine();
        checkIsNumber(tryCnt);
        return Integer.parseInt(tryCnt);
    }

    private void checkIsNumber(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException();
        }
    }
}
