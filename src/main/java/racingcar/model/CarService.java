package racingcar.model;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class CarService {
    public final int MOVE_LIMIT_CONDITION = 4;
    public final int CAR_NAME_LIMIT_SIZE = 5;
    private CarObject CarInstance = CarObject.getInstance();
    public String name;
    public int epoch;

    private CarService() {}

    public boolean carMoveJudgment() {
        int carOnceMove = Randoms.pickNumberInRange(0, 9);
        if(carOnceMove >= MOVE_LIMIT_CONDITION) {
            return true;
        }
        return false;
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
                throw new IllegalArgumentException(Message.getInstance().CAR_NAME_EXCEPTION);
            }
            CarObject.name.add(carNameSizeJudgment(name));
        }
        CarObject.size = CarObject.name.size();

        if(CarObject.size <= 1) {
            throw new IllegalArgumentException(Message.getInstance().CAR_SIZE_EXCEPTION);
        }
    }

    public void carInit() {
        insertCarName(this.name);
        CarInstance.addComponent();
    }

    private static class SingleInstanceHolder {
        private static final CarService INSTANCE = new CarService();
    }

    public static CarService getInstance() {
        return SingleInstanceHolder.INSTANCE;
    }
}
