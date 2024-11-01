/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calendar;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Gia Bao
 */
//cách này là dùng Calendar còn dùng hàm bth vẩn tính được nha
public class ThoiGianChuyenDi {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Calendar thoiGianBatDau = Calendar.getInstance();
        Calendar thoiGianKetThuc = Calendar.getInstance();

        // Nhập Giờ Bắt đầu
        while (true) {
            System.out.print("Nhập Giờ/Phút(h/min) Bắt đầu (định dạng hh/mm): ");
            String BatDau = sc.nextLine();
            String[] Phan1 = BatDau.split("/");// này để anh bỏ dấu "/"rùi đưa vô mảng nè

            if (Phan1.length == 2) {//Kiểm tra trong mảng có 2 giá trị h và phút hong nè
                try {
                    int gioBatDau = Integer.parseInt(Phan1[0]);//lấy giá trị giờ của mảng nè
                    int phutBatDau = Integer.parseInt(Phan1[1]);//lấy giá trị phút của mảng nè

                    if (gioBatDau >= 0 && gioBatDau < 24 && phutBatDau >= 0 && phutBatDau < 60) {//Điều kiện cho nhập đúng định dạng nè
                        thoiGianBatDau.set(Calendar.HOUR_OF_DAY, gioBatDau);//Thiết lập giờ choa biến nè
                        thoiGianBatDau.set(Calendar.MINUTE, phutBatDau);//Thiết lập phút choa biến nè
                        break;
                    } else {
                        System.out.println("Giờ phải từ 0 đến 23 và phút phải từ 0 đến 59.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập đúng định dạng.");
                }
            } else {
                System.out.println("Vui lòng nhập đúng định dạng.");
            }
        }

        // Nhập Giờ Kết Thúc
        while (true) {
            System.out.print("Nhập Giờ/Phút(h/min) Kết Thúc (định dạng hh/mm): ");
            String KetThuc = sc.nextLine();
            String[] Phan2 = KetThuc.split("/");

            if (Phan2.length == 2) {
                try {
                    int gioKetThuc = Integer.parseInt(Phan2[0]);
                    int phutKetThuc = Integer.parseInt(Phan2[1]);

                    if (gioKetThuc >= 0 && gioKetThuc < 24 && phutKetThuc >= 0 && phutKetThuc < 60) {
                        thoiGianKetThuc.set(Calendar.HOUR_OF_DAY, gioKetThuc);
                        thoiGianKetThuc.set(Calendar.MINUTE, phutKetThuc);
                        break;
                    } else {
                        System.out.println("Giờ phải từ 0 đến 23 và phút phải từ 0 đến 59.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập đúng định dạng.");
                }
            } else {
                System.out.println("Vui lòng nhập đúng định dạng.");
            }
        }
        // Kiểm tra xem thời gian kết thúc có trước thời gian bắt đầu không
        if (thoiGianKetThuc.before(thoiGianBatDau)) {//nếu kết thúc 
            thoiGianKetThuc.add(Calendar.DAY_OF_MONTH, 1);//Thêm 1 ngày 
        }
        //thời gian di chuyển
        //Thời gian di chuyển tình là = thời gian kết thúc  - Thoi gian bắt đầu mà tính theo milliseconds nên phải dùng biến long nha mấy ní
        long thoiGianChuyenDiMillis = thoiGianKetThuc.getTimeInMillis() - thoiGianBatDau.getTimeInMillis(); //Biến long nó rộng hơn biến int (int max là 2 tỷ thôi)

        //hàm này là để chuyển sang phút nè 
        //Chia cho 10000 là nó sẻ về giây rùi mình nhân cho 60 để nó về phút nha
        long thoiGianChuyenDiPhut = thoiGianChuyenDiMillis / (1000 * 60);

        // Tính số giờ chuyến đi bằng cách chia tổng số phút cho 60
        long gioChuyenDi = thoiGianChuyenDiPhut / 60;
        // Tính số phút còn lại của chuyến đi bằng cách lấy phần dư của tổng số phút khi chia cho 60
        long phutChuyenDi = thoiGianChuyenDiPhut % 60;

        System.out.printf("Tổng thời gian chuyến đi: %d giờ %d phút\n", gioChuyenDi, phutChuyenDi);

        sc.close();
    }
}
