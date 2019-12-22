package com.jazzyshi.spring01.pojo;

public class PeopleFactory {

    public People newInstance(){
        return new People(1,"史总");
    }

    public static People newStaticInstance(){
        return new People(2,"刘总");
    }
}
