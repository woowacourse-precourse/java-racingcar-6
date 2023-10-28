package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    // 일직선 상의 차의 위치
    private Integer position;

    public Car(String name){
        this.name = name;
        this.position = 0;
    }

    public Integer move(){
        int randomValue = generateRandomValue();
        if(randomValue >= 4){
            this.position++; // 1칸 전진
            return randomValue;
        }else{
            return 0;
        }
    }
    private Integer generateRandomValue(){
        return Randoms.pickNumberInRange(0,9);
    }
}
