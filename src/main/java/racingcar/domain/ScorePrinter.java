package racingcar.domain;


import java.util.List;

public class ScorePrinter {
    CarManager carManager = new CarManager();
    static String MSG_FINAL = "최종 우승자 : ";

    public void printMidtermScore() { //HashMap 데이터를 받음
        carManager.midtermScoreData().forEach((key, value)
                -> System.out.println(key + " : " + "-".repeat(value)));
        System.out.println("");
    }

    public void printFinalScore() { //List<String> 데이터를 받음
        List<String> winnerList = carManager.finalScoreData();

        for (int i = 0; i < winnerList.size(); i++) {
            MSG_FINAL += winnerList.get(i);

            if (i < winnerList.size() - 1) {
                MSG_FINAL += ", ";
            }
        }
        System.out.println(MSG_FINAL);
    }

}
