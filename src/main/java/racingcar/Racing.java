package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    private final Set<String> carNames = new HashSet<>();
    private final List<Car> participants = new ArrayList<>();

    void initParticipants(String[] names) {

        carNames.clear();
        participants.clear();

        for (String carName : names) {
            checkCarNameLength(carName);

            checkDuplicationCarName(carName);

            carNames.add(carName);
            participants.add(new Car(carName));
        }

        if (carNames.size() == 0 || carNames.size() > 5) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

    }

    private void checkCarNameLength(String carName) {
        if (1 > carName.length() || carName.length() > 5) {
            throw new IllegalArgumentException("이름 길이는 1 ~ 5자 이내 입니다.");
        }
    }

    private void checkDuplicationCarName(String carName) {
        if (carNames.contains(carName)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

}
