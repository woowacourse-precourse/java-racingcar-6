package racingcar;

public class GameController {
        private final GameService gameService = new GameService();
        public void run(){
            setGame();
            play();
            printWinner();
        }

        public void setGame() {
            gameService.initializeGameParameters();
        }

        public void play() {
            gameService.startGame();
        }
        public void printWinner(){
            gameService.compareAndPrintWinner();
        }
    }