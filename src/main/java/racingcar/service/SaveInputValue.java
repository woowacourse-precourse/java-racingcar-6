package racingcar.service;

import racingcar.model.InputProcess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveInputValue {

    InputProcess inputProcess = new InputProcess();
    CarNameCheck carNameCheck = new CarNameCheck();
    RepeatNumberCheck repeatNumberCheck = new RepeatNumberCheck();

    List<String> cars;
    String repeatNumber;

    public SaveInputValue(List<String> cars, String repeatNumber) {
        this.cars = cars;
        this.repeatNumber = repeatNumber;
    }

    public List<String> saveCarName() {
        String carInput = inputProcess.getCarName();
        String[] temp = carInput.split(",");
        cars = new ArrayList<>(Arrays.asList(temp));

        checkCarNames();
        isCarNameDuplicated();

        return cars;
    }

    public String saveRepeatNumber() {
        repeatNumber = inputProcess.getRepeatNumber();
        checkRepeatNumber();
        return repeatNumber;
    }

    public void checkCarNames() {
        for (String car : cars) {
            carNameCheck.checkAll(car);
        }
    }

    public void checkRepeatNumber() {
        repeatNumberCheck.checkAll(repeatNumber);
    }

    public void isCarNameDuplicated() {
        List<String> cmp = cars.stream().distinct().toList();
        if (cars.size() != cmp.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }
}
