package racingcar.model;

public class Validator {
    //콤마를 기준으로 이름이 1자 이상 5자 이하가 아닌 경우
    public Validator() {
    }

    public boolean isCarNameFromPlayerValidate(String carName) {
        String[] carNameArray = carName.split(",");
        for (int i = 0; i < carNameArray.length; i++) {
            if (!(carNameArray[i].length() >= 1 && carNameArray[i].length() <= 5)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
}
