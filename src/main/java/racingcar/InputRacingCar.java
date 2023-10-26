package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputRacingCar {

    List<String> inputRacingCar(){
        List<String> inputCar = new ArrayList<>();
        String input = Console.readLine();
        StringTokenizer inputToken = new StringTokenizer(input,",");

        while(inputToken.hasMoreTokens()){
            inputCar.add(inputToken.nextToken());
        }
        return inputCar;
    }
}
