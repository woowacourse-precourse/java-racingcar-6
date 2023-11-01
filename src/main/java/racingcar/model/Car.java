package racingcar.model;

import java.math.BigInteger;

public class Car implements Comparable<Car> {
    public String name;
    public BigInteger score;

    public Car (String name, BigInteger score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Car otherCar) {
        // score 를 기준으로 정렬
        return this.score.compareTo(otherCar.score);
    }
}