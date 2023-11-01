package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RacingGameMessage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class RacingGameTest {
    @DisplayName("레이싱 자동차 목록에 공복이 포함된 경우의 테스트")
    @Test
    void carNameInputLineDelimiterTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String carsName = "pobi namzi jnam jonh";

        //then
        assertThatThrownBy(() -> racingGame.validateContainSpace(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공백 없이 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 자동차 목록 중 중복되는 이름이 있는 경우의 테스트")
    @Test
    void carNameInputLineDuplicateTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String carsName = "pobi,namzi,jnam,jnam";

        //then
        assertThatThrownBy(() -> racingGame.validateDuplicateCarNames(carsName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 자동차 이름이 있습니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 space가 포함될 경우 대한 테스트")
    @Test
    void containSpaceInTryCountTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String tryInput = "2 1";

        //then
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(tryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 ',''가 포함될 경우 대한 테스트")
    @Test
    void containCommaInTryCountTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String tryInput = "2,1";

        //then
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(tryInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 한글,영어가 포함될 경우 대한 테스트")
    @Test
    void containKoreanOrEnglishInTryCountTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String containKorean = "2ㅁ";
        String containEnglish = "4d";

        //then
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(containKorean))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(containEnglish))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이싱 게임을 시도할 횟수 Input 값에 특수문자가 포함될 경우 대한 테스트")
    @Test
    void containSpecialSignInTryCountTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String containAt = "2@";
        String containSemiColon = "4;";

        //then
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(containAt))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
        assertThatThrownBy(() -> racingGame.validateDigitRaceCount(containSemiColon))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주시길 바랍니다");
    }

    @DisplayName("레이스 시도 횟수가 0일 경우에 대한 테스트")
    @Test
    void zeroRaceCountTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String raceCountInput = "0";

        //then
        assertThatThrownBy(() -> racingGame.convertStringToIntRaceCount(raceCountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("레이스 시도 횟수는 1 이상입니다");
    }

    @DisplayName("유효성 검사가 끝난 자동차 이름을 list로 변환하는 테스트")
    @Test
    void convertCarNameToListTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String carNames = "pobi,suhwp,jnam,namzi";
        List<String> carNamesList = Arrays.asList("pobi", "suhwp", "jnam", "namzi");
        List<String> convertedValues = racingGame.convertStringToListCarNames(carNames);

        //then
        assertThat(convertedValues).isEqualTo(carNamesList);
        assertThat(convertedValues.size()).isEqualTo(4);
    }

    @DisplayName("레이스 시도 횟수를 int로 변환하는 테스트")
    @Test
    void convertRaceCountToIntTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String raceCountInput = "2";
        int raceCount = racingGame.convertStringToIntRaceCount(raceCountInput);
        //then
        assertThat(raceCount).isEqualTo(2);
    }

    @DisplayName("winner가 1명일 때 판단하는 테스트")
    @Test
    void OneWinnerTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String carsName = "pobi,namzi,jnam,jonh";
        racingGame.createCarsAfterValidation(carsName);
        List<RacingCar> racingCars = racingGame.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonh = racingCars.get(3);

        pobi.move(1);
        pobi.move(2);
        pobi.move(5);

        namzi.move(4);
        namzi.move(6);
        namzi.move(9);

        jnam.move(3);
        jnam.move(5);
        jnam.move(1);

        jonh.move(2);
        jonh.move(4);
        jonh.move(6);

        //then
        List<String> winners = racingGame.getWinners();
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.size())
                .isEqualTo(1);
    }

    @DisplayName("winner가 1명이상 일 때 판단하는 테스트")
    @Test
    void MoreOneWinnerTest() {
        //when
        RacingGame racingGame = new RacingGame();

        //given
        String carsName = "pobi,namzi,jnam,jonh";
        racingGame.createCarsAfterValidation(carsName);
        List<RacingCar> racingCars = racingGame.getRacingCars();

        RacingCar pobi = racingCars.get(0);
        RacingCar namzi = racingCars.get(1);
        RacingCar jnam = racingCars.get(2);
        RacingCar jonh = racingCars.get(3);

        pobi.move(1);
        pobi.move(2);
        pobi.move(5);

        namzi.move(4);
        namzi.move(6);
        namzi.move(9);

        jnam.move(7);
        jnam.move(5);
        jnam.move(8);

        jonh.move(2);
        jonh.move(4);
        jonh.move(6);

        //then
        List<String> winners = racingGame.getWinners();
        assertThat(winners.get(0)).isEqualTo("namzi");
        assertThat(winners.get(1)).isEqualTo("jnam");
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.size())
                .isEqualTo(2);
    }
}