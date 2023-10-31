package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

class LocationTest {

    @CsvSource({
            "1,1",
            "0,0",
    })
    @ParameterizedTest
    void 문자열로_값_초기화_성공(String given, Integer expected) {
        Location givenLocation = Location.fromString(given);
        assertThat(givenLocation.getIntegerPosition()).isEqualTo(expected);
    }

    @CsvSource({
            "-1",
            "zero",
    })
    @ParameterizedTest
    void 문자열로_값_초기화_실패(String given) {
        assertThatThrownBy(() -> Location.fromString(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @CsvSource({
            "1,1",
            "0,0",
    })
    @ParameterizedTest
    void 정수로_값_초기화_성공(Integer given, Integer expected) {
        Location givenLocation = Location.fromInteger(given);
        assertThat(givenLocation.getIntegerPosition()).isEqualTo(expected);
    }

    @CsvSource({
            "-1",
            "-123",
    })
    @ParameterizedTest
    void 정수로_값_초기화_실패(Integer given) {
        assertThatThrownBy(() -> Location.fromInteger(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @CsvSource({
            "5,'-----'",
            "1,'-'",
    })
    @ParameterizedTest
    void 현재_위치값_문자열로_변환(String given, String expected) {
        Location givenLocation = Location.fromString(given);
        assertThat(givenLocation.getStringPosition()).isEqualTo(expected);
    }

    @Test
    void 움직이지_않을_경우의_문자열로_변환() {
        Location givenLocation = Location.fromString("0");
        assertThat(givenLocation.getStringPosition()).isEqualTo(RacingCarGameText.RACINGCAR_DOES_NOT_MOVE);
    }

    @CsvSource({
            "0, 1",
            "1, 2",
    })
    @ParameterizedTest
    void 한_칸_이동(String given, Integer expected) {
        Location givenLocation = Location.fromString(given);
        givenLocation.step();
        assertThat(givenLocation.getIntegerPosition()).isEqualTo(expected);
    }

    @Test
    void 최대_위치_값_계산() {
        Location location1 = Location.fromString("1");
        Location expectedMaxLocation = Location.fromString("10");
        Location location3 = Location.fromString("5");
        Location location4 = Location.fromString("6");
        Location location5 = Location.fromString("2");
        List<Location> locationList = List.of(location1, expectedMaxLocation, location3, location4, location5);
        Location maxLocation = locationList.stream().max(Location::compareTo).orElse(Location.fromInteger(0));
        assertThat(maxLocation).isEqualTo(expectedMaxLocation);
    }

    @Test
    void 차_위치_값_필터링() {
        Location location1 = Location.fromString("1");
        Location expectedMaxLocation1 = Location.fromString("10");
        Location location3 = Location.fromString("5");
        Location expectedMaxLocation2 = Location.fromString("10");
        Location location5 = Location.fromString("8");
        List<Location> locationList = List.of(location1, expectedMaxLocation1, location3, expectedMaxLocation2, location5);
        Location maxLocation = locationList.stream()
                                        .max(Location::compareTo)
                                        .orElse(Location.fromInteger(0));

        List<Location> filteredLocationList = locationList.stream()
                                        .filter(location -> location.equals(maxLocation))
                                        .toList();
        int expectedSize = 2;
        assertThat(filteredLocationList).hasSize(expectedSize);
    }
}
