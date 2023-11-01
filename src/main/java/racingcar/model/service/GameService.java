package racingcar.model.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;

public class GameService {
    private final int NAME_LENGTH = 5;
    CarRepository carRepository;

    public GameService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCars(List<String> carNames) {
        carNames.forEach(name -> carRepository.save(name));
    }

    public void nameCheck(List<String> carNames) {
        carNames.forEach(car -> {
            if (car.length() > NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다");
            }
        });
    }

    public Car playGame(int idx) {
        return carRepository.carForward(idx, Randoms.pickNumberInRange(0, 9));
    }

    public List<String> resultGame() {
        return carRepository.findAllMaxForward();
    }

    public void emptyNameCheck(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
    }

    public List<String> parseName(String carNames) {
        return Arrays.stream(carNames.split(","))
                .collect(Collectors.toList());
    }

    public int attemptValidCheck(String attemptCount) {
        int attemptCountInt;
        attemptCountInt = numericAttemptCheck(attemptCount);
        negativeAttemptCheck(attemptCountInt);
        return attemptCountInt;
    }

    private int numericAttemptCheck(String attemptCount) {
        try {
            return Integer.parseInt(attemptCount);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    private void negativeAttemptCheck(int attemptNum) {
        if (attemptNum < 0) {
            throw new IllegalArgumentException("시도할 회수는 음수일 수 없습니다");
        }
    }
}
