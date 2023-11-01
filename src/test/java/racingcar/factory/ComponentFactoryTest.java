package racingcar.factory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.controller.RacingCarController;

@DisplayName("컴포넌트 팩토리 클래스가")
class ComponentFactoryTest {

    @Test
    @DisplayName("싱글톤을 보장하는가")
    void equalsSingleton() {
        // given
        final ComponentFactory before = ComponentFactory.getInstance();
        final ComponentFactory after = ComponentFactory.getInstance();

        // when
        final boolean result = before.equals(after);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("매번 동일한 컨트롤러를 반환하는가")
    void equalsRacingCarController() {
        // given
        final ComponentFactory componentFactory = ComponentFactory.getInstance();
        final RacingCarController before = componentFactory.racingCarController();
        final RacingCarController after = componentFactory.racingCarController();

        // when
        final boolean result = before.equals(after);

        // then
        assertThat(result).isTrue();
    }
}
