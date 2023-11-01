package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class CarGenerator {
    
    public List<Object> inputCarNames(){
        List<Object> carNames = new ArrayList<Object>();
        String input = Console.readLine();
        carNames = Arrays.asList(input.split(","));

        return carNames;
    }
}
