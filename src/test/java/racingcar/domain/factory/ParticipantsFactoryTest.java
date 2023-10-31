package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Participants;
import racingcar.domain.RandomMoveEngine;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.CarsValidator;

@SuppressWarnings("NonAsciiCharacters")
class ParticipantsFactoryTest {
    private static final CarFactory carFactory = new CarFactory(new RandomMoveEngine(), new CarNameValidator());

    private static final ParticipantsFactory participantsFactory =
            new ParticipantsFactory(carFactory, new CarsValidator());

    @SuppressWarnings("unchecked")
    @ParameterizedTest
    @MethodSource
    void 유효한_이름이면_정상_생성(List<String> names) throws Exception {
        Field carsField = Participants.class.getDeclaredField("cars");
        carsField.setAccessible(true);

        Participants participants = participantsFactory.createFromNames(names);

        List<Car> cars = (List<Car>) carsField.get(participants);
        assertThat(cars).size().isEqualTo(names.size());
    }

    private static Stream<Arguments> 유효한_이름이면_정상_생성() {
        return Stream.of(
                Arguments.of(List.of("1", "12345")),
                Arguments.of(List.of("1", "2", "3", "4", "5"))
        );
    }

    @Test
    void 중복된_이름의_자동차가_있으면_에러가_발생한다() {
        List<String> names = List.of("car1", "car1");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> participantsFactory.createFromNames(names));
    }

    @ParameterizedTest
    @MethodSource
    void 경주에_참가하는_자동차는_최소_2_대_이상이어야_한다(List<String> names) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> participantsFactory.createFromNames(names));
    }

    private static Stream<Arguments> 경주에_참가하는_자동차는_최소_2_대_이상이어야_한다() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of("car1"))
        );
    }
}
