package racingcar;

public class Car {

    private final String[] carList;

    public Car(String console) {

        String[] checkName = console.split(",");
        carList = new String[checkName.length];

        for (int i = 0; i < checkName.length; i++) {

            carList[i] = Validation.CarNameCheck(checkName[i]);
        }
    }

    public String[] getCarList() {
        return carList;
    }
}
