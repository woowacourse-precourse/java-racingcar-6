package racingcar;

public class CustomView{
    private static final String startAnnouncement = "게임을 시작합니다.";
    private static final String startRoundInput = "시도할 횟수는 몇회 인가요?";
    private static final String startCarInput = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분";
    private static final String gameResult = "실행결과";

    public void printStart(){
        System.out.println(startAnnouncement);
        System.out.println(startCarInput);
    }

    public void printStartRound(){
        System.out.println(startRoundInput);
    }

    public void printGameResult(){
        System.out.println(gameResult);
    }
}
