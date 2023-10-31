package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private List<Car> carList;

    public Racing(List<String> nameList) {
        this.carList = nameList.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public String startRacing(int round) {
        StringBuilder racingResult = new StringBuilder();

        for (int i = 0; i < round; i++) {
            racingResult.append("\n");
            for (Car car : carList) {
                move(car);
                racingResult.append(car.getResult());
            }
        }
        return racingResult.toString();
    }

    public List<String> determineWinner() {
        int maxMove = getMax();

        return carList.stream()
                .filter(car -> car.move == maxMove)
                .map(car -> car.name)
                .collect(Collectors.toList());
    }

    private void move(Car car) {
        if (isGo()) {
            car.move += 1;
        }
    }

    private Boolean isGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    private int getMax() {
        return carList.stream()
                .mapToInt(car -> car.move)
                .max()
                .orElse(Integer.MIN_VALUE);

    }
}

