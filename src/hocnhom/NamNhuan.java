package hocnhom;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class NamNhuan {

    public static void main(String[] args) {
        System.out.println("Nhập năm:");
        Scanner sc = new Scanner(System.in);
        int nam = sc.nextInt();
        if ((nam % 4 == 0 && nam % 100 != 0) || nam % 400 == 0) {
            System.out.println("Năm nhuận");
        } else {
            System.out.println("Năm không nhuận");
        }
    }
}
