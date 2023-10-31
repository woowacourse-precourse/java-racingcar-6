# 미션 - 자동차 경주 게임 🚓

## 💻 DOMAIN

### 1. Car(차)

- 게임에 사용되는 자동차 객체
- String name, int position을 갖는다.
- move()를 통해 position++;

### 2. Game(게임)

- List<Car>와 int currentAttemptCnt, int finalAttemptCnt 가진다.
- increaseCurrentAttemptCnt()를 통해 currentAttemptCnt++;
- finalAttemptCnt과 currentAttemptCnt이 같은지 아닌지 판별하는 checkAttemptCountFinal();


## 🖨️ VIEW

#### 1. 입력

#### 1.1 입력 예시

#### - 입력예시
pobi,woni,jun  (경주 할 자동차 이름 이름은 쉼표, 기준으로 구분)  
5 (시도할 회수)

#### 1.2 입력 예외처리

- 잘못된 값을 입력한 경우 IllegalArgumentException 예외처리를 한다.
- 자동차 이름이 0자 일때 예외처리(이름이 존재하지 않는 경우는 없다.)
- 자동차 이름이 5자 이상일때 예외처리
- 자동차 이름이 중복되는 경우 구분이 안되므로 예외처리
- 사용자가 입력한 이동값이 숫자가 아니라면 예외처리


#### 2. 출력 

#### 2.1 출력 예시

#### - 출력예시

- 각 차수별 실행 결과  
  pobi : --  
  woni : ----  
  jun : ---
- 단독 우승자 안내 문구  
  최종 우승자 : pobi

- 공동 우승자 안내 문구  
  최종 우승자 : pobi, jun

