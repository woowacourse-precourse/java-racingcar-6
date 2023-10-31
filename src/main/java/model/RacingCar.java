package model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar extends Car{
    public RacingCar(String name) {
        super(name);
        this.speed = 4;
    }

    @Override
    public void drive() {
        int random = Randoms.pickNumberInRange(0,9);
        if(random>=speed){
            position++;
        }
    }
}
