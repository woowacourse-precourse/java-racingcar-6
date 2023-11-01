package racingcar.model;


public class CarNameList {
    private final String[] carNameList;
    private final int CHECK_NAME_EXCEED_SIZE = 5;

    public CarNameList(String[] carNameList) {
        this.carNameList = carNameList;
    }

    public int getCarCount() {
        return carNameList.length;
    }

    public String[] getCarNameList() {
        return carNameList;
    }

    public void NameExceptionCheck() {
        for (int i = 0; i < carNameList.length; i++) {
            if (carNameList[i].length() > CHECK_NAME_EXCEED_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }
}
