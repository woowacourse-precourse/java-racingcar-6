package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.NumberGenerator;

public class RacingCar {
    private static final int MAX_BOUND = 9;
    private static final int MOVABLE_THRESHOLD = 4;
    private String name;
    private Integer move;
    private NumberGenerator numberGenerator;


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
        if (randomValue() >= MOVABLE_THRESHOLD) {
            this.move++;
        }
    }

    private Integer randomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void testMove() {
        if (!isTestMovable()) {
            return;
        }
        move++;
    }

    private boolean isTestMovable() {
        return MOVABLE_THRESHOLD <= numberGenerator.generate(MAX_BOUND);
    }
}
