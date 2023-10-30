package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameSystemTest {
    
    private GameSystem gameSystem;
    
    @BeforeEach
    void setUp() {
        gameSystem = new GameSystem();
    }
    
    @DisplayName("입력된 자동차 이름은 쉼표로(,) 구분한다.")
    @Test
    void isSeparatedCarNamesByComma() {
        // given
        String userInput = "Bang,Jae,Young";
        
        // when
        String[] carNames = gameSystem.separateCarNamesByComma(userInput);
        
        // then
        assertThat(carNames).hasSize(3)
                .containsExactly("Bang", "Jae", "Young");
    }
    
    @DisplayName("중복된 자동차 이름이 존재할 수 없다.")
    @Test
    void ShouldNotContainDuplicatedCarNames() {
        // given
        String userInput = "Bang,Bang,Jae,Young";
        
        // when // then
        assertThatThrownBy(() -> gameSystem.setUpCars(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Duplicated car names are exist.");
    }
    
    @DisplayName("입력된 시도할 횟수는 숫자 형태여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"010", "!@#", "abc"})
    void shouldTryCountBeNumber(String userInput) {
        // when // then
        assertThatThrownBy(() -> gameSystem.verfiyTryCount(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Try count is not number.");
    }
}
