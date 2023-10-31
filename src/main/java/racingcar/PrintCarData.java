package racingcar;

public class PrintCarData {
    // 자동차의 이동거리를 리턴하는 printRacingCarDistance 메서드
    public String printRacingCarDistance(int racingCarNameValue){
        StringBuilder carDistance = new StringBuilder();
        for(int i=0; i < racingCarNameValue; i++){ // 이동거리만큼 -를 저장
            carDistance.append("-");
        }
        return carDistance.toString();
    }
}
