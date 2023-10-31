package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int INITIAL_POSITION = 0;

    List<Car> carList = new ArrayList<>();

    @AfterEach
    void clearCarList(){
        carList.clear();
    }

    @Test
    @DisplayName("자동차의 처음 위치가 0임을 검증")
    void initialCarPositionIsZeroTest() {
        //given
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));

        //when

        //then
        for(Car car : carList){
            assertThat(car.getCarPosition()).isEqualTo(INITIAL_POSITION);
        }
    }
}
