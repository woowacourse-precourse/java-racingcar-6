package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCarInput = Console.readLine();

        if(racingCarInput.equals("")){ // 입력값이 없으면 예외 발생
            throw new IllegalArgumentException();
        }

        RacingCarData racingCarData = new RacingCarData(); // 레이싱카 정보에 대한 처리를 담당하는 RacingCarData 클래스 타입 객체를 생성
        CarDataCheck carDataCheck = new CarDataCheck(); // 레이싱카 정보에 대한 확인을 담당하는 CarDataCheck 클래스 타입 객체를 생성
        PrintCarData printCarData = new PrintCarData(); // 레이싱카 정보 출력을 담당하는 PrintCarData 클래스 타입 객체를 생성

        // 순서를 보장하는 해시테이블이 필요하기 때문에 LinkedHashMap을 사용
        // separateRacingCar 메서드를 통해 입력 정보를 쉼표를 기준으로 나누어 해시테이블에 담는다
        LinkedHashMap<String, Integer> racingCarNames = racingCarData.separateRacingCar(racingCarInput);

        carDataCheck.checkCarNameIsValid(racingCarNames); // 6자 이상 자동차 이름이 있는 경우 예외 발생

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNumber = Integer.parseInt(Console.readLine()); // 시도할 회수를 담는 tryNumber 변수를 생성

        System.out.println();
        System.out.println("실행 결과");

        boolean racingStatus = true; // 자동차 경주의 진행 여부를 확인하기 위한 racingStatus 변수를 생성

        while(racingStatus){
            for(String carName : racingCarNames.keySet()){
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                int currentNumber = racingCarData.updateRacingCarDistance(randomNumber); // 랜덤으로 생성한 수가 4 이상이면 1, 그렇지 않으면 0을 리턴
                int updateNumber = racingCarNames.get(carName) + currentNumber; // 현재 자동차가 이동한 거리 + currentNumber
                racingCarNames.put(carName, updateNumber); // 해시테이블의 Value를 업데이트
            }

            if(carDataCheck.checkFinishedTime(racingCarNames, tryNumber)){ // 시도할 회수와 동일한 거리를 이동한 자동차가 있는지 확인
                racingStatus = false;
            }

            for(String racingCarNameKey : racingCarNames.keySet()){
                int racingCarNameValue = racingCarNames.get(racingCarNameKey); // 자동차의 이동거리를 racingCarNameValue에 담음
                System.out.print(racingCarNameKey + " : ");
                String carDistance = printCarData.printRacingCarDistance(racingCarNameValue);
                System.out.println(carDistance); // 자동차의 이동거리를 출력
            }
            System.out.println();

            if(!racingStatus){
                System.out.print("최종 우승자 : ");
                System.out.println(printCarData.printWinRacingCar(racingCarNames, tryNumber)); // 우승한 자동차 이름을 출력
            }
        }
    }
}