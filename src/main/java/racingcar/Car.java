package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int moveCnt;

    public Car(String name){
        setName(name)
        this.moveCnt = 0;
    }
    public void setName(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하");
        }
        this.name = name;
    }

    public int pickNumber(){
        int num = Randoms.pickNumberInRange(0,9);
        return num;
    }

    public void move(){
        this.moveCnt++;
    }

    public String howFar(){
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(" : ");
        for(int i = 0; i < this.moveCnt; i++){
            output.append("-");
        }
        return output.toString();
    }
}
