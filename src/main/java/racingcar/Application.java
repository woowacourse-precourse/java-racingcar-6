package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        /*
          car class (완료)
          round class (완료)
          mainGame class
          customException class
          customInput class (-ing)
         */
    }
    public static class MainGame{
        private CustomView customView;

        public void run(){
            customView.printStart();
            String[] players = customView.strSplit(Console.readLine());
            customView.printStartRound();
            int inputRound = Integer.parseInt(Console.readLine());
            Round round = new Round(inputRound);

        }

    }
}
