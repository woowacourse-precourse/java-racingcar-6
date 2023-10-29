package Game;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
        private String[] carName;
        private int tryNumber;

        public void startGame(){
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
            String answer=readLine();
            carName=answer.split(",");
            System.out.println("시도할 회수는 몇회인가요?");
            String number=readLine();
            tryNumber=Integer.parseInt(number);
        }
}
