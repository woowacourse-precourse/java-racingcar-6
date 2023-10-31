package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Car {
    String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    String getName(){
        return name;
    }

    int getPosition(){
        return position;
    }

    void move(int distance){
        if(distance >= 4) {
            position++;
        }
    }

    void printPosition(){
        for(int i = 0; i < position; i++){
            System.out.println("-");
        }
        System.out.println();
    }
}
