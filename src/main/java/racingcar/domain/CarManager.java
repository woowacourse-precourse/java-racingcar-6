package racingcar.domain;

public class CarManager {

    public CarGroup createCarList(String inputCarNames) {
        CarGroup carGroup = new CarGroup();

        String[] carNameList = inputCarNames.split(",");
        for (String name : carNameList) {
            carGroup.addCar(name);
        }

        return carGroup;
    }

}
