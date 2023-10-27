1. 자동차 이름 입력
- 쉼표로 입력값 구분
  - 0대 일때, IllegalArgumentException 예외처리
  - 1대 일때, 단독우승?x 경주이므로 IllegalArgumentException 예외처리
  - 2대이상 입력
- 이름은 5자 이하만 가능 
    - 6자 이상, IllegalArgumentException 예외처리
    - 전부 공백, IllegalArgumentException 예외처리
- 이름에 공백 포함시 => 공백 제거
- 제공된 라이브러리 사용
- 요구 사항에 명시된 출력문 구성

2. 시도 횟수 입력
- 제공된 라이브러리 사용
- 요구 사항에 명시된 출력문 구성
- 0번 이동시 어떻게 처리할 것인가? 
  - 우승자는 1명 이상이므로, IllegalArgumentException 예외처리
- 문자나 공백 포함시, IllegalArgumentException 예외처리
    
3. 이동 로직 구현
- 0~9사이 랜덤 값이 4~9 일 때 경우 전진
- 0~3 일때, 스톱
- 제공된 라이브러리 사용
- 요구 사항에 명시된 출력문 구성

4. 우승자 출력
- 우승자는 한 명 이상
- 여려 명일시 쉼표로 구분
- 요구 사항에 명시된 출력문 구성
