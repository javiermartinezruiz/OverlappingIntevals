package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static class Interval{
        private Integer x;
        private Integer y;

        public Interval(Integer x, Integer y){
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Interval> mergedList = new ArrayList<>();

        List<Interval> intervalList = Arrays.asList(
                new Interval(1,3),
                new Interval(5,11),
                new Interval(4,10),
                new Interval(20,25)
        );

        intervalList.sort((i, i1)-> i.getX().compareTo(i1.getX()));

        for(int i=0;i<intervalList.size();i++){
            if(i==0){
                mergedList.add(intervalList.get(i));
            }else{
                if(intervalList.get(i).getX().intValue() > mergedList.get(mergedList.size()-1).getY()){
                    mergedList.add(intervalList.get(i));
                }else{
                    if(intervalList.get(i).getY() > mergedList.get(mergedList.size()-1).getY()){
                        mergedList.get(mergedList.size()-1).setY(intervalList.get(i).getY());
                    }
                }
            }
        }

        System.out.println("Merged: "+mergedList);
    }
}
