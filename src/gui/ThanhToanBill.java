/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_Dao;
import entity.HoaDon;
import entity.Nuoc;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Map;
import src.Enitty.ChiTietHoaDon;


/**
 *
 * @author viet6
 */
public class ThanhToanBill extends javax.swing.JFrame {

    private GiaoDienChinh_GUI trangChu;
    private String lastBillDetails;
    private String tongTien1;
    private String hoTen1;
    private HoaDon hoaDon;
    private Map<String, Object> productInfoMap1;
    private Map<String, Integer> productQuantityMap1;

    Double bHeight=0.0;

    public ThanhToanBill() {
        initComponents();
        customizeComponents();
        setTime();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTxTime = new javax.swing.JLabel();
        jTxtDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSubTotal1 = new javax.swing.JTextField();
        txtSubTotal2 = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtSubTotal4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSubTotal3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTxTime.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jTxtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bill.png"))); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("x");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxTime, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jTxtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnInHoaDon.setText(" HOÀN TẤT");
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInHoaDonMouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setViewportView(jScrollPane1);

        txtSubTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotalFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thuế");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thành tiền");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tổng tiền");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khách đưa");

        jLabel6.setBackground(new java.awt.Color(0, 255, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Thối lại");

        txtSubTotal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSubTotal1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal1.setText("10%");

        txtSubTotal2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSubTotal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtThanhTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtThanhTien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        txtSubTotal4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSubTotal4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubTotal4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSubTotal4FocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Mã Khách Hàng");

        txtSubTotal3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSubTotal3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSubTotal4)
                            .addComponent(txtSubTotal)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(txtSubTotal3))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSubTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSubTotal2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubTotal3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnInHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  public void getProductInfoMap(Map<String, Object> productInfoMap) {
        this.productInfoMap1 = productInfoMap;
    }

    public void getProductQuantityMap(Map<String, Integer> productQuantityMap) {
        this.productQuantityMap1 = productQuantityMap;
    }
    private void btnInHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMouseClicked
        hoaDonIn();
        jTextArea1.append(lastBillDetails);
        jTextArea1.append("\n-----------------------------------------\n");
        jTextArea1.append("Tổng tiền: ");
        jTextArea1.append(tongTien1);
        jTextArea1.append("\nThuế: 10% \n");
        jTextArea1.append("Thành tiền: ");
        double total = Double.parseDouble(tongTien1); // Chuyển đổi tổng tiền từ String sang double
        double grandTotal = calculateGrandTotal(total);

        jTextArea1.append(String.valueOf(grandTotal)); // Nối giá trị grandTotal dưới dạng chuỗi vào jTextArea1

        txtSubTotal2.setText(String.valueOf(tongTien1)); // Đặt giá trị grandTotal vào txtSubTotal2
        txtThanhTien.setText(String.valueOf(grandTotal)); // Đặt giá trị grandTotal vào txtThanhTien

        
         // Trích xuất các thông tin từ giao diện
         String maHoaDon = taoMaHoaDon();
        String tongTien = txtSubTotal2.getText(); // Lấy tổng tiền từ giao diện
        String maKhachHang = txtSubTotal3.getText(); // Lấy mã khách hàng từ giao diện
        LocalDate ngayMua = LocalDate.now();
        double tongTiendao = Double.parseDouble(tongTien1);
        hoaDon =new HoaDon(maHoaDon, ngayMua, hoTen1, maKhachHang, tongTiendao);
        HoaDon_Dao hoaDonDao = new HoaDon_Dao();
        try {
            hoaDonDao.themHoaDon(hoaDon);
            // Hiển thị thông báo thành công
            JOptionPane.showMessageDialog(this, "Thanh toán thành công!");
        } catch (SQLException ex) {
            // Xử lý ngoại lệ nếu có lỗi khi thêm hóa đơn
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi thanh toán: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
                if (productInfoMap1 != null && productQuantityMap1 != null) {
        for (Map.Entry<String, Object> entry : productInfoMap1.entrySet()) {
            String maSanPham = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Nuoc) {
                Nuoc nuoc = (Nuoc) value;
                System.out.println(maHoaDon);
                String maSanPhamDao = nuoc.getMaSanPham();
                int soLuong = productQuantityMap1.getOrDefault(maSanPham, 1);
                double tongTienNuoc = nuoc.getGia() * soLuong;
               ChiTietHoaDon cthd = new ChiTietHoaDon(maHoaDon, maSanPhamDao, soLuong, tongTienNuoc);
               ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
                try {
                    cthd_dao.themChiTietHoaDon(cthd);
                } catch (SQLException ex) {
                    Logger.getLogger(ThanhToanBill.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } else{
        System.out.println("chua lay dc map");
    }
        InHoaDon_GUI inHoaDon = new InHoaDon_GUI();
        inHoaDon.hienThiChiTietHoaDon(getTextAreaContent() );
        inHoaDon.setVisible(true); // Hiển thị frame InHoaDon
    }//GEN-LAST:event_btnInHoaDonMouseClicked

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        dispose();
        
    }//GEN-LAST:event_jLabel8MouseClicked

    private void txtSubTotal4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotal4FocusLost
        
    }//GEN-LAST:event_txtSubTotal4FocusLost

    private void txtSubTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSubTotalFocusLost
          double total = Double.parseDouble(tongTien1);

        // Calculate grand total
        double grandTotal = calculateGrandTotal(total);

        // Parse txtSubTotal text to double
        double subTotal = Double.parseDouble(txtSubTotal.getText());

        // Calculate the difference between subTotal and grandTotal
        double difference = subTotal - grandTotal;

        // Set the result to txtSubTotal4
        txtSubTotal4.setText(String.valueOf(difference));
    }//GEN-LAST:event_txtSubTotalFocusLost
   
    public String taoMaHoaDon() {
        // Lấy thời gian hiện tại
        LocalDateTime currentTime = LocalDateTime.now();

        // Lấy ngày hiện tại và chuyển định dạng ngày thành chuỗi
        String date = currentTime.toLocalDate().toString();

        // Chuyển định dạng thời gian thành chuỗi
        String time = currentTime.getHour() + "" + currentTime.getMinute() + "" + currentTime.getSecond();
        
        // Tạo mã hóa đơn từ thời gian và ngày
        String maHoaDon = date.replace("-", "") + time;

        // Trả về mã hóa đơn
        return maHoaDon;
    }

    
    public void hoaDonIn() {
        LocalDateTime currentTime = LocalDateTime.now();
        String date = currentTime.toLocalDate().toString();
        String time = String.format("%02d:%02d:%02d", currentTime.getHour(), currentTime.getMinute(), currentTime.getSecond());
        String maHoaDon = taoMaHoaDon();
        jTextArea1.setText("********************************\n"
                + "Chill Coffee\n"
                + "----------------------------------------\n"
                + "Mã hóa đơn " + maHoaDon + "\n"
                + "-----------------------------------------\n"
                + "Time: " + time + "  Date: " + date + "\n"
                + "-----------------------------------------"
                + "\nThức uống:\t" + "      Số lượng" + "\t        Giá($)\n");
    }

    public void setTextAreaContent(String billDetails) {
        hoaDonIn();
        jTextArea1.append(billDetails);
        jTextArea1.append("\n-----------------------------------------\n");
        jTextArea1.append("Tổng tiền: ");
        jTextArea1.append(tongTien1);
        jTextArea1.append("\nThuế: 10% \n");
        jTextArea1.append("Thành tiền: ");
        double total = Double.parseDouble(tongTien1); // Chuyển đổi tổng tiền từ String sang double
        double grandTotal = calculateGrandTotal(total);

        jTextArea1.append(String.valueOf(grandTotal)); // Nối giá trị grandTotal dưới dạng chuỗi vào jTextArea1

        txtSubTotal2.setText(String.valueOf(tongTien1)); // Đặt giá trị grandTotal vào txtSubTotal2
        txtThanhTien.setText(String.valueOf(grandTotal)); // Đặt giá trị grandTotal vào txtThanhTien
    }
//ten,sl, giá
    public void setLastBillDetails(String billDetails) {
        this.lastBillDetails = billDetails;
    }
//TongTien
    public void setTongTien(String tongTien) {
        this.tongTien1 = tongTien;
    }
//ho ten
    public void setHoTen(String hoTen) {
        this.hoTen1 = hoTen;
        System.out.println(hoTen1);
    }
    public void setTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ThanhToanBill.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    jTxTime.setText(time.split(" ")[0] + " " + time.split(" ")[1]);
                    jTxtDate.setText(df.format(date));
                }
            }
        }).start();
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
            java.util.logging.Logger.getLogger(ThanhToanBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThanhToanBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThanhToanBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThanhToanBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThanhToanBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jTxTime;
    private javax.swing.JLabel jTxtDate;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtSubTotal1;
    private javax.swing.JTextField txtSubTotal2;
    private javax.swing.JTextField txtSubTotal3;
    private javax.swing.JTextField txtSubTotal4;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    private void customizeComponents() {
        jTextArea1.setEditable(false);
        txtSubTotal1.setEditable(false);
        txtSubTotal2.setEditable(false);
        txtSubTotal4.setEditable(false);
        txtThanhTien.setEditable(false);
    }


    private double calculateGrandTotal(double total) {
        double taxPercentage = 10.0; // Thuế cố định là 10%
        double tax = total * (taxPercentage / 100); // Tính số tiền thuế
        double grandTotal = total + tax; // Tổng tiền cần thanh toán (bao gồm cả thuế)
        return grandTotal;
    }
public String getTextAreaContent() {
    return jTextArea1.getText();
}
//pdf
public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double bodyHeight = bHeight;  
    double headerHeight = 5.0;                  
    double footerHeight = 5.0;        
    double width = cm_to_pp(8); 
    double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(0,10,width,height - cm_to_pp(1));  
            
    pf.setOrientation(PageFormat.PORTRAIT);  
    pf.setPaper(paper);    

    return pf;
}
//
   protected static double cm_to_pp(double cm)
    {            
	        return toPPI(cm * 0.393600787);            
    }
 
protected static double toPPI(double inch)
    {            
	        return inch * 72d;            
    }
//
    private void processProductDetails() throws SQLException {
        if (productInfoMap1 != null && productQuantityMap1 != null) {
        for (Map.Entry<String, Object> entry : productInfoMap1.entrySet()) {
            String maSanPham = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Nuoc) {
                Nuoc nuoc = (Nuoc) value;
                String maHoaDon = taoMaHoaDon();
                String maSanPhamDao = nuoc.getMaSanPham();
                int soLuong = productQuantityMap1.getOrDefault(maSanPham, 1);
                double tongTienNuoc = nuoc.getGia() * soLuong;
               ChiTietHoaDon cthd = new ChiTietHoaDon(maHoaDon, maSanPhamDao, soLuong, tongTienNuoc);
               ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
               cthd_dao.themChiTietHoaDon(cthd);
            }
        }
    } else{
        System.out.println("chua lay dc map");
    }
    }
    //
    public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    
            double width = pageFormat.getImageableWidth();                               
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
        
        try{
            int y=20;
            int yShift = 10;
            int headerRectHeight=15;
           // int headerRectHeighta=40;

            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));

            g2d.drawString("-------------------------------------",12,y);y+=yShift;
            g2d.drawString("         CodeGuid.com        ",12,y);y+=yShift;
            g2d.drawString("   No 00000 Address Line One ",12,y);y+=yShift;
            g2d.drawString("   Address Line 02 SRI LANKA ",12,y);y+=yShift;
            g2d.drawString("   www.facebook.com/CodeGuid ",12,y);y+=yShift;
            g2d.drawString("        +94700000000      ",12,y);y+=yShift;
            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

            g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
     
            g2d.drawString(jTextArea1.getText(), 10, y);
         
  
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("       THANK YOU COME AGAIN            ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("       SOFTWARE BY:CODEGUID          ",10,y);y+=yShift;
            g2d.drawString("   CONTACT: contact@codeguid.com       ",10,y);y+=yShift;       
           

    }
    catch(Exception e){
    e.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
}
