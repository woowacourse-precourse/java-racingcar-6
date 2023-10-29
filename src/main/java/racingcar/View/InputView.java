package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputRacingCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 예외처리
        List<String> carNameList = Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .toList();
        // carNameList.forEach(System.out::println);
        return carNameList;
    }

}
