package racingcar.user;
import camp.nextstep.edu.missionutils.Console;
import racingcar.car.Car;

import java.util.List;

public class User extends Validator{
    public List<String> carNameInput(){
        System.out.println(MessageConstant.GAME_START_MESSAGE.getMessage());
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(","));

        for(String i:carNames){
            carNameCheck(i);
        }
        duplicatedNameCheck(carNames);
        return carNames;
    }
    public int gameRoundInput(){
        System.out.println(MessageConstant.ROUND_SELECT_MESSAGE.getMessage());
        String input = Console.readLine();
        gameRoundCheck(input);
        return Integer.parseInt(input);
    }
    public void gameRoundOutput(List<Car> carList){
        for(Car i : carList){
            String printFormat = i.getName()+" : "+"-".repeat(i.getScore());
            System.out.println(printFormat);
        }
        System.out.println();
    }
    public void gameWinnerOutput(List<String> winnerList){
        String result = String.join(", ", winnerList);
        System.out.println(MessageConstant.WINNER_MESSAGE.getMessage()+result);
    }

}
