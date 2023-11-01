package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Integer> moveCountList = new ArrayList<>(); //전역변수 설정
    private List<String> CarNameList = new ArrayList<>(); //전역변수 설정
    private List<String> winners = new ArrayList<>(); //전역변수 설정
    private final String[] carNames;
    private int firstMagicNumber = 0;
    private int lastMagicNumber = 9;

    public Cars() {
        String carNames = Console.readLine();
        nameLengthError(carNames);
        emptyError(carNames);
        this.carNames = carNames.split(",");
    }
    public void nameLengthError(String carNames){  //길이가 5글자 이상일 때
        String[] carNamesArray = carNames.split(",");
        for (String oneCarName : carNamesArray) {
            if (oneCarName.length() > 5) {
                throw new IllegalArgumentException(ExceptionError.nameLengthError);
            }
        }
    }

    public void emptyError(String carNames){ // 공백을 입력했을 때
        String[] carNameArray = carNames.split(",");
        for (String oneCarName : carNameArray) {
            if (oneCarName.trim().isEmpty()) {
                throw new IllegalArgumentException(ExceptionError.emptyError);
            }
        }
    }

    public int randomNumber(){
        return Randoms.pickNumberInRange(firstMagicNumber,lastMagicNumber);
    }

    public void moveCar() {
        for (int i = 0; i < carNames.length; i++) {

            if (randomNumber() > 3) {     //3보다 크면 -를 추가
                carNames[i] += "-";     //car의 이름이 하나의 배열을 가지고 있고 그 배열에서 추가
            }

            int distinctionNumber = carNames[i].indexOf("-"); // 위치

            if(distinctionNumber == -1){
                distinctionNumber = carNames[i].length();
            }

            String CarName = carNames[i].substring(0,distinctionNumber); //차의 원래값
            String moveCount = carNames[i].substring(distinctionNumber, carNames[i].length());

            moveCountList.add(i, moveCount.length()); //움직인 횟수 넣기
            CarNameList.add(i,CarName);

            System.out.println(CarName + " : " + moveCount);
        }

        moveCountList = moveCountList.subList(0,carNames.length);   //나온 차수만큼 나누기
        CarNameList = CarNameList.subList(0, carNames.length);
    }

    public void winnerCar() {
        int maxDistance = -1; // 현재 최대 이동 거리
        //전역변수로 설정한 winners에 승자 이름 저장
        for(int i = 0; i < carNames.length; i++) {
            int moveDistance = moveCountList.get(i);

            if (moveDistance > maxDistance) {
                // 더 큰 이동 거리를 발견하면 승자 목록을 초기화하고 현재 차를 승자로 추가
                maxDistance = moveDistance;
                winners.clear();
                winners.add(CarNameList.get(i));
            } else if (moveDistance == maxDistance) {
                // 현재 최대 이동 거리와 같은 이동 거리를 가지는 차를 승자 목록에 추가
                winners.add(CarNameList.get(i));
            }
        }
    }
    public void printWinnerCar(){
        if(winners.size() == 1){

            System.out.println("최종 우승자 : " + winners.get(0)); // 승자가 한명일 때
        }

        if(winners.size() != 1){
            String result = "";
            for(int i = 0; i< winners.size(); i++){
                result += winners.get(i) + ", ";
            }
            System.out.println("최종 우승자 : " + result.substring(0, result.length() - 2)); //승자가 두명 이상일 떄
        }
    }
}