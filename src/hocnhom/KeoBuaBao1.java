/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hocnhom;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class KeoBuaBao1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] LuaChon = {"kéo", "búa", "bao"};
        String NguoiChon;
        System.out.println("Mời nhập kéo bùa bao hoặc thoát(để thoát)");
        while (true) {
            NguoiChon = sc.nextLine().toLowerCase().trim();
            if (NguoiChon.equals("thoat")) {
                break;
            }
            if (!NguoiChon.equals("kéo") && !NguoiChon.equals("búa") && !NguoiChon.equals("bao")) {
                System.out.println("Không hợp lệ. Vui lòng nhập lại.");
                continue;
            }
            String MayChon = LuaChon[random.nextInt(3)];
            System.out.println("Máy chọn là:" + MayChon);
            String KetQua = NguoiChon.equals(MayChon) ? "Hòa"
                    : (NguoiChon.equals("kéo") && MayChon.equals("bao")) ? "Người thắng"
                    : (NguoiChon.equals("bao") && MayChon.equals("búa")) ? "Người thắng"
                    : (NguoiChon.equals("búa") && MayChon.equals("kéo")) ? "Máy thắng"
                    : "Máy thắng";
            System.out.println(KetQua);

        }
        sc.close(); // Đóng scanner khi không sử dụng

    }

}
