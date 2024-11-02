package DuAnDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChuyenDoiHeCoSo extends JFrame {

    // Color constants
    private static final Color BACKGROUND_COLOR = new Color(240, 248, 255); // Màu nền cho comboBox
    private static final Color PANEL_BACKGROUND_COLOR = Color.WHITE; // Màu nền cho panel
    private static final Color BUTTON_COLOR = new Color(70, 130, 180); // Màu nền cho nút
    private static final Color TEXT_FIELD_BORDER_COLOR = new Color(100, 149, 237); // Màu viền cho trường nhập

    // Font constants
    private static final Font FONT_PLAIN_18 = new Font("Arial", Font.PLAIN, 18);
    private static final Font FONT_BOLD_16 = new Font("Arial", Font.BOLD, 16);
    private static final Font FONT_BOLD_24 = new Font("Arial", Font.BOLD, 24);

    private JTextField nhapSoField; // Trường nhập số từ người dùng
    private JTextField ketQuaField; // Trường hiển thị kết quả chuyển đổi
    private JComboBox<Integer> heCoSoTuCombo; // ComboBox chọn hệ cơ số từ
    private JComboBox<Integer> heCoSoDenCombo; // ComboBox chọn hệ cơ số đến
    private CardLayout cardLayout; // Layout để chuyển đổi giữa các panel
    private JPanel mainPanel; // Panel chính chứa các thành phần

    public ChuyenDoiHeCoSo() {
        setTitle("Chuyển Đổi Hệ Cơ Số"); // Tiêu đề của cửa sổ
        setSize(600, 400); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng ứng dụng khi cửa sổ đóng
        setLocationRelativeTo(null); // Đặt cửa sổ ở giữa màn hình
        setResizable(false); // Không cho phép thay đổi kích thước cửa sổ

        // Tạo layout chính
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(245, 245, 245)); // Màu nền cho panel chính

        // Tạo panel nhập liệu
        JPanel panelNhapLieu = taoPanelNhapLieu();
        mainPanel.add(panelNhapLieu, "PanelNhapLieu"); // Thêm panel nhập liệu

        // Tạo panel kết quả
        JPanel panelKetQua = taoPanelKetQua();
        mainPanel.add(panelKetQua, "PanelKetQua"); // Thêm panel kết quả

        add(mainPanel); // Thêm panel chính vào cửa sổ
    }

    private JPanel taoPanelNhapLieu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Sử dụng layout GridBag
        panel.setBorder(BorderFactory.createTitledBorder("Nhập Thông Tin")); // Đặt tiêu đề cho panel
        panel.setBackground(PANEL_BACKGROUND_COLOR); // Màu nền cho panel
        panel.setPreferredSize(new Dimension(500, 300)); // Kích thước ưu tiên cho panel

        GridBagConstraints gbc = new GridBagConstraints(); // Constraints cho GridBagLayout
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần
        gbc.fill = GridBagConstraints.HORIZONTAL; // Lấp đầy chiều ngang

        // Nhãn và trường nhập số
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nhập số:"), gbc); // Thêm nhãn

        nhapSoField = new JTextField(15); // Trường nhập số
        nhapSoField.setFont(FONT_PLAIN_18); // Sử dụng font constant
        nhapSoField.setBorder(BorderFactory.createLineBorder(TEXT_FIELD_BORDER_COLOR, 1)); // Viền cho trường nhập
        gbc.gridx = 1;
        panel.add(nhapSoField, gbc); // Thêm trường nhập số

        // Nhãn và comboBox cho hệ cơ số từ
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Hệ cơ số từ:"), gbc); // Thêm nhãn

        heCoSoTuCombo = new JComboBox<>(new Integer[]{2, 8, 10, 16}); // ComboBox cho hệ cơ số từ
        heCoSoTuCombo.setFont(FONT_PLAIN_18); // Sử dụng font constant
        heCoSoTuCombo.setBackground(BACKGROUND_COLOR); // Màu nền cho comboBox
        gbc.gridx = 1;
        panel.add(heCoSoTuCombo, gbc); // Thêm comboBox

        // Nhãn và comboBox cho hệ cơ số đến
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Hệ cơ số đến:"), gbc); // Thêm nhãn

        heCoSoDenCombo = new JComboBox<>(new Integer[]{2, 8, 10, 16}); // ComboBox cho hệ cơ số đến
        heCoSoDenCombo.setFont(FONT_PLAIN_18); // Sử dụng font constant
        heCoSoDenCombo.setBackground(BACKGROUND_COLOR); // Màu nền cho comboBox
        gbc.gridx = 1;
        panel.add(heCoSoDenCombo, gbc); // Thêm comboBox

        // Nút xem kết quả
        JButton nutXemKetQua = new JButton("Xem Kết Quả");
        nutXemKetQua.addActionListener(e -> {
            String so = nhapSoField.getText(); // Lấy số từ trường nhập
            int heCoSoTu = (Integer) heCoSoTuCombo.getSelectedItem(); // Lấy hệ cơ số từ
            int heCoSoDen = (Integer) heCoSoDenCombo.getSelectedItem(); // Lấy hệ cơ số đến
            try {
                // Gọi logic chuyển đổi và hiển thị kết quả
                String ketQua = ChuyenDoiLogic.chuyenDoi(so, heCoSoTu, heCoSoDen);
                ketQuaField.setText(ketQua); // Hiển thị kết quả
                cardLayout.show(mainPanel, "PanelKetQua"); // Chuyển đến panel kết quả
            } catch (IllegalArgumentException ex) {
                // Hiển thị thông báo lỗi nếu có
                JOptionPane.showMessageDialog(ChuyenDoiHeCoSo.this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
        nutXemKetQua.setBackground(BUTTON_COLOR); // Màu nền cho nút
        nutXemKetQua.setForeground(Color.WHITE); // Màu chữ cho nút
        nutXemKetQua.setFocusPainted(false); // Không hiển thị viền khi nút được chọn
        nutXemKetQua.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Viền cho nút
        nutXemKetQua.setFont(FONT_BOLD_16); // Sử dụng font constant
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Chiếm 2 cột
        panel.add(nutXemKetQua, gbc); // Thêm nút xem kết quả

        return panel; // Trả về panel nhập liệu
    }

    private JPanel taoPanelKetQua() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Kết Quả")); // Đặt tiêu đề cho panel
        panel.setBackground(PANEL_BACKGROUND_COLOR);
        panel.setPreferredSize(new Dimension(500, 300));

        ketQuaField = new JTextField(); // Trường hiển thị kết quả
        ketQuaField.setEditable(false); // Không cho phép chỉnh sửa
        ketQuaField.setFont(FONT_BOLD_24); // Sử dụng font constant
        ketQuaField.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa kết quả
        panel.add(ketQuaField, BorderLayout.CENTER); // Thêm trường kết quả vào giữa panel

        // Nút quay lại
        JButton nutQuayLai = new JButton("Quay lại");
        nutQuayLai.addActionListener(e -> cardLayout.show(mainPanel, "PanelNhapLieu")); // Quay lại panel nhập liệu
        nutQuayLai.setBackground(BUTTON_COLOR); // Màu nền cho nút
        nutQuayLai.setForeground(Color.WHITE); // Màu chữ cho nút
        nutQuayLai.setFocusPainted(false); // Không hiển thị viền khi nút được chọn
        nutQuayLai.setFont(FONT_BOLD_16); // Sử dụng font constant
        panel.add(nutQuayLai, BorderLayout.SOUTH); // Thêm nút quay lại vào dưới panel

        return panel; // Trả về panel kết quả
    }

    // Phương thức chính để khởi động ứng dụng
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChuyenDoiHeCoSo converter = new ChuyenDoiHeCoSo();
            converter.setVisible(true); // Hiển thị cửa sổ
        });
    }
}
