package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1. 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();
        String[] carNames = userInput.split(","); //배열대신 컬렉션 변경하기

        for (String carName : carNames) {
            System.out.print("\"" + carName + "\"");
        }
        System.out.println();

        // 2대 미만 입력 => 예외 처리
        if (carNames.length < 2) {
            throw new IllegalArgumentException("2대 이상의 자동차 이름을 입력해 주세요.");
        }

        // 공백 입력 & 6자 이상 입력 => 예외 처리
        for (String carName : carNames) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException("공백을 입력하지 마세요.");
            }

            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름을 5자 이하로 입력해 주세요.");
            }
        }

        // 이름에 공백 포함시 => 공백 제거
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }

        for (String carName : carNames) {
            System.out.print("\"" + carName + "\"");
        }

        // 2. 시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        userInput = Console.readLine();
        int roundCount;

        try {
            roundCount = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }

        if(roundCount <= 0){
            throw new IllegalArgumentException("1이상의 숫자를 입력하세요.");
        }

        // 3. 이동 로직 구현
        System.out.println("실행 결과");

        String[] movedCount = {"","",""}; // 배열 대신 컬렉션으로 교체 하기, 초기화 방법고려
        for(int i=0; i<roundCount; i++){

            for(int j=0; j<3; j++){
                // 3도 상수로 변환하기
                if(Randoms.pickNumberInRange(0,9) >= 4){
                    movedCount[j] += "-";
                }
            }

            for(int k=0; k<3; k++){
                System.out.println(carNames[k] + " : " + movedCount[k]);
            }

            System.out.println();
        }

    }
}
