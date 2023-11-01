# 콘솔 출력 테스트 학습 내용 정리
- 'GameResultTest.java'에서 작성한 코드를 위주로 정리함.

## ByteArrayOutputStream
- 의미: '바이트 배열에 출력되는 데이터를 담기 위한 출력 스트림'을 제공하는 클래스
- 용도: 주로 파일이나 네트워크 대신 '메모리'에 데이터를 출력하는 데 사용됨.
- 테스트에서의 용도: 실제 출력을 캡처하여 결과를 확인하거나 비교하는 데 활용됨.
  - 실제 출력 결과를 직접 비교하기보다는 해당 스트림으로 리디렉션하여 결과를 얻어내고 비교함.
- 쓰는 대로 버퍼에서 **_자동으로_** 저장되며, toByteArray() and toString() 메서드를 통해 문자열로 읽을 수 있음.

## Redirection (리디렉션)
- 일반적인 의미: 입력 또는 출력의 방향을 변경하는 것
- 자바에서의 리디렉션: 표준 입력(System.in) 또는 표준 출력(System.out)의 방향을 변경하는 것
  - System.setIn() 및 System.setOut()과 같은 메서드를 사용하여 입력 및 출력 스트림을 변경할 수 있음.
  - System.setOut(새로운 PrintStream 객체)

## new PrintStream()
- PrintStream의 기본 생성자를 호출함. 
- 표준 출력 스트림과 관련이 없는 새로운 PrintStream이 생성됨.

## 출력 테스트 원리
- 원래 자바는 System.out을 표준 출력으로 설정되어 있음.
  - System.out: PrintStream 타입의 필드


## Scanner