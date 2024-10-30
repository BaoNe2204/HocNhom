package BaiTHThu6;

import java.util.Scanner;

public class Bai1 {

    static Scanner scanner = new Scanner(System.in); // Scanner toàn cục

    public static int BatDau() {
        System.out.println(""
                + "1. Tìm ước số chung lớn nhất của 2 số nguyên \n"
                + "2. Tìm bội số chung nhỏ nhất của 2 số nguyên \n"
                + "3. In ra các số nguyên tố nhỏ hơn n \n"
                + "4. In ra n số nguyên tố đầu tiên \n"
                + "5. Liệt kê các ước số là số nguyên tố của n \n"
                + "6. Đảo ngược số n \n"
                + "7. Liệt kê n số Fibonacci đầu tiên \n"
                + "8. Chuyển đổi số n từ hệ cơ số 10 sang hệ cơ số bất kỳ \n"
                + "9. Phân tích số n thành các thừa số nguyên tố \n"
                + "10. Thoát");
        System.out.println("Mời Nhập Lựa Chọn:");
        int menu = scanner.nextInt();
        Menu(menu);
        return 0;
    }

    public static int Menu(int menu) {
        switch (menu) {
            case 1:
                System.out.print("Nhập số nguyên thứ nhất: ");
                int a = scanner.nextInt();
                System.out.print("Nhập số nguyên thứ hai: ");
                int b = scanner.nextInt();
                int UocLonNhat = UocLonNhat(a, b);
                System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + UocLonNhat);
                break;
            case 2:
                System.out.print("Nhập số nguyên thứ nhất: ");
                int a1 = scanner.nextInt();
                System.out.print("Nhập số nguyên thứ hai: ");
                int b1 = scanner.nextInt();
                int Uoc1 = UocLonNhat(a1, b1);
                int UocNhoNhat = Math.abs(a1 * b1) / Uoc1;
                System.out.println("Bội số chung nhỏ nhất của " + a1 + " và " + b1 + " là: " + UocNhoNhat);
                break;
            case 3:
                System.out.print("Nhập số nguyên N: ");
                int N = scanner.nextInt();
                System.out.print("Các số nguyên tố là: ");
                for (int i = 2; i < N; i++) {
                    if (KiemTraSoNguyenTo(i)) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case 4:
                System.out.print("Nhập số nguyên tố cần in: ");
                int N1 = scanner.nextInt();
                int num = 2; 
                int Dem = 0; 
                while (Dem < N1) {
                    if (KiemTraSoNguyenTo(num)) {
                        System.out.print(num + " ");
                        Dem++;
                    }
                    num++;
                }
                break;
            case 5:
                System.out.print("Nhập số nguyên n để tìm ước số nguyên tố: ");
                int Uoc = scanner.nextInt();
                System.out.println("Các ước số nguyên tố của " + Uoc + " là:");
                for (int i = 1; i <= Uoc; i++) {
                    if (Uoc % i == 0 && KiemTraSoNguyenTo(i)) {
                        System.out.println(i);
                    }
                }
                break;
            case 6:
                System.out.print("Nhập số nguyên n: ");
                int SoN = scanner.nextInt();
                String ChuoiDaDaoNguoc = DaoNguocSo(SoN);
                System.out.println("Chuỗi đã đảo ngược là: " + ChuoiDaDaoNguoc);
                break;
            case 7:
                System.out.print("Nhập số n (số lượng số Fibonacci cần in): ");
                int nFibonacci = scanner.nextInt();
                System.out.print("Dãy Fibonacci đầu tiên gồm " + nFibonacci + " số là: ");
                if (nFibonacci >= 1) {
                    System.out.print("0 "); // In số đầu tiên
                }
                if (nFibonacci >= 2) {
                    System.out.print("1 "); // In số thứ hai
                }
                int SoA = 0;
                int SoB = 1;
                for (int i = 3; i <= nFibonacci; i++) {
                    int SoC = SoA + SoB;
                    System.out.print(SoC + " ");
                    SoA = SoB;
                    SoB = SoC;
                }
                break;
            case 8:
                System.out.print("Nhập số nguyên dương n: ");
                int NguyenDuong = scanner.nextInt();

                System.out.print("Nhập cơ số b (2-36): ");
                int CoSob = scanner.nextInt();
                if (CoSob < 2 || CoSob > 36) {
                    System.out.println("Cơ số không hợp lệ! Phải từ 2 đến 36.");
                } else {
                    String result = convertToBase(NguyenDuong, CoSob);
                    System.out.println("Số " + NguyenDuong + " trong hệ cơ số " + CoSob + " là: " + result);
                }
                break;
            case 9:
                System.out.print("Nhập số nguyên dương n: ");
                int soN = scanner.nextInt();
                System.out.print(soN + " = ");
                phanTichThuaSo(soN);
                break;
            case 10:
                System.out.println("Thoát chương trình.");
                System.exit(0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
        }
        BatDau();
        return 0;
    }

    public static void main(String[] args) {
        BatDau();
    }

    public static int UocLonNhat(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static String DaoNguocSo(int N) {
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        return sb.reverse().toString();
    }

    public static boolean KiemTraSoNguyenTo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static String convertToBase(int n, int b) {
        StringBuilder result = new StringBuilder();
        char[] digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        while (n > 0) {
            int remainder = n % b;
            result.insert(0, digits[remainder]);
            n /= b;
        }
        return result.toString();
    }

    public static void phanTichThuaSo(int soN) {
        while (soN % 2 == 0) {
            System.out.print("2");
            soN /= 2;
            if (soN > 1) {
                System.out.print(" x ");
            }
        }

        for (int soLe = 3; soLe <= Math.sqrt(soN); soLe += 2) {
            while (soN % soLe == 0) {
                System.out.print(soLe);
                soN /= soLe;
                if (soN > 1) {
                    System.out.print(" x ");
                }
            }
        }

        if (soN > 2) {
            System.out.print(soN);
        }
    }
}
