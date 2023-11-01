package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

//인덴테이션(3 이상이면 안됨)에 유의, 3항 연산자 사용금지, 1함수 1업무, 기능별 테스트에 유의
//기능 단위 커밋하기!!!!

public class Application {
    public static void main(String[] args) {
        //기능별 구현 후 main함수 안쪽 구성하기
    }

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
