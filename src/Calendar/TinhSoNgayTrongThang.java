/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calendar;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class TinhSoNgayTrongThang {

    static Scanner sc = new Scanner(System.in);
    static Calendar Cld = Calendar.getInstance();

    public static void main(String[] args) {
        System.out.println("Mời Bạn nhập năm muốn kiểm tra: ");
        int year = sc.nextInt();
        System.out.println("Mời bạn nhập tháng cần kiểm tra(1-12): ");
        int month = sc.nextInt() - 1;
        Cld.set(year, month,1);
        int MaxDay = Cld.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.printf("Số Ngày trong tháng %d năm %d là: %d%n",month+1,year,MaxDay);
    }

}
