package racingcar;

public class GameException {
    public void NameCount(String carName){
        if(carName.length() > 5){
            throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
        }
    }
}
