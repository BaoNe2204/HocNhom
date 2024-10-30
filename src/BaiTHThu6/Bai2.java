/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTHThu6;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Bai2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BatDau();
    }

    public static int BatDau() {
        System.out.println("Mời bạn nhập lựa chọn: ");
        System.out.println(""
                + "1. In ra các số chính phương nhỏ hơn n\n"
                + "2. In ra n số chính phương đầu tiên\n"
                + "3. Liệt kê các ước số là số chính phương của n\n"
                + "4. Tính tổng các ký số của n (VD: n=275 => tổng: 14)\n"
                + "5. In ra các số hoàn hảo nhỏ hơn n\n"
                + "6. In ra n số hoàn hảo đầu tiên\n"
                + "7. Liệt kê các ước số là số hoàn hảo của n\n"
                + "8. Chuyển đổi số n từ hệ cơ số 10 sang hệ cơ số 8\n"
                + "9. Chuyển đổi số n từ hệ cơ số 10 sang hệ cơ số 16\n"
                + "10.Thoát");
        int Menu = scanner.nextInt();
        TinhToan(Menu);
        return 0;
    }

    public static int TinhToan(int Menu) {
        switch (Menu) {
            case 1:
                System.out.println("Mời nhập n: ");
                int n = scanner.nextInt();
                System.out.print("Các số Chính Phương nhỏ hơn " + n + " là ");

                for (int i = 1; i * i <= n; i++) {
                    System.out.println(i * i);
                }
                BatDau();
                break;
            case 2:
                System.out.println("Mời nhập n: ");
                int n1 = scanner.nextInt();
                System.out.print("Các số Chính Phương đầu tiên là ");

                for (int i = 1; i <= n1; i++) {
                    System.out.println(i * i);
                }
                BatDau();
                break;
            case 3:
                System.out.println("Mời nhập n: ");
                int n2 = scanner.nextInt();
                for (int i = 1; i <= n2; i++) {
                    if (n2 % i == 0) {
                        if (KiemTraSoChinhPhuong(i)) {
                            System.out.print(i + " ");
                        }
                    }
                }
                BatDau();
                break;
            case 4:
                System.out.print("Mời nhập số nguyên n: ");
                int n3 = scanner.nextInt();
                int sum = 0; //lưu số tổng 237
                while(n3>0){
                    sum += n3%10;//0= 237 % 10
                    n3 /= 10;
                }
                System.out.println("Tổng các ký số là: " + sum);
                break;
            case 5:

                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            default:

                break;

        }
        return 0;
    }

    public static boolean KiemTraSoChinhPhuong(int num) {
        if (num < 0) {
            return false;
        }
        for (int i = 0; i * i <= num; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

}
