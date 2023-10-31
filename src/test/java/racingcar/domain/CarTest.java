package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_POSITION = 1;
    private static final int LEAST_MOVE_NUMBER = 4;

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

    @Test
    @DisplayName("전진 또는 정지")
    void moveOrStop(){
        //given
        int randomNumber;
        carList.add(new Car("eddie"));
        carList.add(new Car("bro"));
        carList.add(new Car("crong"));

        //when

        //then
        for(Car car : carList){
            randomNumber = Randoms.pickNumberInRange(0, 9);
            if(randomNumber >= LEAST_MOVE_NUMBER) {
                car.move();
                assertThat(car.getCarPosition()).isEqualTo(MOVE_POSITION);
            }
            if(randomNumber < LEAST_MOVE_NUMBER){
                assertThat(car.getCarPosition()).isEqualTo(INITIAL_POSITION);
            }
         }

    }
}
