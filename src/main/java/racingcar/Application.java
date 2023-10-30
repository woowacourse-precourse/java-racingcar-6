package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 자동차의 이름, 진행 상황

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램
        playGame();
    }

    // 게임 진행 메소드-입력받기, 출력
    private static void playGame(){

            // 입력받는 메소드로 나눌까??
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carNames=Console.readLine();
            String[] carNameArray=carNames.split(",");
            //자동차 갯수
            int carCount = carNameArray.length;
            //자동차 수만큼 배열 생성
            int[] progress=new int[carCount];

            //이름과 관련된 기본적 예외 처리
            if (!isValidCarNames(carNameArray)) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }

            System.out.println("시도할 횟수는 몇회인가요?");
            int attempts=Integer.parseInt(Console.readLine());

            System.out.println("실행 결과");
            for (int i=0;i<attempts;i++) {
                //해당 자동차 배열에 횟수만큼 랜덤 숫자 지정,
                moveCars(carCount,progress);
                printProgress(carNameArray,progress);
            }

            // 배열을 스트림으로 변환해 최대 값 구하기
            int maxProgress= Arrays.stream(progress).max().orElse(0);

            //우승자 배열
            String[] winners=getWinners(carNameArray,progress,maxProgress);
            //우승자 출력
            printWinners(winners);

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
    // 전진 출력
    private static void printProgress(String[] carNameArray,int[] progress){
        StringBuilder result=new StringBuilder();
        for (int i=0;i<carNameArray.length;i++){
            result.append(carNameArray[i]).append(" : ").append("-".repeat(progress[i]));
            if (i < carNameArray.length-1){
                result.append(", ");
            }
        }
        System.out.println(result);
    }

    // 우승자 구하기
    private static String[] getWinners(String[] carNameArray,int[] progress,int maxProgress){
        List<String> winnerList=new ArrayList<>();

        for (int i=0;i<carNameArray.length;i++){
            if (progress[i]==maxProgress){
                winnerList.add(carNameArray[i]);
            }
        }
        return winnerList.toArray(new String[0]);
    }
    //우승자 출력
    private static void printWinners(String[] winners) {
        String winnersString=String.join(",",winners);
        System.out.println("최종 우승자 : "+winnersString);

    }



}
