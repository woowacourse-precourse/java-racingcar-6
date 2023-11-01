package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int moveCnt;

    public Car(String name){
        this.name = name;
        this.moveCnt = 0;
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
