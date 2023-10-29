package racingcar.controller;

public class RaceController {

    public void race() {
        int tryCount = setupRace();
        raceRound(tryCount);
        printFinalWinner();
    }

    private int setupRace() {
        //TODO: inputView를 통해 시작 메시지 출력

        //TODO: inputView를 통해 사용자로부터 경주 자동차 이름 입력 받기

        //TODO: 시도 횟수 묻는 메시지 출력

        //TODO: 시도횟수 입력 받기

        //TODO: raceService.init(List<String> carList)을 통해 raceService의 hashMap 초기화하기

        //TODO: 시도횟수 반환
        return 0;
    }


    private void raceRound(int tryCount) {
        while (tryCount-- > 0) {
            //TODO: raceService.경주차 이동()을 통해 HashMap의 값 갱신 및 DTO 반환

            //TODO: outputView에 DTO를 전달하여 라운드 진행 상황을 출력
        }
    }

    private void printFinalWinner() {
        //TODO: raceService.getResult()를 통해 최종 우승자 결과를 전달받음 List<String>

        //TODO: outputView.printResult()를 통해 최종 우승자 결과를 출력
    }
}
