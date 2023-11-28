package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }
    
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
    
    public void move(){
        if(createRandomNumber()>=4){
            position++;
        }
        System.out.println(toString());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String toString(){
        return this.name + " : " + "-".repeat(this.position)+ "\n";
    }
}
