package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();  // 게임 객체
        readyGame(game);
        startGame(game);
    }

    private static void startGame(Game game) {
        // 게임 횟수
        System.out.println("실행 결과");
        for(int gameCount = game.getGameCount(); gameCount >= 0; gameCount--){
            // 차 별 랜덤 주행거리 업데이트
            game.runGame();
        }
        // 최종 결과 출력
        game.printFinalGameResult();
    }

    public static void readyGame(Game game){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        game.setCars(getCars());

        System.out.println("시도할 회수는 몇회인가요?");
        game.setGameCount(getGameCount());
    }

    public static List<Car> getCars(){
        List<Car> cars;
        try{
            String[] carNames = Console.readLine().split(",");
            cars = new ArrayList<>();
            for (String carName : carNames) { // 이름은 5자 이하만 가능
                if(carName.equals("") || carName.length() > 5){
                    throw new IllegalArgumentException();
                }
                cars.add(new Car(carName));
            }
        } catch (Exception e){
            throw new IllegalArgumentException();
        }

        return cars;
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
