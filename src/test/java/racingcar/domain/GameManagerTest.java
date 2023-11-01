package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameManagerTest {
    private static final List<String> EMPTY_STRING_LIST = List.of("", " ", "   ", "    ");
    private static final String VALID_USER_INPUT = "pobi,woni,crong,honux";

    @Test
    void validateRacingCarName_메서드로_RacingCar_Name_검증() {
        // given
        String racingCarName = "abcde";
        // when
        // then
        assertThat(GameManager.validateRacingCarName(racingCarName)).isTrue();
    }


    @Test
    void validateRacingCarName_메서드_사용시_RacingCar_Name이_공백이거나_null이면_예외_발생() {
        // given
        // EMPTY_STRING_LIST
        // when
        // then
        assertThatThrownBy(() -> {
            for (String racingCarName : EMPTY_STRING_LIST) {
                GameManager.validateRacingCarName(racingCarName);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 null이거나 비어있습니다.");
    }

    @Test
    void validateRacingCarName_메서드_사용시_RacingCar_Name이_5자_초과하면_예외_발생() {
        // given
        String racingCarName = "abcdef";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateRacingCarName(racingCarName)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 5자를 초과합니다.");
    }

    @Test
    void validateUserInput_메서드로_User_Input_검증() {
        // given
        // when
        // then
        assertThat(GameManager.validateUserInput(VALID_USER_INPUT)).isTrue();
    }

    @Test
    void validateUserInput_메서드로_한사람_User_Input_검증() {
        // given
        // when
        // then
        assertThat(GameManager.validateUserInput("pobi")).isTrue();
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input이_공백이거나_null이면_예외_발생() {
        // given
        // EMPTY_STRING_LIST
        // when
        // then
        assertThatThrownBy(() -> {
            for (String userInput : EMPTY_STRING_LIST) {
                GameManager.validateUserInput(userInput);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유저 입력값이 null이거나 비어있습니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input이_중복된_RacingCar_Name이_있으면_예외_발생() {
        // given
        String userInput = "pobi,woni,crong,pobi";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInput(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("중복된 racingcar 이름이 있습니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_User_Input에_5자_초과하는_RacingCar_Name이_있으면_예외_발생() {
        // given
        String userInput = "pobi,woni,crong,honux,abcdef";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInput(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("racingcar 이름이 5자를 초과합니다.");
    }

    @Test
    void validateUserInputForTryCount_메서드로_User_Input_검증() {
        // given
        String userInput = "5";
        // when
        // then
        assertThat(GameManager.validateUserInputForTryCount(userInput)).isTrue();
    }

    @Test
    void validateUserInputForTryCount_메서드_사용시_User_Input이_공백이거나_null이면_예외_발생() {
        // given
        // EMPTY_STRING_LIST
        // when
        // then
        assertThatThrownBy(() -> {
            for (String userInput : EMPTY_STRING_LIST) {
                GameManager.validateUserInputForTryCount(userInput);
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유저 입력값이 null이거나 비어있습니다.");
    }

    @Test
    void validateUserInputForTryCount_메서드_사용시_User_Input이_정수가_아니면_예외_발생() {
        // given
        String userInput = "1.54";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInputForTryCount(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("유저 입력값이 정수가 아닙니다.");
    }

    @Test
    void validateUserInputForTryCount_메서드_사용시_User_Input이_1보다_작으면_예외_발생() {
        // given
        String userInput = "0";
        // when
        // then
        assertThatThrownBy(() -> GameManager.validateUserInputForTryCount(userInput)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("유저 입력값이 1보다 작습니다.");
    }

    @Test
    void instantiateRacingCars_메서드로_RacingCar_인스턴스_생성() {
        // given
        // VALID_USER_INPUT
        // when
        GameManager.validateUserInput(VALID_USER_INPUT);
        GameManager.validateUserInputForTryCount("5");
        // then
        // check if the return list is equal to the list of RacingCar instances
        assertThat(GameManager.instantiateRacingCars()).isEqualTo(GameManager.racingCars);
    }

    @Test
    void makeRacingCarsMove_메서드로_RacingCar_이동() {
        // given
        // VALID_USER_INPUT
        // when
        GameManager.validateUserInput(VALID_USER_INPUT);
        GameManager.validateUserInputForTryCount("5");
        GameManager.instantiateRacingCars();
        // then
        // check just it prints out the position of each RacingCar well
        GameManager.makeRacingCarsMove();
    }

    @Test
    void judgeWinner_메서드로_우승자_결정() {
        // given
        GameManager.racingCars = List.of(new RacingCar("pobi"), new RacingCar("woni"),
                new RacingCar("crong"), new RacingCar("honux"));
        GameManager.racingCars.get(0).position = 5;
        GameManager.racingCars.get(1).position = 4;
        GameManager.racingCars.get(2).position = 3;
        GameManager.racingCars.get(3).position = 5;

        // when

        // then
        assertThat(GameManager.judgeWinners()).isEqualTo(List.of("pobi", "honux"));
    }

    @Test
    void printWinners_메서드로_우승자_출력() {
        // given
        // when
        // then
        GameManager.printWinners(List.of("pobi"));
        GameManager.printWinners(List.of("pobi", "honux"));
        GameManager.printWinners(List.of("pobi", "honux", "crong"));
    }
}