package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Sentence;

import static racingcar.util.Consts.START_INCLUSIVE;
import static racingcar.util.Consts.END_INCLUSIVE;
import static racingcar.util.Consts.MOVEMENT_CRITERIA;
import static racingcar.util.Consts.SINGLE_MOVEMENT_DISTANCE;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
    }

    public static Car createCar(String name) {
        Car car = new Car(name);
        car.distance = 0;
        return car;
    }

    public void raceOneRound() {
        int randomResult = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (randomResult >= MOVEMENT_CRITERIA) {
            distance += SINGLE_MOVEMENT_DISTANCE;
        }
    }

    public CarResultDto createCarResultDto() {
        return new CarResultDto(name, distance);
    }

    public record CarResultDto(String name, int distance) {

        @Override
        public String toString() {
            StringBuilder resultExpression = new StringBuilder(name);
            resultExpression.append(Sentence.COLON_FOR_LIST.getMessage());
            for (long i = 0; i < distance; i++) {
                resultExpression.append("-");
            }
            return resultExpression.toString();
        }
    }
}