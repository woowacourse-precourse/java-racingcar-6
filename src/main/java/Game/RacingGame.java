package Game;

import camp.nextstep.edu.missionutils.Randoms;

import static Game.Constants.*;
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
            System.out.println(STARTMESSAGE);
            getInputCarName();
            System.out.println(TRYNUMBERMESSAGE);
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
            System.out.println(RESULTPRINT);
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
                System.out.print(DASH);
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
            System.out.print(WINNERRESULT);
            int maxnum=findMaxRun();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum){
                    System.out.println(carName[i]);
                    break;
                }
            }
        }
        private void printOneMoreWinner(){
            System.out.print(WINNERRESULT);
            int maxnum=findMaxRun();
            int winnerNum=checkWinnerNum();
            for(int i=0;i<count;i++){
                if(gameResult[i]==maxnum&&winnerNum>1) {
                    System.out.print(carName[i]);
                    System.out.print(COMMASPACE);
                    winnerNum--;
                }else if(gameResult[i]==maxnum){
                    System.out.print(carName[i]);
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
            carName = answer.split(COMMA);
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
