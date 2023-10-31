package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String position = "";

    public Car(String name){
        this.name = name;
    }
    public String getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }
    public void moveForward() {
        int move = isMovable();
        if (move >= 4) {
            position += "-";
        }
    }

    public int isMovable() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (randomNumber >= 4) return randomNumber;
        else return 0;
    }
}