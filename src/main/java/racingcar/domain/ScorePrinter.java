package racingcar.domain;


import java.util.List;

public class ScorePrinter {

    CarManager carManager = new CarManager();

    public void printMidtermScore() { //HashMap 데이터를 받음
        carManager.midtermScoreData().forEach((key, value)
                -> System.out.println(key + " : " + "-".repeat(value)));
    }

    public void printFinalScore(){ //List<String> 데이터를 받음
        List<String> winnerList = carManager.finalScoreData();
        String winnerMsg = "최종 우승자 : ";

        for(int i = 0; i<winnerList.size(); i++){
            winnerMsg += winnerList.get(i);
            if(i < winnerList.size()-1){
                winnerMsg += ", ";
            }
        }

        System.out.println(winnerMsg);
    }
}
