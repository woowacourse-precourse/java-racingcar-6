package racingcar.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarName;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;

class InputMapperTest {

    private final InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("이름을 콤마로 구분하여 입력하면 CarNames 클래스를 생성한다.")
    void inputToCarNames() {
        // Given
        String input = "car1,car2,car3";
        CarName carName1 = mock(CarName.class);
        CarName carName2 = mock(CarName.class);
        CarName carName3 = mock(CarName.class);
        when(carName1.name()).thenReturn("car1");
        when(carName2.name()).thenReturn("car2");
        when(carName3.name()).thenReturn("car3");

        // When
        CarNames carNames = inputMapper.toCarNames(input);

        // Then
        assertEquals(carName1.name(), carNames.getNames().get(0).name());
        assertEquals(carName2.name(), carNames.getNames().get(1).name());
        assertEquals(carName3.name(), carNames.getNames().get(2).name());
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
