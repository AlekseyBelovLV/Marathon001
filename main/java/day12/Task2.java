package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        evenNum(num, 0, 30);
        evenNum(num, 300, 350);
        System.out.println(num);
    }

    public static void evenNum(List<Integer> num, int min, int max) {
        for(int i = min; i < max; i++) {
            if(i % 2 == 0) { num.add(i); }
        }
    }
}
