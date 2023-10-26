package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public List<String> inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Arrays.stream(readLine().split(","))
                .collect(Collectors.toList());
    }

    public int inputTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = readLine();
        return Integer.parseInt(tryNumber);
    }


}
