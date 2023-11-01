package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    // 일직선 상의 차의 위치
    private Integer position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move(){
        int randomValue = generateRandomValue();
        if(randomValue >= 4){
            this.position++; // 1칸 전진
        }
    }
    private Integer generateRandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }
}
