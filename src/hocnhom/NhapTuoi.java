/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hocnhom;

import java.util.Scanner;

public class NhapTuoi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mời bạn nhập tồi:");
        int tuoi = sc.nextInt();
        System.out.println((tuoi >= 1 && tuoi < 3) ? "trẻ con"
                : (tuoi >= 3 && tuoi < 6 )? "trể mẩu giáo"
                        : (tuoi >= 6 && tuoi < 12) ? "Nhi đồng"
                                : (tuoi >= 12 && tuoi < 18) ? "thiếu niên"
                                        : (tuoi >= 18 && tuoi < 45) ? "Người trưởng thành"
                                                :(tuoi >= 45 && tuoi <= 65) ? "Trung niên": "Người cao tuổi" );                                  
 }   
}

