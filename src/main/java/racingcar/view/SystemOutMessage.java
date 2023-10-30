package racingcar.view;

public class SystemOutMessage {

    public static void RaceMessage(String[] carNames, String[] raceLog){
        System.out.println("실행 결과");
    }

    public static void RaceMessage(String carName, String raceLog, int i){
        System.out.println("실행 결과");
    }



    public void RaceResultMessage(String[] prizeWinner){
        System.out.println("최종 우승자 : "+prizeWinner);

    }
}
