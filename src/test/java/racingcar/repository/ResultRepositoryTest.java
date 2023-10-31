package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class ResultRepositoryTest {
    private ResultRepository resultRepository;

    @BeforeEach
    void setUp() {
        resultRepository = ResultRepository.getInstance();
        resultRepository.clean();
    }

    @AfterEach
    void end() {
        resultRepository.clean();
    }
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