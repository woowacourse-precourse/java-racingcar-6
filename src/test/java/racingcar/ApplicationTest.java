package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void processCarNames_5_글자_초과_하는_이름_존재할_때_예외_발생(){
        Game game = new Game();
        String carNames = "abcdef,ab";

        assertThatThrownBy(() -> game.processCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void processCarNames_1_글자_미만인_이름_존재할_때_예외_발생(){
        Game game = new Game();
        String carNames = ",ab";


        assertThatThrownBy(() -> game.processCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void processCarNames_유효한_이름들일_때_예외_발생_안함(){
        Game game = new Game();
        String carName = "abc,de";

        assertDoesNotThrow(() -> game.processCarNames(carName));
    }

    @Test
    void splitAndConvertToList_유효한_사용자_입력일_때_쉼표를_기준으로_분할(){
        Game game = new Game();
        String carNamesInput = "pobi,woni,jun";
        List<String> carList = game.splitAndConvertToList(carNamesInput, ",");

        assertThat(carList).contains("woni", "pobi", "jun");
    }

    @Test
    void storeCarNames_List에_들어_있는_값들_LinkedHashMap에_저장(){
        Game game = new Game();
        List<String> carList = Arrays.asList("pobi", "woni");
        game.storeCarNames(carList);

        LinkedHashMap<String, Integer> cars = game.getCars();
        assertThat(cars.size()).isEqualTo(2);
        assertThat(cars.containsKey("pobi"));
        assertThat(cars.containsKey("woni"));
        assertThat(cars.get("pobi")).isEqualTo(0);
        assertThat(cars.get("woni")).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
