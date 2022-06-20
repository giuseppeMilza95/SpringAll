package com.love2code.springdemo;

public class GoodFortuneService implements FortuneService{


    @Override
    public String getFortune() {
        return "You have good fortune today!!";
    }
}
