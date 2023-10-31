package validator;

import util.Function;

import java.util.ArrayList;

public class Validator {

    public void getCarsNameValidationChk(String inputString) {
        String nullInputChk = inputString.replaceAll("\\s+", "");

        if (nullInputChk.isEmpty()) {
            System.out.println("입력은 아무것도 없으면 안됩니다.");
            throw new IllegalArgumentException("입력은 아무것도 없으면 안됩니다.");
        }

        String[] carsNameList = nullInputChk.split(",");
        ArrayList<String> carsNameArrayList = new ArrayList<>();

        for (String name : carsNameList) {
            if (name.isEmpty()) {
                System.out.println("차 이름은 내용이 없으면 안됩니다.");
                throw new IllegalArgumentException("차 이름은 내용이 없으면 안됩니다.");
            }
            if (name.length() > 5) {
                System.out.println("차 이름은 5자 이하만 가능합니다.");
                throw new IllegalArgumentException("차 이름은 5자 이하만 가능합니다.");
            }
            if (carsNameArrayList.contains(name)) {
                System.out.println("차 이름은 중복될 수 없습니다.");
                throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
            }
            carsNameArrayList.add(name);
        }
    }

    public void getPlayTimeValidationChk(String inputString) {
        String nullInputChk = inputString.replaceAll("\\s+", "");

        if (nullInputChk.isEmpty()) {
            System.out.println("입력은 아무것도 없으면 안됩니다.");
            throw new IllegalArgumentException("입력은 아무것도 없으면 안됩니다.");
        }

        if (!Function.isInteger(inputString)) {
            System.out.println("입력은 정수이어야 합니다.");
            throw new IllegalArgumentException("입력은 정수이어야 합니다.");
        }

        int inputNum = Integer.parseInt(inputString);

        if (inputNum <= 0) {
            System.out.println("입력은 0보다 커야 합니다.");
            throw new IllegalArgumentException("입력은 0보다 커야 합니다.");
        }
    }
}
