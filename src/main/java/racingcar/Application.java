package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dao.RacingCarInformationDao;
import racingcar.dao.WinnerInformationDao;
import racingcar.service.GameGuideTextPrintService;
import racingcar.service.ProgressCheckService;
import racingcar.service.RacingCarNameAddService;
import racingcar.service.RacingCarNameScanService;
import racingcar.service.TryNumberScanService;
import racingcar.service.TryNumberStringToIntService;
import racingcar.service.WinnerInformationAddService;
import racingcar.service.WinnerInformationPrintService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 자동차 이름을 저장할 객체
        RacingCarInformationDao racingCarInformationDao = new RacingCarInformationDao();

        // 우승 자동차 이름을 저장할 객체
        WinnerInformationDao winnerInformationDao = new WinnerInformationDao();

        // 게임 진행 도와주는 텍스트 출력 객체
        GameGuideTextPrintService gameGuideTextPrintService = new GameGuideTextPrintService();

        // 자동차 이름 입력하시오
        gameGuideTextPrintService.inputCarName();

        // 자동차 이름 입력받음.
        RacingCarNameScanService racingCarNameScanService = new RacingCarNameScanService();
        racingCarNameScanService.readRacingCarNames();

        // 자동차 이름 저장.
        RacingCarNameAddService racingCarNameAddService = new RacingCarNameAddService(racingCarNameScanService, racingCarInformationDao);
        racingCarNameAddService.add();

        // 시도 횟수 입력하시오
        gameGuideTextPrintService.inputTryNumber();

        // 시도 횟수 입력받음.
        TryNumberScanService tryNumberScanService = new TryNumberScanService();
        tryNumberScanService.readTryNumber();

        // 입력받은 시도 횟수 자료형 변환
        TryNumberStringToIntService tryNumberStringToIntService = new TryNumberStringToIntService(tryNumberScanService);
        tryNumberStringToIntService.execute();

        gameGuideTextPrintService.gameResult();

        // 게임진행
        ProgressCheckService progressCheckService = new ProgressCheckService(racingCarInformationDao);
        progressCheckService.execute();

        // 우승 자동차 저장
        WinnerInformationAddService winnerInformationAddService = new WinnerInformationAddService(winnerInformationDao, racingCarInformationDao);
        winnerInformationAddService.add();

        gameGuideTextPrintService.gameWinner();

        WinnerInformationPrintService winnerInformationPrintService = new WinnerInformationPrintService(winnerInformationDao);
        winnerInformationPrintService.print();

    }
}
