# 기능 목록

## Input
- [] 이름 입력받기
  -  [] null값 검증, 검증 실패 시 IllegalArgumentException 발생
- [] 시도할 회수 입력받기
  - [] 숫자만 들어왔는지 검증, 검증 실패 시 IllegalArgumentException 발생
  - [] 1 이상의 숫자만 들어왔는지 검증, 검증 실패 시 IllegalArgumentException 발생
  - [] null값 검증, 검증 실패 시 IllegalArgumentException 발생

## Output
- [] 각 라운드당 실행 결과 출력
- [] 우승자 출력
  - 여러 명일 경우 쉼표를 이용하여 구분

## RandomNumberGenerator
- [] 0에서 9까지의 정수 중 한 개의 정수 랜덤 반환

## Cars
- [] 이름 쉼표를 기준으로 구분
  - [] 증복된 이름 검증, 검증 실패 시 IllegalArgumentException 발생
  - [] 각 이름 5글자 이하, 검증 실패 시 IllegalArgumentException 발생
- [] 무작위 값이 4 이상일 경우에만 차 전진