package gui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        try {
            // Thiết lập giao diện look and feel
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Loading_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Khởi tạo và hiển thị cửa sổ loading
        Loading_GUI loadingWindow = new Loading_GUI();
        loadingWindow.setVisible(true);
        // Thực hiện quá trình loading
        loadingWindow.progress();
    }
}
