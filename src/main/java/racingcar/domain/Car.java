package racingcar.domain;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    public Car(String name){
        this.name = name;
    }
    public String announceName(){
        return name;
    }
    public boolean tryMove(){
        if(Randoms.pickNumberInRange(0,9)>=4){
            return true;
        }
        return false;
    }
}
