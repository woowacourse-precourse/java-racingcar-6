package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        //        GameController controller = new GameController();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = readLine();
        //        controller.checkCarName(userInput);

        String[] carNames = checkCarName(userInput);
        int numberOfCar = carNames.length;
        System.out.println("시도할 횟수는 몇회인가요?");
        String tryCount = readLine();
        //        controller.checkTries(tryCount);

        int tries = checkTries(tryCount);
        String[] setCarNames = setCarName(carNames);
        int[] forwarded = new int[numberOfCar];

        for (int i = 0; i < tries; i++){
            gameController(forwarded,setCarNames, i, tries);
        }
    }

    /**
     * 전진한 결과, 유저의 차이름들, for구문의 i, 레이싱 회수를 받아서 결과값을 만들고 다른 메소드들을 호출함
     * @param forwarded
     * @param setCarNames
     * @param i
     * @param tries
     */
    private static void gameController(int[] forwarded, String[] setCarNames, int i, int tries) {
        int length = setCarNames.length;

        for (int j = 0; j < length; j++){
            boolean move = isForwardPossible();
            if (!move) continue;
            setCarNames[j] += "-";
            forwarded[j] += 1;
        }

        printRaceResult(setCarNames);

        if (i == tries-1){
            findWinners(forwarded, setCarNames);
        }
    }

    /**
     *  user의 차이름 입력을 받아서 유효한 값인지 확인하고 String[]로 각 유저의 이름을 쪼개서 리턴
     * @param users
     * @return String[] carNames
     */
    private static String[] checkCarName(String users){
        String[] carNames = users.split(",");
        for (String name : carNames) {
            if (name.trim().isEmpty()){
                throw new IllegalArgumentException("정확한 이름을 입력해주세요");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
            }
        }
        return carNames;
    }

    /**
     * String[] 변환 된 유저의 차이름 입력에 " : " 기호 추가
     * @param carName
     * @return String[] carName
     */
    private static String[] setCarName(String[] carName){
        int numberOfCar = carName.length;
        for (int i = 0; i < numberOfCar; i++){
            carName[i] += " : ";
        }
        return carName;
    }

    /**
     * 유저의 시도 횟수 입력을 받아서 유효한 값인지 확인하고 parseInt()를 사용해 int로 변환 후 리턴
     * @param tryCount
     * @return int tries
     */
    private static int checkTries(String tryCount){
        int tries = 0;
        try {
            tries = parseInt(tryCount);
        } catch (Exception e){
            throw new IllegalArgumentException("유효한 숫자를 입력하세요");
        }
        return tries;
    }

    /**
     * 1~9까지 랜덤한 숫자를 생성해 4이상이면 전진 가능 true 리턴 아니면 false 리턴
     * @return boolean
     */
    private static boolean isForwardPossible(){
        int i = Randoms.pickNumberInRange(0,9);
        if (i >= 4){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 레이스 실행에 대한 결과를 출력
     * @param setCarNames
     */
    private static void printRaceResult(String[] setCarNames){
        System.out.println("실행 결과");
        for (String s : setCarNames){
            System.out.println(s);
        }
        System.out.println();
    }

    /**
     * 유저와 레이스 결과를 받아서 우승자가 누군지 판별하고 winners 리스트에 추가
     * @param raceResult
     * @param users
     */
    private static void findWinners(int[] raceResult, String[] users){
        int length = raceResult.length;
        int highestNumber = 0;
        List<String> winners = new ArrayList<>(highestNumber);
        for (int j = 0; j < length; j ++){
            if (raceResult[j] > highestNumber) {
                winners.clear();
                highestNumber = raceResult[j];
            }
            if (raceResult[j] >= highestNumber) {
                winners.add(users[j]);
            }
        }
        printWinners(winners);
    }

    /**
     * 받은 우승자 리스트를 출력
     * @param winners
     */
    private static void printWinners(List<String> winners){
        System.out.print("최종 우승자 : ");
        for (int k = 0; k < winners.size(); k++) {
            System.out.print(winners.get(k).replace(" : ", "").replace("-", ""));
            if (k < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
