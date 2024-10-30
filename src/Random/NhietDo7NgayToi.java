/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Random;

import java.util.Random;

/**
 *
 * @author Gia Bao
 */
public class NhietDo7NgayToi {

    public static void main(String[] args) {
        Random random = new Random();
        int soNgay = 7;
        int nhietDoMin = 15;
        int nhietDoMax = 30;

        System.out.printf("| %-10s | %-15s |\n", "Ngày", "Nhiệt độ (°C)");
        System.out.println("|------------|-----------------|");

        for (int i = 1; i <= soNgay; i++) {
            int nhietDo = random.nextInt(nhietDoMax - nhietDoMin + 1) + nhietDoMin;
            System.out.printf("| Ngày %2d    | %-15d |\n", i, nhietDo);
        }
    }
}
