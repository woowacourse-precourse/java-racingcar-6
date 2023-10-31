package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Cars {
    private Car[] cars;
    private String winner = "";
    private int max = 0;

    public Cars(String[] carNames) throws IllegalArgumentException {
        if (!existSameName(carNames)) {
            cars = new Car[carNames.length];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(carNames[i]);
            }
        }
        throw new IllegalArgumentException("이름이 중복되었습니다.");
    }

    public boolean existSameName(String[] carNames) {
        Set<String> names = new HashSet<>();
        for (int i = 0; i < carNames.length; i++) {
            if (names.contains(carNames[i])) return false;
            names.add(carNames[i]);
        }
        return true;
    }

    public void moveResult(int count) {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.length; j++) {
                System.out.println(cars[j].goOrStop());
                max = Math.max(cars[j].getMovingLength(), max);
            }
            System.out.println();
        }
    }

    public String findFinalWinner() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getMovingLength() == max) {
                winner += cars[i].getCarName() + ",";
            }
        }
        return winner.substring(0, winner.length() - 1);
    }

}
