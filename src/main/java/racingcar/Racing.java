package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Racing {

    private final Set<String> carNames = new HashSet<>();
    private final List<Car> participants = new ArrayList<>();
    private int playCount;

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

    void initPlayCount(int playCount) {
        checkPlayCount(playCount);

        this.playCount = playCount;
    }

    List<String> getPlayResults() {

        List<String> playResults = new ArrayList<>();

        for (int i = 0; i < this.playCount; i++) {
            moveCars();

            String nowResult = getNowLocation();
            playResults.add(nowResult);
        }

        return playResults;
    }

    private void moveCars() {
        for (Car car : participants) {
            car.move();
        }
    }

    private String getNowLocation() {

        String result = "";

        for (Car car : participants) {
            result += car.toString() + "\n";
        }

        return result;
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

    private void checkPlayCount(int playCount) {
        if (playCount < 1 || playCount > 10) {
            throw new IllegalArgumentException("플레이 횟수는 1~10 사이 입니다.");
        }
    }

}
