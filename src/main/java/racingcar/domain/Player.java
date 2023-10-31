package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Player {

    public List<String> inputCarNames(){
        String carNames = Console.readLine();
        List<String> names = Arrays.stream(carNames.split(",")).toList();
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
        return Integer.parseInt(tryCnt);
    }

}
