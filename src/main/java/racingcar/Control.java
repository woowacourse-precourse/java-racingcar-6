package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Control {
    static int tryNumber;
    static List<String> winnerName = new ArrayList<>();     // 우승자를 저장할 List
    static List<String> names = new ArrayList<>();          // Car 객체의 이름을 저장할 List
    static List<Car> Cars = new ArrayList<>();              // Car 객체를 저장할 List

    /* Car객체를 생성해서 List에 add */
    void createObjects() {
        for (String name : names) {
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
            Cars.add(car);
        }
    }

    /* 인자로 전달받은 자동차 이름을 쉼표를 기준으로 나누고 List에 저장 */
    void stringToList(String names) {
        Control.names = List.of(names.split(","));
        createObjects();
    }

    /* 사용자로부터 입력받은 시도할 횟수 저장 */
    void setTryNumber(String tryNumber) {
        Control.tryNumber = Integer.parseInt(tryNumber);
    }

    /* 실제 게임이 진행되는 메소드 */
    static public void playGame() {
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < names.size(); j++) { // 자동차 개수만큼 반복
                int randomNumber = Randoms.pickNumberInRange(0, 9); // 0~9까지의 난수 생성
                if (randomNumber >= 4) { // 생성된 난수가 4이상이면 자동차 이동
                    Cars.get(j).moveCount++;
                }
            }
            View.print("Progress"); // 진행 상황(현재 자동차가 이동한 거리) 출력
        }
    }

    /* 우승자를 계산하는 메소드 */
    static public void calculateWinner() {
        int max = -1; // 객체의 moveCount(이동거리)가 가장 큰 값을 찾기 위해 max변수 초기화
        for(Car car: Cars) {
            if(car.moveCount > max){
                max = car.moveCount;
            }
        }
        for(Car car: Cars){ // max와 같은 값을 갖는 객체를 찾아 winnerName List에 추가(1등과 동점자 찾는 과정)
            if(car.moveCount == max){
                winnerName.add(car.name);
            }
        }
    }
}
