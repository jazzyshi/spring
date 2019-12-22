package com.jazzyshi.spring01.pojo;

import java.lang.reflect.Array;
import java.util.*;

public class People {
    private int id;
    private String name;


    Set<?> sets;
    List<?> lists;
    String[] arrays;
    Map maps;
    Properties props;


    //依赖注入
    House house;

    public String[] getArrays() {
        return arrays;
    }

    public void setArrays(String[] arrays) {
        this.arrays = arrays;
    }

    public Properties getProps() {
        return props;
    }

    public People(){
        super();
        System.out.println("执行默认无参构造函数");
    }

    public People(int id,String name){
        super();
        this.id = id;
        this.name = name;
        System.out.println("执行有参构造函数int");
    }

    public People(Integer id,String name){
        super();
        this.id = id;
        this.name = name;
        System.out.println("执行有参构造函数integer");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Set<?> getSets() {
        return sets;
    }

    public void setSets(Set<?> sets) {
        this.sets = sets;
    }

    public List<?> getLists() {
        return lists;
    }

    public void setLists(List<?> lists) {
        this.lists = lists;
    }


    public Map getMaps() {
        return maps;
    }

    public void setMaps(Map map) {
        this.maps = map;
    }



    public void setProps(Properties props) {
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sets=" + sets +
                ", lists=" + lists +
                ", arrays=" + Arrays.toString(arrays) +
                ", maps=" + maps +
                ", props=" + props +
                ", house=" + house +
                '}';
    }
}
