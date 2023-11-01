package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_ROUND_NUMBER_MESSAGE = "시도할 횟수는 몇회인가요?";

    private final InputViewValidator inputViewValidator;

    public InputView(InputViewValidator inputViewValidator){
        this.inputViewValidator = inputViewValidator;
    }
    public List<String> inputCarNames(){
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String carNamesString = Console.readLine();
        inputViewValidator.validateCarNames(carNamesString);
        List<String> carNameList = Arrays.asList(carNamesString.split(","));
        return carNameList;
    }

    public Integer inputTotalRoundNumber(){
        System.out.println(INPUT_TOTAL_ROUND_NUMBER_MESSAGE);
        String totalRoundNumberString = Console.readLine();
        inputViewValidator.validateTotalRoundNumber(totalRoundNumberString);
        Integer totalRoundNumber = Integer.parseInt(totalRoundNumberString);
        return totalRoundNumber;
    }
}
