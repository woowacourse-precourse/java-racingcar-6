package racingcar.unitTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.mapper.CarNameMapper;
import racingcar.model.vo.CarName;

public class CarNameMapperTest {

    private CarNameMapper carNameMapper;

    @BeforeEach
    void setUp() {
        carNameMapper = new CarNameMapper();
    }

    @Test
    void should_true_when_convertSuccessful() {
        // given
        String carName = "park,kim,lee";
        // when
        List<CarName> carNameGroup = carNameMapper.toCarName(carName);
        // then
        assertThat(carNameGroup).asList()
                .contains(new CarName("park"),
                        new CarName("kim"),
                        new CarName("lee"));
    }
}
