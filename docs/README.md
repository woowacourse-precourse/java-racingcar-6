# 미션 - 자동차 경주

# 기능 목록

---

# Model

## 1. Name

### isValid
- 이름 조건 검증(5자 이하)

## 2. Attempt

### isValid
- 숫자 입력 검증

## 3. Move

### generateRandom
- 랜덤값 생성

## 4. Game

### calculateDistance
- 이동거리 계산

---

# View

## 1. InputView

### name
- 이름 입력

### attemptsNum
- 게임 횟수 입력

## 2. OutputView

### initial
- 결론 시작 문장 출력

### result
- 자동차 이름 + 이동 거리 출력

### winner
- 우승자 출력

---

# Controller

## 1. GameController

### start
- 이름 입력
- 시도 횟수 입력
- 이름 조건 검증
- 시도 횟수 검증
- 실행 결과 문장 표시
- HashMap 주입
- 게입 반복 실행
- 최대 거리 이동 이름 검색
- 우승자 표시

### initializeDistanceMap
- HashMap에 공백 주입

### playGameRepeat
- 게입 반복 실행

### playGame
- 이동 거리 "-" 표시

### showResult
- 자동차 이름 + 이동 거리 출력

### showWinner
- 우승자 출력

### maxDistance
- 최대 이동 거리 이름 확인










