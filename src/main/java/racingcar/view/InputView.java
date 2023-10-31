package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void displayInputCarsView() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void displayInputTryView() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public List<String> getInputCarsView(){
        displayInputCarsView();
        return inputParser.parsingNames(Console.readLine());
    }

    public int getInputTryView(){
        displayInputTryView();
        return inputParser.parseInt(Console.readLine());
    }

}
