# 미션 - 자동차 경주

> 초간단 자동차 경주 게임을 구현한다.

## 🏎️ 경주 진행 방식

1. 경주 시작
2. 사용자 입력
3. 경주 한 차수 진행
4. 현재 차수 상황 출력
5. 3,4를 사용자 입력만큼 반복
6. 경주 결과 출력

## 🚀 구현할 기능 목록

경주 시작
- [x]  `Application`의 `main()` 에서 게임 시작

사용자 입력 받기
- [x]  사용자 입력 안내 콘솔 출력

사용자 입력 처리
- [x]  [예외] 이름 길이 5자 이하
- [x]  [예외] 시도할 횟수가 양의 정수가 아님
- [x]  입력값을 자동차 이름으로 하는 자동차 객체 생성

한 차수 진행
- [x]  0에서 9까지의 정수 중 한 개의 정수 반환
- [x] 4 이상인지 판단
- [x]  자동차 전진 || 움직이지 않음

현재 차수 상황 출력
- [x]  경주 진행 상황 콘솔 출력

경주 결과 출력
- [x]  경주 결과 콘솔 출력

--- 

## ♻️ 리팩터링

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - (`test/java/study` 참고)
