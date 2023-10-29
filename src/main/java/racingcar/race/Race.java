package racingcar.race;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Race {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MIX_RANDOM_NUMBER = 9;
    private static final int GO_FORWARD = 4;

    private List<Car> cars = new ArrayList<>();

    public void saveName(List<String> carNames) {
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
    public boolean decideGo() {
        boolean go = false;
        int randomNum = pickNumberInRange(MIN_RANDOM_NUMBER, MIX_RANDOM_NUMBER);
        if (randomNum >= GO_FORWARD) {
            go = true;
        }
        return go;
    }
    public void goFoward() {
        for (Car car : cars) {
            if (decideGo()) {
                car.plusPosition();
            }
        }
    }
    public void printRace() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + car.addDash());
            System.out.println();
        }
        System.out.println();
    }
    public List<Integer> savePositionInList() {
        List<Integer> position = new ArrayList<>();
        for (Car car : cars) {
            position.add(car.getPosition());
        }
        return position;
    }
    public List<Integer> findWinnerIndex() {
         Compare compare = new Compare();
         List<Integer> index = new ArrayList<>();
         index = compare.findMaxIndex(savePositionInList());
         return index;
    }
    public void findWinnerName() {
        Compare compare = new Compare();
        List<Integer> index = findWinnerIndex();
        List<String> name = new ArrayList<>();
        int maxCount = compare.findHowManyMax(savePositionInList());
        for (int i = 0; i < maxCount; i++) {
            name.add(cars.get(index.get(i)).getName());
        }
        System.out.println(name.toString());
    }
}
