package hocnhom;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class TinhSoNgay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("năm:");
        int Nam = sc.nextInt();
        System.out.println("Tháng:");
        int thang = sc.nextInt();
        switch (thang) {
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("có 31 ngày");
                break;
            case 4, 6, 9, 11:
                System.out.println("có 30 ngày");
                break;
            case 2:
                if ((Nam % 4 == 0 && Nam % 100 != 0) || Nam % 400 == 0) {
                    System.out.println("có 29 ngày");
                    System.out.println("nhuận");
                } else {
                    System.out.println("có 28 ngày");
                    System.out.println("Không nhuận");
                }
                break;
            default:
                System.out.println("Không có tháng này");
                break;

        }
    }

}
