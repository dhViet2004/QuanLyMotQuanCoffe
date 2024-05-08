package gui;

import connectDB.ConnectionDB;
import com.sun.jdi.connect.spi.Connection;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.HoaDon_Dao;
import entity.Nuoc;
import dao.Nuoc_DAO;
import dao.ThongKe_DAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import entity.KhachHang;
import entity.Login;
import entity.NhanVien;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import entity.HoaDon;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class GiaoDienChinh_GUI extends javax.swing.JFrame {

    Nuoc_DAO nuocDAO;
    private KhachHang_DAO khachHang_DAO;
    private int diemThanhVien;
    private Map<String, Object> productInfoMap = new HashMap<>();
    private Object e;
    private GridBagConstraints gbc;
    private JButton giam;
    private JTextField textField_SL;
    private NhanVien authenticatedEmployee;
    private Login authenticatedUser;
    public GiaoDienChinh_GUI(NhanVien userMaNv) throws SQLException {
        
        // tạo kết nối
        ConnectionDB.getInstance().connect();
        initComponents();
        addEventListenersChinh();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        nuocDAO = new Nuoc_DAO(); // Khởi tạo đối tượng Nuoc_DAO
        showDataToTable(); // Hiển thị dữ liệu lên bảng
        setLocationRelativeTo(null);
        setResizable(false);
        khachHang_DAO = new KhachHang_DAO(); // Khởi tạo đối tượng KhachHang_DAO
        updateTableKhachHang();
        txtMaNV.setText(userMaNv.getMaNhanVien());
        txtHoTenNV.setText(userMaNv.getHoTen());
        txtChucVu.setText(userMaNv.getChucVu());
    }

    private void addEventListenersChinh() {
        // Thêm sự kiện cho button Thống kê
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(btnThongKe); // Thay đổi màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(btnThongKe); // Khôi phục màu khi di chuột ra
            }
        });

        // Thêm sự kiện cho button Employee Benefits
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(btnKhachHang); // Thay đổi màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(btnKhachHang); // Khôi phục màu khi di chuột ra
            }
        });

        // Thêm sự kiện cho button Tại bàn
        btnTaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(btnTaiBan); // Thay đổi màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(btnTaiBan); // Khôi phục màu khi di chuột ra
            }
        });

        // Thêm sự kiện cho button Tại quầy
        btnCaiDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(btnCaiDat); // Thay đổi màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(btnCaiDat); // Khôi phục màu khi di chuột ra
            }
        });

        // Thêm sự kiện cho button Trang chủ
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setColor(btnTrangChu); // Thay đổi màu khi di chuột vào
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetColor(btnTrangChu); // Khôi phục màu khi di chuột ra
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidepane = new javax.swing.JPanel();
        btnQuanLy = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnKhachHang = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTaiBan = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCaiDat = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTrangChu = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtChucVu = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        pnContainer = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnEpTraiCay = new javax.swing.JButton();
        btnNuocCoga = new javax.swing.JButton();
        btnNuocSuoi = new javax.swing.JButton();
        btnCaPhe = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnNuocCoGa = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelThanhToan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btn_ThanhToan = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnDeleteAll = new javax.swing.JButton();
        lblThanhTien = new javax.swing.JTextField();
        TaiBan = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        CaiDat = new javax.swing.JPanel();
        QuanLy = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtMaSize = new javax.swing.JTextField();
        txtDanhMuc = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        txtGiaTien = new javax.swing.JTextField();
        txtMaLoai = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnXoaRong = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        KhachHang = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDiemTV = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        addKH = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        ThongKe = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        sidepane.setBackground(new java.awt.Color(204, 255, 255));
        sidepane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuanLy.setBackground(new java.awt.Color(223, 255, 254));
        btnQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnQuanLyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnQuanLyMouseExited(evt);
            }
        });

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/quanlyNuoc.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Quản lý nước");

        javax.swing.GroupLayout btnQuanLyLayout = new javax.swing.GroupLayout(btnQuanLy);
        btnQuanLy.setLayout(btnQuanLyLayout);
        btnQuanLyLayout.setHorizontalGroup(
            btnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnQuanLyLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnQuanLyLayout.setVerticalGroup(
            btnQuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnQuanLyLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnQuanLy, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 290, 60));

        btnThongKe.setBackground(new java.awt.Color(223, 255, 254));
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thống kê");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnThongKeLayout = new javax.swing.GroupLayout(btnThongKe);
        btnThongKe.setLayout(btnThongKeLayout);
        btnThongKeLayout.setHorizontalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThongKeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnThongKeLayout.setVerticalGroup(
            btnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThongKeLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 290, 60));

        btnKhachHang.setBackground(new java.awt.Color(223, 255, 254));
        btnKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhachHangMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/customer.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Khách hàng");

        javax.swing.GroupLayout btnKhachHangLayout = new javax.swing.GroupLayout(btnKhachHang);
        btnKhachHang.setLayout(btnKhachHangLayout);
        btnKhachHangLayout.setHorizontalGroup(
            btnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKhachHangLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnKhachHangLayout.setVerticalGroup(
            btnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKhachHangLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 290, 60));

        btnTaiBan.setBackground(new java.awt.Color(223, 255, 254));
        btnTaiBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaiBanMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/store.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tại bàn");

        javax.swing.GroupLayout btnTaiBanLayout = new javax.swing.GroupLayout(btnTaiBan);
        btnTaiBan.setLayout(btnTaiBanLayout);
        btnTaiBanLayout.setHorizontalGroup(
            btnTaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTaiBanLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnTaiBanLayout.setVerticalGroup(
            btnTaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTaiBanLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnTaiBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 290, 60));

        btnCaiDat.setBackground(new java.awt.Color(223, 255, 254));
        btnCaiDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaiDatMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caiDac.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Cài đặt");

        javax.swing.GroupLayout btnCaiDatLayout = new javax.swing.GroupLayout(btnCaiDat);
        btnCaiDat.setLayout(btnCaiDatLayout);
        btnCaiDatLayout.setHorizontalGroup(
            btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnCaiDatLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnCaiDatLayout.setVerticalGroup(
            btnCaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnCaiDatLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnCaiDat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 290, 60));

        btnTrangChu.setBackground(new java.awt.Color(223, 255, 254));
        btnTrangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrangChuMouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/home.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Trang chủ");

        javax.swing.GroupLayout btnTrangChuLayout = new javax.swing.GroupLayout(btnTrangChu);
        btnTrangChu.setLayout(btnTrangChuLayout);
        btnTrangChuLayout.setHorizontalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTrangChuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        btnTrangChuLayout.setVerticalGroup(
            btnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTrangChuLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18))
        );

        sidepane.add(btnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/store.png"))); // NOI18N
        jLabel13.setText("   Chill Coffee");
        jLabel13.setToolTipText("");
        sidepane.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 70));

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        sidepane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 270, 60));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        sidepane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("Chức vụ:");
        sidepane.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setText("Họ tên:");
        sidepane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, -1, -1));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setText("Mã NV:");
        sidepane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        txtChucVu.setEditable(false);
        txtChucVu.setBackground(new java.awt.Color(207, 255, 255));
        txtChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtChucVu.setBorder(null);
        sidepane.add(txtChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 190, 30));

        txtMaNV.setEditable(false);
        txtMaNV.setBackground(new java.awt.Color(207, 255, 255));
        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaNV.setBorder(null);
        sidepane.add(txtMaNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 190, 30));

        txtHoTenNV.setEditable(false);
        txtHoTenNV.setBackground(new java.awt.Color(207, 255, 255));
        txtHoTenNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHoTenNV.setBorder(null);
        sidepane.add(txtHoTenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 190, 30));

        pnContainer.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(802, 111));
        jPanel1.setMinimumSize(new java.awt.Dimension(802, 111));
        jPanel1.setPreferredSize(new java.awt.Dimension(802, 111));

        btnEpTraiCay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEpTraiCay.setText("Trà trái cây");
        btnEpTraiCay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEpTraiCayMouseClicked(evt);
            }
        });
        btnEpTraiCay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEpTraiCayActionPerformed(evt);
            }
        });
        btnEpTraiCay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnEpTraiCayKeyTyped(evt);
            }
        });

        btnNuocCoga.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuocCoga.setText("Cà phê máy");
        btnNuocCoga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuocCogaMouseClicked(evt);
            }
        });
        btnNuocCoga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuocCogaActionPerformed(evt);
            }
        });

        btnNuocSuoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuocSuoi.setText("Cà phê VN");
        btnNuocSuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuocSuoiMouseClicked(evt);
            }
        });
        btnNuocSuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuocSuoiActionPerformed(evt);
            }
        });

        btnCaPhe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCaPhe.setText("Khác");
        btnCaPhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCaPheMouseClicked(evt);
            }
        });
        btnCaPhe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaPheActionPerformed(evt);
            }
        });

        btnTatCa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTatCa.setText("Tất cả");
        btnTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTatCaMouseClicked(evt);
            }
        });

        jButton1.setText("Tìm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtTim.setForeground(new java.awt.Color(204, 204, 204));
        txtTim.setText("Nhập Mã");
        txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimFocusLost(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnNuocCoga, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnNuocSuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnEpTraiCay, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnCaPhe, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txtTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuocCoga, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuocSuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEpTraiCay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaPhe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout pnNuocCoGaLayout = new javax.swing.GroupLayout(pnNuocCoGa);
        pnNuocCoGa.setLayout(pnNuocCoGaLayout);
        pnNuocCoGaLayout.setHorizontalGroup(
            pnNuocCoGaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1181, Short.MAX_VALUE)
        );
        pnNuocCoGaLayout.setVerticalGroup(
            pnNuocCoGaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnNuocCoGa);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        label1.setText("Thanh Toán");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        panelThanhToan.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelThanhToanLayout = new javax.swing.GroupLayout(panelThanhToan);
        panelThanhToan.setLayout(panelThanhToanLayout);
        panelThanhToanLayout.setHorizontalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );
        panelThanhToanLayout.setVerticalGroup(
            panelThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(panelThanhToan);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btn_ThanhToan.setBackground(new java.awt.Color(0, 204, 51));
        btn_ThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThanhToan.setText("Thanh Toán");
        btn_ThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThanhToanMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Total");

        btnDeleteAll.setBackground(new java.awt.Color(255, 51, 0));
        btnDeleteAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeleteAll.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAll.setText("Xóa Tất Cả");
        btnDeleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteAllMouseClicked(evt);
            }
        });

        lblThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThanhTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblThanhTien.setText("0.0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThanhTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(77, 77, 77))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 307, Short.MAX_VALUE))
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HomeLayout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 311, Short.MAX_VALUE)))
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                    .addGap(0, 909, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 583, Short.MAX_VALUE))
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                    .addContainerGap(119, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HomeLayout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pnContainer.add(Home, "card8");

        TaiBan.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(51, 51, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Bàn 1");

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Bàn 2");

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Bàn 3");

        jButton6.setBackground(new java.awt.Color(51, 51, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Bàn 4");

        jButton7.setBackground(new java.awt.Color(51, 51, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Bàn 5");

        jButton8.setBackground(new java.awt.Color(51, 51, 255));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Bàn 6");

        jButton9.setBackground(new java.awt.Color(51, 51, 255));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Bàn 8");

        jButton10.setBackground(new java.awt.Color(51, 51, 255));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Bàn 7");

        jButton11.setBackground(new java.awt.Color(51, 51, 255));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Bàn 9");

        jButton12.setBackground(new java.awt.Color(51, 51, 255));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Bàn 10");

        jButton13.setBackground(new java.awt.Color(51, 51, 255));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Bàn 12");

        jButton14.setBackground(new java.awt.Color(51, 51, 255));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Bàn 11");

        jButton15.setBackground(new java.awt.Color(51, 51, 255));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Bàn 13");

        jButton16.setBackground(new java.awt.Color(51, 51, 255));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Bàn 14");

        jButton17.setBackground(new java.awt.Color(51, 51, 255));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("Bàn 16");

        jButton18.setBackground(new java.awt.Color(51, 51, 255));
        jButton18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Bàn 15");

        jButton19.setBackground(new java.awt.Color(51, 51, 255));
        jButton19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Bàn 17");

        jButton20.setBackground(new java.awt.Color(51, 51, 255));
        jButton20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Bàn 18");

        jButton21.setBackground(new java.awt.Color(51, 51, 255));
        jButton21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Bàn 20");

        jButton22.setBackground(new java.awt.Color(51, 51, 255));
        jButton22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Bàn 19");

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel12.setText("Hóa đơn");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(137, 137, 137))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 502, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel34.setText("Danh sách bàn");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(204, 204, 204))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel34)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TaiBanLayout = new javax.swing.GroupLayout(TaiBan);
        TaiBan.setLayout(TaiBanLayout);
        TaiBanLayout.setHorizontalGroup(
            TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiBanLayout.createSequentialGroup()
                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TaiBanLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TaiBanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        TaiBanLayout.setVerticalGroup(
            TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TaiBanLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TaiBanLayout.createSequentialGroup()
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(TaiBanLayout.createSequentialGroup()
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TaiBanLayout.createSequentialGroup()
                                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(TaiBanLayout.createSequentialGroup()
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(TaiBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pnContainer.add(TaiBan, "card4");

        javax.swing.GroupLayout CaiDatLayout = new javax.swing.GroupLayout(CaiDat);
        CaiDat.setLayout(CaiDatLayout);
        CaiDatLayout.setHorizontalGroup(
            CaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1219, Short.MAX_VALUE)
        );
        CaiDatLayout.setVerticalGroup(
            CaiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        pnContainer.add(CaiDat, "card5");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Mã size");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Danh mục");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Mô tả");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Mã sản phẩm");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Mã loại");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Tên sản phẩm");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setText("Giá tiền");

        txtMaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSizeActionPerformed(evt);
            }
        });

        txtMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoTaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaSize, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                                    .addComponent(txtDanhMuc)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(103, 103, 103)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Mã loại", "Mã size", "Tên sản phẩm", "Danh mục", "Giá tiền", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(327, Short.MAX_VALUE)))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(0, 153, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 51));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaSP.setBackground(new java.awt.Color(255, 51, 0));
        btnXoaSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoaSP.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaSP.setText("Xóa");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnXoaRong.setBackground(new java.awt.Color(255, 153, 0));
        btnXoaRong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXoaRong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaRong.setText("Xóa rỗng");
        btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRongActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(102, 255, 102));
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnXuatFile.setText("Xuất File");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnXoaRong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(btnXuatFile)
                .addGap(59, 59, 59))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaRong, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout QuanLyLayout = new javax.swing.GroupLayout(QuanLy);
        QuanLy.setLayout(QuanLyLayout);
        QuanLyLayout.setHorizontalGroup(
            QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1219, Short.MAX_VALUE)
            .addGroup(QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        QuanLyLayout.setVerticalGroup(
            QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
            .addGroup(QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 120, Short.MAX_VALUE)))
            .addGroup(QuanLyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyLayout.createSequentialGroup()
                    .addContainerGap(533, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pnContainer.add(QuanLy, "card6");

        KhachHang.setBackground(new java.awt.Color(255, 255, 255));

        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Điểm thành viên"
            }
        ));
        tableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKhachHangMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableKhachHang);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setText("Họ tên");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel35.setText("Mã Khách hàng");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel36.setText("Điểm thành viên");

        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        addKH.setBackground(new java.awt.Color(0, 153, 0));
        addKH.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        addKH.setForeground(new java.awt.Color(255, 255, 255));
        addKH.setText("Thêm");
        addKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKHActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(255, 102, 0));
        jButton25.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Sửa");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(204, 0, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("Xóa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel36)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(addKH)))
                .addGap(49, 49, 49)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemTV, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel35)
                    .addContainerGap(451, Short.MAX_VALUE)))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtDiemTV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addKH)
                    .addComponent(jButton25)
                    .addComponent(jButton23))
                .addGap(89, 89, 89))
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addGap(48, 48, 48)
                    .addComponent(jLabel35)
                    .addContainerGap(424, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout KhachHangLayout = new javax.swing.GroupLayout(KhachHang);
        KhachHang.setLayout(KhachHangLayout);
        KhachHangLayout.setHorizontalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        KhachHangLayout.setVerticalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150))
        );

        pnContainer.add(KhachHang, "card7");

        ThongKe.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(204, 255, 255));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setText("Hàng hóa");

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

        jComboBox1.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hôm qua", "Hôm nay", "Tháng này", " " }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(204, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Chill Coffe");

        jButton24.setBackground(new java.awt.Color(204, 255, 255));
        jButton24.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton24.setText("Lịch sử");
        jButton24.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 601, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(23, 23, 23))
        );

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("Top sản phẩm bán chạy");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Tổng doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jComboBox4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setText("Năm");

        jButton2.setBackground(new java.awt.Color(204, 204, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Thống kê");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Thời gian", "Số lượng hóa đơn", "Tổng doanh thu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable3);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setText("Tổng số hóa đơn");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jPanel14ComponentHidden(evt);
            }
        });

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày mua", "Mã nhân viên", "Mã khách hàng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable6);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("Lịch sử mua hàng");

        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026" }));

        jButton26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 0, 0));
        jButton26.setText("Lọc");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton26MouseClicked(evt);
            }
        });
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Tháng");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setText("Năm");

        jButton27.setBackground(new java.awt.Color(255, 255, 153));
        jButton27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton27.setText("In");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton26))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ThongKeLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(ThongKeLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnContainer.add(ThongKe, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1234, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(309, Short.MAX_VALUE)
                    .addComponent(pnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidepane, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 688, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked
        Home.setVisible(false);
        QuanLy.setVisible(false);
        ThongKe.setVisible(true);
        TaiBan.setVisible(false);
        CaiDat.setVisible(false);
        KhachHang.setVisible(false);
    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachHangMouseClicked
        Home.setVisible(false);
        QuanLy.setVisible(false);
        ThongKe.setVisible(false);
        TaiBan.setVisible(false);
        CaiDat.setVisible(false);
        KhachHang.setVisible(true);
    }//GEN-LAST:event_btnKhachHangMouseClicked

    private void btnTaiBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaiBanMouseClicked
        Home.setVisible(false);
        QuanLy.setVisible(false);
        ThongKe.setVisible(false);
        TaiBan.setVisible(true);
        CaiDat.setVisible(false);
        KhachHang.setVisible(false);

    }//GEN-LAST:event_btnTaiBanMouseClicked

    private void btnTrangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrangChuMouseClicked
        Home.setVisible(true);
        QuanLy.setVisible(false);
        ThongKe.setVisible(false);
        TaiBan.setVisible(false);
        CaiDat.setVisible(false);
        KhachHang.setVisible(false);


    }//GEN-LAST:event_btnTrangChuMouseClicked

    private void btnCaPheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaPheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCaPheActionPerformed

    private void btnNuocSuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuocSuoiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuocSuoiActionPerformed

    private void btnNuocCogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuocCogaActionPerformed

    }//GEN-LAST:event_btnNuocCogaActionPerformed

    private void btnNuocCogaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuocCogaMouseClicked
        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridBagLayout());
        pnNuocCoGa.setBackground(Color.WHITE);

        Nuoc_DAO dao = new Nuoc_DAO();
        List<Nuoc> nuocs = null;
        try {
            nuocs = dao.getAllListByType("L001");
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Đặt lại gbc.gridx về 0
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        for (Nuoc n : nuocs) {
            JPanel pnSanPham = new JPanel();
            pnSanPham.setBackground(Color.WHITE);
            pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnSanPham.setPreferredSize(new Dimension(200, 270));
            pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            JLabel lblImg = new JLabel();
            lblImg.setPreferredSize(new Dimension(180, 150));
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
            lblImg.setIcon(scaleIcon(icon, 180, 150));

            JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
            lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

            JButton btnThem = new JButton("Thêm");
            Font font = new Font("Segoe UI", Font.BOLD, 16);
            btnThem.setFont(font);
            btnThem.setBackground(new Color(223, 255, 254));
            btnThem.setForeground(Color.BLACK);

            pnSanPham.setLayout(new BorderLayout());
            pnSanPham.add(lblImg, BorderLayout.NORTH);

            JPanel panelMid = new JPanel();
            panelMid.setBackground(Color.WHITE);
            panelMid.setLayout(new BorderLayout());
            panelMid.add(lblTenSanPham, BorderLayout.WEST);
            panelMid.add(lblGia, BorderLayout.EAST);
            pnSanPham.add(panelMid, BorderLayout.CENTER);

            JPanel panelSouth = new JPanel();
            panelSouth.setBackground(Color.WHITE);
            panelSouth.add(btnThem);
            pnSanPham.add(panelSouth, BorderLayout.SOUTH);

            // Thêm JPanel vào pnNuocCoGa sử dụng GridBagConstraints
            pnNuocCoGa.add(pnSanPham, gbc);

            // Tăng chỉ số cột (gbc.gridx) và xử lý vị trí theo lưới
            gbc.gridx++;
            if (gbc.gridx > 3) {
                gbc.gridx = 0; // Quay lại cột đầu tiên nếu đạt số cột tối đa
                gbc.gridy++; // Chuyển sang dòng tiếp theo
            }

            // Đăng ký sự kiện cho nút "Thêm"
            btnThem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Xử lý khi nút "Thêm" được nhấp
                    addProductToMap(n.getTenSanPham(), n); // Thêm sản phẩm vào productInfoMap
                    updateTable2(); // Cập nhật bảng table2 với thông tin mới
                }
            });
        }

        // Cập nhật giao diện
        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();

    }//GEN-LAST:event_btnNuocCogaMouseClicked

    private void btnEpTraiCayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEpTraiCayActionPerformed

    }//GEN-LAST:event_btnEpTraiCayActionPerformed

    private void btnNuocSuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuocSuoiMouseClicked
        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridBagLayout());
        pnNuocCoGa.setBackground(Color.WHITE);

        Nuoc_DAO dao = new Nuoc_DAO();
        List<Nuoc> nuocs = null;
        try {
            nuocs = dao.getAllListByType("L002");
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Đặt lại gbc.gridx về 0
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        for (Nuoc n : nuocs) {
            JPanel pnSanPham = new JPanel();
            pnSanPham.setBackground(Color.WHITE);
            pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnSanPham.setPreferredSize(new Dimension(200, 270));
            pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            JLabel lblImg = new JLabel();
            lblImg.setPreferredSize(new Dimension(180, 150));
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
            lblImg.setIcon(scaleIcon(icon, 180, 150));

            JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
            lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

            JButton btnThem = new JButton("Thêm");
            Font font = new Font("Segoe UI", Font.BOLD, 16);
            btnThem.setFont(font);
            btnThem.setBackground(new Color(223, 255, 254));
            btnThem.setForeground(Color.BLACK);

            pnSanPham.setLayout(new BorderLayout());
            pnSanPham.add(lblImg, BorderLayout.NORTH);

            JPanel panelMid = new JPanel();
            panelMid.setBackground(Color.WHITE);
            panelMid.setLayout(new BorderLayout());
            panelMid.add(lblTenSanPham, BorderLayout.WEST);
            panelMid.add(lblGia, BorderLayout.EAST);
            pnSanPham.add(panelMid, BorderLayout.CENTER);

            JPanel panelSouth = new JPanel();
            panelSouth.setBackground(Color.WHITE);
            panelSouth.add(btnThem);
            pnSanPham.add(panelSouth, BorderLayout.SOUTH);

            // Thêm JPanel vào pnNuocCoGa sử dụng GridBagConstraints
            pnNuocCoGa.add(pnSanPham, gbc);

            // Tăng chỉ số cột (gbc.gridx) và xử lý vị trí theo lưới
            gbc.gridx++;
            if (gbc.gridx > 3) {
                gbc.gridx = 0; // Quay lại cột đầu tiên nếu đạt số cột tối đa
                gbc.gridy++; // Chuyển sang dòng tiếp theo
            }

            // Đăng ký sự kiện cho nút "Thêm"
            btnThem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Xử lý khi nút "Thêm" được nhấp
                    addProductToMap(n.getTenSanPham(), n); // Thêm sản phẩm vào productInfoMap
                    updateTable2(); // Cập nhật bảng table2 với thông tin mới
                }
            });
        }

        // Cập nhật giao diện
        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();
    }//GEN-LAST:event_btnNuocSuoiMouseClicked


    private void btnTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTatCaMouseClicked
        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridLayout(0, 4, 10, 10)); // Sử dụng GridLayout cho JPanel chứa sản phẩm
        pnNuocCoGa.setBackground(Color.WHITE);
        //add(new JScrollPane(pnNuocCoGa), BorderLayout.CENTER); // Thêm jPanelSPS vào JScrollPane và đặt vị trí ở CENTER

        // Lấy danh sách sản phẩm từ DAO
        Nuoc_DAO dao = new Nuoc_DAO();
        List<Nuoc> nuocs = null;
        try {
            nuocs = dao.getAllList();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Nuoc n : nuocs) {
            JPanel pnSanPham = new JPanel();
            pnSanPham.setBackground(Color.WHITE);
            pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnSanPham.setLayout(new BorderLayout(10, 10));
            pnSanPham.setPreferredSize(new Dimension(200, 270));
            pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            JLabel lblImg = new JLabel();
            lblImg.setPreferredSize(new Dimension(180, 150));
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
            lblImg.setIcon(scaleIcon(icon, 180, 150));

            JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
            lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

            JButton btnThem = new JButton("Thêm");
            Font font = new Font("Segoe UI", Font.BOLD, 16);
            btnThem.setFont(font);
            btnThem.setBackground(new Color(223, 255, 254)); // Đặt màu nền là màu xanh lam
            btnThem.setForeground(Color.BLACK);
            //btnThem.setIcon(new ImageIcon(getClass().getResource("/img/suoi.png"))); // Đặt biểu tượng cho nút "Thêm"
            //btnThem.setPreferredSize(new Dimension(30, 30)); // Đặt kích thước cho nút "Thêm"

            JPanel panelMid = new JPanel();
            panelMid.setBackground(Color.WHITE);
            panelMid.setLayout(new BorderLayout());
            panelMid.add(lblTenSanPham, BorderLayout.WEST);
            panelMid.add(lblGia, BorderLayout.EAST);

            JPanel panelSouth = new JPanel();
            panelSouth.setBackground(Color.WHITE);
            panelSouth.setLayout(new BorderLayout());
            panelSouth.add(btnThem, BorderLayout.CENTER);

            pnSanPham.add(lblImg, BorderLayout.NORTH);
            pnSanPham.add(panelMid, BorderLayout.CENTER);
            pnSanPham.add(panelSouth, BorderLayout.SOUTH);

            pnNuocCoGa.add(pnSanPham); // Thêm panel sản phẩm vào jPanelSPS
            btnThem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Xử lý khi nút "Thêm" được nhấp

                    addProductToMap(n.getTenSanPham(), n); // Thêm sản phẩm vào productInfoMap
                    updateTable2(); // Cập nhật bảng table2 với thông tin mới
                }
            });
        }
        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();
    }//GEN-LAST:event_btnTatCaMouseClicked

    private void btnEpTraiCayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEpTraiCayMouseClicked
        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridBagLayout());
        pnNuocCoGa.setBackground(Color.WHITE);

        Nuoc_DAO dao = new Nuoc_DAO();
        List<Nuoc> nuocs = null;
        try {
            nuocs = dao.getAllListByType("L003");
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Đặt lại gbc.gridx về 0
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        for (Nuoc n : nuocs) {
            JPanel pnSanPham = new JPanel();
            pnSanPham.setBackground(Color.WHITE);
            pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnSanPham.setPreferredSize(new Dimension(200, 270));
            pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));

            JLabel lblImg = new JLabel();
            lblImg.setPreferredSize(new Dimension(180, 150));
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
            lblImg.setIcon(scaleIcon(icon, 180, 150));

            JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
            lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

            JButton btnThem = new JButton("Thêm");
            Font font = new Font("Segoe UI", Font.BOLD, 16);
            btnThem.setFont(font);
            btnThem.setBackground(new Color(223, 255, 254));
            btnThem.setForeground(Color.BLACK);

            pnSanPham.setLayout(new BorderLayout());
            pnSanPham.add(lblImg, BorderLayout.NORTH);

            JPanel panelMid = new JPanel();
            panelMid.setBackground(Color.WHITE);
            panelMid.setLayout(new BorderLayout());
            panelMid.add(lblTenSanPham, BorderLayout.WEST);
            panelMid.add(lblGia, BorderLayout.EAST);
            pnSanPham.add(panelMid, BorderLayout.CENTER);

            JPanel panelSouth = new JPanel();
            panelSouth.setBackground(Color.WHITE);
            panelSouth.add(btnThem);
            pnSanPham.add(panelSouth, BorderLayout.SOUTH);

            // Thêm JPanel vào pnNuocCoGa sử dụng GridBagConstraints
            pnNuocCoGa.add(pnSanPham, gbc);

            // Tăng chỉ số cột (gbc.gridx) và xử lý vị trí theo lưới
            gbc.gridx++;
            if (gbc.gridx > 3) {
                gbc.gridx = 0; // Quay lại cột đầu tiên nếu đạt số cột tối đa
                gbc.gridy++; // Chuyển sang dòng tiếp theo
            }

            // Đăng ký sự kiện cho nút "Thêm"
            btnThem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Xử lý khi nút "Thêm" được nhấp
                    addProductToMap(n.getTenSanPham(), n); // Thêm sản phẩm vào productInfoMap
                    updateTable2(); // Cập nhật bảng table2 với thông tin mới
                }
            });
        }

        // Cập nhật giao diện
        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();
    }//GEN-LAST:event_btnEpTraiCayMouseClicked

    private void btnCaPheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaPheMouseClicked
        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridLayout(0, 4, 10, 10)); // Sử dụng GridLayout cho JPanel chứa sản phẩm
        pnNuocCoGa.setBackground(Color.WHITE);
        //add(new JScrollPane(pnNuocCoGa), BorderLayout.CENTER); // Thêm jPanelSPS vào JScrollPane và đặt vị trí ở CENTER

        // Lấy danh sách sản phẩm từ DAO
        Nuoc_DAO dao = new Nuoc_DAO();
        List<Nuoc> nuocs = null;
        try {
            nuocs = dao.getAllListByType("L004");
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Nuoc n : nuocs) {
            JPanel pnSanPham = new JPanel();
            pnSanPham.setBackground(Color.WHITE);
            pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            pnSanPham.setLayout(new BorderLayout(10, 10));
            pnSanPham.setPreferredSize(new Dimension(200, 270));
            pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(0, 0, 0)),
                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            JLabel lblImg = new JLabel();
            lblImg.setPreferredSize(new Dimension(180, 150));
            ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
            lblImg.setIcon(scaleIcon(icon, 180, 150));

            JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
            lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

            JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

            JButton btnThem = new JButton("Thêm");
            Font font = new Font("Segoe UI", Font.BOLD, 16);
            btnThem.setFont(font);
            btnThem.setBackground(new Color(223, 255, 254)); // Đặt màu nền là màu xanh lam
            btnThem.setForeground(Color.BLACK);
            //btnThem.setIcon(new ImageIcon(getClass().getResource("/img/suoi.png"))); // Đặt biểu tượng cho nút "Thêm"
            //btnThem.setPreferredSize(new Dimension(30, 30)); // Đặt kích thước cho nút "Thêm"

            JPanel panelMid = new JPanel();
            panelMid.setBackground(Color.WHITE);
            panelMid.setLayout(new BorderLayout());
            panelMid.add(lblTenSanPham, BorderLayout.WEST);
            panelMid.add(lblGia, BorderLayout.EAST);

            JPanel panelSouth = new JPanel();
            panelSouth.setBackground(Color.WHITE);
            panelSouth.setLayout(new BorderLayout());
            panelSouth.add(btnThem, BorderLayout.CENTER);

            pnSanPham.add(lblImg, BorderLayout.NORTH);
            pnSanPham.add(panelMid, BorderLayout.CENTER);
            pnSanPham.add(panelSouth, BorderLayout.SOUTH);

            pnNuocCoGa.add(pnSanPham); // Thêm panel sản phẩm vào jPanelSPS
        }
        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();
    }//GEN-LAST:event_btnCaPheMouseClicked

    private void btnEpTraiCayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEpTraiCayKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEpTraiCayKeyTyped

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        pnNuocCoGa.removeAll();
        pnNuocCoGa.setLayout(new GridBagLayout());
        pnNuocCoGa.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Đặt lại gbc.gridx về 0
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.weightx = 1;
        gbc.weighty = 1;
        String maSanPham = txtTim.getText().trim(); // Lấy và loại bỏ các khoảng trắng ở hai đầu của chuỗi

        // Kiểm tra xem mã sản phẩm có hợp lệ không
        if (maSanPham.isEmpty() || maSanPham.equals("Nhập Mã")) {
            // Hiển thị thông báo nếu không có mã sản phẩm được nhập
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return; // Kết thúc phương thức nếu không có mã sản phẩm
        }

        // Lấy danh sách sản phẩm từ DAO
        Nuoc_DAO dao = new Nuoc_DAO();
        try {
            Nuoc n = dao.getProductByCode(maSanPham);
            if (n != null) {
                // Sản phẩm được tìm thấy, thực hiện các hành động cần thiết

                JPanel pnSanPham = new JPanel();
                pnSanPham.setBackground(Color.WHITE);
                pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pnSanPham.setPreferredSize(new Dimension(200, 270));
                pnSanPham.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(0, 0, 0)),
                        BorderFactory.createEmptyBorder(10, 10, 10, 10)));

                JLabel lblImg = new JLabel();
                lblImg.setPreferredSize(new Dimension(180, 150));
                ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
                lblImg.setIcon(scaleIcon(icon, 180, 150));

                JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.LEFT);
                lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

                JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.RIGHT);

                JButton btnThem = new JButton("Thêm");
                Font font = new Font("Segoe UI", Font.BOLD, 16);
                btnThem.setFont(font);
                btnThem.setBackground(new Color(223, 255, 254));
                btnThem.setForeground(Color.BLACK);

                pnSanPham.setLayout(new BorderLayout());
                pnSanPham.add(lblImg, BorderLayout.NORTH);

                JPanel panelMid = new JPanel();
                panelMid.setBackground(Color.WHITE);
                panelMid.setLayout(new BorderLayout());
                panelMid.add(lblTenSanPham, BorderLayout.WEST);
                panelMid.add(lblGia, BorderLayout.EAST);
                pnSanPham.add(panelMid, BorderLayout.CENTER);

                JPanel panelSouth = new JPanel();
                panelSouth.setBackground(Color.WHITE);
                panelSouth.add(btnThem);
                pnSanPham.add(panelSouth, BorderLayout.SOUTH);

                // Thêm JPanel vào pnNuocCoGa sử dụng GridBagConstraints
                pnNuocCoGa.add(pnSanPham, gbc);

                // Tăng chỉ số cột (gbc.gridx) và xử lý vị trí theo lưới
                gbc.gridx++;
                if (gbc.gridx > 3) {
                    gbc.gridx = 0; // Quay lại cột đầu tiên nếu đạt số cột tối đa
                    gbc.gridy++; // Chuyển sang dòng tiếp theo
                }

                // Đăng ký sự kiện cho nút "Thêm"
                btnThem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Xử lý khi nút "Thêm" được nhấp
                        addProductToMap(n.getTenSanPham(), n); // Thêm sản phẩm vào productInfoMap
                        updateTable2(); // Cập nhật bảng table2 với thông tin mới
                    }
                });
            } else {
                JOptionPane.showMessageDialog(this, "Không Tìm thấy Sản Phẩm", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        pnNuocCoGa.revalidate();
        pnNuocCoGa.repaint();
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtTimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusGained
        if (txtTim.getText().equals("Nhập Mã")) {
            txtTim.setText("");
            txtTim.setForeground(Color.BLACK);
        }

    }//GEN-LAST:event_txtTimFocusGained

    private void txtTimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusLost
        if (txtTim.getText().equals("")) {
            txtTim.setText("Nhập Mã");
            txtTim.setForeground(new Color(204, 204, 204));
        }
    }//GEN-LAST:event_txtTimFocusLost

    private void btnDeleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteAllMouseClicked
        productInfoMap.clear();
        productQuantityMap.clear();
        updateTable2();
    }//GEN-LAST:event_btnDeleteAllMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMouseClicked
        QuanLy.setVisible(true);
        Home.setVisible(false);
        ThongKe.setVisible(false);
        TaiBan.setVisible(false);
        CaiDat.setVisible(false);
        KhachHang.setVisible(false);
    }//GEN-LAST:event_btnQuanLyMouseClicked

    private void txtMaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSizeActionPerformed

    private void txtMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoTaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) { // Kiểm tra xem một hàng đã được chọn chưa
            // Lấy thông tin từ hàng được chọn và hiển thị lên các JTextField
            txtMaSP.setText(jTable1.getValueAt(selectedRow, 0).toString());
            txtMaLoai.setText(jTable1.getValueAt(selectedRow, 1).toString());
            txtMaSize.setText(jTable1.getValueAt(selectedRow, 2).toString());
            txtTenSP.setText(jTable1.getValueAt(selectedRow, 3).toString());
            txtDanhMuc.setText(jTable1.getValueAt(selectedRow, 4).toString());
            txtGiaTien.setText(jTable1.getValueAt(selectedRow, 5).toString());
            txtMoTa.setText(jTable1.getValueAt(selectedRow, 6).toString());

            // Khóa JTextField mã SP
            txtMaSP.setEditable(false);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            // Kiểm tra tính hợp lệ của dữ liệu
            if (!validateInput()) {
                return;
            }

            Nuoc_DAO nuocDAO = new Nuoc_DAO();

            // Tạo đối tượng Nuoc mới từ các giá trị được nhập từ giao diện
            Nuoc newProduct = new Nuoc();
            newProduct.setMaSanPham(txtMaSP.getText());
            newProduct.setMaLoai(txtMaLoai.getText());
            newProduct.setMaSize(txtMaSize.getText());
            newProduct.setTenSanPham(txtTenSP.getText());
            newProduct.setDanhMuc(txtDanhMuc.getText());
            newProduct.setGia(Double.parseDouble(txtGiaTien.getText()));
            newProduct.setMoTa(txtMoTa.getText());

            // Thêm sản phẩm vào cơ sở dữ liệu
            nuocDAO.addProduct(newProduct);

            // Cập nhật bảng hiển thị dữ liệu
            showList();

            // Thông báo thành công
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");

        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi thêm sản phẩm
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thêm sản phẩm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // Lấy thông tin từ các JTextField
        String maSP = txtMaSP.getText();
        String maLoai = txtMaLoai.getText();
        String maSize = txtMaSize.getText();
        String tenSP = txtTenSP.getText();
        String danhMuc = txtDanhMuc.getText();
        double gia = Double.parseDouble(txtGiaTien.getText());
        String moTa = txtMoTa.getText();

        // Kiểm tra các trường có rỗng không
        if (maSP.isEmpty() || maLoai.isEmpty() || maSize.isEmpty() || tenSP.isEmpty() || danhMuc.isEmpty() || txtGiaTien.getText().isEmpty() || moTa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        // Tiến hành cập nhật thông tin của sản phẩm trong CSDL
        Nuoc productToUpdate = new Nuoc(maSP, maLoai, maSize, tenSP, danhMuc, gia, moTa);
        Nuoc_DAO nuocDAO = new Nuoc_DAO();

        try {
            nuocDAO.updateProduct(productToUpdate);
            JOptionPane.showMessageDialog(this, "Sửa thông tin sản phẩm thành công.");
            // Sau khi sửa thành công, cần cập nhật lại danh sách sản phẩm trên bảng
            showList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi sửa thông tin sản phẩm: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // Lấy chỉ số của hàng được chọn trên bảng
        int selectedRowIndex = jTable1.getSelectedRow();

        // Kiểm tra xem có hàng được chọn không
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm để xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Lấy mã sản phẩm từ hàng được chọn
        String maSanPham = jTable1.getValueAt(selectedRowIndex, 0).toString();

        // Xác nhận việc xóa sản phẩm
        int option = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                // Thực hiện xóa sản phẩm từ cơ sở dữ liệu
                Nuoc_DAO nuocDAO = new Nuoc_DAO();
                nuocDAO.deleteProduct(maSanPham);

                // Hiển thị lại danh sách sản phẩm sau khi xóa
                showList();

                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xóa sản phẩm: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongActionPerformed
        txtMaSP.setText("");
        txtMaSize.setText("");
        txtMaLoai.setText("");
        txtTenSP.setText("");
        txtDanhMuc.setText("");
        txtGiaTien.setText("");
        txtMoTa.setText("");
    }//GEN-LAST:event_btnXoaRongActionPerformed

    private void btnQuanLyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMouseEntered
        setColor(btnQuanLy);
    }//GEN-LAST:event_btnQuanLyMouseEntered

    private void btnQuanLyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyMouseExited
        resetColor(btnQuanLy);
    }//GEN-LAST:event_btnQuanLyMouseExited

    private void btn_ThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThanhToanMouseClicked
        btn_ThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin sản phẩm từ map và đưa vào JTextArea trong ThanhToanBill
                String billDetails = getProductDetails();
                String tongTien = calculateTotal();
                // Chuyển sang trang thanh toán và hiển thị thông tin trên JTextArea
                ThanhToanHoaDon_GUI thanhToanBill = new ThanhToanHoaDon_GUI();
                thanhToanBill.setTongTien(tongTien);
                thanhToanBill.setTextAreaContent(billDetails); // Đưa thông tin vào JTextArea
                thanhToanBill.setLastBillDetails(billDetails);
                thanhToanBill.setTongTien(tongTien);
                thanhToanBill.setHoTen(txtHoTen.getText());
                thanhToanBill.setVisible(true);

                // Đóng cửa sổ trang chủ (nếu cần)
//                dispose(); // Đóng JFrame của trang chủ sau khi chuyển sang trang thanh toán
            }

            private String getProductDetails() {
                StringBuilder billDetails = new StringBuilder();

                // Duyệt qua productInfoMap để lấy thông tin sản phẩm
                for (Map.Entry<String, Object> entry : productInfoMap.entrySet()) {
                    String tenSanPham = entry.getKey();
                    Object value = entry.getValue();

                    if (value instanceof Nuoc) {
                        Nuoc nuoc = (Nuoc) value;
                        int soLuong = productQuantityMap.getOrDefault(tenSanPham, 1);
                        double gia = nuoc.getGia();

                        // Tạo dòng thông tin cho mỗi sản phẩm
                        String productLine = String.format("%-30s %-15d  %10.0fđ\n", tenSanPham, soLuong, gia);
                        billDetails.append(productLine);
                    }
                }

                return billDetails.toString();
            }
        });
    }//GEN-LAST:event_btn_ThanhToanMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void loadTable(ArrayList<String[]> data) {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có trong bảng

        for (String[] row : data) {
            model.addRow(row); // Thêm dòng mới vào bảng với dữ liệu từ ArrayList
        }
    }
    ThongKe_DAO x = new ThongKe_DAO();

    private void loadTable2(ArrayList<String[]> data) {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0); // Xóa tất cả các dòng hiện có trong bảng

        for (String[] row : data) {
            model.addRow(row); // Thêm dòng mới vào bảng với dữ liệu từ ArrayList
        }
    }
    private void btnCaiDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCaiDatMouseClicked
        CaiDat.setVisible(true);
        Home.setVisible(false);
        QuanLy.setVisible(false);
        ThongKe.setVisible(false);
        TaiBan.setVisible(false);
        KhachHang.setVisible(false);
    }//GEN-LAST:event_btnCaiDatMouseClicked

    private void tableKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKhachHangMouseClicked
        // Lấy chỉ số dòng được click
        int row = tableKhachHang.rowAtPoint(evt.getPoint());

        // Lấy thông tin của dòng được click
        String maKhachHang = tableKhachHang.getValueAt(row, 0).toString();
        String hoTen = tableKhachHang.getValueAt(row, 1).toString();
        String diemTV = tableKhachHang.getValueAt(row, 2).toString();

        // Hiển thị thông tin của dòng được click
        txtMaKH.setText(maKhachHang);
        txtHoTen.setText(hoTen);
        txtDiemTV.setText(diemTV);
    }//GEN-LAST:event_tableKhachHangMouseClicked

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void addKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKHActionPerformed
        String maKhachHang = txtMaKH.getText();
        String hoTen = txtHoTen.getText();
        int diemTV = Integer.parseInt(txtDiemTV.getText());

        KhachHang newCustomer = new KhachHang(maKhachHang, hoTen, diemThanhVien);

        try {
            khachHang_DAO.insertCustomer(newCustomer);
            updateTableKhachHang();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_addKHActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        int selectedRow = tableKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để sửa.");
            return;
        }

        String maKhachHang = txtMaKH.getText();
        String hoTen = txtHoTen.getText();
        int diemThanhVien = Integer.parseInt(txtDiemTV.getText());

        KhachHang updatedCustomer = new KhachHang(maKhachHang, hoTen, diemThanhVien);

        try {
            khachHang_DAO.updateCustomer(updatedCustomer);
            updateTableKhachHang();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int selectedRow = tableKhachHang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xóa.");
            return;
        }

        String maKhachHang = (String) tableKhachHang.getValueAt(selectedRow, 0);

        try {
            khachHang_DAO.deleteCustomer(maKhachHang);
            updateTableKhachHang();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
              try{
           JFileChooser jFileChooser = new JFileChooser();
           jFileChooser.showSaveDialog(this);
           File saveFile = jFileChooser.getSelectedFile();
           
           if(saveFile != null){
               saveFile = new File(saveFile.toString()+".xlsx");
               Workbook wb = new XSSFWorkbook();
               Sheet sheet = wb.createSheet("customer");
               
               Row rowCol = sheet.createRow(0);
               for(int i=0;i<jTable1.getColumnCount();i++){
                   Cell cell = rowCol.createCell(i);
                   cell.setCellValue(jTable1.getColumnName(i));
               }
               
               for(int j=0;j<jTable1.getRowCount();j++){
                   Row row = sheet.createRow(j+1);
                   for(int k=0;k<jTable1.getColumnCount();k++){
                       Cell cell = row.createCell(k);
                       if(jTable1.getValueAt(j, k)!=null){
                           cell.setCellValue(jTable1.getValueAt(j, k).toString());
                       }
                   }
               }
               FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
               wb.write(out);
               wb.close();
               out.close();
               openFile(saveFile.toString());
           }else{
               JOptionPane.showMessageDialog(null,"Error al generar archivo");
           }
       }catch(FileNotFoundException e){
           System.out.println(e);
       }catch(IOException io){
           System.out.println(io);
       }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        String dateString = jComboBox1.getSelectedItem().toString();
        LocalDate today = LocalDate.now();
        ArrayList<String[]> result = null;
        if (dateString.equalsIgnoreCase("Hôm qua")) {
            today = today.minusDays(1);
            try {
                result = x.thongKe2(today);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (dateString.equalsIgnoreCase("Tháng này")) {

            try {
                result = x.thongKeTheoThang(today.getMonthValue());
            } catch (SQLException ex) {
                Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } 

        } else {
            today = LocalDate.now();
            try {
                result = x.thongKe2(today);
            } catch (SQLException ex) {
                Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadTable(result);
        jTextField1.setText(today.toString());
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        try {
            // TODO add your handling code here:
            DocDuLieuDatabaseVaoTable();
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton24MouseClicked

        private void DocDuLieuDatabaseVaoTable() throws SQLException {
        List<HoaDon> list = y.getAllList();
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng
        for (HoaDon a : list) {
            model.addRow(new Object[]{
                a.getMaHoaDon(), a.getNgayMua().toString(), a.getMaNhanVien(), a.getMaKhachHang(), a.getTongTien()
            });
        }
    }
    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
        // TODO add your handling code here:
        //         nam = jComboBox4.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //         TODO add your handling code here:
        String nam = jComboBox4.getSelectedItem().toString(); // Lấy giá trị năm từ combobox
        if (nam != null && !nam.isEmpty()) { // Kiểm tra xem năm có tồn tại không
            try {
                ArrayList<String[]> result = x.thongKe3(nam); // Gọi hàm thongKe3 để lấy dữ liệu
                loadTable2(result); // Hiển thị dữ liệu lên bảng
            } catch (SQLException ex) {
                Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Vui lòng chọn năm trước khi thực hiện thống kê.");
        }
    }//GEN-LAST:event_jButton2MouseClicked
   HoaDon_Dao y = new HoaDon_Dao();
        private void LocHoaDonTheoThangNam() {
        int thang = Integer.parseInt(jComboBox2.getSelectedItem().toString());
        int nam = Integer.parseInt(jComboBox3.getSelectedItem().toString());

        List<HoaDon> list = null;
     
        try {
            list = y.getDSHDTheoThangNam(thang, nam);
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng
        for (HoaDon a : list) {
            model.addRow(new Object[]{
                a.getMaHoaDon(), a.getNgayMua().toString(), a.getMaNhanVien(), a.getMaKhachHang(), a.getTongTien() + "đ"
            });
        }
    }
    private void jButton26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseClicked
        // TODO add your handling code here:
        LocHoaDonTheoThangNam();
    }//GEN-LAST:event_jButton26MouseClicked

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try {
            // lấy danh sách hóa đơn
            int thang = Integer.parseInt(jComboBox2.getSelectedItem().toString());
            int nam = Integer.parseInt(jComboBox3.getSelectedItem().toString());

            List<HoaDon> list = null;
            try {
                list = y.getDSHDTheoThangNam(thang, nam);
            } catch (SQLException ex) {
                Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("Danh Sách Thống Kê");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);

            // cột 1
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Mã hóa đơn");

            // cột 2
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ngày mua");

            // cột 3
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã nhân viên");

            // cột 4
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Mã khách hàng");

            // cột 5
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Thành tiền");

            for (int i = 0; i < list.size(); i++) {
                HoaDon hd = list.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(list.get(i).getMaHoaDon());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(list.get(i).getNgayMua().toString());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(list.get(i).getMaNhanVien());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(list.get(i).getMaKhachHang());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(list.get(i).getTongTien());
            }

            File f = new File("D:\\NAM_HAI\\HK2\\HSK_JV\\BTLon\\Excel\\DSTK.xlsx");

            FileOutputStream fis = null;
            try {
                fis = new FileOutputStream(f);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            workBook.write(fis);
            fis.close();
        } catch (IOException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "In thành công");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jPanel14ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel14ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14ComponentHidden
    private Map<String, Integer> productQuantityMap = new HashMap<>();

    private void updateTable2() {
        panelThanhToan.removeAll();
        panelThanhToan.setLayout(new GridBagLayout());
        panelThanhToan.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (Map.Entry<String, Object> entry : productInfoMap.entrySet()) {
            String tenSanPham = entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Nuoc) {
                Nuoc n = (Nuoc) value;

                JPanel pnSanPham = new JPanel();
                pnSanPham.setBackground(Color.WHITE);
                pnSanPham.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                pnSanPham.setLayout(new BorderLayout(10, 10));

                JLabel lblImg = new JLabel();
                ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + n.getMoTa()));
                Image scaledImage = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                lblImg.setIcon(new ImageIcon(scaledImage));

                JLabel lblTenSanPham = new JLabel(n.getTenSanPham(), SwingConstants.CENTER);
                lblTenSanPham.setFont(new Font("Segoe UI", Font.BOLD, 16));

                JLabel lblGia = new JLabel(String.format("%.0fđ", n.getGia()), SwingConstants.CENTER);

                JPanel panelMid = new JPanel(new BorderLayout());
                panelMid.setBackground(Color.WHITE);
                panelMid.add(lblTenSanPham, BorderLayout.NORTH);
                panelMid.add(lblGia, BorderLayout.CENTER);

                JPanel panel_3 = new JPanel();
                panel_3.setBackground(Color.WHITE);

                int initialQuantity;
                if (productQuantityMap.containsKey(tenSanPham)) {
                    // Nếu sản phẩm đã tồn tại, tăng số lượng lên 1
                    initialQuantity = productQuantityMap.get(tenSanPham);
                } else {
                    // Nếu sản phẩm chưa tồn tại, sử dụng số lượng mặc định là 1
                    initialQuantity = 1;
                }

                JTextField textFieldSL = new JTextField(String.valueOf(initialQuantity), 2);
                textFieldSL.setHorizontalAlignment(JTextField.CENTER);
                textFieldSL.setFont(new Font("Tahoma", Font.BOLD, 10));

                JButton giamButton = new JButton("-");
                giamButton.setBorderPainted(false);
                giamButton.setForeground(Color.WHITE);
                giamButton.setBackground(new Color(0, 189, 214));
                giamButton.setFont(new Font("Tahoma", Font.PLAIN, 10));

                JButton tangButton = new JButton("+");
                tangButton.setBorderPainted(false);
                tangButton.setBackground(new Color(0, 189, 214));
                tangButton.setForeground(Color.WHITE);
                tangButton.setFont(new Font("Tahoma", Font.PLAIN, 10));

                giamButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int currentQuantity = Integer.parseInt(textFieldSL.getText());
                        if (currentQuantity > 1) {
                            textFieldSL.setText(String.valueOf(currentQuantity - 1));
                            productQuantityMap.put(tenSanPham, currentQuantity - 1);
                            calculateTotal(); // Tính toán lại tổng tiền sau khi cập nhật số lượng
                        }
                    }
                });

                tangButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int currentQuantity = Integer.parseInt(textFieldSL.getText());
                        textFieldSL.setText(String.valueOf(currentQuantity + 1));
                        productQuantityMap.put(tenSanPham, currentQuantity + 1);
                        calculateTotal(); // Tính toán lại tổng tiền sau khi cập nhật số lượng
                    }
                });

                panel_3.add(giamButton);
                panel_3.add(textFieldSL);
                panel_3.add(tangButton);

                panelMid.add(panel_3, BorderLayout.SOUTH);

                pnSanPham.add(panelMid, BorderLayout.CENTER);

                pnSanPham.add(lblImg, BorderLayout.WEST);

                JButton btnXoa = new JButton("X");
                btnXoa.setForeground(Color.red);
                btnXoa.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        removeProductFromMap(tenSanPham);
                        updateTable2();
                    }
                });
                pnSanPham.add(btnXoa, BorderLayout.EAST);

                gbc.insets = new Insets(5, 5, 5, 5);

                panelThanhToan.add(pnSanPham, gbc);
                gbc.gridy++;
            }
        }

        panelThanhToan.revalidate();
        panelThanhToan.repaint();
        calculateTotal(); // Tính toán tổng tiền sau khi cập nhật bảng
    }

    public void removeProductFromMap(String tenSanPham) {
        // Xóa sản phẩm khỏi productInfoMap
        productQuantityMap.put(tenSanPham, 1);
        productInfoMap.remove(tenSanPham);

    }

    private String calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Object> entry : productInfoMap.entrySet()) {
            String tenSanPham = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Nuoc) {
                Nuoc n = (Nuoc) value;
                int quantity = productQuantityMap.getOrDefault(tenSanPham, 1);
                total += n.getGia() * quantity;
            }
        }
        // Chuyển đổi giá trị total thành chuỗi trước khi cập nhật nhãn lblThanhTien
        String formattedTotal = String.format("%.0f", total); // Định dạng số thập phân để hiển thị hai chữ số sau dấu phẩy
        lblThanhTien.setText(formattedTotal); // Cập nhật nhãn lblThanhTien với giá trị đã định dạng
        return formattedTotal;
    }

    private ImageIcon createImageIcon(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path)); // Đọc hình ảnh từ đường dẫn
            if (image == null) {
                System.err.println("Hình ảnh không tồn tại hoặc không thể đọc được từ đường dẫn: " + path);
                return null;
            }

            Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Scale ảnh xuống kích thước 50x50
            return new ImageIcon(scaledImage); // Trả về ImageIcon đã được scale
        } catch (IOException e) {
            System.err.println("Không thể đọc hình ảnh từ đường dẫn: " + e.getMessage());
            return null;
        }
    }

    public void addProductToMap(String tenSanPham, Nuoc product) {
        // Thêm sản phẩm vào productInfoMap
        productInfoMap.put(tenSanPham, product);
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(198, 224, 225));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(223, 255, 254));
    }

    /**
     * @param args the command line arguments
     */
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GiaoDienChinh_GUI(null).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
//        NhanVien_DAO nv = new NhanVien_DAO();
//        NhanVien user = (NhanVien) nv.getUserByUserPassword("admin","admin");
//        System.out.println(user.getHoTen());
//        System.out.println(user.getChucVu());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CaiDat;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JPanel QuanLy;
    private javax.swing.JPanel TaiBan;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JButton addKH;
    private javax.swing.JButton btnCaPhe;
    private javax.swing.JPanel btnCaiDat;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnEpTraiCay;
    private javax.swing.JPanel btnKhachHang;
    private javax.swing.JButton btnNuocCoga;
    private javax.swing.JButton btnNuocSuoi;
    private javax.swing.JPanel btnQuanLy;
    private javax.swing.JButton btnSua;
    private javax.swing.JPanel btnTaiBan;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnThem;
    private javax.swing.JPanel btnThongKe;
    private javax.swing.JPanel btnTrangChu;
    private javax.swing.JButton btnXoaRong;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JButton btn_ThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JTextField lblThanhTien;
    private javax.swing.JPanel panelThanhToan;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnNuocCoGa;
    private javax.swing.JPanel sidepane;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTextField txtChucVu;
    private javax.swing.JTextField txtDanhMuc;
    private javax.swing.JTextField txtDiemTV;
    private javax.swing.JTextField txtGiaTien;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

    private ImageIcon scaleIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        return scaledIcon;
    }

    private boolean validateInput() throws SQLException {
        // Kiểm tra các trường dữ liệu để đảm bảo rằng chúng không để trống
        if (txtMaSP.getText().isEmpty() || txtMaLoai.getText().isEmpty() || txtMaSize.getText().isEmpty()
                || txtTenSP.getText().isEmpty() || txtDanhMuc.getText().isEmpty() || txtGiaTien.getText().isEmpty()
                || txtMoTa.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String maSP = txtMaSP.getText();
        if (nuocDAO.isProductExistsInList(maSP)) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaSP.requestFocus();
            return false;
        }

        // Kiểm tra xem giá tiền có phải là một số không
        try {
            Double.parseDouble(txtGiaTien.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Giá tiền phải là một số", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra định dạng của mã sản phẩm, mã loại và mã size
        String maSPPattern = "^SP\\d+$";
        if (!txtMaSP.getText().matches(maSPPattern)) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm phải bắt đầu là SP, tiếp theo là các chữ số", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaSP.requestFocus();
            return false;
        }

        String maLoai = txtMaLoai.getText();
        List<String> allowedMaLoai = Arrays.asList("L001", "L002", "L003", "L004");

        if (!allowedMaLoai.contains(maLoai)) {
            JOptionPane.showMessageDialog(this, "Mã loại phải là L001, L002, L003 hoặc L004", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaLoai.requestFocus();
            return false;
        }

        String maSizePattern = "^S00[1-3]$";
        if (!txtMaSize.getText().matches(maSizePattern)) {
            JOptionPane.showMessageDialog(this, "Mã size phải có định dạng S001, S002 hoặc S003", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMaSize.requestFocus();
            return false;
        }

        String moTaPattern = ".*\\.(jpg|png)$";
        if (!txtMoTa.getText().matches(moTaPattern)) {
            JOptionPane.showMessageDialog(this, "Mô tả phải kết thúc bằng .jpg hoặc .png", "Lỗi", JOptionPane.ERROR_MESSAGE);
            txtMoTa.requestFocus();
            return false;
        }

        // Nếu không có lỗi, trả về true
        return true;
    }

// Phương thức để cập nhật bảng
    private void showList() {
        try {
            Nuoc_DAO nuocDAO = new Nuoc_DAO();
            List<Nuoc> list = nuocDAO.getAllList();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ trên bảng

            // Thêm dữ liệu mới vào bảng
            for (Nuoc nuoc : list) {
                model.addRow(new Object[]{
                    nuoc.getMaSanPham(), nuoc.getMaLoai(), nuoc.getMaSize(), nuoc.getTenSanPham(),
                    nuoc.getDanhMuc(), nuoc.getGia(), nuoc.getMoTa()
                });
            }
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra khi lấy dữ liệu từ cơ sở dữ liệu
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi lấy dữ liệu từ cơ sở dữ liệu: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    private void showDataToTable() {
        try {
            List<Nuoc> list = nuocDAO.getAllList(); // Lấy danh sách sản phẩm
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Xóa các dòng cũ trong bảng
            for (Nuoc nuoc : list) {
                model.addRow(new Object[]{
                    nuoc.getMaSanPham(), nuoc.getMaLoai(), nuoc.getMaSize(), nuoc.getTenSanPham(), nuoc.getDanhMuc(), nuoc.getGia(), nuoc.getMoTa()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiaoDienChinh_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateTableKhachHang() throws SQLException {
         DefaultTableModel model = (DefaultTableModel) tableKhachHang.getModel();
        model.setRowCount(0); // Clear the table before updating

        KhachHang_DAO khachHangDAO = new KhachHang_DAO();

        List<KhachHang> customers = khachHangDAO.getAllCustomers();
        for (KhachHang customer : customers) {
            model.addRow(new Object[]{customer.getMaKhachHang(), customer.getHoTen(), customer.getDiemThanhVien()});
        }
    }

    private void openFile(String file) {
    try {
        var path = new File(file);
        Desktop.getDesktop().open(path);
    } catch (IOException ioe) {
        System.out.println(ioe);
    }
}




}
