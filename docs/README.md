# 기능 목록

## Input

- [x] 사용자 입력받기 - null값 검증, 검증 실패 시 IllegalArgumentException 발생
    - [x] 이름 입력받기
    - [x] 시도할 횟수 입력받기
        - [x] 숫자만 들어왔는지 검증, 검증 실패 시 IllegalArgumentException 발생
        - [x] 1 이상의 숫자만 들어왔는지 검증, 검증 실패 시 IllegalArgumentException 발생

## Output

- [x] 각 라운드당 실행 결과 출력
- [] 우승자 출력
    - 여러 명일 경우 쉼표를 이용하여 구분

## RandomNumberGenerator

- [x] 0에서 9까지의 정수 중 한 개의 정수 랜덤 반환

## MovePossibilityChecker

- [x] 전진해도 되는지 안되는지 판단

## Cars

- [x] 이름 쉼표를 기준으로 구분
    - [x] 중복된 이름 검증, 검증 실패 시 IllegalArgumentException 발생
    - [x] 각 이름 5글자 이하, 검증 실패 시 IllegalArgumentException 발생
- [x] MovePossibilityChecker값이 FORWARD면 전진, 아니면 전진x