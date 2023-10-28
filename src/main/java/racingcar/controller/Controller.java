package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.service.CarManageService;
import racingcar.service.PlayService;
import racingcar.service.WinnerService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Controller {
    private PlayService playService = new PlayService();
    private CarManageService carManageService = new CarManageService();
    private WinnerService winnerService = new WinnerService();

    public Race startGame(){
        Race race = new Race();

        String names = InputView.inputName();
        List<String> carNameList = carManageService.createCarNameList(names);
        race.setCars(carManageService.createCars(carNameList));

        String tryNum = InputView.inputTryNum();
        race.setTryNum(playService.transFromTryNumForInt(tryNum));
        System.out.println();
        return race;
    }

    public void playGame(Race race){
        for(int i = 0; i< race.getTryNum(); i++) {
            playService.playTurn(race);
            OutputView.printAllCarPosition(race);
        }
        carManageService.sortCarsByPoint(race.getCars());
        List<Car> winners = winnerService.makeWinnersList(race, winnerService.getWinnerPoint(race));
        List<String> winnerNames = winnerService.makeWinnerNameList(winners);
        String winnerNamesSTR = winnerService.makeWinnerNameForPrint(winnerNames);
        OutputView.printWinner(winnerNamesSTR);
    }


}
