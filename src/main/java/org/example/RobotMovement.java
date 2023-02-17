package org.example;

import lombok.extern.log4j.Log4j2;

/**
 * //Implement the 'walk' method.
 * //Assume robot inital position is (0,0).
 * //walk method take path where each character corresponds to a movement of the robot.
 * // The robot moves up, down, left, and right represented by the characters 'U', 'D', 'L', and 'R'
 * // Ignore other characters.
 */
@Log4j2
public class RobotMovement {

    public static void main(String[] args) {
        var gvnStr = "UDDLLRUUUDUURUDDUULLDRRRR";
        int x =0, y=0;
        for(int i =0;i<gvnStr.length();i++){
            var c = gvnStr.charAt(i);
            switch(c){
                case 'U':
                    y+=1;
                    break;
                case 'D':
                    y-=1;
                    break;
                case 'R':
                    x+=1;
                    break;
                case 'L':
                    x-=1;
                    break;
                default:
                    break;
            }
        }
        log.debug("x and y axis after movement of robot will be [{},{}]", x,y);
    }
}
