# 입출력 스트림 정리

## Stream(스트림)
- 의미: 단일 방향으로 데이터를 운반하는 통로
- 종류는 크게 두 가지
  - 바이트 기반 스트림: 그림, 멀티미디어 등의 바이너리 데이터를 읽고 출력할 때 사용
  - 문자 기반 스트림: 문자 데이터를 읽고 출력할 때 사용

## 바이트 기반 스트림
- InputStream
  - 바이트 기반 입력 스트림의 최상위 클래스
  - 모든 바이트 기반 입력 스트림 클래스는 이를 상속받아서 만들어짐.
- OutputStream
  - 바이트 기반 출력 스트림의 최상위 클래스 
  - 모든 바이트 기반 출력 스트림 클래스는 이를 상속받아서 만들어짐.

## 문자 기반 스트림
- Reader
    - 문자 기반 입력 스트림의 최상위 클래스
    - 모든 문자 기반 입력 스트림 클래스는 이를 상속받아서 만들어짐.
- Writer
    - 문자 기반 출력 스트림의 최상위 클래스
    - 모든 문자 기반 출력 스트림 클래스는 이를 상속받아서 만들어짐.

## 보조 스트림
- 역할: 다른 스트림과 연결되어 여러 편리한 기능을 제공함.
- 특징: 자체적으로 입출력을 수행할 수 없어 입출력 소스와 바로 연결되는 InputStream, Writer 등에 연결해서 입출력을 수행함.

## 보조 스트림 종류
- 문자 변환: OutputStreamWriter, InputStreamReader
- 성능 향상: BufferedOutputStream, BufferedWriter
- 기본 타입 입출력: DataInputStream, DataOutputStream
- 프린트 보조: printStream, printWriter 
  - System.out은 printStream에 해당함.
  - print(), println() 메서드를 가지고 있음.
  - 객체 입출력: ObjectOutputStream, ObjectInputStream

## 입출력 관련 API
- System.in
  - InputStream 타입의 필드
  - 콘솔에서 키보드의 데이터를 입력받을 수 있도록 함.
  - 보조 스트림을 연결해서 사용하거나, Scanner를 이용해서 입력된 문자열을 읽음.
- System.out
  - printStream 타입의 필드
  - 콘솔에서 모니터로 데이터를 출력함.
  - print(), println(), printf()와 같은 메서드를 이용해 모니터로 출력함.
- Scanner
  - java.util 패키지에서 제공하는 클래스
  - 라인 단위 문자열을 쉽게 읽도록 함.
- File
  - java.io 패키지에서 제공하는 클래스
  - 파일 및 폴더(디렉토리) 정보를 제공해 줌.