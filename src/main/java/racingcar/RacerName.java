package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacerName {
    public static List<String> inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼(,) 기준으로 구분)");
        List<String> racerNames = new ArrayList<>();
        racerNames.add(Console.readLine());

        return racerNames;
    }
}
