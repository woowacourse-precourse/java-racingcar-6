package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        if(isMoveValid(randomNumber)){
            this.position++;
        }
    }
    public boolean isMoveValid(int num){
        return num >= 4;
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
}
