package racingcar;

public class InputNumCheck{
    public static Integer numCheck(String gameNum){

        char tempNum = gameNum.charAt(0);
        int num = (byte) tempNum;

        if(num < 48 || num > 57){ // 아스키 코드값이 48보다 작고 57보다 크다면
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
        int successInputNum = Integer.parseInt(gameNum);
        return successInputNum;
    }
}
