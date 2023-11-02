package racingcar;

public class GameController {
        private final GameService gameService = new GameService();
        public void run(){
            setGame();
            playGame();
            printWinner();
        }

        public void setGame() {
            gameService.initializeGameParameters();
        }

        public void playGame() {
            gameService.startGame();
        }
        public void printWinner(){
            gameService.compareAndPrintWinner();
        }
    }