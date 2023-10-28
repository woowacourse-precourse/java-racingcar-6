package validator;

import java.util.ArrayList;

public class Validator {
    public void getCarsNameValidationChk(String inputString) {
        String nullInputChk = inputString.trim();
        if(nullInputChk.isEmpty()) {
            throw new IllegalArgumentException("입력은 아무것도 없으면 안됩니다.");
        }

        String[] carsNameList = inputString.split(",");
        ArrayList<String> carsNameArrayList = new ArrayList<>();

        for(String name : carsNameList) {
            if(name.isEmpty()) {
                throw new IllegalArgumentException("차 이름은 내용이 없으면 안됩니다.");
            }
            if(name.length() > 5) {
                throw new IllegalArgumentException("차 이름은 5자 이하만 가능합니다.");
            }
            if(carsNameArrayList.contains(name)) {
                throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
            }
            carsNameArrayList.add(name);
        }
    }
}
