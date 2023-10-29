package racingcar.game.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarConverterTest {

    @Test
    @DisplayName("5 자릿수 이하의 입력이 쉼표로 구분 될시 정상적인 자동차 객체의 리스트를 생성해야 한다")
    void inputToListOfCars_Normal() {

        assertThat(CarConverter.inputToListOfCars("a,ab,abc,abcd,abcde")).map(car -> car.getName())
                .isEqualTo(List.of("a", "ab", "abc", "abcd", "abcde"));

        assertThat(CarConverter.inputToListOfCars("a,a,a,a,a,a,a,a")).map(car -> car.getName())
                .isEqualTo(List.of("a", "a", "a", "a", "a", "a", "a", "a"));

        assertThat(CarConverter.inputToListOfCars("가나다라마,하하하하하,호호호호호,히히히히히")).map(car -> car.getName())
                .isEqualTo(List.of("가나다라마", "하하하하하", "호호호호호", "히히히히히"));

        assertThat(CarConverter.inputToListOfCars("🚗🚗🚗🚗🚗,⚓⚓⚓⚓⚓,🌎🌎🌎🌎🌎")).map(car -> car.getName())
                .isEqualTo(List.of("🚗🚗🚗🚗🚗", "⚓⚓⚓⚓⚓", "🌎🌎🌎🌎🌎"));

        assertThat(CarConverter.inputToListOfCars("")).map(car -> car.getName())
                .isEqualTo(List.of(""));

        assertThat(CarConverter.inputToListOfCars(",,,,,")).map(car -> car.getName())
                .isEqualTo(List.of("", "", "", "", "", ""));

    }

    @Test
    @DisplayName("5글자를 초과하는 입력이 들어 올시 IllegalArgumentException 예외를 throw 해야 한다")
    void inputToListOfCars_Exception() {
        assertThatThrownBy(() -> CarConverter.inputToListOfCars("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToListOfCars("a,a,a,a,a,a,a,a,aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(
                () -> CarConverter.inputToListOfCars("ㅁㄴㅇㄻㄴㅇㄹ,여긴 ㅇㅅㅇ 하는 사람 없어서 좋네요,aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 입력값에 대해 올바른 결과를 반환해야한다")
    void inputToTryCount_Normal() {
        assertThat(CarConverter.inputToTryCount("0"))
                .isEqualTo(0);

        assertThat(CarConverter.inputToTryCount("10"))
                .isEqualTo(10);

        assertThat(CarConverter.inputToTryCount("100"))
                .isEqualTo(100);

        assertThat(CarConverter.inputToTryCount("99999999"))
                .isEqualTo(99999999);
    }

    @Test
    @DisplayName("올바르지 않은 입력값에 대해 IlleagalArgumentExcpetion 타입의 예외를 throw 해야한다")
    void inputToTryCount_Exception() {
        assertThatThrownBy(() -> CarConverter.inputToTryCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount("1.08"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount("1 백"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount("1\\u0022));//"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount("1e5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount("1E5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> CarConverter.inputToTryCount(
                "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}