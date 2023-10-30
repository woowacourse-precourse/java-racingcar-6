package racingcar;

import java.util.HashMap;
import java.util.Map;

/*
    게임 진행 시 필요한 데이터 처리, 저장 클래스
    자동차 명
    자동차 전진 거리
    시도할 회수
    우승자 탐색
 */
public class GameData {
    HashMap<String, String> carInfo;
    int tryCount;

    private void checkCarName(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }

    private void checkTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟 수는 0보다 작거나 같을 수 없습니다.");
        }
    }

    public void setCars(String input) {
        String[] split = input.split(",");

        for (String str : split){
            checkCarName(str);
            carInfo.put(str, "");
        }
    }

    public void setTryCount(int input) {
        checkTryCount(input);
        tryCount = input;
    }

    public void moveCar(String carName) {
        String distance = carInfo.get(carName) + '-';
        carInfo.replace(carName, distance);
    }

    public String getWinner() {
        String winner = "";
        String winnerDistance = "";

        for (Map.Entry<String, String> car : carInfo.entrySet()) {
            if(car.getValue().length() >= winnerDistance.length()){
                if(winner.isEmpty()) {
                    winner = car.getKey();
                }
                else {
                    winner = winner + ", " + car.getKey();
                }
                winnerDistance = car.getValue();
            }
        }

        return winner;
    }
}
