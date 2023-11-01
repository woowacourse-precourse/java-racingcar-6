package racingcar;


import controller.RacingcarController;

/*
 * 클래스 이름 : Application
 *
 * 버전 정보 : Java 17
 *
 * 최종 수정날짜 : 2023-11-01
 *
 * 내용 : 가장 앞단에서 실행되는 클래스
 *
 * 작성자 : 문재경
 */
public class Application {
    public static void main(String[] args) {
        RacingcarController rc = new RacingcarController();
        rc.run();
    }
}
