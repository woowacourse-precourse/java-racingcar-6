package racingcar.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final String racingCarName = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String tryCount = "시도할 횟수는 몇회인가요?";

    public String AskCarName(){
        System.out.println(racingCarName);
        return Console.readLine();
    }

    public int AskTryCount(){
        System.out.println(tryCount);
        String inputTryCount = Console.readLine();
        int intTrtCount = Integer.parseInt(inputTryCount);
        return intTrtCount;
    }

    public List<String> storeCarName() {
        List<String> carName = Arrays.asList(AskCarName().split(","));
        return carName;
    }
}
