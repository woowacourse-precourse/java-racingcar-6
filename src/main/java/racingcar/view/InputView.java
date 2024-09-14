package racingcar.view;


import racingcar.model.Cars;
import racingcar.util.InputUtil;
import racingcar.view.console.ConsoleReader;
import racingcar.view.console.ConsoleWriter;

import java.util.List;

/*
역할은 우리가 보는 InputView를 담당하고 있다.
그럼 이걸 메세지에 보여주는 함수가 필요한데 어떻게 보여주지?
 */
public class InputView {
    private static final String GET_CAR_NAMES_STRING=  "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GET_NUMBER_OF_MOVE = "시도할 회수는 몇회인가요?";
    ConsoleWriter consoleWriter = new ConsoleWriter();
    ConsoleReader consoleReader = new ConsoleReader();

    public Cars getCars(){
        consoleWriter.printMessage(GET_CAR_NAMES_STRING);
        return new Cars(InputUtil.validateName(consoleReader.getLine()));
    }

    public int getNumberOfMoves(){
        consoleWriter.printMessage(GET_NUMBER_OF_MOVE);
        return InputUtil.validateNumberOfMoves(consoleReader.getLine());
    }
}
