package main;

import util.DBConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("안녕하세요 햄버거 가게입니다.!!");
        System.out.println("JDBC설정");
        DBConnection dbcon = new DBConnection();
        dbcon.connect();
        
        System.out.println("devlop 브랜치에서 feature로 가져왔을때");
        System.out.println("변경 안되게하려면 Branch > Merge into Current Branch");
    }

}