package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;

import static racingcar.util.Consts.START_INCLUSIVE;
import static racingcar.util.Consts.END_INCLUSIVE;
import static racingcar.util.Consts.MOVEMENT_CRITERIA;
import static racingcar.util.Consts.MOVEMENT_DISTANCE;

public class Car {
    private BigInteger id;
    private String name;
    private BigInteger distance;

    private Car(BigInteger id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Car createCar(BigInteger id, String name) {
        Car car = new Car(id, name);
        car.distance = BigInteger.ZERO;
        return car;
    }

    public void raceOneRound() {
        int randomResult = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (randomResult >= MOVEMENT_CRITERIA) {
            distance = distance.add(BigInteger.valueOf(MOVEMENT_DISTANCE));
        }
    }

    public CarResultDto createCarResultDto() {
        return new CarResultDto(name, distance);
    }

    public static class CarResultDto {
        private String name;
        private long distance;

        public CarResultDto(String name, BigInteger distance) {
            this.name = name;
            this.distance = distance.longValue();
        }

        public String getName() {
            return name;
        }

        public long getDistance() {
            return distance;
        }
    }

}
