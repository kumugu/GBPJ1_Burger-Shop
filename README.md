# 2024-11-21 할 일: JDBC 설정 및 초기 프로젝트 작업


---

## **1. JDBC 설정 작업 진행**

### 1.1. JDBC 라이브러리 추가

- JDBC 드라이버(예: Oracle은 `ojdbc6.jar`)를 프로젝트에 추가.


---


### 1.2. DB 설정 파일 생성

- 팀원들이 수정할 수 있도록 데이터베이스 설정 파일 작성:

  ```properties
  db.url=jdbc:oracle:thin:@localhost:1521:xe
  
  db.username=basic
  
  db.password=1234
  ```

------

### 1.3. `DBConnection` 클래스 작성

- 설정 파일을 읽고 데이터베이스 연결 객체를 반환:

  ```java
  import java.sql.*;
  import java.util.Properties;
  import java.io.FileInputStream;
  
  public class DBConnection {
      private static Connection connection;
  
      public static Connection getConnection() throws Exception {
          if (connection == null || connection.isClosed()) {
              Properties props = new Properties();
              FileInputStream fis = new FileInputStream("db.properties");
              props.load(fis);
  
              String url = props.getProperty("db.url");
              String user = props.getProperty("db.username");
              String password = props.getProperty("db.password");
  
              connection = DriverManager.getConnection(url, user, password);
          }
          return connection;
      }
  }
  ```

------

### 1.4. DB 연결 테스트

- ```
  DBConnection
  ```

  을 호출해 데이터베이스 연결을 확인:

  ```java
  public class TestDBConnection {
      public static void main(String[] args) {
          try (Connection conn = DBConnection.getConnection()) {
              if (conn != null) {
                  System.out.println("DB 연결 성공!");
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }
  ```

------

## **2. 역할 분담과 초기 작업 시작**

### 2.1. 팀원별 작업 영역 확정

- 각 팀원의 담당 기능 할당:
  - 로그인 기능
  - 직원 관리
  - 재고 관리
  - 스케줄 관리

### 2.2. 공통 구조 설정

- ```
  develop
  ```

   브랜치에 기본 프로젝트 구조와 초기 코드를 세팅:

  - **폴더 구조**: `src`, `resources`, `test` 등.
  - **공통 유틸리티**: DB 연결 클래스, 로그 관리 등.
  - 초기 작업 완료 후 팀원이 이를 기반으로 기능 구현 시작.

------

## **3. 데이터베이스 설계 및 초기 세팅**

### 3.1. 데이터베이스 테이블 설계

- ER 다이어그램을 기반으로 테이블 생성 SQL 작성.

### 3.2. 데이터베이스 구축

- 테이블 생성 및 샘플 데이터 삽입(테스트에 사용):

  ```sql
    CREATE TABLE employees (
      id NUMBER PRIMARY KEY,
      name VARCHAR2(50),
      role VARCHAR2(20),
      salary NUMBER
  );
  
  INSERT INTO employees VALUES (1, 'John Doe', 'Manager', 5000);
  ```

### 3.3. DB 연결 코드 작성

- 공통 `DBConnection.java` 구현 후 `develop` 브랜치에 추가.
- 팀원들에게 DB 접근 방법 공유.

------

## **4. 로그인 및 인증 시스템 개발 (우선순위)**

### 4.1. 로그인 화면 설계

- Swing을 사용하여 기본 로그인 UI 설계.

### 4.2. 인증 로직 구현

- 입력된 ID와 비밀번호를 DB와 비교.
- 비밀번호는 **암호화된 상태로 처리**(bcrypt 등 추가 연구 필요).

### 4.3. 권한 기반 접근 제어 설정

- **관리자 권한**: 모든 기능 접근 가능.
- **일반 직원 권한**: 자신의 정보만 조회/수정 가능.
