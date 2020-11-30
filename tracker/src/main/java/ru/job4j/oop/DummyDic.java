package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String result = "Unknown word " + eng;
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        DummyDic dic = new DummyDic();
        String rus = dic.engToRus("sky");
    }
}
