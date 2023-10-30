package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;
import racingcar.constant.ProgressMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class RacingCars {

    private static final int START_INDEX = 0;
    private static final int MIN_RACING_CAR_NUM = 2;
    private final List<RacingCar> elements;

    public RacingCars(final List<RacingCar> elements) {
        validate(elements);
        this.elements = Collections.unmodifiableList(elements);
    }

    private void validate(final List<RacingCar> racingCars) {
        if (racingCars.size() < MIN_RACING_CAR_NUM || isNotUnique(racingCars)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACING_CARS_NAME.toValue());
        }
    }

    private boolean isNotUnique(final List<RacingCar> racingCars) {
        return racingCars.size() != racingCars.stream().distinct().count();
    }

    public int numOfElement() {
        return elements.size();
    }

    public void moveByNumbers(final Numbers numbers) {
        IntStream.range(START_INDEX, numOfElement())
                .forEach(index -> moveIfMovable(numbers, index));
    }

    private void moveIfMovable(final Numbers numbers, final int index) {
        final MoveStatus moveStatus = numbers.checkMoveStatus(index);

        if (moveStatus.isMove()) {
            move(index);
        }
    }

    private void move(final int index) {
        final RacingCar racingCar = elements.get(index);
        racingCar.move();
    }

    public String toResultMessage() {
        final String newLine = ProgressMessage.NEW_LINE.toValue();

        return elements.stream()
                        .map(RacingCar::toResultMessage)
                        .collect(Collectors.joining(newLine))
                + newLine;
    }

    public Winners findWinners() {
        final Integer maxDistance = calculateMaxDistance();
        return findMaxDistanceCars(maxDistance);
    }

    private Winners findMaxDistanceCars(final Integer maxDistance) {
        return elements.stream()
                .filter(racingCar -> racingCar.hasSameDistance(maxDistance))
                .map(RacingCar::toName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Winners::new));
    }

    private Integer calculateMaxDistance() {
        return elements.stream()
                .map(RacingCar::moveDistance)
                .max(Integer::compare)
                .orElseThrow(
                        () ->
                                new IllegalStateException(
                                        ErrorMessage.INVALID_MAX_CALCULATION.toValue()));
    }
}
