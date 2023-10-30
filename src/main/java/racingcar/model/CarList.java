package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CarMap 클래스는 ArrayList를 이용해 RacingCar 객체를 저장한다.
 *
 * @author haiseong
 */
public class CarList {
    private static final int DEFAULT_MAX_DISTANCE = 0;

    private final List<RacingCar> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    /**
     * 이름을 받아 RacingCar를 저장한다.
     *
     * @param name 자동차에 붙일 이름
     */
    public void add(String name) {
        carList.add(new RacingCar(name));
    }

    /**
     * 각 자동차들이 라운드를 진행하게한다.
     */
    public void executeRound() {
        carList.forEach(RacingCar::executeRound);
    }

    /**
     * 우승한 자동차들의 리스트를 뽑아낸다.
     *
     * @return 우승한 자동차들의 이름 리스트
     */
    public List<String> getWinners() {
        int maxDistance = getMaxDistance();

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return carList.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .orElse(DEFAULT_MAX_DISTANCE);
    }

    /**
     * 자동차들의 정보를 iterator로 반환한다.
     *
     * @return 자동차들의 iterator
     */
    public Iterator<RacingCar> getIterator() {
        return carList.iterator();
    }
}
