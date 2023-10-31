package racingcar;

import static racingcar.RacingConstant.MAX_NAME_LENGTH;
import static racingcar.RacingConstant.MAX_PLAY_COUNT;
import static racingcar.RacingConstant.MIN_NAME_LENGTH;
import static racingcar.RacingConstant.MIN_PLAY_COUNT;

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

    List<String> getWinnerNames() {
        return calculateWinner();
    }

    private List<String> calculateWinner() {

        int maxMoveDistance = 0;
        List<String> winnerNames = new ArrayList<>();

        for (Car car : participants) {

            int nowCarMoveDistance = car.getMovedDistance();

            if (nowCarMoveDistance == maxMoveDistance) {
                winnerNames.add(car.getName());
            }

            if (nowCarMoveDistance > maxMoveDistance) {
                maxMoveDistance = nowCarMoveDistance;
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
        }

        return winnerNames;
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
        if (MIN_NAME_LENGTH > carName.length() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + MIN_NAME_LENGTH + " ~ " + MAX_NAME_LENGTH + "자 이내 입니다.");
        }
    }

    private void checkDuplicationCarName(String carName) {
        if (carNames.contains(carName)) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private void checkPlayCount(int playCount) {
        if (playCount < MIN_PLAY_COUNT || playCount > MAX_PLAY_COUNT) {
            throw new IllegalArgumentException("플레이 횟수는 " + MIN_PLAY_COUNT + "~" + MAX_PLAY_COUNT + " 사이 입니다.");
        }
    }

}
