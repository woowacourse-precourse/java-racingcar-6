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

class GameData {
    private HashMap<String, String> carInfo = new HashMap<>();
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

        for (String str : split) {
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
        carInfo.put(carName, distance);
    }

    public HashMap<String, String> getCarInfo() {
        return carInfo;
    }

    public String getWinner() {
        int maxDistance = 0;
        for (String distance : carInfo.values()) {
            if (distance.length() > maxDistance) {
                maxDistance = distance.length();
            }
        }

        StringBuilder winner = new StringBuilder();
        for (Map.Entry<String, String> car : carInfo.entrySet()) {
            if (car.getValue().length() == maxDistance) {
                if (winner.length() > 0) {
                    winner.append(", ");
                }
                winner.append(car.getKey());
            }
        }
        return winner.toString();
    }
}