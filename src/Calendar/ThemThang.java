/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calendar;

import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author admin
 */
public class ThemThang {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Nhập ngày thứ nhất (dd/mm/yyyy): ");
        String date1 = sc.nextLine();
        System.out.print("Nhập Tháng cần thêm : ");
        int month = sc.nextInt();

        Calendar cld = Calendar.getInstance();
        String[] Phan1 = date1.split("/");
        cld.set(Integer.parseInt(Phan1[2]), Integer.parseInt(Phan1[1]) - 1, Integer.parseInt(Phan1[0]));

        cld.add(Calendar.MONTH, month);

        int newDay = cld.get(Calendar.DAY_OF_MONTH);
        int newMonth = cld.get(Calendar.MONTH) + 1;
        int newYear = cld.get(Calendar.YEAR);

        System.out.printf("Ngày mới sau khi thêm %d tháng: %02d/%02d/%d%n", month, newDay, newMonth, newYear);

    }

}
