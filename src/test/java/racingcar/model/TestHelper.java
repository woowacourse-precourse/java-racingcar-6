package racingcar.model;

import static racingcar.model.NameTest.MIN_NAME_LENGTH;

import java.util.UUID;
import racingcar.model.car.Car;
import racingcar.model.car.Name;
import racingcar.model.car.Position;

public class TestHelper {

    static String generateRandomString(int length) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, length);
    }

    /**
     * @return 랜덤 Name을 가진 Car 반환
     */
    static Car genearteCar() {
        return new Car(Name.from(generateRandomCarName()), new Position(0));
    }

    private static String generateRandomCarName() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0, MIN_NAME_LENGTH);
    }
}
