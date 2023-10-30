package racingcar.Controller;

import racingcar.domain.CarManager;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputController {
    CarManager carManager = new CarManager();
    RaceController raceController = new RaceController();

    public void getNameOfCar() {
        splitName(readLine());
    }

    public void splitName(String readLine) {
        validateInput(readLine);//입력이 비어 있는지

        List<String> carNamesList = Arrays.asList(readLine.split(","));
        for (String carName : carNamesList) {
            String trimmedCarName = carName.trim();
            isInvalidName(trimmedCarName);//이름이 5자 이하인지
            if (!trimmedCarName.isEmpty()) {
                Car car = new Car(trimmedCarName);
                carManager.addCar(car);
            }
        }
        validateCarCount();

        raceController.setCarList(carManager);//설정한 값을 raceController에서 쓰기 위해 carManager값을 전달해준다.
    }

    private void validateInput(String readLine) {
        if (readLine == null|| readLine.trim().isEmpty()) {
            throw new IllegalArgumentException("입력은 비어 있을 수 없습니다.");
        }
    }

    private void isInvalidName(String nickName) {
        if (nickName.length() > 5) throw new IllegalArgumentException("5자 이상의 닉네임은 입력할 수 없습니다.");
    }
    private void validateCarCount() {
        if (carManager.getCarCount() < 1) {
            throw new IllegalArgumentException("적어도 한 대 이상의 유효한 차량 이름을 입력해야 합니다.");
        }
    }

    public int getRaceTries() {
        try {
            return Integer.parseInt(readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("부적절한 입력입니다.");
        }
    }
}
