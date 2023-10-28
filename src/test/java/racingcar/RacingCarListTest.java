package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RacingCarList")
class RacingCarListTest {

    @Test
    @DisplayName("자동차 리스트를 정상적으로 생성한다")
    public void createList() {
        List<String> names = List.of("abc", "def", "ghi");
        RacingCarList racingCarList = new RacingCarList();

        racingCarList.addRacingCarsByNames(names);
        List<RacingCarStatus> information = racingCarList.collectStatus();

        List<String> statusNames = information.stream()
                .map(RacingCarStatus::getName).toList();

        assertThat(statusNames).hasSameElementsAs(names);
    }

    @Test
    @DisplayName("자동차 리스트에 중복된 이름이 있다면 예외를 발생한다")
    public void validateDuplicateName() {
        List<String> names = List.of("abc", "def", "ghi", "abc");

        RacingCarList racingCarList = new RacingCarList();
        assertThatThrownBy(() -> {
            racingCarList.addRacingCarsByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 리스트가 비어있는 경우 예외를 발생한다")
    public void validateEmptyList() {
        List<String> names = List.of();

        RacingCarList racingCarList = new RacingCarList();
        assertThatThrownBy(() -> {
            racingCarList.addRacingCarsByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 리스트가 범위를 초과하는 경우 예외를 발생한다")
    public void validateListLength() {
        List<String> names = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

        RacingCarList racingCarList = new RacingCarList();
        assertThatThrownBy(() -> {
            racingCarList.addRacingCarsByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
