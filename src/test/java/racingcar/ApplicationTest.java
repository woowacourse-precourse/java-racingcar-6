package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceGameController;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Car car = new Car("kgy");
    private RaceGameController raceGameController = new RaceGameController();

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
    void 자동차_이름_숫자포함일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang1,geon,young", "3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_숫자일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang,geon,13", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_5자_초과일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang,geonyoung", "2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_공백일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" ", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_빈줄일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 시도_횟수_문자일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang,geon,young", "a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_소수점_숫자일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang,geon,young", "3.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수_공백일경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kang,geon,young", " "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 자동차_객체_리스트_변환() {
        List<Car> carList = new ArrayList<>();
        List<String> carInputList = new ArrayList<>(List.of("kang", "geon", "young"));
        carList = raceGameController.convertCarList(carInputList);

        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    void 범위내_무작위_숫자_생성() {
        int randomNumber = car.generateRandomNumber();
        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }


    @Test
    void 자동차_한대_참여할경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kgy", "3");
                    assertThat(output()).contains("kgy : ---", "최종 우승자 : kgy");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_모두_공동_우승할경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("kang,geon,young", "3");
                    assertThat(output()).contains("kang : ---", "geon : ---", "young : ---", "최종 우승자 : kang, geon, young");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
