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
public class NgayToiSinhNhat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar NgayHomNay = Calendar.getInstance();
        Calendar[] ngaySinh = new Calendar[5]; // Khởi tạo biến chứa ngày sinh

        // Lấy Giá trị người dùng nhập vào
        for (int i = 0; i < 5; i++) {
            ngaySinh[i] = Calendar.getInstance();
            while (true) { // Vòng lặp chỉ dừng khi khi đụng biến break
                System.out.printf("Nhập ngày sinh cho người thứ %d (ngày/tháng/năm): ", i + 1);
                String[] LayDuLieu = sc.nextLine().split("/"); // Tách dữ liệu nhập vào

                if (LayDuLieu.length == 3) {
                    try {
                        int Ngay = Integer.parseInt(LayDuLieu[0]);
                        int Thang = Integer.parseInt(LayDuLieu[1]) - 1; // hàm này thì tháng bắt đầu từ 0 nên ta trừ 1 của tháng máy mới hiểu
                        int Nam = Integer.parseInt(LayDuLieu[2]);

                        // Kiểm tra tính hợp lệ của ngày tháng
                        //Thang này là của máy nên bị trừ 1 đơn vị nha máy ní
                        if (Thang < 0 || Thang > 11 || Ngay < 1 || Ngay > 31) {
                            System.out.println("Ngày hoặc tháng không hợp lệ. Vui lòng nhập lại.");
                            continue;
                        }

                        // Kiểm tra số ngày trong tháng
                        if ((Thang == 1 && Ngay > 29) || (Thang == 1 && Ngay == 29 && !(Nam % 4 == 0 && (Nam % 100 != 0 || Nam % 400 == 0)))) {
                            System.out.println("Ngày không hợp lệ cho tháng 2. Vui lòng nhập lại.");
                            continue;
                        } else if ((Thang == 3 || Thang == 5 || Thang == 8 || Thang == 10) && Ngay > 30) {
                            System.out.println("Ngày không hợp lệ cho tháng có 30 ngày. Vui lòng nhập lại.");
                            continue;
                        }

                        // Thiết lập ngày sinh cho máy tính
                        ngaySinh[i].set(Nam, Thang, Ngay);
                        break; // Thoát vòng lặp nếu nhập hợp lệ

                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập đúng định dạng.");
                    }
                } else {
                    System.out.println("Vui lòng nhập đúng định dạng.");
                }
            }
        }

        System.out.println("\nSố ngày còn lại đến sinh nhật tiếp theo:");
        for (int i = 0; i < 5; i++) {
            Calendar sinhNhat = (Calendar) ngaySinh[i].clone(); // Tạo bản sao của ngày sinh nhật hong là trùng dữ liệu đóa
            sinhNhat.set(Calendar.YEAR, NgayHomNay.get(Calendar.YEAR)); // Thiết lập năm hiện tại để tí tính

            if (sinhNhat.before(NgayHomNay)) {
                sinhNhat.add(Calendar.YEAR, 1); // Nếu sinh nhật đã qua trong năm, cộng thêm 1 năm
            }
            //lấy ngày sinh nhật trừ cho ngày hôm nay nha
            long differenceInMillis = sinhNhat.getTimeInMillis() - NgayHomNay.getTimeInMillis(); // Tính chênh lệch thời gian đang là milis nha
            long daysRemaining = differenceInMillis / (1000 * 60 * 60 * 24); // Chuyển đổi thành ngày

            // Tính tuổi
            int tuoi = NgayHomNay.get(Calendar.YEAR) - ngaySinh[i].get(Calendar.YEAR);
            if (sinhNhat.before(NgayHomNay)) {
                tuoi--; // Giảm tuổi nếu sinh nhật đã qua
            }

            System.out.printf("Người thứ %d: %d ngày còn lại, Tuổi: %d\n", i + 1, daysRemaining, tuoi);
        }

        sc.close(); 
    }
}
