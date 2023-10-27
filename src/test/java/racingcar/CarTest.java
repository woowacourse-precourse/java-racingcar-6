package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Name;

public class CarTest {

    private Name name;
    private Car car;

    @BeforeEach
    public void init(){
        name = new Name("pobi");
        car = new Car(name);
    }

    @Test
    @DisplayName("자동차를 한칸 전진시킬때, 자동차의 전진 상태는 1의 값을 가진다.")
    void carTest() throws Exception{
        //given, when
        car.addAdvances();

        //then
        assertThat(car.getCarAdvances()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 자동차의 이름을 올바르게 반환한다.")
    void carTest2() throws Exception{
        //given, when, then
        assertThat(car.getCarName()).isEqualTo(name.getName());
    }

    @Test
    @DisplayName("주어진 랜덤 숫자가 4이상인 경우 true를 반환한다.")
    void carTest3() throws Exception{

        //given
        final int randomNumber = 4;

        //when
        boolean result = car.isValidateAdvance(randomNumber);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("주어진 랜덤 숫자가 3이하 경우 true를 반환한다.")
    void carTest4() throws Exception{

        //given
        final int randomNumber = 0;

        //when
        boolean result = car.isValidateAdvance(randomNumber);

        //then
        assertThat(result).isFalse();
    }

}
