package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame implements Game {
    private static final int criterion = 4;
    private static final int carNameLength = 5;
    private int attempts;
    private final List<Car> carList = new ArrayList<>();
    private List<String> winners;

    @Override
    public void play(String[] args) {
        if (args != null && args.length > 0) {
            makeCars(args[0]);
            validateAttempts(args[1]);
        }

        for (Car car : carList) {
            goAhead(car, Randoms.pickNumberInRange(0, 9));
        }
    }

    @Override
    public boolean continues() {
        if (attempts > 0) {
            attempts--;
            return true;
        }

        checkWinners();
        return false;
    }

    public void makeCars(String carNames) {
        for (String name : carNames.split(",")) {
            validateCarName(name);
            carList.add(new Car(name));
        }
    }

    public boolean goAhead(Car car, int randomNumber) {
        if (randomNumber >= criterion) {
            car.move();
            return true;
        }

        return false;
    }

    public void validateAttempts(String attempts) {
        try {
            this.attempts = Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수를 입력해주세요.", e);
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > carNameLength) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void checkWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        winners = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinners() {
        return winners;
    }
}
