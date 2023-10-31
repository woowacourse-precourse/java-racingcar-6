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

}
