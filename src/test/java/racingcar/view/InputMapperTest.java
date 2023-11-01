package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;

class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("이름을 콤마로 구분하여 입력하면 CarNames 클래스를 생성한다.")
    void inputToCarNames() {
        // Given
        String input = "car1,car2,car3";

        // When
        CarNames carNames = inputMapper.toCarNames(input);

        // Then
        assertEquals(List.of("car1", "car2", "car3"), carNames.getNames());
    }

    @Test
    @DisplayName("음수가 아닌 정수 입력 시 TryCount 클래스를 생성한다.")
    void inputToTryCount() {
        // Given
        String input = "5";

        // When
        TryCount tryCount = inputMapper.toTryCount(input);

        // Then
        assertEquals(5, tryCount.getCount());
    }
}
