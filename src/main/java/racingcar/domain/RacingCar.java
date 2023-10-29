package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.NumberGenerator;

public class RacingCar {
    private static final int MAX_BOUND = 9;
    private static final int MOVABLE_THRESHOLD = 4;
    private NumberGenerator numberGenerator;
    private String name;
    private Integer move;


    public RacingCar(String name, Integer move) {
        this.name = name;
        this.move = move;
    }

    public RacingCar(String name, Integer move,NumberGenerator numberGenerator) {
        this.name = name;
        this.move = move;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }

    public void moveRacingCar() {
        if (randomValueIsGreaterThanFour()) {
            this.move += 1;
        }
    }

    private boolean randomValueIsGreaterThanFour() {
        if ( randomValue() >= 4) {
            return true;
        }
        return false;
    }

    private Integer randomValue(){
        return Randoms.pickNumberInRange(0, 9);
    }

    /** 테스팅을 위한 메소드들 **/
    public void move() {
        if (!isMovable()) {
            return;
        }
        move++;
    }
    private boolean isMovable() {
        return MOVABLE_THRESHOLD < numberGenerator.generate(MAX_BOUND);
    }
}
