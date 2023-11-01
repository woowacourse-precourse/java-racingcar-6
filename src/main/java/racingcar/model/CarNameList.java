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
        for (int i = 0; i < carNameList.length; i++) {
            if (carNameList[i].length() > CHECK_NAME_EXCEED_SIZE) {
                throw new IllegalArgumentException();
            }
        }
    }
    public void NameValueCheck(){
        for(int i=0; i<carNameList.length; i++){
            if(!Pattern.matches(CHAR_DIGIT, carNameList[i])){
                throw new IllegalArgumentException();
            }
        }
    }
}
