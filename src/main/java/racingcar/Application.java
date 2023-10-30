package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static RacingCarController racingCarController = new RacingCarController();

    public static void main(String[] args) {
        try{
            racingCarController.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
