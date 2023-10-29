package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private IOService ioService = new IOService();
    void systemIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
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
    void 자동차_이름_입력_정상(){
        systemIn("pobi,woni,jun,,");
        List<String> carNames = ioService.scanCarNames();
        assertEquals("pobi", carNames.get(0));
        assertEquals("woni", carNames.get(1));
        assertEquals("jun", carNames.get(2));
    }

    @Test
    void 자동차_이름_공백_입력_예외_테스트(){
        systemIn("\n");
        List<String> carNames;

        assertThatThrownBy(()->
            ioService.scanCarNames()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_입력_글자수_초과_테스트(){
        systemIn("pobi,woni,jun,lujaeeee");
        List<String> carNames;

        assertThatThrownBy(()->
                ioService.scanCarNames()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 랜덤_숫자_리스트_생성_테스트(){
        int size = 9;
        List<Integer> randomNumbers = NumberGenerator.createRandomNumbers(size);

        assertThat(randomNumbers).hasSize(size);
        randomNumbers.forEach(
                (number)->assertThat(number)
                        .isGreaterThanOrEqualTo(0)
                        .isLessThanOrEqualTo(9)
        );


    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
