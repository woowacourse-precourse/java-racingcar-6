package racingcar.view;

import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    public String inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        Validator.validateContainsComma(names);
        Validator.validateNames(names);
        return names;
    }



    public int inputTryNumber(){
        System.out.println("시도할 회수는 몇회인가요?");
        String tryNumber = readLine();
        Validator.validateOverOneNumber(tryNumber);
        return Integer.parseInt(tryNumber);
    }


}
