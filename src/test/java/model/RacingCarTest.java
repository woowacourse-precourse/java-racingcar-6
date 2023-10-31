package model;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @Test
    void drive() {
        Car testcar1 = new RacingCar("testcar");
        int random = Randoms.pickNumberInRange(1,9);
        System.out.println("랜덤 넘버 : " + random);
        for(int i=0;i<random;i++){
            testcar1.drive();
            System.out.println(testcar1.position);
        }
    }
}