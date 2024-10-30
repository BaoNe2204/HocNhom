/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hocnhom;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class SoNguyenDuong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập 1 số:");
        int N = sc.nextInt();
        if (N % 2 == 0 && N > 0) {
            System.out.println(N + " là số nguyên dương và số chẳn");

        } else if (N < 0) {
            System.out.println(N + "Không phải là số nguyên dương");
        } else {
            System.out.println(N + "Không phải là số chẳn");

        }
    }

}
