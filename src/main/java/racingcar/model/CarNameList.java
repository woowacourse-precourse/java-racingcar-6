package racingcar.model;


import java.util.regex.Pattern;

public class CarNameList {
    private final String[] carNameList;
    private final int CHECK_NAME_EXCEED_SIZE = 5;

    private final String CHAR_DIGIT = "^[\\w]*$";

    public CarNameList(String[] carNameList) {
        this.carNameList = carNameList;
    }

    public int getCarCount() {
        return carNameList.length;
    }

    public String[] getCarNameList() {
        return carNameList;
    }

    public void NameSizeExceededCheck() {
        for (String carName : carNameList) {
            if (carName.length() > CHECK_NAME_EXCEED_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }
    public void NameValueCheck(){
        for (String carName : carNameList) {
            if (carNameValueChecker(carName)) {
                throw new IllegalArgumentException();
            }
        }
    }
    public boolean carNameValueChecker(String carName){
        return !Pattern.matches(CHAR_DIGIT, carName);
    }
}
