package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    public int getPosition() {
        return this.position;
    }
}
