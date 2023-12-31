package racingcar.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Count;

public class Track {

    private static final Map<Car, Integer> track = new HashMap<>();

    public void ready(Cars cars) {
        track.clear();
        cars.getCars().forEach(c -> track.put(c, 0));
        validateNumberOfCars();
    }


    private void validateNumberOfCars() {
        if (track.keySet().size() < 2) {
            throw new IllegalArgumentException("[ERROR] 2개 이상의 자동차를 입력해주세요.");
        }
    }

    public void go(Count count) {
        for(int i = 0; i < count.getCount(); i++) {
            track.keySet().forEach(c -> move(c, Randoms.pickNumberInRange(0, 9)));
        }
    }

    private void move(Car car, int number) {
        if(number > 3) {
            int index = track.get(car);
            track.put(car, ++index);
        }
    }

    public List<Car> findWinners() {
        int max = max();
        return track.keySet().stream()
                        .filter(c -> isWinner(c, max))
                        .toList();
    }


    private boolean isWinner(Car car, int max) {
        return track.get(car) == max;
    }

    private int max() {
        int max = 0;
        for(int l : track.values()) {
            max = Math.max(max, l);
        }
        return max;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        track.keySet().forEach(car ->
                sb.append(car.getName())
                        .append(" : ")
                        .append("-".repeat(track.get(car)))
                        .append("\n")
        );
        return sb.toString();
    }
}
