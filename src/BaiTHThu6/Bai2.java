package BaiTHThu6;

import java.util.Scanner;

public class Bai2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        batDau();
    }

    public static int batDau() {
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
                + "10. Thoát");
        int menu = scanner.nextInt();
        thucHienTinhToan(menu);
        return 0;
    }

    public static int thucHienTinhToan(int menu) {
        switch (menu) {
            case 1:
                System.out.println("Mời nhập n: ");
                int n1 = scanner.nextInt();
                System.out.print("Các số Chính Phương nhỏ hơn " + n1 + " là ");
                for (int i = 1; i * i <= n1; i++) {
                    System.out.println(i * i);
                }
                batDau();
                break;
            case 2:
                System.out.println("Mời nhập n: ");
                int n2 = scanner.nextInt();
                System.out.print("Các số Chính Phương đầu tiên là ");
                for (int i = 1; i <= n2; i++) {
                    System.out.println(i * i);
                }
                batDau();
                break;
            case 3:
                System.out.println("Mời nhập n: ");
                int n3 = scanner.nextInt();
                for (int i = 1; i <= n3; i++) {
                    if (n3 % i == 0 && kiemTraSoChinhPhuong(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                batDau();
                break;
            case 4:
                System.out.print("Mời nhập số nguyên n: ");
                int n4 = scanner.nextInt();
                int tong = 0;
                while (n4 > 0) {
                    tong += n4 % 10;
                    n4 /= 10;
                }
                System.out.println("Tổng các ký số là: " + tong);
                batDau();
                break;
            case 5:
                System.out.println("Mời nhập n: ");
                int n5 = scanner.nextInt();
                System.out.print("Các số hoàn hảo nhỏ hơn " + n5 + " là: ");
                for (int i = 1; i < n5; i++) {
                    if (kiemTraSoHoanHao(i)) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
                batDau();
                break;
            case 6:
                System.out.println("Mời nhập n: ");
                int n6 = scanner.nextInt();
                System.out.print("Các số hoàn hảo đầu tiên là: ");
                int count = 0,
                 i = 1;
                while (count < n6) {
                    if (kiemTraSoHoanHao(i)) {
                        System.out.print(i + " ");
                        count++;
                    }
                    i++;
                }
                System.out.println();
                batDau();
                break;
            case 7:
                System.out.println("Mời nhập n: ");
                int n7 = scanner.nextInt();
                if (n7 <= 0) {
                    System.out.println("Vui lòng nhập một số nguyên dương.");
                    batDau();
                    break; 
                }

                System.out.print("Các ước số hoàn hảo của " + n7 + " là: ");
                for (int j = 1; j <= n7; j++) {
                    if (n7 % j == 0 && kiemTraSoHoanHao(j)) {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
                batDau();
                break;

            case 8:
                System.out.print("Mời nhập n: ");
                int n8 = scanner.nextInt();
                System.out.println("Số " + n8 + " trong hệ cơ số 8 là: " + Integer.toOctalString(n8));
                batDau();
                break;
            case 9:
                System.out.print("Mời nhập n: ");
                int n9 = scanner.nextInt();
                System.out.println("Số " + n9 + " trong hệ cơ số 16 là: " + Integer.toHexString(n9).toUpperCase());
                batDau();
                break;
            case 10:
                System.out.println("Thoát chương trình.");
                return 0;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                batDau();
                break;
        }
        return 0;
    }

    public static boolean kiemTraSoChinhPhuong(int num) {
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

    public static boolean kiemTraSoHoanHao(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}
