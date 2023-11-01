package racingcar.domain.car;

import static racingcar.domain.Constants.MIN_MOVE_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.IndexModel;

public class Car extends IndexModel {

    private final Name name;
    private final Positions positions = Positions.create();
    private List<Integer> pickedNumbers = new ArrayList<>();

    private Car(String strName) {
        name = Name.create(strName);
    }

    public static Car create(String strName) {
        return new Car(strName);
    }

    public static List<Car> createList(List<String> strNameList) {
        return strNameList.stream()
                .map(Car::create)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name.getName();
    }

    public Positions getPositions() {
        return positions;
    }

    public int calcPickedNumberSize() {
        return pickedNumbers.size();
    }

    public int calcMaxPosition() {
        return positions.calcMaxPosition();
    }

    public int findPositionAt(int index) {
        return positions.findPositionAt(index);
    }

    public void moveForward() {
        positions.moveForward();
    }

}