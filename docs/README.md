## 📌 기능 목록

### Car
- [x] 자동차 이름을 가짐
- [x] 전진 위치를 가짐


### Input
- [x] 자동자 이름을 입력 받음
  - [x] 쉼표를 통해 구분
- [x] 전진 시도 횟수(게임 횟수)를 입력 받음
- [x] 입력받는 값은 [우테코에서 제공하는 라이브러리](https://github.com/woowacourse-projects/mission-utils#mission-utils) `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용


### Output
- [x] 차수별 실행 결과 출력
- [x] 우승자 안내 문구를 출력


### Exception Check
- [x] 자동차 이름 입력값 검증
  - [x] 자동차 이름이 없는 경우 예외 처리
  - [x] 자동차 이름에 공백이 포함될 경우 예외 처리
  - [x] 5자 초과 입력할 경우 예외 처리
  - [x] 중복된 자동차 이름이 있을 경우 예외 처리
- [x] 전진 시도 횟수(게임 횟수) 입력값 검증
  - [x] 입력된 값이 없을 경우 예외 처리 
  - [x] 입력된 값이 숫자가 아닐 경우 예외 처리
- [x] 예외 처리 방식 : `IllegalArgumentException` 발생시킨 후 애플리케이션 종료


### Application
- [x] Game Controller 실행


### Game Controller
- [x] 자동차 생성 명령
- [x] 전진 시도 횟수 설정 명령
- [x] 자동차 경주 실행 명령 (게임 로직 실행)
- [x] 실행 결과 출력 명령
- [x] 게임 결과 출력 명령


### Racing Game
- [x] 게임 횟수를 가짐
- [x] 게임 회차 별 자동차별 랜덤 숫자 생성 (0부터 9까지의 숫자 한개)
  - [x] 랜덤값 추출은 [우테코에서 제공하는 라이브러리](https://github.com/woowacourse-projects/mission-utils#mission-utils) `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
- [x] 게임 회차 별 생성된 랜던 값이 4 이상인 자동차의 전진 횟수 증가
- [x] 회차별 실행 결과 Game Controller 전달
- [x] 모든 회자 실행 결과로 우승자 선정