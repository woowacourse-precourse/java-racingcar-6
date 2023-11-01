package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static String[] getUserCarList(String carNames){
        String[] carList = carNames.split(",");
        checkError(carList);
        return carList;
    }

    public static void checkError(String[] carList){
        for (String s : carList) {
            if (s.length() > 5) throw new IllegalArgumentException("6자 이상인 이름이 존재합니다");
        }
    }

    public static int getUserRaceNum(){
        System.out.println("시도할 회수는 몇회인가요?");
        int raceNum = Integer.parseInt(Console.readLine());
        return raceNum;
    }

    public static void setRandomNum(int[] raceResult){
        for ( int j = 0 ; j < raceResult.length ; j++ ){
            int temp = Randoms.pickNumberInRange(0,9);
            if ( temp >= 4 ) raceResult[j]++;
        }
    }

    public static void printRaceResult(String[] carList, int[] raceResult){
        for ( int j = 0 ; j < carList.length ; j++ ){
            System.out.print(carList[j] + " : ");
            for ( int k = 0 ; k < raceResult[j] ; k++ ){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findMax(int[] raceResult){
        int max = 0;
        for (int j : raceResult) {
            if (j >= max) max = j;
        }
        return max;
    }

    public static void printWinner(int max, String[] carList, int[] raceResult){
        System.out.print("최종 우승자 : ");
        int flag = 0;
        for ( int i = 0 ; i < carList.length ; i++ ){
            if ( raceResult[i] == max && flag == 0 ){
                System.out.print(carList[i]);
                flag = 1;
            }
            else if ( raceResult[i] == max && flag == 1 ){
                System.out.print(", " + carList[i]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carList = getUserCarList(carNames);
        int[] raceResult = new int[carList.length];
        int raceNum = getUserRaceNum();

        System.out.println("실행 결과");
        for (int i = 0 ; i < raceNum ; i++ ){
            setRandomNum(raceResult);
            printRaceResult(carList, raceResult);
        }

        printWinner(findMax(raceResult), carList, raceResult);

    }
}
