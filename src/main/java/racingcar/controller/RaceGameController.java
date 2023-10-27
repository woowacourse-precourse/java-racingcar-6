package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGameController {
    private InputView inputView;
    private OutputView outputView;

    public RaceGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startGame() {
        inputView.printStartMessage();
        //차후 보완
        String names = Console.readLine();
        RacingCars racingCars = new RacingCars();
        Referee referee = new Referee();

        racingCars.carCreator(splinter(names));
        System.out.println(splinter(names));
        inputView.printLoopSetMessage();
        int loop = Integer.parseInt(Console.readLine());
        //실행시작
        outputView.printFirstResultMessage();
        for(int i = 0 ; i < loop; i++){
            playingGame(racingCars);
        }
        referee.findWinnerStep(racingCars);
        // --를 통한 분한
        List<String> nameList = referee.winnerNameList(racingCars);
        if(nameList.size()==1){
            outputView.printWinnerResult(nameList.get(0));
        }
        if(nameList.size() > 1){
            outputView.printJointWinnerResult(nameList);
        }
        // outputView
    }

    public void playingGame(RacingCars racingCars) {
        for(Car car: racingCars.getAllCars()){
            car.moveIfRandomSuccess();
            outputView.printRaceStatusMessage(car);
        }
    }

    public List<String> splinter(String name) {
        return Arrays.stream(name.split(","))
                .collect(Collectors.toList());
    }
}
