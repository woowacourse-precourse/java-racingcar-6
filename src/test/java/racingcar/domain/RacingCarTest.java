package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_END_INCLUSIVE;
import static racingcar.constant.RacingGameConstant.RANDOM_NUMBER_START_INCLUSIVE;
import static racingcar.constant.RacingGameConstant.START_POSITION;
import static racingcar.exception.ErrorMessage.CAR_NAME_LENGTH_EXCEPTION;
import static racingcar.exception.ErrorMessage.CAR_POSITION_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.condition.MoveCondition;
import racingcar.domain.random.DoubleRandomService;
import racingcar.domain.random.RandomNumberFactory;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("레이싱 카 이름이 주어지면, 이름이 5자리 이하인지 확인하고 생성한다.")
    @ValueSource(strings = {"suz", "&(&(", "chan"})
    void createRacingCarWithCarNameLessThanOrEqualFive(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        RacingCar racingCar = new RacingCar(given, moveCondition);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar(given, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 5자라 넘거나 이름이 존재하지 않으면, 예외가 발생한다.")
    @ValueSource(strings = {"suzhan", "&(&(12", "chanlee", "", "  ", " "})
    void createRacingCarError(String given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when //then
        assertThatThrownBy(() -> new RacingCar(given, moveCondition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("레이싱 카 위치가 0 이하면 레이싱카를 생성한다.")
    @ValueSource(ints = {0, 1, 23})
    void createRacingCarWithPosition(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when
        RacingCar racingCar = new RacingCar("k3", given, moveCondition);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("k3", given, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("레이싱 카 위치가 0 미만 이면 레이싱카를 생성한다.")
    @ValueSource(ints = {-1, -2, -34})
    void createRacingCarWithPositionLessThanZero(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();

        // when // then
        assertThatThrownBy(() -> new RacingCar("k3", given, moveCondition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_POSITION_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("경주를 해 랜덤 값이 4 이상이면 레이싱 카는 한칸 앞으로 간다.")
    @ValueSource(ints = {4, 9})
    void goOneStepForward(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();
        RacingCar racingCar = new RacingCar("tobi", moveCondition);
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory(new DoubleRandomService(given));
        int randomNumber = randomNumberFactory.create(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);

        // when
        racingCar.race(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", 1, moveCondition));
    }

    @ParameterizedTest
    @DisplayName("경주를 해 랜덤 값이 4 미만이면 레이싱 카는 움직이지 않는다.")
    @ValueSource(ints = {0, 3})
    void cannotGoOneStepForward(int given) {
        // given
        MoveCondition moveCondition = new MoveCondition();
        RacingCar racingCar = new RacingCar("tobi", moveCondition);
        RandomNumberFactory randomNumberFactory = new RandomNumberFactory(new DoubleRandomService(given));
        int randomNumber = randomNumberFactory.create(RANDOM_NUMBER_START_INCLUSIVE, RANDOM_NUMBER_END_INCLUSIVE);

        // when
        racingCar.race(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar("tobi", START_POSITION, moveCondition));
    }
}
