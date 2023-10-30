package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 생성 객체들

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput = Console.readLine();

        Player player = new Player();
        ArrayList<String> carList = player.createPlayerCarList(playerInput);


        // TODO: validates playerCars
        Validators validator = new Validators();
        validator.isListElementOverFive(carList);


        System.out.println("시도할 회수는 몇회인가요?");
        String numberOfLaps = Console.readLine();
        int lapOfRace = player.setLapsOfRace(numberOfLaps);

        // TODO: play racing games for numberOfLaps
        for (int lap=0; lap<lapOfRace; lap++) {

        }

        // TODO: print Winners

    }
}
