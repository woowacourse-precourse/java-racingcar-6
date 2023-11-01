package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.Parser;
import racingcar.view.RacingCarPrint;

import java.util.ArrayList;
import java.util.List;

import static racingcar.util.RandomUtil.setRandomNumber;

public class RacingCarService {
    final int start = 0;
    final int end = 9;
    Game game = new Game();
    RacingCarPrint racingCarPrint = new RacingCarPrint();
    Parser parser = new Parser();
    public void setGame() {
        // 자동차 이름 받고 게임 객체에 셋팅
        game.setCarList(setCars(inputCarNames()));
        // 시도 횟수 받기
        game.setGameCount(inputGameCount());
    }

    public void playGame() {
        racingCarPrint.printResultMention();
        for(int i = 0; i < game.getGameCount(); i++){
            play(start, end);
        }
    }

    private void play(int start, int end){
        for(int i = 0; i < game.getCarList().size(); i++){
            if(setRandomNumber(start, end)>=4){
                game.getCarList().get(i).upGoCount();
            }
        }
        racingCarPrint.printResultAll(game.getCarList());
    }

    private String[] inputCarNames(){
        racingCarPrint.printStartMention();
        String input = Console.readLine();
        return parser.parserCarInput(input);
    }

    private List<Car> setCars(String[] carNames){
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < carNames.length; i++){
            Car car = new Car();
            car.setCarName(carNames[i]);
            carList.add(car);
        }
        return carList;
    }

    private int inputGameCount(){
        racingCarPrint.printGameCountMention();
        String input = Console.readLine();
        return parser.parserCountInput(input);
    }

    public List<String> judgeWinner() {
        List<Car> carList = game.getCarList();
        int max = Integer.MIN_VALUE;
        ArrayList<String> winners = new ArrayList<>();

        for(Car car : carList){
            if(car.getGoCount()>max){
                max = car.getGoCount();
            }
        }
        for(Car car : carList){
            if(car.getGoCount() == max) winners.add(car.getCarName());
        }
        return winners;
    }
}
