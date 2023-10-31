package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean isDuplicate() {
        int originalCarSize = this.cars.size();
        return cars.stream()
                .distinct()
                .collect(Collectors.toList())
                .size() != originalCarSize;
    }

    public void validateDuplication() {
        if(isDuplicate()) {
            throw new IllegalArgumentException("같은 자동차 이름을 입력하였습니다. 애플리케이션을 종료합니다.");
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private List<Car> judgeWinner() {
        int maxProgress = getMaxProgress();

        return this.cars.stream()
                .filter(v -> v.getProgress().getValue() == maxProgress)
                .collect(Collectors.toList());
    }

    public Winners generateWinners() {
        return new Winners(judgeWinner());
    }


    private int getMaxProgress() {
        List<Integer> progresses = this.cars.stream()
                .map(Car::getProgress)
                .map(Progress::getValue)
                .collect(Collectors.toList());

        return Collections.max(progresses);
    }
}