package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class RacingGame {
    //자동차
    Map<String, Long> cars;
    //트랙 총 길이
    Long circuitLength;

    //cars 생성 : HashMap
    RacingGame(){
        cars = new HashMap<>();
        circuitLength = 0L;

        this.setter();
    }

    private void setter(){
        this.setCarsName();
        this.setCircuitLength();
    }

    /**
     * 경기에 참가하는 자동차들을 입력받아 배열에 저장후
     * cars에 (키, 값) 추가
     * */

    private void setCarsName() {
        printStart();
        String inputRacersName = Console.readLine();
        String[] carNames = inputRacersName.split(",");

        for (String carName : carNames) {
            cars.put(carName, 0L);
        }
    }

    // 입력값을 시도할 횟수로 초기화
    private void setCircuitLength(){
        String totalLength = Console.readLine();
        circuitLength = Long.parseLong(totalLength);
    }

    /**
     * 입력 받은 횟수 만큼 경주 시작
     *checkOneLab() 호출
     */
    private void gameStart(){
        for(int i = 0; i<circuitLength;i++){
            checkOneLab();
        }
    }

    /**
     * 하나의 회차 동안 이루어질 전진 여부
     *getNewRandomNumber() 호출 |
     */
    private void checkOneLab(){
        for(String carName : cars.keySet()){
            int random = getNewRandomNumber();
            if(random >= 4){
                Long currentDistance = cars.get(carName);
                cars.put(carName, currentDistance + 1);
            }
        }
    }

    //1 ~ 9 사이의 난수 1개를 반환해주는 메서드
    private int getNewRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }

//    private void printCarDistances() {
//        for (Map.Entry<String, Long> entry : cars.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//    }

    //
    public void run(){
        gameStart();
//        printCarDistances();
    }

    private void printStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


}
