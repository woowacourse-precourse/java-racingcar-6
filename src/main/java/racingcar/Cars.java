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

            System.out.println(CarName + ":" + moveCount);
        }

        moveCountList = moveCountList.subList(0,carNames.length);   //나온 차수만큼 나누기
        CarNameList = CarNameList.subList(0, carNames.length);
    }
}