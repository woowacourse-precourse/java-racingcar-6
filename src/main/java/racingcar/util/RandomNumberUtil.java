package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 무작위 숫자를 생성하기 위한 유틸 클래스입니다.
 */
public class RandomNumberUtil implements RandomNumber{
        private static RandomNumberUtil instance;

        private RandomNumberUtil(){}

        public static RandomNumberUtil getInstance() {
                if (instance == null) {
                        instance = new RandomNumberUtil();
                }

                return instance;
        }

        /**
         * 0에서 9사이의 무작위 숫자를 반환합니다.
         *
         * @return 숫자
         */
        @Override
        public int pickRandomNumber(){
                return Randoms.pickNumberInRange(0, 9);
        }
}
