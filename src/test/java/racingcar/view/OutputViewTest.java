package racingcar.view;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Player;

class OutputViewTest {

    private static final String FORWARD = "forward";
    private final OutputView outputView = new OutputView();
    private OutputStream captor;
    private PrintStream standardOut;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        System.out.println(captor.toString().trim());
    }

    @DisplayName("[성공] 현재 상태를 출력하는 테스트")
    @Test
    public void 현재_상태를_출력하는_테스트() throws Exception {
        // given
        Player pobi = new Player("pobi");

        Field pobiForward = pobi.getClass().getDeclaredField(FORWARD);
        pobiForward.setAccessible(true);
        pobiForward.set(pobi, 2); // pobi는 전진을 2번함

        // when
        outputView.printPlayerStatus(pobi);

        // then
        Assertions.assertThat(captor.toString().trim()).isEqualTo("pobi : --");
    }

    @DisplayName("[실패] 현재 상태를 출력하는 테스트")
    @Test
    public void 현재_상태를_출력하는_테스트_실패() throws Exception {
        // given
        Player pobi = new Player("pobi");

        Field pobiForward = pobi.getClass().getDeclaredField(FORWARD);
        pobiForward.setAccessible(true);
        pobiForward.set(pobi, 2); // pobi는 전진을 2번함

        // when
        outputView.printPlayerStatus(pobi);

        // then
        Assertions.assertThat(captor.toString().trim()).isNotEqualTo("pobi : -");
    }

    @DisplayName("[성공] 우승자를 출력하는 테스트")
    @Test
    public void 우승자를_출력하는_테스트() throws Exception {
        // given
        String woni = "woni";
        String test = "test";

        ArrayList<String > winners = new ArrayList<>();
        winners.add(woni);
        winners.add(test);

        // when
        outputView.printWinner(winners);

        // then
        Assertions.assertThat(captor.toString().trim()).isEqualTo("최종 우승자 : woni, test");
    }

    @DisplayName("[실패] 우승자를 출력하는 테스트")
    @Test
    public void 우승자를_출력하는_테스트_실패() throws Exception {
        // given
        String woni = "woni";
        String test = "test";

        ArrayList<String > winners = new ArrayList<>();
        winners.add(woni);
        winners.add(test);

        // when
        outputView.printWinner(winners);

        // then
        Assertions.assertThat(captor.toString().trim()).isNotEqualTo("최종 우승자 : woni");
    }
}