package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.dto.GameResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class RacingImpl implements Racing {

    private final List<Car> participants;
    private final int retryCount;

    public RacingImpl(List<String> carNameList, int retryCount) {
        this.participants = carNameList.stream().map(carName -> new Car(carName)).toList();
        this.retryCount = retryCount;
    }

    @Override
    public List<List<GameResult>> start() {
        return IntStream.range(0, retryCount)
                .mapToObj(i -> move())
                .toList();
    }

    @Override
    public List<String> getWinners() {
        int maxPosition = participants
                .stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();

        return participants
                .stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(c -> c.getName())
                .toList();
    }

    private List<GameResult> move() {
        participants.stream().forEach(c -> {
            int randNum = Randoms.pickNumberInRange(0, 9);
            c.move(randNum);
        });
        return makeGameResult();
    }

    private List<GameResult> makeGameResult() {
        return participants.stream().map(car -> new GameResult(car.getName(), car.getViewPosition())).toList();
    }
}
