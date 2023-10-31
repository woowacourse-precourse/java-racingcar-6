package racingcar;

import java.util.ArrayList;

public class Racing {

    private static final int RACE_CONDITION = 3;
    private static String[] raceCarNameArray;
    private int round;
    private ArrayList<Car> carArray = new ArrayList<>();

    Racing(String[] raceCarNameArray, int round) {
        this.raceCarNameArray = raceCarNameArray;
        this.round = round;
        for (int i = 0; i < raceCarNameArray.length; i++) {
            Car car = new Car(raceCarNameArray[i]);
            carArray.add(car);
        }
    }

    public void CarRacingGameStart() {
        raceStart(raceCarNameArray, round);
        Result result = new Result(carArray);
        result.finalWinner();
    }

    public void raceStart(String[] racerNameArray, int round) {
        for (int i = 0; i < round; i++) {
            goRace(racerNameArray);
            System.out.println();
        }
    }

    private void goRace(String[] racerNameArray) {
        for (int i = 0; i < racerNameArray.length; i++) {
            getRoundResults(i);
        }
    }

    private void getRoundResults(int i) {
        Dice dice = new Dice();
        int randomNumber = dice.getDice();
        if (randomNumber > RACE_CONDITION) {
            carArray.get(i).setDistance("-");
            carArray.get(i).setCount();
        }
        System.out.println(carArray.get(i).getName() + " : " + carArray.get(i).getDistance());
    }

}
