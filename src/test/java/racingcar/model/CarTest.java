package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    static Car car;

    @BeforeEach
    public void before(){
        car = new Car("tam");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void 위치변경_없음(int number){
        //when (기능 작동)
        car.moveForward(number);
        int position = car.getPosition();

        //then (기능 작동 후 결과)
        Assertions.assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void 위치변경(int number){
        //when (기능 작동)
        car.moveForward(number);
        int position = car.getPosition();

        //then (기능 작동 후 결과)
        Assertions.assertThat(position).isEqualTo(1);
    }
}