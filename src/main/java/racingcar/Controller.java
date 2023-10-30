package racingcar;


public class Controller {
    Generator generator = new Generator();
    int A = 0;

    private boolean judgeNumber() {
        int randomNumber = generator.numberGenerator();
        return randomNumber >=4;
    }

    private void moving () {
        if(judgeNumber()) {
            A += 1;
        }
    }

    public void replay () {

    }

    public void judgeWinner () {

    }
}
