package racingcar;

import racingcar.playcar.PlayCars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        PlayCars playCars = new PlayCars();

        playCars.input();

        playCars.getResult();

        playCars.getWinner();
    }
}
