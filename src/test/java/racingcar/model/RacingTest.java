package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;
import racingcar.dto.response.CarInfo;
import racingcar.exception.IllegalRacingStatusException;

class RacingTest {

    private final Integer COUNT = 2;
    private final List<String> NAMES = List.of("car1", "car2");
    private final CarNames CAR_NAMES = CarNames.from(NAMES);
    private final TryCount TRY_COUNT = TryCount.fromInput(String.valueOf(COUNT));
    private final NumberGenerator DUMMY_NUMBER_GENERATOR = mock(NumberGenerator.class);

    @Test
    @DisplayName("CarNames와 TryCount를 통해 Racing 생성 테스트")
    void createRacing() {
        // Given

        // When
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, DUMMY_NUMBER_GENERATOR);

        // Then
        assertNotNull(racing);
        assertEquals(0, racing.getCurrentTryCount());
        assertEquals(COUNT, racing.getMaxTryCount());
    }

    @Test
    @DisplayName("race 메서드 호출 시 currentTryCount가 1씩 증가한다.")
    void currentTryCountIncreaseOnRace() {
        // Given
        NumberGenerator mockNumberGenerator = mock(NumberGenerator.class);
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(4);
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, mockNumberGenerator);

        // When
        racing.race();

        // Then
        assertEquals(1, racing.getCurrentTryCount());

        // When
        racing.race();

        // Then
        assertEquals(2, racing.getCurrentTryCount());
    }

    @Test
    @DisplayName("race 메서드를 maxTryCount번 보다 많이 호출하면 예외를 던진다.")
    void executeRaceAboveMaxTryCount() {
        // Given
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, DUMMY_NUMBER_GENERATOR);

        // When
        for (int i = 0; i < COUNT; i++) {
            racing.race();
        }

        // Then
        assertThrows(IllegalRacingStatusException.class, racing::race);
    }

    @Test
    @DisplayName("maxCount만큼 이동하면 레이스에서 우승한 자동차들의 이름을 얻을 수 있다.")
    void getWinningCarNames() {
        // Given
        NumberGenerator mockNumberGenerator = mock(NumberGenerator.class);
        when(mockNumberGenerator.generateInRange(anyInt(), anyInt())).thenReturn(4);
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, mockNumberGenerator);

        // When
        for (int i = 0; i < COUNT; i++) {
            racing.race();
        }

        // Then
        assertEquals(NAMES, racing.getWinningCarNames());
    }

    @Test
    @DisplayName("racing이 끝나지 않은 상태에서 우승한 차들의 이름을 얻으려고 하면 IllegalRacingStatusException을 발생시킨다.")
    void getWinnerNamesBeforeFinishRacing() {
        // Given
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, DUMMY_NUMBER_GENERATOR);

        // When & Then
        assertThrows(IllegalRacingStatusException.class, racing::getWinnerNames);
    }

    @Test
    @DisplayName("getCarInfoList로 레이싱에 속한 자동차들의 정보들을 가져올 수 있다.")
    void getCarInfoList() {
        // Given
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, DUMMY_NUMBER_GENERATOR);

        // When
        List<CarInfo> carInfoList = racing.getCarInfoList();

        // Then
        assertEquals(NAMES.size(), carInfoList.size());
        assertEquals(NAMES.get(0), carInfoList.get(0).getName());
        assertEquals(NAMES.get(1), carInfoList.get(1).getName());
        assertEquals(0, carInfoList.get(0).getMoveCount());
        assertEquals(0, carInfoList.get(1).getMoveCount());
    }

    @Test
    @DisplayName("isFinished는 curentTryCount가 maxTryCount 이하일 때 True이다.")
    void isFinished() {
        // Given
        Racing racing = Racing.of(CAR_NAMES, TRY_COUNT, DUMMY_NUMBER_GENERATOR);

        // When & Then
        for (int i = 0; i < COUNT; i++) {
            assertFalse(racing.isFinished());
            racing.race();
        }

        // Then
        assertTrue(racing.isFinished());
    }
}
