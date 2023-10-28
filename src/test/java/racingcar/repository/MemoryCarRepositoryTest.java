package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class MemoryCarRepositoryTest {

    private final CarRepository memoryCarRepository = MemoryCarRepository.getInstance();

    @Test
    public void 새로운멤버저장() {
        //given
        String name = "car1";
        final Car car = Car.create(name);

        //when
        final Car result = memoryCarRepository.save(car);

        //then
        assertThat(result.getId()).isNotNull(); //TODO: ID는 save() 로직 내부에서 자동으로 할당해줌
        assertThat(result.getName()).isEqualTo("car1");
    }

    //TODO: ID테스트_1번부터 1씩 커지는 순서로 생성되는지(멤버 2개 만들어서 id값 확인)
    //TODO: get~~(getPosition)같은것을 쓸경우 이거를 위한 테스트 따로하기(위치 이동시킨다음  위치값 저장 잘되는지)
}
