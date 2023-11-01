package racingcar.model;
import camp.nextstep.edu.missionutils.Randoms;



public class Car {
    private final String name;
    private int position = 0;

    public Car(String name){
        if (name==null || name.length() > 5){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }
    public void move(){
        if (Randoms.pickNumberInRange(0,9) >= 4){
            position ++;
        }
    }
    public int getPosition(){
        return position;
    }
    public String getName(){
        return name;
    }

}