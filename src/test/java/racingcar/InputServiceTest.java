package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputServiceTest {
    
    private InputService inputService;
    
    @BeforeEach
    void setUp() {
        inputService = new InputService();
    }
    
    @AfterEach
    void closeConsole() {
        Console.close();
    }
    
    @DisplayName("콘솔에 입력하는 사용자의 입력으로 자동차의 입력을 받는다.")
    @Test
    void getCarNames() {
        // given
        System.setIn(createUserInput("Bang,Jae,Young"));
        
        // when
        String carNames = inputService.getCarNames();
        
        // then
        assertThat(carNames).isEqualTo("Bang,Jae,Young");
    }
    
    @DisplayName("시도할 횟수는 숫자 형태여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "!@#", " ", ""})
    void getTryCount(String userInput) {
        // given
        System.setIn(createUserInput(userInput));
        
        // when // then
        assertThatThrownBy(() -> inputService.getTryCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TryCount is not valid.");
    }
    
    InputStream createUserInput(String input) {
        if (input.isEmpty()) {
            input = "default";
        }
        return new ByteArrayInputStream(input.getBytes());
    }
}
