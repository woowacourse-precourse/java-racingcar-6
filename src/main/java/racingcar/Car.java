package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    final private String carName;
    private int distance;

    public Car(String name){
        carName = name;
        distance = 0;
    }

    /**
     * Car객체의 carName을 반환한다.
     *
     * @return carName
     */
    public String getCarName(){
        return carName;
    }

    /**
     * Car객체의 distance를 반환한다.
     *
     * @return distance
     */
    public int getDistance() {return distance;}

    /**
     * 자동차가 이동할 지, 이동하지 않을 지 결정한다.
     */
    public void move(){
        if(Randoms.pickNumberInRange(0,9) >= 4)
            distance++;
    }
}
