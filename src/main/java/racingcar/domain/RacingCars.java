package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;

public final class RacingCars {

    private static final int START_INDEX = 0;
    private static final int MOVE_STANDARD = 4;
    private static final String NEW_LINE = "\n";
    private final List<RacingCar> elements;

    public RacingCars(final List<RacingCar> elements) {
        validate(elements);
        this.elements = Collections.unmodifiableList(elements);
    }

    private void validate(final List<RacingCar> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ELEMENT_SIZE.toValue());
        }
    }

    public int numOfElement() {
        return elements.size();
    }

    public void moveByNumbers(final List<Integer> numbers) {
        IntStream.range(START_INDEX, elements.size())
                .forEach(index -> move(numbers, index));
    }

    private void move(final List<Integer> numbers, final int index) {
        final RacingCar racingCar = elements.get(index);
        final MoveStatus moveStatus = checkMoveStatus(numbers.get(index));
        if (moveStatus.isMove()) {
            racingCar.addMoveStatus(moveStatus);
        }
    }

    private MoveStatus checkMoveStatus(final int number) {
        if (isMovable(number)) {
            return MoveStatus.MOVE;
        }
        return MoveStatus.STOP;
    }

    private boolean isMovable(final int number) {
        return MOVE_STANDARD <= number;
    }

    public String toResultMessage() {
        return elements.stream()
                .map(RacingCar::toResultMessage)
                .collect(Collectors.joining(NEW_LINE)) + NEW_LINE;
    }

    public Winners findWinners() {
        final Integer maxDistance = calculateMaxDistance();
        return findSameDistanceCars(maxDistance);
    }

    private Winners findSameDistanceCars(final Integer distance) {
        return elements.stream()
                .filter(racingCar -> racingCar.hasSameDistance(distance))
                .map(RacingCar::toName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Winners::new));
    }

    private Integer calculateMaxDistance() {
        return elements.stream()
                .map(RacingCar::moveDistance)
                .max(Integer::compare)
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_MAX_LOGIC.toValue()));
    }
}
