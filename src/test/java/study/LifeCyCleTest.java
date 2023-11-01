package study;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCyCleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("LifeCyCleTest.beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("LifeCyCleTest.beforeEach");
    }

    @Test
    void 테스트_실행1() {
        System.out.println("LifeCyCleTest.테스트_실행1");
    }

    @Test
    void 테스트_실행2() {
        System.out.println("LifeCyCleTest.테스트_실행2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("LifeCyCleTest.afterEach");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("LifeCyCleTest.afterAll");
    }
}
