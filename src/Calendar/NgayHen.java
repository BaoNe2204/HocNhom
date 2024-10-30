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
public class NgayHen {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập Ngày/Tháng/Năm (dd/mm/yyyy): ");
        String date = sc.nextLine();

        String[] Lich = date.split("/");

        Calendar cld = Calendar.getInstance();
        cld.set(Integer.parseInt(Lich[2]), Integer.parseInt(Lich[1]) - 1, Integer.parseInt(Lich[0]));
        String[] CacThu = {"Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"};
        int Thu = cld.get(Calendar.DAY_OF_WEEK);
        System.out.printf("Ngày hẹn: %d/%d/%d là %s\n", Integer.parseInt(Lich[0]), Integer.parseInt(Lich[1]) +1, Integer.parseInt(Lich[2]), CacThu[Thu - 1]);

    }

}
