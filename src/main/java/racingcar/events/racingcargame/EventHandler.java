package racingcar.events.racingcargame;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.racingcargame.Cars;
import racingcar.domain.racingcargame.GameProgress;
import racingcar.domain.racingcargame.Tries;
import racingcar.domain.racingcargame.Winner;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class EventHandler {

    Cars cars;
    Tries tries;
    GameProgress gameProgress;
    Winner winner;
    Validation validation;
    Exception exception;

    public EventHandler() {
        this.cars = new Cars();
        this.gameProgress = new GameProgress();
        this.tries = new Tries();
        this.winner = new Winner();
        this.validation = new Validation();
        this.exception = new Exception();
    }

    //경기 시작!
    public void startPrint(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }


    public void inputName(){
        // 차이름 입력 및 저장
        cars.setCars(readLine().split(","));
        // 차 이름 입력 관련 예외 확인
        exception.inputNameException(cars.getCars());
        // 동일한 이름 있는지 예외 확인
        exception.inputNameSameException(cars.getCars());
    }

    // 시도 입력!
    public void inputTryPrint(){
        System.out.println("시도할 회수는 몇회인가요?");
    }



    public void inputTrySave(){
        // 시도횟수 입력 및 오류 발생 시 예외처리
        tries.setTries(Integer.parseInt(exception.inputTryException(tries.getChk())));
        // 시도횟수가 양수가 아닐 경우 예외처리
        exception.isTryNumberPositive(tries.getTries());
    }

    public void progressPrepare(){
        // 진행 상황 저장 메소드
        gameProgress.setProgress(new String[cars.getCars().length]);
        // 진행 상황 초기화 메소드
        Arrays.fill(gameProgress.getProgress(), "");
    }

    // 게임 진행 메소드 - 랜덤숫자 설정, 게임 진행 상황 저장, 게임 상황 출력
    public void gameProgress(){
        for(int i=0; i< tries.getTries(); i++){
            racingCarGameProgress();
            System.out.println();
        }

    }

    private void racingCarGameProgress() {
        for(int j=0; j<cars.getCars().length; j++){
            // 랜덤 숫자 설정
            gameProgress.setCount(Randoms.pickNumberInRange(0,9));
            // 게임 진행상황 저장
            gameProgress.setProgress(validation.progressValidate(gameProgress.getCount(),
                    gameProgress.getProgress(), j));
            // 현재 자동차의 게임 진행 상황 출력
            racingCarGameProgressPrint(j);
        }
    }

    private void racingCarGameProgressPrint(int j) {
        // 현재 자동차의 게임 진행 상황 출력
        System.out.println(cars.getCars()[j] + " : " + gameProgress.getProgress()[j]);
    }

    public void winnerSelect(){
        //가장 먼 거리 검증 메소드로 확인 후, 설정
        winner.setMax(validation.maxLengthValidate(cars.getCars(), gameProgress.getProgress(),
                winner.getMax()));
        // 우승자 검증 메소드로 확인 후, 설정
        winner.setWinner(validation.winnerValidate(cars.getCars(), gameProgress.getProgress(),
                winner.getWinner(), winner.getMax()));

    }

    private void winnerPrintTuning() {
        if(winner.getWinner().endsWith(", ")){
            winner.setWinner(winner.getWinner().substring(0,winner.getWinner().length()-2));
        }
    }

    public void winnerPrint(){
        // 다수의 우승자가 나올 경우 뒤에 ", "가 붙는 문자를 제거하기 위한 부분
        winnerPrintTuning();
        // 최종 우승자 출력
        System.out.println("최종 우승자 : " + winner.getWinner());
    }



}
