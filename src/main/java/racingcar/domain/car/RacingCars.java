package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import racingcar.domain.forwardMethod.ForwardMethod;

public class RacingCars implements Iterable<RacingCar> {

    private static final int REQUIRED_NUMBER_RACINGCAR = 2;
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        if (isNotEnoughCars(racingCars)) {
            throw new IllegalArgumentException("경주를 위해 최소 두 대의 RacingCar 가 필요합니다.");
        }
        if (isDuplicateName(racingCars)) {
            throw new IllegalArgumentException("중복된 이름을 가진 RacingCar 가 함께 경주할 수 없습니다.");
        }
        this.racingCars = racingCars;
    }

    public RacingCars(RacingCars racingCarList) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (RacingCar racingCar : racingCarList.racingCars) {
            racingCars.add(new RacingCar(racingCar));
        }
        this.racingCars = racingCars;
    }

    public RacingCars move(ForwardMethod forwardMethod) {
        List<RacingCar> relocatedRacingCars = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            RacingCar relocatedRacingCar = new RacingCar(racingCar.move(forwardMethod));
            relocatedRacingCars.add(relocatedRacingCar);
        }
        return new RacingCars(relocatedRacingCars);
    }

    public RacingCarWinners findWinners() {
        int maxPosition = findMaxPosition();

        removeLosers(maxPosition);
        List<Name> winnerNames = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            winnerNames.add(racingCar.name());
        }
        return new RacingCarWinners(winnerNames);
    }

    private void removeLosers(int maxPosition) {
        racingCars.removeIf(racingCar -> racingCar.getPosition() < maxPosition);
    }

    public int findMaxPosition() {
        racingCars.sort(Collections.reverseOrder());

        return racingCars.get(0)
                .getPosition();
    }

    private boolean isNotEnoughCars(List<RacingCar> racingCars) {
        return racingCars.size() < REQUIRED_NUMBER_RACINGCAR;
    }

    private boolean isDuplicateName(List<RacingCar> racingCars) {
        Set<RacingCar> racingCarSet = new HashSet<>(racingCars);

        return racingCarSet.size() != racingCars.size();
    }

    public void add(RacingCar racingCar) {
        if (racingCars.contains(racingCar)) {
            throw new IllegalArgumentException();
        }
        racingCars.add(racingCar);
    }

    public boolean contains(RacingCar racingCar) {
        return racingCars.contains(racingCar);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        racingCars.forEach(racingCar -> stringBuilder.append(racingCar.toString())
                .append("\n"));
        return stringBuilder.toString();
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return racingCars.iterator();
    }
}
