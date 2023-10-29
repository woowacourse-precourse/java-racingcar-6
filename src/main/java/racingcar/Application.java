package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 자동차의 이름, 진행 상황

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        playGame();
    }

    // 게임 진행 메소드-입력받기, 출력
    private static void playGame(){

            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames=Console.readLine();
            String[] carNameArray=carNames.split(",");
            //자동차 갯수
            int carCount = carNameArray.length;
            //자동차 수만큼 배열 생성
            int[] progress=new int[carCount];

            //기본적 예외 처리
            if (!isValidCarNames(carNameArray)) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }

            System.out.println("시도할 횟수는 몇회인가요?");
            int attempts=Integer.parseInt(Console.readLine());

            for (int i=0;i<attempts;i++) {
                //해당 자동차 배열에 횟수만큼 랜덤 숫자 지정,
                moveCars(carCount,progress);
//                printProgress(carNameArray,progress);
            }



    //입력된 자동차 이름으로 Car 객체 생성











    }
    // 입력값 예외처리 해주는 메소드-이름, 횟수
    private static boolean isValidCarNames(String[] carNames){
        for (String name: carNames){
            if (name.length()>5){
                return false;
            }
        }
        return true;
    }

    //각 자동차에 무작위 전진 횟수 지정 메소드
    private static void moveCars(int carCount,int[] progress) {
        for (int j=0; j<carCount; j++){
            int randomValue= Randoms.pickNumberInRange(0,9);
            //만약 지정된 수가 4이상일경우 전진 수에 +해주기
            if (randomValue>=4){
                progress[j]++;
            }
        }
    }



}
