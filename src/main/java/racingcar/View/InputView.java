package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
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
        // 이름이 5글자 이하
        // 그냥 Return으로 바로 넘겨도 될듯
        return carNameList;
    }
    public static String inputRacingRoundTimes(){
        System.out.println("시도할 회수는 몇회인가요?");
        String racingRoundTimes = Console.readLine(); // String을 다른걸로 바꿀수는 없을까?
        // 숫자만 되게 예외처리
        return racingRoundTimes;
    }
}
