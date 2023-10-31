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
        //input
        private void getInput() throws IllegalArgumentException{
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기분으로 구분)");
            getInputCarName();
            System.out.println("시도할 회수는 몇회인가요?");
            getInputTryNumber();
            gameResult = new int[count];
        }

        //game service
        private void makeRandomResult() {
            int random;
            for (int i = 0; i < count; i++) {
                random = Randoms.pickNumberInRange(0, 9);
                gameResult[i] += checkRun(random);
            }
        }

        private int checkRun(int number) {
            if (number >= 4) {
                return 1;
            }
            return 0;
        }

        private void printTotalResult() {
            System.out.println("실행 결과");
            for (int i = 0; i < tryNumber; i++) {
                makeRandomResult();
                printEachResult();
                System.out.println();
            }
        }
        private void printEachResult() {
            for (int i = 0; i < count; i++) {
                System.out.print(carName[i] + " : ");
                printDash(gameResult[i]);
            }
        }
        private void printDash(int num) {
            for (int i = 0; i < num; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        private int findMaxRun(){
            int maxnum=0;
            for(int i=0;i<count;i++){
                if(gameResult[i]>maxnum){
                    maxnum=gameResult[i];
                }
            }
            return maxnum;
        }
        private int checkWinnerNum(){
            int maxnum=findMaxRun();
            int winner=0;
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    winner++;
                }
            }
            return winner;
        }
        private void printOneWinner(){
            System.out.print("최종 우승자 : ");
            int maxnum=findMaxRun();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    System.out.println(carName[i]);
                    break;
                }
            }
        }
        private void printOneMoreWinner(){
            System.out.print("최종 우승자 : ");
            int maxnum=findMaxRun();
            int check=checkWinnerNum();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    System.out.print(carName[i]);
                    check--;
                }
                if(check>0){
                    System.out.print(", ");
                }
            }
        }
        private void printResult(){
            if(checkWinnerNum()==1){
                printOneWinner();
            }else{
                printOneMoreWinner();
            }
        }
        private void getInputCarName() throws IllegalArgumentException{
            String answer = readLine();
            carName = answer.split(",");
            count = carName.length;
            for(int i=0;i<count;i++){
                if(carName[i].length()>5){
                    throw new IllegalArgumentException();
                }
            }
        }

        private void getInputTryNumber() throws IllegalArgumentException{
            try{
                String number = readLine();
                tryNumber = Integer.parseInt(number);
                if(tryNumber<=0){
                    throw new IllegalArgumentException();
                }
            }catch(Exception e){
                throw new IllegalArgumentException();
            }
        }
}
