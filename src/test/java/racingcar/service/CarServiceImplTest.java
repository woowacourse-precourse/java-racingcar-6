package racingcar.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.MemoryCarRepository;

public class CarServiceImplTest {

    private CarRepository memoryCarRepository = MemoryCarRepository.getInstance();
    private CarService carService = CarServiceImpl.getInstance(memoryCarRepository);

    @BeforeEach
    public void setUp() {
        memoryCarRepository.deleteAll();
    }

    @Test
    public void Car객체저장() {
        //given
        String name = "car1";
        final Car car1 = Car.create(name);

        //when
        carService.join(car1);

        //then
        assertThat(memoryCarRepository.findByName("car1").get()).isEqualTo(car1);
    }

    @Test
    public void 중복된_이름의_Car객체저장() {
        //given
        String name = "car1";
        final Car car1 = Car.create(name);
        final Car car2 = Car.create(name);

        //when
        carService.join(car1);

        //then
        assertThatThrownBy(() -> carService.join(car2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Car_이름의_길이가_5초과하면_예외발생() {
        //given
        final Car car1 = Car.create("abcdef");

        //when
        final RuntimeException result = assertThrows(IllegalArgumentException.class,
                () -> carService.join(car1));

        //then
        assertThat(result).isNotNull();
    }

    //TODO: Car에서 get~~(getPosition)같은것을 쓸경우 이거를 위한 테스트 따로하기(위치 이동시킨다음  위치값 저장 잘되는지)
    // 이건 Car Model이 아닌 Service에서 하는게 맞을듯.

}
