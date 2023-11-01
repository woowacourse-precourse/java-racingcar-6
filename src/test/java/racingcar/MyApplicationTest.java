package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.MethodOrderer.MethodName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("애플리케이션 기능목록을 검증하는 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodName.class)
public class MyApplicationTest {

    private static final PrintStream systemOut = System.out;
    private static final InputStream systemIn = System.in;

    private ByteArrayOutputStream outBuffer;
    private PrintStream outputStream;
    private List<String> outputs = Collections.emptyList();


    void run(String... args) {
        resetInputStream(args);
        resetOutputStream();
        runMain();
        outputs = Arrays.stream(outBuffer.toString().split("\n"))
                .collect(Collectors.toList());
    }

    void runMain() {
        Application.main(new String[]{});
    }

    void resetInputStream(String... args) {
        byte[] inBuffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(inBuffer));
    }

    void resetOutputStream() {
        outBuffer = new ByteArrayOutputStream();
        outputStream = new PrintStream(outBuffer);
        System.setOut(outputStream);
    }

    @AfterAll
    static void tearDown() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }

    @AfterEach
    void clean() {
        outputs = Collections.emptyList();
        Console.close();
    }

    protected List<String> outputs() {
        return List.copyOf(outputs);
    }

    protected void printOutputs() {
        systemOut.println(Arrays.toString(outputs().toArray()));
    }

}
