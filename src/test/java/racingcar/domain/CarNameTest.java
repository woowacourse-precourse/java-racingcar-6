package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    CarName carName;

    @BeforeEach
    void CarName() {
        carName = new CarName("test");
    }

    @Test
    @DisplayName("carName에 \" : \" 를 추가하여 반환")
    void makeNameForPrintResultTest() {
        //given

        //when
        String result = carName.makeNameForPrintResult();

        //then
        assertThat(result).isEqualTo("test : ");
    }

    @Test
    @DisplayName("메소드 실행시 변수로 carName을 가진 Winner 생성")
    void registerAsWinnerTest() {
        //given

        //when
        Winner winner = carName.registerAsWinner();

        //then
        assertThat(winner).extracting("winner").isEqualTo("test");
    }

    @ParameterizedTest
    @DisplayName("같은 carName을 가지고 있으면 동등하다는 boolean값 반환")
    @CsvSource(value = {"test, true", "xxxx, false"})
    void equalsTest(String name, boolean expect) {
        //given
        CarName temp = new CarName(name);

        //when
        boolean result = carName.equals(temp);

        //given
        assertThat(result).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("같은 carName을 가지고 있으면 같은 hashCode 반환")
    @CsvSource(value = {"test, true", "xxxx, false"})
    void hashCodeTest(String name, boolean expect) {
        //given
        CarName temp = new CarName(name);

        //when
        int carNameHashCode = carName.hashCode();
        int tempHashCode = temp.hashCode();

        //given
        assertThat(carNameHashCode==tempHashCode).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("같은 carName을 가지고 있으면 동등한 객체로 판단")
    @CsvSource(value = {"test, 1", "xxxx, 2"})
    void equalObjectTest(String name, int result) {
        //given
        Set<CarName> carNames = new HashSet<>();
        CarName temp = new CarName(name);

        //when
        carNames.add(carName);
        carNames.add(temp);

        //given
        assertThat(carNames.size()).isEqualTo(result);
    }

    @Test
    @DisplayName("이름의 길이가 1~5 가 아니면 IlligalException 예외 발생")
    void CarNameConstructor() {
        //given

        //when

        //then
        assertThatThrownBy(() -> new CarName("abcdef")).isInstanceOf(IllegalArgumentException.class);
    }
}
