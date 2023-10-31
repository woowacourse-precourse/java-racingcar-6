package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;

public class CarTest {

    private Name name;
    private Car car;

    @BeforeEach
    public void init() {
        name = new Name("pobi");
        car = new Car(name);
    }

    @Test
    @DisplayName("주어진 자동차의 이름을 올바르게 반환한다.")
    void carTest() throws Exception {
        //given, when, then
        assertThat(car.getName()).isEqualTo(name.getName());
    }

    @Test
    @DisplayName("주어진 랜덤 숫자가 4이상인 경우 자동차 전진하므로 1을 반환한다.")
    void carTest2() throws Exception {

        //given
        final int randomNumber = 4;

        //when
        car.addPosition(randomNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 랜덤 숫자가 3이하 경우 자동차가 전진하지 못하므로 0을 반환한다.")
    void carTest3() throws Exception {

        //given
        final int randomNumber = 0;

        //when
        car.addPosition(randomNumber);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
