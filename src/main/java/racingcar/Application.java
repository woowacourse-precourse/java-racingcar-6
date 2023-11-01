package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

//인덴테이션(3 이상이면 안됨)에 유의, 3항 연산자 사용금지, 1함수 1업무, 기능별 테스트에 유의
//기능 단위 커밋하기!!!!

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        validateCarNames(carNames); //자동차 이름이 유효한지 확인한다. 하단에 메소드 구현

        //입력된 자동차들의 이름을 쉼표로 구분하여 배열에 저장한다
        String[] carNameArray = carNames.split(",");

        //시도 횟수를 정수로 변환 후 저장
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        //시도 횟수에 대한 예외처리를 추가
        if (tryCount <= 0) {
            //예외를 throw 후 프로그램 끝냄
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        int carCount = carNameArray.length; //자동차 총 개수 구하기

        //시도횟수, 자동차 수에 대해 2차원 배열을 만들어서 경주 결과를 저장한다
        int[][] raceResults = new int[tryCount][carCount];

        //시도횟수와 차 수만큼 random수를 생성
        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < carCount; j++) {
                int randomValue = Randoms.pickNumberInRange(0, 9);
                raceResults[i][j] = randomValue;
            }
        }

        printRaceResults(carNameArray, raceResults); //경주 결과를 출력하는 함수. 하단에 메소드 구현
        printWinners(carNameArray, raceResults); //우승자 출력 함수. 하단에 메소드 구현
    }

    //아래부터는 필요한 메소드들을 정의했습니다. 문제 조건(함수 하나당 하나의 일만 하기)에 맞춰 구현 중...

    //경주 결과를 출력하는 메소드
    public static void printRaceResults(String[] carNames, int[][] raceResults) {

        for (int i = 0; i < raceResults.length; i++) {
            for (int j = 0; j < raceResults[i].length; j++) {
                String carName = carNames[j];
                int result = raceResults[i][j];
                StringBuilder dashes = new StringBuilder(); //stringBuilder 초기화시키기

                for (int k = 0; k < result; k++) {
                    dashes.append("-"); //랜덤하게 생성한 -를 반복 출력
                }
                //자동차 이름 뒤에 ---...가 출력되게 하기
                System.out.println(carName + " : " + dashes.toString());
            }
            System.out.println();
        }
    }

    //자동차 이름이 유효한지 판단하는 메소드
    public static void validateCarNames(String carNames) {
        //자동차 이름을 쉼표로 구분해서 저장
        String[] names = carNames.split(",");
        //자동차 이름에 대한 예외처리
        if (names.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력되어야 합니다.");
        }

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력되어야 합니다.");
            }
        }
    }

    //우승자를 출력하는 메소드
    public static void printWinners(String[] carNames, int[][] raceResults) {
        int maxDistance = 0; //최대 이동 거리 저장
        StringBuilder winners = new StringBuilder(); //우승자 저장

        for (int i = 0; i < raceResults[0].length; i++) {
            int totalDistance = 0; //각 자동차의 총 이동 거리 저장

            for (int j = 0; j < raceResults.length; j++) {
                totalDistance += raceResults[j][i]; //각 자동차의 이동거리 + 총 이동거리
            }

            //우승자를 결정한다.
            if (totalDistance > maxDistance) { //현재 자동차의 현재 distance가 지금까지의 max보다 크면
                maxDistance = totalDistance; //바뀜
                //최종 우승자를 stringBuilder에 설정함
                winners = new StringBuilder(carNames[i]);
            } else if (totalDistance == maxDistance) {
                winners.append(",").append(carNames[i]);
                //공동우승하는 경우를 다뤄준다
            }
        }

        System.out.println("최종 우승자 : " + winners.toString());
    }
}
