package org.example;

import lombok.extern.log4j.Log4j2;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
@Log4j2
public class App {

    public void act(Double l){
        log.info("acting as: {}", l);
    }

    public int display(int a, int b){
       log.info("a and b values are: {} and {} respectively", a,b);
       return a+b;
    }

    public Integer display(Integer a, Integer b){
        log.info("a and b values are: {} and {} respectively", a,b);
        return a+b;
    }
    public static void main( String[] args ){
        log.info( "Hello World!" );
        var app = new App();
        var int1 = new Integer(3);
        var int2 = new Integer(4);
        app.display(3,4);
        app.display(int1,int2);
        int x = 3;
        List<Integer> li = new ArrayList<>();
        String s = new String("");
        String s1="";
        Instant i1 = Instant.now();
        for(double i = 0; i< 9; i++){
            s1=s1+s+": "+i;
            log.info("s1: {}",s1);
        }
        Instant i2 = Instant.now();
        Duration d1 = Duration.between(i1,i2);
        log.info("d1 ms: {}",d1.toMillis());
    }
}
