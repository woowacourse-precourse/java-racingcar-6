package racingcar.domain.racing.car;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.IndexModel;

public class Car extends IndexModel {

    private final Name name;
    private final Positions positions = Positions.create();

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

    public int calcMaxPosition() {
        return positions.calcMaxPosition();
    }

    public int findPositionAt(int index) {
        return positions.findPositionAt(index);
    }

    public void addPositionByRandomNum(int randomNum) {
        positions.addPositionByRandomNum(randomNum);
    }

    public boolean isCurrPositionSameOrOver(int position) {
        return positions.isCurrPositionSameOrOver(position);
    }
}