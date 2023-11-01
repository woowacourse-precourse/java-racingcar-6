package racingcar.domain.factory;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Participants;
import racingcar.domain.RandomMoveEngine;

@SuppressWarnings("NonAsciiCharacters")
class ParticipantsFactoryTest {
    private static final CarFactory carFactory = new CarFactory(new RandomMoveEngine());
    private static final ParticipantsFactory participantsFactory = new ParticipantsFactory(carFactory);

    @SuppressWarnings("unchecked")
    @Test
    void 이름으로_참가자들을_생성할_수_있다() throws Exception {
        Field carsField = Participants.class.getDeclaredField("cars");
        carsField.setAccessible(true);
        List<String> names = List.of("car1","car2","car3");

        Participants participants = participantsFactory.createFromNames(names);

        List<Car> cars = (List<Car>) carsField.get(participants);
        assertThat(cars).size().isEqualTo(3);
    }
}
