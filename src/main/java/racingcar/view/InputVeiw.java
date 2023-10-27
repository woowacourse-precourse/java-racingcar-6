package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

/**
 * stream 더 효율적으로 할 수 있는 방법 찾기
 */
public class InputVeiw {

    public List<String> inputCarName() {
        return Arrays.stream(Console.readLine()
                        .split(",")).toList();
        // 문자열을 , 기준으로 쪼개서 -> list에 넣기
    }

    public Integer inputRoundNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
