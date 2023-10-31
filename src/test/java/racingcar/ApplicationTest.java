package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Referee;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("자동차 이름 parsing")
    void 자동차_이름_파싱(){
        String input = "pobi,woni";
        String[] carName = input.split(",");

        List<Car> tempCars = new ArrayList<>();
        for (String name : carName) {
            if (name.length() > 5 || name.isEmpty() || tempCars.stream().map(Car::getName).anyMatch(name::equals)) {
                throw new IllegalArgumentException();
            }
            Car car = new Car();
            car.setName(name);
            car.setPosition(0);
            tempCars.add(car);
        }

        assertThat(tempCars.get(0).getName()).isEqualTo("pobi");
        assertThat(tempCars.get(1).getName()).isEqualTo("woni");

    }

    @Test
    @DisplayName("이름 예외 처리 - 5글자 이내")
    void 이름에_대한_예외_처리1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("이름 예외 처리 - 중복된 이름")
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 횟수 입력")
    void 게임횟수_입력(){
        Referee referee = new Referee();
        String numOfname = "1";
        referee.setNumOfGame(numOfname);

        assertThat(referee.getNumOfGame()).isEqualTo(1);

    }

    @Test
    @DisplayName("게임 횟수 예외 처리 - 0 이하의 숫자")
    void 게임횟수에_대한_예외처리1(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    @DisplayName("게임 횟수 예외 처리 - 숫자가 아닌 값")
    void 게임횟수에_대한_예외처리2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "not_digit_value"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
