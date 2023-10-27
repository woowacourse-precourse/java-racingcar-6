package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    // TODO: 진행한 거리 어떤 타입으로 만들지 고민하기 - 1차 stringbuilder로 만들어보기
    private final StringBuilder distance; 

    public Car(String name) {
        this.name = name;
        this.distance = new StringBuilder();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        if(generateRandomNumber() < 4) return;
        distance.append("-");
    }
    
    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getDistance() {
        return distance.toString();
    }
}
