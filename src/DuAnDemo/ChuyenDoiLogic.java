package DuAnDemo;

public class ChuyenDoiLogic {

    // Phương thức chính để chuyển đổi từ hệ cơ số này sang hệ cơ số khác
    public static String chuyenDoi(String so, int heCoSoTu, int heCoSoDen) {
        // Chuyển đổi số nhập vào sang hệ cơ số 10
        int soDec = convertToDecimal(so, heCoSoTu);
        // Chuyển đổi từ hệ cơ số 10 sang hệ cơ số đích
        return convertFromDecimal(soDec, heCoSoDen);
    }

    // Phương thức chuyển đổi số từ hệ cơ số tùy chọn sang hệ cơ số 10
    private static int convertToDecimal(String so, int heCoSo) {
        int result = 0; // Khởi tạo kết quả
        for (int i = 0; i < so.length(); i++) {
            char c = so.charAt(i); // Lấy ký tự tại vị trí i
            int digit = Character.digit(c, heCoSo); // Chuyển đổi ký tự thành số trong hệ cơ số
            if (digit < 0) {
                throw new IllegalArgumentException("Số không hợp lệ trong hệ cơ số " + heCoSo); // Kiểm tra tính hợp lệ
            }
            result = result * heCoSo + digit; // Cập nhật giá trị kết quả
        }
        return result; // Trả về giá trị đã chuyển đổi
    }

    // Phương thức chuyển đổi số từ hệ cơ số 10 sang hệ cơ số đích
    private static String convertFromDecimal(int soDec, int heCoSo) {
        if (soDec == 0) return "0"; // Nếu số là 0, trả về "0"

        StringBuilder result = new StringBuilder(); // Sử dụng StringBuilder để xây dựng kết quả
        while (soDec > 0) {
            int digit = soDec % heCoSo; // Tính phần dư
            // Chuyển đổi số thành ký tự tương ứng
            result.insert(0, Character.forDigit(digit, heCoSo)); // Thêm ký tự vào đầu chuỗi kết quả
            soDec /= heCoSo; // Chia số cho hệ cơ số để tiếp tục quá trình
        }
        return result.toString(); // Trả về chuỗi kết quả
    }
}
