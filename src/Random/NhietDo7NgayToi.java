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
        int SoNgay = 7;
        int NhietDoMin = 15;
        int NhietDoMax = 30;
        System.out.println("|Ngày  |  Nhiệt độ(°C)  |");
        System.out.println("|------|----------------|");
        for (int i = 1; i <= SoNgay; i++) {
            int NhietDo = random.nextInt(NhietDoMax - NhietDoMin + 1) + NhietDoMin;//tính nhiệt độ trong ngày ,bỏ hàm random vào for để random được nhìu giá trị nhiệt độ nè
            System.out.printf("|Ngày%2d|    %-12d|\n", i, NhietDo);//%-12d kiểu như là nó chỉnh độ rộng của font printf
        }

    }
}
