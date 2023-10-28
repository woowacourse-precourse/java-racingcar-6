package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {
    @ParameterizedTest
    @DisplayName("정상적인 이름인 경우 레이싱카가 생성된다")
    @ValueSource(strings = {"a", "ab", "aab", "qwer", "happy"})
    public void createRacingCar(String name){
        assertDoesNotThrow(() -> {
            new RacingCar(name);
        });
    }

    @ParameterizedTest
    @DisplayName("이름이 범위를 초과하는 경우 예외가 발생한다")
    @ValueSource(strings = {"hellow", "helloworld", "m y n a", "meisaz", "1     "})
    public void createExceedingRacingCarName(){
        String name = "abcdef";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
    }

    @Test
    @DisplayName("이름이 빈 문자열인 경우 예외가 발생한다")
    public void createEmptyRacingCarName(){
        String name = "";
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
    }

    @Test
    @DisplayName("자신의 정보를 올바르게 변환한다")
    public void checkInformation(){
        String name = "abcde";
        RacingCar racingCar = new RacingCar(name);
        RacingCarStatus information = racingCar.getStatus();
        assertThat(information.getName()).isEqualTo(name);
        assertThat(information.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("4 미만의 수가 주어지면 움직이지 않는다")
    public void lowerNumberThanThresholdTest(int chosenNumber){
        RacingCar racingCar = new RacingCar("name");
        int initialPosition = racingCar.getStatus().getPosition();
        racingCar.checkAndMoveForward(chosenNumber);
        int afterPosition = racingCar.getStatus().getPosition();

        assertThat(initialPosition).isEqualTo(afterPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상의 수가 주어지면 앞으로 움직인다")
    public void higherNumberThanThresholdTest(int chosenNumber){
        RacingCar racingCar = new RacingCar("name");
        int initialPosition = racingCar.getStatus().getPosition();
        racingCar.checkAndMoveForward(chosenNumber);
        int afterPosition = racingCar.getStatus().getPosition();

        assertThat(initialPosition + 1).isEqualTo(afterPosition);
    }

}