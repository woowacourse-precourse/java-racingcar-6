package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.stubbing.OngoingStubbing;

public class RacingGameTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final String lineSeparator = System.lineSeparator();

    @BeforeEach
    public void setUpStreams() {
        System.setOut((new PrintStream(output)));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
        Console.close();
    }

    @Test
    @DisplayName("자동차 경주 우승자 출력 테스트")
    void canPrintRacingGameWinnerTest() throws Exception{
        final int MOVE_SUCESS = 9;
        final int MOVE_FAIL = 1;
        InputStream input = new ByteArrayInputStream("부릉이,따릉이\n2".getBytes());
        System.setIn(input);

        int[] values = new int[]{MOVE_SUCESS, MOVE_SUCESS, MOVE_FAIL, MOVE_SUCESS};
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            OngoingStubbing<Integer> stubbing = mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()));
            for (int value : values) {
                stubbing = stubbing.thenReturn(value);
            }
            Application.main(null);
            assertThat(output.toString()).contains("최종 우승자 : 따릉이" + lineSeparator);
        }
    }

    @Test
    @DisplayName("자동차 경주 중복 우승자 출력 테스트")
    void canPrintRacingGameDuplicateWinnerTest() throws Exception{
        final int MOVE_SUCESS = 9;
        final int MOVE_FAIL = 1;
        InputStream input = new ByteArrayInputStream("부릉이,따릉이\n2".getBytes());
        System.setIn(input);

        int[] values = new int[]{MOVE_SUCESS, MOVE_SUCESS, MOVE_FAIL, MOVE_FAIL};
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            OngoingStubbing<Integer> stubbing = mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()));
            for (int value : values) {
                stubbing = stubbing.thenReturn(value);
            }
            Application.main(null);
            assertThat(output.toString()).contains("최종 우승자 : 부릉이, 따릉이" + lineSeparator);
        }
    }

    @Test
    @DisplayName("자동차 경주 최종 테스트 (예시와 같은 동작)")
    void canRacingGameTest() throws Exception{
        final int MOVE_SUCESS = 9;
        final int MOVE_FAIL = 1;
        InputStream input = new ByteArrayInputStream("pobi,woni,jun\n5".getBytes());
        System.setIn(input);

        int[] values = new int[]{
                MOVE_SUCESS, MOVE_FAIL, MOVE_SUCESS,
                MOVE_SUCESS, MOVE_SUCESS, MOVE_SUCESS,
                MOVE_SUCESS, MOVE_SUCESS, MOVE_SUCESS,
                MOVE_SUCESS, MOVE_SUCESS, MOVE_SUCESS,
                MOVE_SUCESS, MOVE_SUCESS, MOVE_SUCESS
        };
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            OngoingStubbing<Integer> stubbing = mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()));
            for (int value : values) {
                stubbing = stubbing.thenReturn(value);
            }
            Application.main(null);
            assertThat(output.toString()).isEqualTo("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + lineSeparator
                    + "시도할 회수는 몇회인가요?" + lineSeparator
                    + lineSeparator
                    + "실행 결과" + lineSeparator
                    + "pobi : -" + lineSeparator
                    + "woni : " + lineSeparator
                    + "jun : -" + lineSeparator
                    + lineSeparator
                    + "pobi : --" + lineSeparator
                    + "woni : -" + lineSeparator
                    + "jun : --" + lineSeparator
                    + lineSeparator
                    + "pobi : ---" + lineSeparator
                    + "woni : --" + lineSeparator
                    + "jun : ---" + lineSeparator
                    + lineSeparator
                    + "pobi : ----" + lineSeparator
                    + "woni : ---" + lineSeparator
                    + "jun : ----" + lineSeparator
                    + lineSeparator
                    + "pobi : -----" + lineSeparator
                    + "woni : ----" + lineSeparator
                    + "jun : -----" + lineSeparator
                    + lineSeparator
                    + "최종 우승자 : pobi, jun" + lineSeparator);
        }
    }
}
