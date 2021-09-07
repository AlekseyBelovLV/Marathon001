package day8;

public class Task1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String str = new String();   // 2385 ms
        for (int i = 0; i <= 20000; i++) {
            str += (i + " ");
        }
        System.out.println(str);

//        StringBuilder sb = new StringBuilder();  // 10 ms
//        for (int i = 0; i <= 2000; i++) {
//            sb.append(" ").append(i);
//        }
//        System.out.println(sb.toString());

        long stopTime = System.currentTimeMillis();
        System.out.println("Длительность работы в мс.: " + (stopTime - startTime));
    }
}
