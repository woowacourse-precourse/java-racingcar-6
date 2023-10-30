package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public String carName;
    public int distance;


    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    public Car(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void drive(){
        int num = Randoms.pickNumberInRange(0,9);

        if(num>=4){
            distance++;
        }
    }

}
