package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacerName {
    public static List<String> inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼(,) 기준으로 구분)");
        // List<String> racerList = new ArrayList<>();
        List<String> racerList = Arrays.asList(Console.readLine().split(","));



//        for (String racer: racerList) {
//            if(racer.length() >= 6){
//                throw new IllegalArgumentException("5자리 이하의 이름을 입력하세요");
//            }
//        }

        return racerList;
    }
}
