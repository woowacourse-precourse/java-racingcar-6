package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.message.InputMessage;
import racingcar.utils.Validation;

import java.util.List;

public class InputView {
    private final Validation validation = new Validation();
    public List<String> startGame(){
        System.out.println(InputMessage.INPUT_RACING_CARNAME.getMsg()+InputMessage.NOTE_CARS_DELIMITER.getMsg());

        List<String> carNames = List.of(Console.readLine().split(InputMessage.CARS_DELIMITER.getMsg()));
        return validation.validateCarNames(carNames);
    }
    public Integer inputTryCount(){
        System.out.println(InputMessage.INPUT_TRYCOUNT);
        Integer tryCount = Integer.valueOf(Console.readLine());

        return validation.validTryCount(tryCount);
    }
}
