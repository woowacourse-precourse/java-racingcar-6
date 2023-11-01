package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final List<String> names = new ArrayList<>();

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
    void 비어있는_이름_입력시_예외_처리() {
        names.clear();
        names.add("");
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputValidator.carsName("", names))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_최대_길이_제한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abcdef,ghi"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_분리_1명() {
        String carsName = "abc";
        String[] names = carsName.split(",");

        assertThat(names).contains("abc");
        assertThat(names).containsExactly("abc");
    }


    @Test
    void 자동차_이름_분리_다수() {
        String carsName = "abc,def,ghi,jkl";
        String[] names = carsName.split(",");

        assertThat(names).contains("ghi", "def", "jkl", "abc");
        assertThat(names).containsExactly("abc", "def", "ghi", "jkl");
    }

    @Test
    void 레이스_횟수_입력_예외_처리() {
        String carName = "abc,def"; // there is no exception
        String raceTime = "5a"; // expect to occur exception
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(carName, raceTime))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Test
    void 자동차_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("abc : -", "abc : --", "abc : ---", "def : -",
                            "def : --", "def : ---");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 자동차_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("abc : ", "def : ");
                },
                STOP
        );
    }


    @Test
    void 자동차_위치_증가() {
        names.clear();
        names.add("abc");
        names.add("def");
        names.add("ghi");

        CarList carList = new CarList(names);
        carList.plusOnePosition(0);
        carList.plusOnePosition(0);
        assertThat(carList.getPosition(0) == 2);
        assertThat(carList.getPosition(1) == 0);
        assertThat(carList.getPosition(2) == 0);

    }

    @Test
    void 자동차_최대_위치_탐색_1명() {
        names.clear();
        names.add("abc");
        names.add("def");
        names.add("ghi");

        CarList carList = new CarList(names);
        carList.plusOnePosition(0);
        carList.plusOnePosition(0);
        List<Integer> maxPositionIndexArray = carList.findMaxCarPositionIndex();
        assertThat(maxPositionIndexArray)
                .containsExactly(0);

        carList = new CarList(names);
        carList.plusOnePosition(1);
        maxPositionIndexArray = carList.findMaxCarPositionIndex();
        assertThat(maxPositionIndexArray)
                .containsExactly(1);
    }

    @Test
    void 자동차_최대_위치_탐색_다수() {
        names.clear();
        names.add("abc");
        names.add("def");
        names.add("ghi");
        
        CarList carList = new CarList(names);
        carList.plusOnePosition(0);
        carList.plusOnePosition(1);
        List<Integer> maxPositionIndexArray = carList.findMaxCarPositionIndex();
        assertThat(maxPositionIndexArray)
                .containsExactly(0, 1);
    }


    @Test
    void 다수_승리자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("최종 우승자 : abc, def");
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 단일_승리자_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("abc,def", "3");
                    assertThat(output()).contains("최종 우승자 : abc");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
