package racingcar.controller;

import racingcar.service.RacingService;

public class RacingController {
    RacingService racingService;

    public RacingController() {
        racingService = new RacingService();
    }

    public void settingCars(String userInput){
        racingService.generateCars(userInput);
    }

    public void playRacing(int count){
        System.out.println("\n실행 결과");
        for(int i=0; i<count; i++){
            racingService.playGame();
            racingService.printAllCarsDistance();
            System.out.println();
        }
    }

    public void printWinner(){
        String winner = racingService.selectWinner();
        System.out.println("최종 우승자 : " + winner);
    }
}
