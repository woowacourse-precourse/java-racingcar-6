package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@DisplayName("애플리케이션 기능목록을 검증하는 테스트")
@DisplayNameGeneration(ReplaceUnderscores.class)
@TestInstance(Lifecycle.PER_CLASS)
public class MyApplicationTest {

    private static final PrintStream systemOut = System.out;
    private static final InputStream systemIn = System.in;
    private static final String INPUT_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRIALS = "시도할 회수는 몇회인가요?";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자";
    private ByteArrayOutputStream outBuffer;
    private PrintStream outputStream;
    private List<String> outputs = Collections.emptyList();


    @Test
    void 게임_시작_직후에_자동차_이름_입력_문구_출력() {
        run("pobi,woni", "10");
        assertThat(outputs())
                .first()
                .isEqualTo(INPUT_NAMES);

    }

    @Test
    void 자동차_이름_입력_문구와_시도할_횟수_입력_문구_출력() {
        run("pobi,woni", "10", "1");
        assertThat(outputs())
                .contains(INPUT_NAMES, INPUT_TRIALS);
    }
    @Test
    void 자동차_이름을_빈_문자열로_주면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(()->{
            run("", "10");

        });
    }

    @Test
    void 자동차_이름이_0글자이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(()->{
            run("pobi,,woni", "10");

        });
    }
    @Test
    void 자동차_이름이_6글자_이상이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(()->{
            run("pobi,sebastian,woni", "10");

        });
    }

    @Test
    void 시도할_횟수가_0_이하의_값이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(()->{
            run("pobi,woni", "-15");

        });
    }
    @Test
    void 시도할_횟수가_정수형이_아닌_값이면_프로그램_종료() {
        assertThatProgramExitsWithIllegalArgumentException(()-> {
            run("pobi,woni", "hello");
        });

    }

    void assertThatProgramExitsWithIllegalArgumentException(ThrowingCallable callable) {
        assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(outputs())
                .doesNotContain(EXECUTION_RESULT)
                .noneMatch(s -> s.contains(FINAL_WINNER));
    }


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

    List<String> outputs() {
        return List.copyOf(outputs);
    }

}
