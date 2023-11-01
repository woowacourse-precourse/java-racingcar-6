package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * 콘솔 입출력을 사용하는 메소드를 테스트할 때 유용한 기능을 제공하는 클래스 extends 하여 사용한다.
 */
public abstract class NsConsoleIOTest {

    private InputStream stdInput;
    private PrintStream stdOutput;
    private OutputStream outputStream;

    private void backupStdIO() {
        stdInput = System.in;
        stdOutput = System.out;
    }

    private void restoreStdIO() {
        System.setIn(stdInput);
        System.setOut(stdOutput);
    }

    @BeforeEach
    private void beforeInit() {
        backupStdIO();
        changeStdOutput();
    }

    /**
     * Standard out 을 ByteArrayOutputStream 으로 대체하는 작업
     */
    private void changeStdOutput() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @AfterEach
    private void afterInit() {
        restoreStdIO();
        clearConsoleScanner();
    }

    /**
     * camp.nextstep.edu.missionutils.Console::readLine() 메소드 내부에서 사용하는 scanner 를 지우기 위한 작업
     * </p>
     * setConsoleInput() 에서 새로 생성한 ByteArrayInputStream 은 해당 테스트 이후로 더이상 사용되지 않기 때문에 위와 같은 작업이 필요함.
     */
    private void clearConsoleScanner() {
        Console.close();
    }

    protected final void setConsoleInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    protected final String getConsoleOutput() {
        return outputStream.toString();
    }
}
