package racingcar.model;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class CarService {
    public final int MOVE_LIMIT_CONDITION = 4;
    public final int CAR_NAME_LIMIT_SIZE = 5;
    public int carOnceMove = 0;

    private String name;
    private int epoch;

    private CarService() {}

    public void inputName() {
        name = readLine();
    }

    public void inputEpoch() {
        epoch = Integer.parseInt(readLine());
    }

    public void setCarOnceMoveDistance() {
        do {
            carOnceMove = Randoms.pickNumberInRange(0, 9);
        } while (carOnceMove <= MOVE_LIMIT_CONDITION);
    }

    public String carNameSizeJudgment(String carName) {
        if (carName.length() <= CAR_NAME_LIMIT_SIZE) {
            return carName;
        }
        return null;
    }

    public void insertCarName(String carName) {
        List<String> nameList = Arrays.asList(carName.split(","));
        for (var name : nameList) {
            if (carNameSizeJudgment(name) == null) {
                continue;
            }
            CarObject.name.add(carNameSizeJudgment(name));
        }
    }

    public void insertCarDistance() {
        if (!CarObject.distance.isEmpty()) {
            CarObject.distance.clear();
        }

        for (int i = 0; i < CarObject.size; i++) {
            setCarOnceMoveDistance();
            CarObject.distance.add(carOnceMove);
        }
    }

    public void carAction() {
        CarObject CarInstance = CarObject.getInstance();

        insertCarName(this.name);
        insertCarDistance();
        CarInstance.updateDistance();
    }

    private static class SingleInstanceHolder {
        private static final CarService INSTANCE = new CarService();
    }

    public static CarService getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
