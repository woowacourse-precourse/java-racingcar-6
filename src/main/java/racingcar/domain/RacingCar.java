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

    public RacingCar(String name, Integer move, NumberGenerator numberGenerator) {
        this.name = name;
        this.move = move;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return this.move;
    }

    public void moveRacingCar() {
        if (randomValueIsGreaterThanFour()) {
            this.move += 1;
        }
    }

    private boolean randomValueIsGreaterThanFour() {
        if (randomValue() >= 4) {
            return true;
        }
        return false;
    }

    private Integer randomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }
    @Override
    public String toString(){
        return this.name + " : " + this.move;
    }

    /** 랜덤 값 테스트를 위한 메소드 **/
    public void move() {
        if (!isMovable()) {
            return;
        }
        move++;
    }

    private boolean isMovable() {
        return MOVABLE_THRESHOLD <= numberGenerator.generate(MAX_BOUND);
    }
}
