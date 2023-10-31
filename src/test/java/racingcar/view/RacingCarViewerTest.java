package racingcar.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;


class RacingCarViewerTest extends NsTest {

    @DisplayName("Null 또는 공백이 포함될 경우 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: inValidCarName: {0}")
    @ValueSource(strings = {"string  -", "s tring", "i ", "d1 233"})
    void failNullAndEmptyCarName(String inValidCarName) {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    String numberOfAttempts = "3";
                    runException("pobi,whyWhale," + inValidCarName, numberOfAttempts);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("레이싱 게임 규정상 5글자가 넘어가는 이름을 입력하면 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: outOfLengthCarName: {0}")
    @ValueSource(strings = {"blueWhale", "whyWhale", "DarkWhale  ", "ticTok"})
    @NullAndEmptySource
    void failOutOfLengthCarName(String outOfLengthCarName) {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> {
                    String numberOfAttempts = "1";
                    runException("pobi,whyWhale" + outOfLengthCarName, numberOfAttempts);
                }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도할 횟수는 Null 또는 공백이 포함될 경우 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: outOfLengthCarName: {0}")
    @ValueSource(strings = {"string  -", "s tring", "i ", "d1 233"})
    @NullAndEmptySource
    void failNullAndEmptyNumberOfAttempts(String invalidNumberOfAttempts) {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,whyWhale", invalidNumberOfAttempts))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도할 횟수는 숫자가 아니면 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: outOfLengthCarName: {0}")
    @ValueSource(strings = {"i", "l", "L", "a"})
    void failNotNumberNumberOfAttempts(String notNumber) {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,whyWhale", notNumber))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도할 횟수는 1미만 1억을 초과하면 IllegalException 이 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: outOfLengthCarName: {0}")
    @ValueSource(ints = {0, -1, 100_000_001})
    void failNotNumberNumberOfAttempts(int outOfRangeNumber) {
        //given
        //when
        //then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,whyWhale", String.valueOf(outOfRangeNumber)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}