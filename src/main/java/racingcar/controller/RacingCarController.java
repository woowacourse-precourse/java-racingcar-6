package racingcar.controller;

import racingcar.service.GearShifting;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        String cars = inputView.readRaceCarNames();
        String[] names = cars.split(",");
        int round = Integer.parseInt(inputView.readRaceRound());

        // 각각의 racer 초기화
        Map<String, Integer> position = new HashMap<>();
        for(String name: names){
            position.put(name, 0);
        }

        outputView.printExecution();
        // 라운드 별 각각의 레이서 결과 출력
        for (int i=0 ; i < round ; i++){
            play(position);
            outputView.printResult(position);
            System.out.println();
        }
    }

    private void play(Map<String, Integer> position) {
        for (String name : position.keySet()){
            if (GearShifting.moveForward()) {
                playMoveForward(position, name);
            }
        }
    }

    private void playMoveForward(Map<String, Integer> position, String name){
        position.put(name, position.get(name) + 1);
    }
}
