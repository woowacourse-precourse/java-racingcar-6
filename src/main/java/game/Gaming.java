package game;

import java.util.Map;

public class Gaming {

    Map<String, Integer> carsMap = null;
    InGame inGame = null;

    public Gaming(Map<String, Integer> carsMap) {
        this.carsMap = carsMap;
        this.inGame = new InGame(carsMap);
    }

    public void playGame(int tryNum) {
        int cnt = 0;

        while (cnt<tryNum) {
            inGame.addCarsMapStep();
            printStepResult();
            cnt++;
        }
    }

    public void printStepResult () {
        for (String car : carsMap.keySet()) {
            System.out.println(car + " : " + inGame.getStepString(car));
        }
        System.out.println();
    }

    public void printFinalWinner() {
        String[] winnerArr = inGame.getFinalWinner(inGame.getMaxStep());
        System.out.print("최종 우승자 : " + winnerArr[0]);
        for (int i=1; i<winnerArr.length; i++) {
            System.out.print("," + winnerArr[i]);
        }
    }
}
