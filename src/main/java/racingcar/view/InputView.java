package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_ROUND_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";
    public List<String> InputCarNames(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNames = Console.readLine();
        List<String> carNameList = Arrays.asList(carNames.split(", "));
        return carNameList;
    }

    public Integer InputTotalRoundNumber(){
        System.out.println(INPUT_TOTAL_ROUND_NUMBER_MESSAGE);
        Integer totalRoundNumber = Integer.parseInt(Console.readLine());
        return totalRoundNumber;
    }
}
