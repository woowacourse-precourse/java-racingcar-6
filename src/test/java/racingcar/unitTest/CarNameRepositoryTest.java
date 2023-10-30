package racingcar.unitTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.CarNameRepository;

public class CarNameRepositoryTest {

    @Test
    void should_throwException_when_isNotIncludeComma() {
        // given
        String name = "sangmin";
        CarNameRepository carNameRepository = new CarNameRepository();

        // when & then
        Assertions.assertThatThrownBy(() -> carNameRepository.saveCarNames(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자는 최대 2명 이상입니다.");
    }

    @Test
    void should_true_when_successfulSplitName() {
        // given
        String name = "park,kim,lee";
        CarNameRepository carNameRepository = new CarNameRepository();

        // when
        carNameRepository.saveCarNames(name);

        // then
        Assertions.assertThat(carNameRepository.toString()).isEqualTo(name);
    }
}
