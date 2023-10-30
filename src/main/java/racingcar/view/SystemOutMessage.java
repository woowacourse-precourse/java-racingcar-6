package racingcar.view;

public class SystemOutMessage {

    public static void RaceOngoingMessage(String[] carNames, String[] raceLog){
        System.out.println("실행 결과");
        for(int i=0;i<carNames.length;i++){
            System.out.println(carNames[i]+" : "+ raceLog[i]);
        }
    }
    public void RaceResultMessage(String[] prizeWinner){
        System.out.println("최종 우승자 : "+prizeWinner);

    }
}
