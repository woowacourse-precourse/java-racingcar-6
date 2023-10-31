package racingcar;

public class Check {

    public void checkNameSize(String input){
        String[] strArr = input.split(",");
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
            }
        }
        return;
    }

    public void checkNumber(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
        return;
    }
}
