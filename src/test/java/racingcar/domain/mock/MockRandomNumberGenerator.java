
package racingcar.domain.mock;

import racingcar.domain.random.RandomNumberGenerator;

import java.util.LinkedList;
import java.util.Queue;

public class MockRandomNumberGenerator implements RandomNumberGenerator {

        private final Queue<Integer> numbers;

        private MockRandomNumberGenerator(Queue<Integer> numbers) {
            this.numbers = numbers;
        }

        public static RandomNumberGenerator setNumbers(int... numbers) {
            Queue<Integer> queue = new LinkedList<>();
            for (int number : numbers) {
                queue.add(number);
            }
            return new MockRandomNumberGenerator(queue);
        }

        @Override
        public int getRandomNumber() {
            if (!numbers.isEmpty()) {
                return numbers.remove();
            }
            throw new IllegalArgumentException("숫자가 더이상 존재하지 않음");
        }
    }