package racingcar;

public class OutputView {

    public void raceOutput(String currentCarNameAndPosition){
        System.out.println(currentCarNameAndPosition + "\n");
    }

    public void winnerOutput(String winnerList){
        System.out.println("최종 우승자 : " + winnerList);
    }
}
