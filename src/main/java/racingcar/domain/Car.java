package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;


public class Car implements Comparable<Car> {
    private String name;
    private int position;


    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void move() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            position++;
        }
        System.out.println(getNowPositionToString());
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    public String getNowPositionToString() {
        return name + " : " +  "-".repeat(position);
    }
    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5를 초과합니다.");
        }
    }


    public void setPosition(int moveCount) {
        this.position = moveCount;
    }


    @Override
    public int compareTo(Car c) {
        return c.position - this.position;
    }
}
