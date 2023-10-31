package racingcar;

import java.util.List;
import java.util.Map;

public class Message {

    //게임 시작전 안내문 출력
    public static void printCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    //차 이동횟수 입력받기
    public static void printMovingNumberMessage() {
        System.out.println("시도할 횟수 몇회인가요?");
    }

    //횟수별 실행결과 출력하기
    public static void printCarRacingResult(int movingNumber, List<String> carList, Map<String, Integer> carRacingRecord) {
        System.out.println("\n실행 결과");
        for(int i=0;i < movingNumber;i++) {
            Application.updateCarRacingRecord(carList,carRacingRecord);
            printCarRacingRecord(carList, carRacingRecord);
            System.out.println();
        }
    }

    //전진 횟수 (-)으로 표시하기
    public static String getRacingRecord(int recordNumber) {
        StringBuilder racingRecord = new StringBuilder();
        for(int i=0;i<recordNumber;i++) {
            racingRecord.append("-");
        }
        return racingRecord.toString();
    }

    //전진이 된 차 기록 출력하기
    public static void printCarRacingRecord(List<String> carList, Map<String,Integer> carRacingRecord) {
        for(String carName : carList) {
            String racingRecord = getRacingRecord(carRacingRecord.get(carName));
            System.out.println(carName+" : "+racingRecord);
        }
    }

    //결과 출력
    public static void printGameResult(List<String> carList, Map<String, Integer> carRacingRecord) {
        int maxRecord = 0;
        for(String carName : carList) {
            String racingRecord = getRacingRecord(carRacingRecord.get(carName));
            maxRecord = Math.max(maxRecord,racingRecord.length());
        }
        List<String> winners = RacingCar.getWinner(carRacingRecord,maxRecord);
        StringBuilder winnerName= new StringBuilder();
        for(int i=0;i<winners.size()-1;i++) {
            winnerName.append(winners.get(i)+", ");
        }
        winnerName.append(winners.get(winners.size()-1));
        System.out.println("최종 우승자 : "+winnerName.toString());
    }

}


