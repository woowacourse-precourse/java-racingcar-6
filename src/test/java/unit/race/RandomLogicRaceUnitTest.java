package unit.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.dto.input.CarInputDto;
import racingcar.service.race.Racing;
import racingcar.service.race.RandomLogicRace;

public class RandomLogicRaceUnitTest {
    private Racing racing;
    @BeforeEach
    void init(){
        racing = new RandomLogicRace();
    }

    @Test
    void 랜덤으로_차들의_포지션이_바뀌는지_확인(){
        //given
        String[] testCars = {"car1","car2","car3"};
        Cars cars = Cars.of(new CarInputDto(testCars));
        //when
        racing.race(cars);
        //then
        assertThat(cars.getCarList().get(0).getCarName()).isEqualTo("car1");
        System.out.println(cars.getCarList().get(0).getCarPosition());
    }

    @Test
    void 차들의_이름이_하나도_입력받지_못하였을_때  (){
        //given
        String[] testCars = {};
        Cars cars = Cars.of(new CarInputDto(testCars));
        //when
        racing.race(cars);
        //then
        assertThatThrownBy(()->cars.getCarList().get(0))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index 0 out of bounds for length 0");
    }
}
