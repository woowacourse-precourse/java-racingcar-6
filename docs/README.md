## 기능 목록

- 사용자로부터 시도할 총 횟수와 자동차 이름을 입력받아 저장한다.
    - 자동차 이름을 받아 파싱해 racingCar 객체에 저장한다.
    - 시도할 총 횟수를 저장한다.
    - 1자 이상, 5자 이하의 정상적인 이름인지 확인한다.
    - 잘못됫 값을 입력할 경우 `IllegalArgumentException`을 발생시키고 애플리케이션을 종료한다.
- 주어진 횟수동안 자동차가 전진하거나 멈춘 결과를 출력한다.
    - 0에서 9 사이의 무작위 값을 구한다.
    - 무작위 값이 4 이상일 경우 전진한다.
    - 자동차 이동 거리에 따라 "-"를 생성하여 출력한다.
- 자동차 경주에 참여한 자동차 중에서 우승자를 찾는다.
    - 이동 거리가 가장 큰 자동차를 찾아 자동차 이름을 출력한다.
    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 예외처리
    - 입력된 내용이 쉼표(,)로 끝나는 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름이 1자 이상, 5자 이하인지 확인, 아닐 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름 중 중복된 이름이 있을 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름에 공백이 있을 경우 `IllegalArgumentException`을 발생
    - 입력된 내용이 없을 경우 `IllegalArgumentException`을 발생
    - 입력된 시도 횟수를 `Integer.parseInt()`를 사용했을 때 `NumberFormatException`이 발생할 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름이 하나일 경우 `IllegalArgumentException`을 발생

## 기능 구현

#### 1. domain

- Car
    - 자동차 이름을 저장할 변수 선언
    - 자동차의 현재 위치를 저장할 변수 선언
    - 특정 조건에 부합하면 distance 값만큼 currentPosition 값을 증가시킬 함수 생성
- Game
    - 시도 횟수 저장할 변수 선언
    - Car 객체들을 저장할 Car 타입 List 자료형 변수 선언
    - 시도 횟수를 카운트 할 변수 선언
    - 차수별로 시도 횟수를 카운트하는 함수 생성
    - 시도 횟수가 총 시도 횟수와 동일한지 판별하는 함수 생성

#### 2. view

- InputView
    - 사용자로부터 자동차 이름을 입력받기 위한 메시지 출력 함수 생성
    - 사용자로부터 총 시도 횟수를 입력받기 위한 메시지 출력 함수 생성
- OutputView
    - "실행결과"를 출력하기 위한 함수 생성
    - 자동차의 현재 위치(전진한 수)만큼 "-"를 출력하는 함수 생성
    - 자동차 이름을 같이 출력하기 위한 함수 생성
    - 위에 기술한 함수를 호출하여 차수별 진행 결과를 출력하는 함수 생성
    - 우승자가 1명인 경우와 아닌 경우를 나누어 최종 우승자(자동차 이름)를 출력
    - 우승자가 1명인지 판별하는 함수 분리하여 생성

#### 3. util

- Parser
    - 사용자로부터 입력받은 자동차 이름을 쉼표(,)를 기준으로 나누어 String 타입의 List 자료형을 리턴하는 함수 생성
    - 사용자로부터 입력받은 총 시도 횟수를 int 타입으로 형변환하여 리턴하는 함수 생성
- Validator
    - 입력된 내용이 쉼표(,)로 끝나는 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름이 1자 이상, 5자 이하인지 확인, 아닐 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름 중 중복된 이름이 있을 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름에 공백이 있을 경우 `IllegalArgumentException`을 발생
    - 입력된 내용이 없을 경우 `IllegalArgumentException`을 발생
    - 입력된 시도 횟수를 `Integer.parseInt()`를 사용했을 때 `NumberFormatException`이 발생할 경우 `IllegalArgumentException`을 발생
    - 입력된 자동차 이름이 하나일 경우 `IllegalArgumentException`을 발생

#### 4. service

- CarMovement
    - 테스트하기 용이하도록 인터페이스 생성
- Forward
    - CarMovement 인터페이스 구현 클래스
    - 0, 9 사이의 무작위 정수 값을 생성하여 4 이상인 경우 true를 리턴하는 함수 생성
- GameService
    - Game 객체의 자동차 객체 list를 get하여 전진 여부를 판별하는 함수를 호출한 후 전진했을 경우 Car 객체의 currentPosition 값을 증가시키는 함수 호출
    - 위의 함수를 호출하고 시도 횟수를 증가시키는 함수 생성
    - 최대 전진 위치(횟수)를 계산하는 함수 생성
    - 위의 함수의 리턴값을 인수로 받아 가장 많이 전진한 자동차 이름을 찾는 함수 생성
    - 위의 함수를 호출하여 최종 우승자를 찾는 함수 생성
    - 게임이 종료되었는지 판별하는 함수 생성

#### 5. controller

- Controller
    - getCarNamesByUserInput
        - 사용자로부터 자동차 이름을 입력받기 위한 메시지 출력 함수 호출
        - 사용자로부터 입력받은 값을 저장
        - 예외처리한 후 입력받은 값 리턴
    - getTrialByUserInput
        - 사용자로부터 총 시도 횟수를 입력받기 위한 메시지 출력 함수 생성
        - 사용자로부터 입력받은 값을 저장
        - 예외처리한 후 입력받은 값 리턴
    - Car 타입의 List 자료형 cars에 자동차 이름을 삽입하여 Car 객체를 생성하여 추가하는 함수 생성
    - getTrialByUserInput의 리턴값을 인수로 받은 parseNumberOfTrial 함수를 호출하여 총 시도 횟수를 int 타입으로 형변환하는 함수 생성
    - 새로운 Game 객체를 생성하는 함수 생성
    - play
        - "실행결과"를 출력하는 함수 호출
        - isEndGame(game)의 값이 false인 동안 반복하는 while문 작성
        - 시도 횟수가 총 시도 횟수와 같아질 때까지 차수별 실행 결과 반복 출력
        - isEndGame(game)의 값이 true일 경우 while문 탈출 후 최종 우승자를 보여주는 함수 호출
    - run
        - getCarNamesByUserInput의 리턴값을 인수로 받은 parseCarNames를 호출하여 위의 함수 인수로 넘겨 호출
        - creatGame의 리턴값을 인수로 받은 play 메소드 호출

#### 6. Constant

- 상수 정리
- 자동차 경주 게임 프로그램에서 사용하는 상수를 모아 선언
- 생성하는 무작위 값의 최소값 선언
- 생성하는 무작위 값의 최대값 선언
- 전진 여부를 판별하는 수 선언
- 자동차 이름 길이 최소값 선언
- 자동차 이름 길이 최대값 선언
- 자동차 최대 전진 위치를 계산할 때 필요한 상수 선언
- 최종 우승자가 1명인지 판별할 때 필요한 상수 선언
- 공백 여부를 판별할 때 필요한 상수(String) 선언

#### 7. Application

- Controller 객체 생성
- run 메소드 호출