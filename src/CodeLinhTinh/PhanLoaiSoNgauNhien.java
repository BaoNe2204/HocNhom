/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeLinhTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Gia Bao
 */

public class PhanLoaiSoNgauNhien {

    public static void main(String[] args) {
        Random random = new Random(); // Tạo đối tượng Random để sinh số ngẫu nhiên
        List<Integer> soNgauNhien = new ArrayList<>(); // Danh sách lưu trữ các số ngẫu nhiên

        // Sinh 10 số ngẫu nhiên từ 1 đến 100
        for (int i = 0; i < 10; i++) {
            int so = random.nextInt(100) + 1; // Sinh số ngẫu nhiên từ 1 đến 100
            soNgauNhien.add(so); // Thêm số vào danh sách
        }

        // In ra danh sách các số ngẫu nhiên
        System.out.println("Danh sách các số ngẫu nhiên:");
        for (int so : soNgauNhien) {
            System.out.print(so + " "); // In ra từng số
        }
        System.out.println(); // Xuống dòng sau khi in

        // Phân loại các số
        System.out.println("Phân loại:");
        for (int so : soNgauNhien) {
            String phanLoai; // Biến để lưu loại số
            if (so >= 1 && so <= 33) {
                phanLoai = "Thấp";
            } else if (so >= 34 && so <= 66) {
                phanLoai = "Trung bình";
            } else {
                phanLoai = "Cao";
            }
            System.out.printf("Số %d: %s\n", so, phanLoai); // In ra số và loại của nó
        }
    }
}
