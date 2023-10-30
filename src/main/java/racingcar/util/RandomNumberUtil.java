package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil implements RandomNumber{
        private static RandomNumberUtil instance;

        private RandomNumberUtil(){}

        public static RandomNumberUtil getInstance() {
                if (instance == null) {
                        instance = new RandomNumberUtil();
                }

                return instance;
        }

        @Override
        public int pickRandomNumber(){
                return Randoms.pickNumberInRange(0, 9);
        }
}
