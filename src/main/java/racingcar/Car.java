package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    String name;
    int moveCount;
    StringBuilder sb;

    public Car(){}
    public Car(String name){
        validName(name);
        this.name = name;
        this.moveCount = 0;
        this.sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
    }
    public void validName(String name){
        if(name.length()>5) throw new IllegalArgumentException("5글자 이하만 가능");
    }
    public void move(){
        if(Randoms.pickNumberInRange(0,9)>=4) {
            this.moveCount++;
            this.sb.append("-");
        }
    }
    public String toString(){
        return sb.toString();
    }

    @Override
    public int compareTo(Car o) {
        return this.moveCount - o.moveCount;
    }
}
