package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.RacingCar;
import domain.RacingGameStartManager;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameStartManagerTest {
    private RacingGameStartManager racingGameStartManager;

    @BeforeEach
    void setUp() {
        racingGameStartManager = new RacingGameStartManager();
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 기반으로 RacingCar Set 생성")
    void RacingCar_Set_생성_자동차_이름_정상입력() {
        // given
        String[] racingCarNames = new String[]{"jong1", "jong2", "jong3"};

        // when
        Set<RacingCar> racingCarSet = racingGameStartManager.createRacingCarSet(racingCarNames);

        // then
        assertThat(racingCarSet.size()).isEqualTo(racingCarNames.length);

        int i=0;
        for (RacingCar racingCar : racingCarSet) {
            assertThat(racingCar).usingRecursiveComparison().isEqualTo(new RacingCar(racingCarNames[i++], 0));
        }
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 기반으로 RacingCar Set 생성 - 자동차 이름 5자 이상인 경우")
    void RacingCar_Set_생성_자동차_이름_5자_이상인_경우() {
        // given
        String[] racingCarNames = new String[]{"jong11", "jong2", "jong3"};

        // when, then
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
            racingGameStartManager.createRacingCarSet(racingCarNames);
        });

        assertThat(actual).hasMessage("자동차 이름은 1자 이상 5자 이하만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력받은 자동차 이름을 기반으로 RacingCar Set 생성 - 자동차 이름 중복된 경우")
    void RacingCar_Set_생성_자동차_이름_중복된_경우() {
        // given
        String[] racingCarNames = new String[]{"jong1", "jong1", "jong3"};

        // when, then
        IllegalArgumentException actual = assertThrows(IllegalArgumentException.class, () -> {
            racingGameStartManager.createRacingCarSet(racingCarNames);
        });

        assertThat(actual).hasMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("입력받은 String 타입의 이동 횟수를 정수로 변환")
    void 입력받은_String_타입의_이동_횟수를_정수로_변환() {
        // given
        String inputRacingCarMoveNum = "3";

        // when
        int actual = racingGameStartManager.convertInputRacingCarMoveNumToInt(inputRacingCarMoveNum);

        // then
        assertThat(actual).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3.3", "-3"})
    @DisplayName("입력받은 String 타입의 이동 횟수를 정수로 변환 - 예외 처리 테스트")
    void 입력받은_String_타입의_이동_횟수를_정수로_변환_예외처리_테스트(String inputRacingCarMoveNum) {
        assertThrows(IllegalArgumentException.class, () ->
                racingGameStartManager.convertInputRacingCarMoveNumToInt(inputRacingCarMoveNum)
        );
    }
}