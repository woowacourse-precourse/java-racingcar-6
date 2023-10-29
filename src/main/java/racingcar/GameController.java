package racingcar;

public class GameController {
        private final GameService gameService = new GameService();

        public void run(){
            setGame();//input요소들
            play();//게임플레이(2.1)
            printWinner();//게임결과 출력(3.1)
        }

        public void setGame() {
            gameService.input();
        }

        public void play() {
            gameService.startGame();
        }
        public void printWinner(){

        }
    }