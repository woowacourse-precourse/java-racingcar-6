package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputRacingCar {

    List<String> inputRacingCar(){
        List<String> inputCar = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        StringTokenizer inputToken = new StringTokenizer(input,",");

        while(inputToken.hasMoreTokens()){
            inputCar.add(inputToken.nextToken());
        }
        return inputCar;
    }
}
