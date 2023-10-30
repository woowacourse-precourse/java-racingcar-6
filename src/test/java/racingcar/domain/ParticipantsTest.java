package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.testutils.TestCarFactory.createCar;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
class ParticipantsTest {

    @SuppressWarnings("unchecked")
    @ParameterizedTest
    @MethodSource
    void 유효한_이름이면_정상_생성(List<String> names) throws Exception {
        Field carsField = Participants.class.getDeclaredField("cars");
        carsField.setAccessible(true);

        Participants participants = Participants.from(names);

        List<Car> cars = (List<Car>) carsField.get(participants);
        assertThat(cars).size().isEqualTo(names.size());
    }

    public static Stream<Arguments> 유효한_이름이면_정상_생성() {
        return Stream.of(
                Arguments.of(List.of("1", "12345")),
                Arguments.of(List.of("1", "2", "3", "4", "5"))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 30})
    void 레이스를_하면_시도_횟수만큼_결과가_기록된다(int attemptCount) {
        Car car1 = createCar();
        Car car2 = createCar();
        Participants participants = new Participants(List.of(car1, car2));

        RaceHistory raceHistory = participants.raceNTimes(attemptCount);

        int actual = raceHistory.getPositionHistory().size();
        assertThat(actual).isEqualTo(attemptCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 시도_횟수가_유효하지_않으면_예외가_발생한다(int attemptCount) {
        Car car1 = createCar();
        Car car2 = createCar();
        Participants participants = new Participants(List.of(car1, car2));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> participants.raceNTimes(attemptCount));
    }

    @Test
    void 우승자_목록을_가져올_수_있다() {
        Car car1 = createCar(true);
        Car car2 = createCar(false);
        Car car3 = createCar(true);
        Participants participants = new Participants(List.of(car1, car2, car3));
        participants.raceNTimes(10);

        List<String> winners = participants.getWinners();
        assertThat(winners).contains(car1.getName(), car3.getName()).doesNotContain(car2.getName());
    }
}
