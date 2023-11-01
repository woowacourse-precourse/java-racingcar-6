package racingcar;

import racingcar.playcar.PlayCars;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayCars playCars = new PlayCars(scanner);

        playCars.input();

        playCars.getResult();

        playCars.getWinner();
    }
}
