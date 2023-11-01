package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.fields.ColumnMapping;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private ByteArrayOutputStream outputStream;

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
    void test_moveCars() {
        String[] carNameArray={"pobi","woni"};
        int[] carForwardArray=new int[2];

        Application.moveCars(carNameArray,carForwardArray);

        for (int forwardCount: carForwardArray){
            assertThat(forwardCount).isIn(0,1);
        }
    }

    @Test
    void test_PrintOutForwardCounts() {
        String[] carNameArray={"pobi","woni","jin"};
        int[] carForwardArray={2,3,4};
        outputStream=new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Application.printForwardCounts(carNameArray,carForwardArray);
        String expectedOutput="pobi : --, woni : ---, jin : ----";
        assertThat(outputStream.toString().trim()).isEqualTo(expectedOutput);
    }

    @Test
    void test_getWinners() {
        String[] carNameArray={"pobi","woni","jin"};
        int[] carForwardArray={3,2,3};
        int maxForwardCount=3;

        String[] winners=Application.getWinners(carNameArray,carForwardArray,maxForwardCount);
        assertThat(winners).containsExactly("pobi","jin");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
