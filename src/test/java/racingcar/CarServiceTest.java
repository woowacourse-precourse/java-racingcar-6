package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarServiceTest {
    
    private CarService carService;
    
    @BeforeEach
    void setUp() {
        carService = new CarService();
    }
    
    @DisplayName("입력된 자동차 이름은 쉼표로(,) 구분한다.")
    @Test
    void isSeparatedCarNamesByComma() {
        // given
        String userInput = "Bang,Jae,Young";
        
        // when
        List<Car> cars = carService.getCars(userInput);
        
        // then
        assertThat(cars).hasSize(3)
                .extracting("name")
                .containsExactly("Bang", "Jae", "Young");
    }
    
    @DisplayName("중복된 자동차 이름이 존재할 수 없다.")
    @Test
    void shouldNotContainDuplicatedCarNames() {
        // given
        String userInput = "Bang,Bang,Jae,Young";
        
        // when // then
        assertThatThrownBy(() -> carService.getCars(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Duplicated car names are exist.");
    }
    
    //TODO raceCars 메서드 테스트
}
