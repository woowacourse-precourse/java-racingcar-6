package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.Stream;

public record Round(List<Integer> carMoves) {
    private static final Integer RANDOM_MIN_NUM = 0;
    private static final Integer RANDOM_MAX_NUM = 9;
    private static final Integer MOVE_NUM = 4;

    @Override
    public List<Integer> carMoves() {
        List<Boolean> isCarMoves = this.isCarMoves();

        for (int i = 0; i < this.carMoves.size(); i++) {
            this.moveSingleCar(i, isCarMoves);
        }

        return this.carMoves;
    }

    private void moveSingleCar(int carIndex, List<Boolean> isCarMoves) {
        Boolean isMove = isCarMoves.get(carIndex);
        if (isMove) {
            this.carMoves.set(carIndex, this.carMoves.get(carIndex) + 1);
        }
    }

    private List<Boolean> isCarMoves() {
        return Stream.generate(this::canMove).limit(this.carMoves.size()).toList();
    }

    private Boolean canMove() {
        int randomNumber = pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM);
        return randomNumber >= MOVE_NUM;
    }
}
