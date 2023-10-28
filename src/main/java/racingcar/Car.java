package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int location;
    
    Car(String name) {
        this.location = 0;
        this.name = name;
    }
    
    void changeLocation() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            this.location++;
        }
    }
    
}
