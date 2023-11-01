1. 자동차 이름 입력
- 쉼표 다음에 이름이 입력되지 않을 때, IllegalArgumentException 예외 처리
- 쉼표로 입력값 구분
  - 0대일 때, IllegalArgumentException 예외 처리
  - 1대일 때, 단독 우승?x 경주이므로 IllegalArgumentException 예외 처리
  - 2대 이상 입력
- 이름은 5자 이하만 가능 
    - 6자 이상, IllegalArgumentException 예외 처리
    - 전부 공백, IllegalArgumentException 예외 처리
- 이름 양 끝에 공백 포함 시 => 공백 제거
- 이름 중복 시, IllegalArgumentException 예외 처리
- 제공된 라이브러리 사용
- 요구 사항에 명시된 출력문 구성

2. 시도 횟수 입력
- 제공된 라이브러리 사용
- 요구 사항에 명시된 출력문 구성
- 0번 이하 입력 시, 어떻게 처리할 것인가? 
  - 시도 횟수가 0이하일 때, 허용x IllegalArgumentException 예외 처리
- 문자나 공백 포함 시, IllegalArgumentException 예외 처리
    
3. 이동 로직 구현
- 0~9사이 랜덤 값이 4~9 일 때 경우 전진
- 0~3일 때, 스톱
- 제공된 라이브러리 사용(Randoms)
- 요구 사항에 명시된 출력문 구성

4. 우승자 출력
- 우승자는 한 명 이상
- 여려 명일 시 쉼표로 구분
- 요구 사항에 명시된 출력문 구성
