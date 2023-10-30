package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.service.Game;

public class GameController {
    private Game game = new Game();

    public void setUp(String participants){
        game.setUp(Arrays.stream(participants.split(",")).map(str->str.trim())
                .collect(Collectors.toList()));
    }

    public void startGame(Integer numberOfAttempt){
        System.out.println();
        System.out.println("실행 결과");
        for(int i = 0; i<numberOfAttempt; i++){
            game.moveForwardAttemptCars();
            printCars();
        }
    }

    public void printCars(){
        for(Car car: game.getCars()){
            System.out.print(car.getName()+" : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    public void printPosition(Integer position){
        for(int i = 0; i<position; i++){
            System.out.print("-");
        }
    }

    public void printFinalists(){
        List<String> finalists = game.getFinalists();

        System.out.print("최종 우승자 : ");
        for(int i = 0; i<finalists.size()-1; i++){
            System.out.print(finalists.get(i)+", ");
        }
        System.out.println(finalists.get(finalists.size()-1));
    }
}
