package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int distance;

    Car(String name){
        this.name = name;
        this.distance = 0;
    }

    void moveForward(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance++;
        }
    }

    void printState(){
        System.out.printf("%s : ", this.name);
        for (int i = 0; i < this.distance; i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
