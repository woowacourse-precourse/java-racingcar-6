package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 우승_자동차_테스트_우승자_여러명() {
        Util util = new Util();
        Car[] carList = new Car[3];
        carList[0] = new Car("pobi", 5);
        carList[1] = new Car("crong", 5);
        carList[2] = new Car("wooni", 5);

        List<String> victorylist = util.compare(carList);

        assertThat(victorylist).contains("pobi", "crong", "wooni");


    }

    @Test
    void 우승_자동차_테스트_우승자_1명() {
        Util util = new Util();
        Car[] carlist = new Car[3];
        carlist[0] = new Car("pobi", 3);
        carlist[1] = new Car("crong", 2);
        carlist[2] = new Car("wooni", 5);

        List<String> victorylist = util.compare(carlist);

        assertThat(victorylist.get(0)).isEqualTo("wooni");

    }

    @Test
    void 자동차_이동() {
        Util util = new Util();
        String[] split = {"pobi", "crong", "wooni"};
        Car[] carlist = util.createCar(split);

        util.move(carlist[0], 5);
        util.move(carlist[1], 2);

        assertThat(carlist[0].getPos()).isEqualTo(1);
        assertThat(carlist[1].getPos()).isEqualTo(0);

    }

    @Test
    void 자동차_생성() {
        Util util = new Util();
        String[] split = {"pobi", "crong", "wooni"};

        Car[] carList = util.createCar(split);

        assertThat(carList[0].getName()).isEqualTo("pobi");
        assertThat(carList[0].getPos()).isEqualTo(0);
        assertThat(carList[1].getName()).isEqualTo("crong");
        assertThat(carList[1].getPos()).isEqualTo(0);
        assertThat(carList[2].getName()).isEqualTo("wooni");
        assertThat(carList[2].getPos()).isEqualTo(0);

    }

    @Test
    void 이름_분류() {
        Input input = new Input();
        String inputData = "pobi,crong,woni";
        String[] devidedName = input.devide_name(inputData);

        assertThat(devidedName).containsExactly("pobi", "crong", "woni");
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
