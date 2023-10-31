package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Race;
import racingcar.util.InputValidation;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class Game {
    private Race race;
    public Game() {
        race = new Race();
    }

    public void gameStart(){ //게임 시작
        setRace();
        runRace();
        printRaceResult();
    }

    private void setRace() { //레이스 세팅
        List<String> carNameList = makeCarNameList();
        String roundsInput = Input.inputRounds();
        InputValidation.checkRaceRoundInput(roundsInput);
        int raceRounds = Integer.parseInt(roundsInput);
        race.setCarList(carNameList);
        race.setRaceRounds(raceRounds);
    }

    private List<String> makeCarNameList() {
        String carNames = Input.inputCarNames();
        String[] carNameArray = carNames.split(",");
        List<String> carNameList = List.of(carNameArray);
        for (String carName : carNameList) {
            InputValidation.checkNameLength(carName);
        }
        return carNameList;
    }

    private void runRace(){ //각 라운드 시작
        Output.printRaceStart();
        while (!race.isRaceFinished()) {
            race.playOneRound();
            printRoundResult(race.getCarList());
        }
    }

    private void printRoundResult(List<Car> carList) {
        for (Car car : carList){
            Output.printCarResult(car.getCarName(), car.getMoveLength());
        }
        Output.roundFinish();
    }

    private void printRaceResult() { //레이스 결과 출력
        List<String> raceResult = race.getRaceResult();
        Output.printRaceResult(raceResult);
    }
}
