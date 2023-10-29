package racingcar;

public class MyException {
    public void isCorrectName(String name) {
        if(name.length()>4){
            throw new IllegalArgumentException("이름이 5자를 넘습니다.");
        }
    }

}
