/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Random;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Gia Bao
 */
public class DoanSo {
    public static void main(String[] args) {
        Random random = new Random();
        int soNgauNhien = random.nextInt(100) + 1; // Tạo số ngẫu nhiên từ 1 đến 100
        Scanner sc = new Scanner(System.in);
        System.out.println("Chào mừng bạn đến với trò chơi đoán số!");
        System.out.println("Tôi đã chọn một số ngẫu nhiên từ 1 đến 100.\nBạn hãy đoán xem đó là số nào.");
        int NguoiDungDoan = 0;
        while (soNgauNhien != NguoiDungDoan) {
            System.out.print("Nhập số bạn đoán: ");
            NguoiDungDoan = sc.nextInt(); // Nhận số người dùng đoán
            if (NguoiDungDoan < soNgauNhien) {
                System.out.println("Cao hơn!"); // Gợi ý nếu số đoán thấp hơn
            } else if (NguoiDungDoan > soNgauNhien) {
                System.out.println("Thấp hơn!"); // Gợi ý nếu số đoán cao hơn
            } else {
                System.out.println("Đúng rồi! Số tôi chọn là: " + soNgauNhien);
            }
        }
        sc.close();
    }

}
