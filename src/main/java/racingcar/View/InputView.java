package racingcar.View;

import java.io.PrintStream;
import java.util.List;

public class InputView {

    private final PrintStream printStream;


    public InputView(PrintStream printStream) {
        this.printStream = printStream;

    }

    public List<String> inputCarNames() {
        printStream.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        //scanner X, Console.readLine() 사용
        //중복 처리
        return null;
    }

    //회수 입력?
}
