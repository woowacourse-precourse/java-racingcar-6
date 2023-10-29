package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";


    public void inputCarName(){
        System.out.println(CAR_INPUT);
        String carName = Console.readLine();

        List<String> carNameList = splitCarName(carName);

        CarNameValidator.checkLength(carNameList);
        CarNameValidator.checkDuplicated(carNameList);
    }

    public List<String> splitCarName(String carName){
        List<String> carNameList = Arrays.
                stream(carName.split(DELIMITER)).
                toList();

        return carNameList;
    }

    public void inputCount(){
        System.out.println(COUNT_INPUT);
        String count = Console.readLine();

        //유효성 검증
    }
}
