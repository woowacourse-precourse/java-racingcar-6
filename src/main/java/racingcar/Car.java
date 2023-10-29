package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int goCount = 0;
    public Car(String name) {
        this.name = name;
    }

    public void goOrStop() {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            goCount++;
        }
    }
    
    public void printNameAndCount() {
        System.out.print(name + " : ");
        for(int i = 0; i < goCount; i++) {
            System.out.print("-");
            if (i != goCount - 1) {
                System.out.print(" ");
            }
        }
    }
}
