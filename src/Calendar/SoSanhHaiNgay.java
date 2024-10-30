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
public class SoSanhHaiNgay {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập ngày thứ nhất (dd/mm/yyyy): ");
        String date1 = sc.nextLine();
        System.out.print("Nhập ngày thứ hai (dd/mm/yyyy): ");
        String date2 = sc.nextLine();
        Calendar cld1 = Calendar.getInstance();
        Calendar cld2 = Calendar.getInstance();

        String[] Phan1 = date1.split("/");
        String[] Phan2 = date2.split("/");

        cld1.set(Integer.parseInt(Phan1[2]), Integer.parseInt(Phan1[1]) - 1, Integer.parseInt(Phan1[0]));
        cld1.set(Integer.parseInt(Phan2[2]), Integer.parseInt(Phan2[1]) - 1, Integer.parseInt(Phan2[0]));

        if (cld1.before(cld2)) {
            System.out.println("Ngày thứ nhất sớm hơn ngày thứ hai.");
        } else if (cld1.after(cld2)) {
            System.out.println("Ngày thứ nhất trễ hơn ngày thứ hai.");
        } else {
            System.out.println("Hai ngày là như nhau.");

        }

    }

}
