package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class AnnouncerTest extends NsTest {
    private final Announcer announcer = new Announcer();
    private final Car pobi = new Car("pobi");
    private final Car woni = new Car("woni");


    @Test
    void 자동차들의_위치를_정상적으로_출력() {
        // given
        pobi.moveForward();
        woni.moveForward();
        woni.moveForward();

        // when -> announceRoundResult()

        // then
        assertSimpleTest(() -> {
            announcer.announceRaceRound(List.of(pobi, woni));
            assertThat(output()).contains("pobi : -", "woni : --");
        });
    }

    @Override
    protected void runMain() {
        announcer.announceRaceRound(List.of(pobi, woni));
    }
}
