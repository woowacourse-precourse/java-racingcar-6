package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class ResultRepositoryTest {
    private final ResultRepository resultRepository = new ResultRepository();

    @Test
    public void 저장소_삽입_성공_테스트() {
        //given
        resultRepository.add(new Car("test1"));
        resultRepository.add(new Car("test2"));

        //when
        int size = resultRepository.getResultList().size();

        //then
        Assertions.assertThat(size).isEqualTo(2);
    }

}