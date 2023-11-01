package racingcar.domain.car;

import static racingcar.domain.Constants.MAX_CAR_LENGTH;
import static racingcar.domain.Constants.MIN_MOVE_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.domain.IndexModel;
import racingcar.util.ExceptionUtil;

public class Car extends IndexModel {


    private Name name;
    private int currPosition = 0;
    private List<Integer> pickedNumbers = new ArrayList<>();
    private List<Integer> positions = new ArrayList<>();


    private Car(String strName) {
        name = Name.create(strName);
    }

    public static Car create(String strName) {
        return new Car(strName);
    }

    public String getName() {
        return name.getName();
    }

    public int getLastPosition() {
        return currPosition;
    }

    public int calcPickedNumberSize() {
        return pickedNumbers.size();
    }

    public int findPositionAt(int turn) {
        return positions.get(turn);
    }

    public boolean isPositionSameOrOver(int maxPosition) {
        return currPosition >= maxPosition;
    }

    public void insertPickedNumber(int num) {
        pickedNumbers.add(num);
        moveForwardIfNumberisSameOrOverCriteria(num);
        positions.add(currPosition);
    }

    private void moveForwardIfNumberisSameOrOverCriteria(int num) {
        if (num >= MIN_MOVE_NUMBER) {
            moveForward();
        }
    }
    public void moveForward() {
        currPosition++;
    }

}