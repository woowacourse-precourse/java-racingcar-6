package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;


public class InputView {

    public static List<String> inputNames() {
        try {
            String names = readLine();
            return Arrays.asList(names.split(","));
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 형식의 자동차 이름이 입력되었습니다.", e);
        }
    }

    public static int inputTrialCount() {
        try {
            String trialCount = readLine();
            return Integer.parseInt(trialCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 형식의 시도횟수가 입력되었습니다.", e);
        }
    }
}
