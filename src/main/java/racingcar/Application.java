package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        readyGame(game);
    }

    public static void readyGame(Game game){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();

        System.out.println("시도할 회수는 몇회인가요?");
        game.setGameCount(getGameCount());
    }

    public static int getGameCount(){
        String userInput = Console.readLine();
        if(UserInputIsInteger(userInput)){
            return Integer.parseInt(userInput);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static boolean UserInputIsInteger(String userInput){
        try{
            Integer.parseInt(userInput);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
