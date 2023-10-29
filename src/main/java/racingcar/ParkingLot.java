package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParkingLot {
    public static List<Car> createCars(String inputNames) throws RacingGameException {
        String[] carNames = inputNames.split(",");
        List<Car> cars = new ArrayList<>();
        Set<String> uniqueNames = new HashSet<>();

        if (carNames.length == 1 && carNames[0].trim().isEmpty()) {
            throw new RacingGameException("입력된 자동차가 없습니다.");
        }

        for (String name : carNames) {
            String trimmedName = name.trim();

            if (trimmedName.length() > 5) {
                throw new RacingGameException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }

            if (uniqueNames.contains(trimmedName)) {
                throw new RacingGameException("중복된 자동차가 발견되었습니다.");
            }

            cars.add(new Car(trimmedName));
            uniqueNames.add(trimmedName);
        }

        return cars;
    }
}
