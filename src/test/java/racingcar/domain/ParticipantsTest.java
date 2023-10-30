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

    @Test
    void 중복된_이름의_자동차가_있으면_에러가_발생한다() {
        List<Car> cars = List.of(
                new Car("car1"),
                new Car("car1"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(cars));
    }

    @ParameterizedTest
    @MethodSource
    void 경주에_참가하는_자동차는_최소_2_대_이상이어야_한다(List<Car> cars) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Participants(cars));
    }

    public static Stream<Arguments> 경주에_참가하는_자동차는_최소_2_대_이상이어야_한다() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(createCar()))
        );
    }

    @Test
    void 레이스를_진행할_수_있다() {
        List<Car> cars = List.of(
                createCar(true),
                createCar(false),
                createCar(true));
        Participants participants = new Participants(cars);

        List<Car> race = participants.race();

        List<Integer> positions = race.stream().map(Car::getPosition).toList();
        assertThat(positions).isEqualTo(List.of(1, 0, 1));
    }

    @Test
    void 우승자_목록을_가져올_수_있다() {
        Car car1 = createCar(true);
        Car car2 = createCar(false);
        Car car3 = createCar(true);
        Participants participants = new Participants(List.of(car1, car2, car3));
        participants.race();
        participants.race();

        List<String> winners = participants.getWinners();
        assertThat(winners).contains(car1.getName(), car3.getName()).doesNotContain(car2.getName());
    }
}
