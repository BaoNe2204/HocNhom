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
public class TinhTuoi {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Mời bạn nhập dd/mm/yyyy :");
        String NgaySinh = scanner.nextLine();

        String[] Phan1 = NgaySinh.split("/");

        Calendar NgaySinhcld = Calendar.getInstance();

        NgaySinhcld.set(Integer.parseInt(Phan1[2]), Integer.parseInt(Phan1[1]) - 1, Integer.parseInt(Phan1[0]));
        Calendar today = Calendar.getInstance();

        int tuoi = today.get(Calendar.YEAR) - NgaySinhcld.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < NgaySinhcld.get(Calendar.DAY_OF_YEAR)) {
            tuoi--;
        }

        System.out.println("Tuổi của bạn là: " + tuoi);

    }

}
