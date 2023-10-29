package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public static List<String> inputRacingCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 예외처리
        return Arrays.stream(Console.readLine().split(","))
                .map(String::trim)
                .toList();
    }
    public static String inputRacingRoundTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
