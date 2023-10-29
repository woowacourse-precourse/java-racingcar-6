package racingcar;

import racingcar.View.CarRacing;

public class Application {
    public static void main(String[] args) {
        try {
            CarRacing carRacing = new CarRacing();
            carRacing.run();
        }catch(Exception e){
            throw new IllegalStateException();
        }
    }
}
