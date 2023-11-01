package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class RacingGame {
    // 자동차
    Map<String, Long> cars;
    // 트랙 총 길이
    Long circuitLength;

    // cars 생성: LinkedHashMap
    RacingGame() {
        cars = new LinkedHashMap<>();  // HashMap를 LinkedHashMap으로 변경
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
            validityCheckByCarsName(carName);
            cars.put(carName, 0L);
        }
    }

    //입력한 자동차의 이름이 5글자 이상일 경우 오류발생
    private static void validityCheckByCarsName(String carName) {
        if(carName.length() >= 5){
            throw new IllegalArgumentException("입력한 자동차의 이름이 5글자를 초과합니다.");
        }
    }


    // 입력값을 시도할 횟수로 초기화
    private void setCircuitLength(){
        System.out.println("시도할 회수는 몇회인가요?");
        String totalLength = Console.readLine();
        validityCheckByCircuitLength(totalLength);
        circuitLength = Long.parseLong(totalLength);
    }

    /**
     *  시도할 횟수 입력값이 숫자가 아닐 때 오류 발생
     *  isNumeric() 호출
     */
    private static void validityCheckByCircuitLength(String totalLength) {
        if(!isNumeric(totalLength)) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다."); // 오류 발생
        }
    }

    // 정규 표현식을 사용해 숫자로만 구성되어 있는지 확인
    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }


    /**
     * 입력 받은 횟수 만큼 경주 시작
     * checkOneLab() 호출
     */
    private void gameStart(){
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i<circuitLength;i++){
            checkOneLab();
        }
    }

    /**
     * 하나의 회차 동안 이루어질 전진 여부
     *getNewRandomNumber() 호출
     */
    private void checkOneLab(){
        for(String carName : cars.keySet()){
            int random = getNewRandomNumber();
            if(random >= 4){
                Long currentDistance = cars.get(carName);
                cars.put(carName, currentDistance + 1);
            }
            printCurrentStatus(carName);
        }
        System.out.println();
    }

    //현재 전진한 자동차의 상태 출력
    private void printCurrentStatus(String carName){
        Long meters = cars.get(carName);
        String output = carName + " : ";

        for(int i=0; i<meters; i++){
            output += "-";
        }

        System.out.println(output);
    }


    //1 ~ 9 사이의 난수 1개를 반환해주는 메서드
    private int getNewRandomNumber(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }

    /**
     * 우승한 자동자의 이름 출력
     * 공동 우승할 경우 두 개의 이름을 ','로 구분해 출력
     */
    private void printWinnerCars() {
        long maxDistance = 0L;
        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Long> entry : cars.entrySet()) {
            String carsName = entry.getKey();
            Long carsDistance = entry.getValue();

            if(carsDistance > maxDistance) {
                maxDistance = carsDistance;
                winners.clear();
                winners.add(carsName);
            }
            else if(carsDistance == maxDistance){
                winners.add(carsName);
            }
        }
        if (winners.size() == 1) {
            System.out.println("최종 우승자 : " + winners.get(0));
        } else {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        }
    }


    //
    public void run(){
        gameStart();
        printWinnerCars();
    }

    private void printStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


}
