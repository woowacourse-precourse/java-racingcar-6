package Game;

import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGame {
        private String[] carName;
        private int[] gameResult;
        private int tryNumber;
        private int count;
        public void startGame() {
            getInput();
            printTotalResult();
            printResult();
        }
        public void getInput() {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
            String answer = readLine();
            carName = answer.split(",");
            System.out.println("시도할 회수는 몇회인가요?");
            String number = readLine();
            tryNumber = Integer.parseInt(number);
            System.out.println(carName[0]);
            count = carName.length;
            gameResult = new int[count];
        }
        public void makeRandomResult() {
            int random;
            for (int i = 0; i < count; i++) {
                random = Randoms.pickNumberInRange(0, 9);
                gameResult[i] += checkRun(random);
            }
        }

        public int checkRun(int number) {
            if (number >= 4) {
                return 1;
            }
            return 0;
        }

        public void printTotalResult() {
            System.out.println("실행 결과");
            for (int i = 0; i < tryNumber; i++) {
                makeRandomResult();
                printEachResult();
                System.out.println();
            }
        }
        public void printEachResult() {
            for (int i = 0; i < count; i++) {
                System.out.print(carName[i] + " : ");
                printDash(gameResult[i]);
            }
        }
        public void printDash(int num) {
            for (int i = 0; i < num; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        public int findMaxRun(){
            int maxnum=0;
            for(int i=0;i<count;i++){
                if(gameResult[i]>maxnum){
                    maxnum=gameResult[i];
                }
            }
            return maxnum;
        }
        public int checkWinnerNum(){
            int maxnum=findMaxRun();
            int winner=0;
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    winner++;
                }
            }
            return winner;
        }
        public void printOneWinner(){
            System.out.print("최종 우승자 : ");
            int maxnum=findMaxRun();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    System.out.println(carName[i]);
                    break;
                }
            }
        }
        public void printOneMoreWinner(){
            System.out.print("최종 우승자 : ");
            int maxnum=findMaxRun();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    System.out.print(carName[i]);
                    maxnum--;
                }
                if(maxnum>0){
                    System.out.print(", ");
                }
            }
        }
        public void printResult(){
            if(checkWinnerNum()==1){
                printOneWinner();
            }else{
                printOneMoreWinner();
            }
        }

}
