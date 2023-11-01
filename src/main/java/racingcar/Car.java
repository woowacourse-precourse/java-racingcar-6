package racingcar;

import java.util.List;

public class Car {

    private String name;
    int position;
    static int max=0;

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        this.name = name;
    }

    public void movecar(){
        position++;
        updatemax();
    }

    public void updatemax(){
        if(position>max){
            max = position;
        }
    }
}
