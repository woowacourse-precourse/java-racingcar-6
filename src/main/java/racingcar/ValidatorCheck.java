package racingcar;

public class ValidatorCheck {

    public void inputOnlyNumber(int playRound){
        if(!(playRound >0)) {
            throw new IllegalArgumentException("0이상의 정수를 입력해주세요.");
        }
    }
}
