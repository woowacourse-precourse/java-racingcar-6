package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.*;
import racingcar.view.PrintInput;
import racingcar.view.PrintOutput;
import racingcar.view.PrintResult;

import java.util.List;

public class PlayGame {
    public List<Car> settingcar(){
        PrintInput.inputCar();
        String input_carName = Console.readLine();
        CreateCar createCar = new CreateCar();
        return createCar.createCar(input_carName);
    }

    public int numberOfGame(){
        PrintInput.inputNumberOfMove();
        String input = Console.readLine();
        return ValidCheck.moveTypeCheck(input);
    }

    public void play(){
        List<Car> car_list = settingcar();
        int game = numberOfGame();

        for (int i = 0; i<game; i++){
            CarMove.move(car_list);
            PrintOutput.printAllMove(car_list);
        }

        List<String> winner = FindWinner.findWinner(car_list);
        PrintResult.printWinner(winner);
    }
}
