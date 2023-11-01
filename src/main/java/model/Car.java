package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int stepCount;

    public Car(){}
    public Car(String name){
        this.name = name;
    }

    /**
     * 전진 가능한 Random 수 얻기
     *
     * @return 0에서 9 사이에서 무작위 정수 값 반환
     */
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }


}
