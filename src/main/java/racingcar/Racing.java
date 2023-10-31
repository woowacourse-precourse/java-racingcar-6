package racingcar;

import java.util.ArrayList;

public class CarRacingGame {

    private static String[] racerNameArray;
    private int round;
    ArrayList<Racer> userArray = new ArrayList<>();
    CarRacingGame(String[] racerNameArray, int round) {
        this.racerNameArray = racerNameArray;
        this.round = round;
    }

    public void CarRacingGameStart() {
        for (int i = 0; i < racerNameArray.length; i++) {
            Racer racer = new Racer(racerNameArray[i]);
            userArray.add(racer);
        }
        raceStart(racerNameArray, round);
        Result result = new Result(userArray);
        result.finalWinner();
    }

    public void raceStart(String[] racerNameArray, int round) { // 전진 하라
        for (int i = 0; i < round; i++) {
            goRace(racerNameArray);
            System.out.println();
        }
    }

    private void goRace(String[] racerNameArray) {
        for (int i = 0; i < racerNameArray.length; i++) {
            resultPrint(i);
        }
    }

    private void resultPrint(int i) {
        Dice dice = new Dice();
        int randomNumber = dice.getDice();
        if (randomNumber > 3) {
            userArray.get(i).setDistance("-");
            userArray.get(i).setCount();
        }
        System.out.println(userArray.get(i).getName() + " : " + userArray.get(i).getDistance());
    }

}
