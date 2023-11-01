package model;

public class Game {
    public static int tryCount;

    /** 사용자 시도 횟수 저장 */
    public static void setTryCount(int tryCount) {
        Game.tryCount = tryCount;
    }

    /** 사용자 시도 횟수 얻기 */
    public static int getTryCount() {
        return tryCount;
    }

//    자동차 실행 결과 가공하기()
//    우승자 판단하기()
//    우승자 결과 데이터 가공하기()

}

