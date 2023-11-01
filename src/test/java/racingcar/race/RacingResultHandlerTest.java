package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.TestFixtureUtils;
import racingcar.vo.CarCollection;

import static org.junit.jupiter.api.Assertions.*;

class RacingResultHandlerTest {

    private RacingResultHandler racingResultHandler;

    @BeforeEach
    void setUp() {
        racingResultHandler = new RacingResultHandler();
    }

    @Test
    @DisplayName("execute 실행 테스트")
    void execute() {
        //given
        final CarCollection carCollection = TestFixtureUtils.generateCarCollection(3);
        //when
        final CarCollection result = racingResultHandler.execute(carCollection);
        //then
        assertEquals(carCollection.getCarList().size(), result.getCarList().size());
        Assertions.assertThat(carCollection).usingRecursiveComparison().isEqualTo(result);
    }
}