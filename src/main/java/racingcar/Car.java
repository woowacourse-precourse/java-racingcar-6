package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int location;
    
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
    
    void printLocation() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    String getName() {
        return name;
    }
    
    int getLocation() {
        return location;
    }
}
