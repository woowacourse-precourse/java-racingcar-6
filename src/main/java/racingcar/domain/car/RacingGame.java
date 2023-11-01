package racingcar.domain.car;

import racingcar.domain.random.NumberGenerator;

import java.util.List;

public class RacingGame {

    private static final int MOVE_STANDARD = 4;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void play(List<Car> cars){
        for(Car car : cars){
            if(canMove(generateNum())){
                car.move();
            }
        }
    }

    private boolean canMove(int generateNum){
        return generateNum >= MOVE_STANDARD;
    }

    private int generateNum(){
        return numberGenerator.generate();
    }

}
