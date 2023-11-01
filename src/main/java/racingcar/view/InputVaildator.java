package racingcar.view;

import java.util.List;

public class InputVaildator {

    public void isNameLessThan5Char(List<String> carNames) {
        //리스트 길이만큼 돌리기
        //만약 5자 이하면 통과, 아니면 예외처리
        for (int i = 0; i < carNames.size(); i++) {
            if (carNames.get(i).length() > 5) {
                System.out.println("차 이름의 길이가 5를 초과합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void isString(List<String> carNames) {
        for (String name : carNames) {
            if(!name.matches("^[a-zA-Z]*$")){
                System.out.println("차 이름 중 문자가 아닌 것이 있습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public int isInt(String strNum) {
        try{
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e){
            System.out.println("레이싱 시도 횟수가 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    public void isEmpty(List<String> carNames) {
        for (String name : carNames) {
            if (name == null) {
                System.out.println("주어진 차 이름 중 공백이 있습니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void isEmpty(String strNum) {
        if (strNum == null) {
            System.out.println("레이싱 시도 회수가 주어지지 않았습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void isZero(String strNum) {
        if (strNum == "0") {
            System.out.println("주어진 레이싱 시도 회수가 0번입니다.");
            throw new IllegalArgumentException();
        }
    }
}
