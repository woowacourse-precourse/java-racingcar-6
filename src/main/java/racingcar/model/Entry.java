package racingcar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Entry {

    private final List<Car> cars = new ArrayList<>();;

    public Entry() {
    }

    public int size() {
        return cars.size();
    }

    /**
     * 엔트리에 차량(car)을 추가합니다.
     * @param car 추가할 차량
     * @throws IllegalArgumentException 동일한 차량이 엔트리에 있는 경우.
     *     한편, 두 차량의 이름이 같을 경우 동일한 차량으로 간주한다.
     */
    public void join(Car car) throws IllegalArgumentException{
        cars.forEach(c -> {
            if (c.isNamesake(car)) {
                throw new IllegalArgumentException("해당 차량이 이미 엔트리에 존재합니다.");
            }
        });

        cars.add(car);
    }

    public void driveAll() {
        cars.forEach(Car::drive);
    }

    /**
     * @return 우승자 리스트 반환. 엔트리가 비어있는 경우 null 반환
     */
    public List<Car> getWinners() {
        Car oneOfWinner;
        Optional<Car> OptionalOneOfWinners = cars.stream().max(Comparator.naturalOrder());
        if (OptionalOneOfWinners.isPresent()) {
            oneOfWinner = OptionalOneOfWinners.get();

            return cars
                    .stream()
                    .filter(car -> car.isNotLoseTo(oneOfWinner))
                    .toList();
        }
        return null;
    }
}
