package racingcar;

import util.Converter;

public class Application {

    public static void main(String[] args) {
        Input input = new Input();
        String carsName = input.carsName();
        String tryNumString = input.tryNum();
        int tryNum = Converter.stringToInt(tryNumString);

        RaceGame raceGame = new RaceGame();
        raceGame.run(carsName, tryNum);
    }
}
