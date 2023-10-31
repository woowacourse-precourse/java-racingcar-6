package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.validation.InputValidation;


public class InputView {

    private static final String ASK_TRIES="시도할 회수는 몇회인가요?";
    private static final String ASK_CAR_NAMES="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    public String readTriesInput(){
        System.out.println(ASK_TRIES);
        return Console.readLine();
    }

    public String readCarNamesInput(){
        System.out.println(ASK_CAR_NAMES);
        return Console.readLine();
    }

}
