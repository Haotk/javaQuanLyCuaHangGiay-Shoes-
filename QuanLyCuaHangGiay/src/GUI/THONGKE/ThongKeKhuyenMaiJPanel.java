
package GUI.THONGKE;

import static DataThongKe.ChartData.createDataChartPresent;
import DataThongKe.DataThongKeKhuyenMai;
import static DataThongKe.DataThongKeKhuyenMai.ThongKeKhuyenMaiNgay;
import static DataThongKe.DataThongKeKhuyenMai.ThongKeKhuyenMaiTuDen;
import static DataThongKe.DataThongKeKhuyenMai.ThongKeKhuyenMaiThang;
import static DataThongKe.DataThongKeKhuyenMai.ThongKeKhuyenMaiQuy;
import static DataThongKe.DataThongKeKhuyenMai.ThongKeKhuyenMaiNam;
import static DataThongKe.DataThongKeKhuyenMai.getNgayTao;

import GUI.Sweet.SweetComboBox;
import GUI.Sweet.SweetFileChooser;
import GUI.ThongKeJPanel;
import IO.Excel.ThongKeKhuyenMaiQuyExcel;
import IO.Excel.ThongKeKhuyenMaiThangExcel;
import static controller.createChart.createLineChart;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import static quanlycuahanggiay.DateTime.setDate;
import static quanlycuahanggiay.Currency.changeCurrency;

/**
 *
 * @author admin
 */
public class ThongKeKhuyenMaiJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeKhuyenMaiJPanel
     */
    SweetComboBox cbxNamQuy;
    SweetComboBox cbxNam;
    public void setComboBox(){
        String[] namthang = {"2020","2019","2018","2017"};
        SweetComboBox cbxNamThang = new SweetComboBox("#ffffff","#181818",0,0,140,30,namthang);
        String[] thang = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        SweetComboBox cbxThang = new SweetComboBox("#ffffff","#181818",0,0,140,30,thang);
        pnlNamThang.add(cbxNamThang);
        pnlThang.add(cbxThang);
        cbxNamThang.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int[] khuyenMai = ThongKeKhuyenMaiThang(cbxNamThang,cbxThang);
                lblChuongTrinhKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
            
        });
        cbxThang.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int[] khuyenMai = ThongKeKhuyenMaiThang(cbxNamThang,cbxThang);
                lblChuongTrinhKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
            
        });
        cbxNamThang.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int[] khuyenMai = ThongKeKhuyenMaiThang(cbxNamThang,cbxThang);
                lblChuongTrinhKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        cbxThang.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int[] khuyenMai = ThongKeKhuyenMaiThang(cbxNamThang,cbxThang);
                lblChuongTrinhKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamThang.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });

        
        
        String[] namquy = {"2020","2019","2018","2017"};
        cbxNamQuy = new SweetComboBox("#ffffff","#181818",0,0,140,30,namquy);   
        String[] quy = {"1","2","3","4"};
        SweetComboBox cbxQuy = new SweetComboBox("#ffffff","#181818",0,0,140,30,quy);
        pnlNamQuy.add(cbxNamQuy);
        pnlQuy.add(cbxQuy);
        cbxNamQuy.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int[] khuyenMai = ThongKeKhuyenMaiQuy(cbxNamQuy,cbxQuy);
                lblChuongTrinhKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        cbxQuy.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int[] khuyenMai = ThongKeKhuyenMaiQuy(cbxNamQuy,cbxQuy);
                lblChuongTrinhKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        cbxNamQuy.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int[] khuyenMai = ThongKeKhuyenMaiQuy(cbxNamQuy,cbxQuy);
                lblChuongTrinhKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        cbxQuy.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int[] khuyenMai = ThongKeKhuyenMaiQuy(cbxNamQuy,cbxQuy);
                lblChuongTrinhKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNamQuy.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        
        
        String[] nam = {"2020","2019","2018","2017"};
        cbxNam = new SweetComboBox("#ffffff","#181818",0,0,140,30,nam);  
        pnlNam.add(cbxNam);
        cbxNam.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                int[] khuyenMai = ThongKeKhuyenMaiNam(cbxNam);
                lblChuongTrinhKMNam.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNam.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });
        cbxNam.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                int[] khuyenMai = ThongKeKhuyenMaiNam(cbxNam);
                lblChuongTrinhKMNam.setText(changeCurrency(Integer.toString(khuyenMai[0])));
                lblChiTietKMNam.setText(changeCurrency(Integer.toString(khuyenMai[1])));
            }
        });

    }     
      
        public void setChart(){
        createLineChart(pnlChart,createDataChartPresent(getNgayTao()));
    }    
    public ThongKeKhuyenMaiJPanel() {
        initComponents();
        setChart();
        setDate(dateNgay,dateTu,dateDen);
        setComboBox();
         pnlQuayVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
         pnlXemChiTiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuayVe = new GUI.Rounded();
        lblQuayVe = new javax.swing.JLabel();
        pnlThongKe = new GUI.Rounded();
        lblNgay = new javax.swing.JLabel();
        dateNgay = new com.toedter.calendar.JDateChooser();
        lblNgay1 = new javax.swing.JLabel();
        dateTu = new com.toedter.calendar.JDateChooser();
        dateDen = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblNgay3 = new javax.swing.JLabel();
        lblNgay4 = new javax.swing.JLabel();
        lblNgay5 = new javax.swing.JLabel();
        lblNgay6 = new javax.swing.JLabel();
        lblNgay7 = new javax.swing.JLabel();
        lblNgay8 = new javax.swing.JLabel();
        pnlNamThang = new javax.swing.JPanel();
        pnlThang = new javax.swing.JPanel();
        pnlQuy = new javax.swing.JPanel();
        pnlNamQuy = new javax.swing.JPanel();
        pnlNam = new javax.swing.JPanel();
        lblChuongTrinhKMNgay = new javax.swing.JLabel();
        lblChiTietKMNgay = new javax.swing.JLabel();
        lblChuongTrinhKMTuDen = new javax.swing.JLabel();
        lblChiTietKMTuDen = new javax.swing.JLabel();
        lblChuongTrinhKMNamThang = new javax.swing.JLabel();
        lblChiTietKMNamThang = new javax.swing.JLabel();
        lblChiTietKMNamQuy = new javax.swing.JLabel();
        lblChuongTrinhKMNamQuy = new javax.swing.JLabel();
        lblChuongTrinhKMNam = new javax.swing.JLabel();
        lblChiTietKMNam = new javax.swing.JLabel();
        pnlShowChart = new GUI.Rounded();
        pnlChart = new javax.swing.JPanel();
        pnlXemChiTiet = new GUI.Rounded();
        lblQuayVe1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 47, 62));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlQuayVe.setBackground(new java.awt.Color(45, 47, 62));
        pnlQuayVe.setForeground(new java.awt.Color(238, 38, 63));
        pnlQuayVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlQuayVeMouseClicked(evt);
            }
        });

        lblQuayVe.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblQuayVe.setForeground(new java.awt.Color(255, 255, 255));
        lblQuayVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back-icon.png"))); // NOI18N
        lblQuayVe.setText("  Quay về");

        javax.swing.GroupLayout pnlQuayVeLayout = new javax.swing.GroupLayout(pnlQuayVe);
        pnlQuayVe.setLayout(pnlQuayVeLayout);
        pnlQuayVeLayout.setHorizontalGroup(
            pnlQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQuayVeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuayVe, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlQuayVeLayout.setVerticalGroup(
            pnlQuayVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVe, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        add(pnlQuayVe, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 18, -1, -1));

        pnlThongKe.setBackground(new java.awt.Color(45, 47, 62));
        pnlThongKe.setForeground(new java.awt.Color(53, 55, 70));
        pnlThongKe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNgay.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay.setText("Ngày:");
        pnlThongKe.add(lblNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        dateNgay.setBackground(new java.awt.Color(255, 255, 255));
        dateNgay.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateNgayPropertyChange(evt);
            }
        });
        pnlThongKe.add(dateNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 140, -1));

        lblNgay1.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay1.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay1.setText("Năm:");
        pnlThongKe.add(lblNgay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 30));

        dateTu.setBackground(new java.awt.Color(255, 255, 255));
        dateTu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateTuPropertyChange(evt);
            }
        });
        pnlThongKe.add(dateTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 140, -1));

        dateDen.setBackground(new java.awt.Color(255, 255, 255));
        dateDen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateDenPropertyChange(evt);
            }
        });
        pnlThongKe.add(dateDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 140, -1));

        jLabel1.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(210, 57, 44));
        jLabel1.setText("Số chi tiết khuyến mãi:");
        pnlThongKe.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(210, 57, 44));
        jLabel3.setText("Số chương trình khuyến mãi:");
        pnlThongKe.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(210, 57, 44));
        jLabel5.setText("Số chương trình khuyến mãi:");
        pnlThongKe.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(210, 57, 44));
        jLabel6.setText("Số chi tiết khuyến mãi:");
        pnlThongKe.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(210, 57, 44));
        jLabel7.setText("Số chương trình khuyến mãi:");
        pnlThongKe.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(210, 57, 44));
        jLabel8.setText("Số chi tiết khuyến mãi:");
        pnlThongKe.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        jLabel10.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(210, 57, 44));
        jLabel10.setText("Số chi tiết khuyến mãi:");
        pnlThongKe.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(210, 57, 44));
        jLabel11.setText("Số chương trình khuyến mãi:");
        pnlThongKe.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, -1, -1));

        jLabel13.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(210, 57, 44));
        jLabel13.setText("Số chương trình khuyến mãi:");
        pnlThongKe.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(210, 57, 44));
        jLabel14.setText("Số chi tiết khuyến mãi:");
        pnlThongKe.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        lblNgay3.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay3.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay3.setText("Từ:");
        pnlThongKe.add(lblNgay3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 30));

        lblNgay4.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay4.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay4.setText("Năm:");
        pnlThongKe.add(lblNgay4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 30));

        lblNgay5.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay5.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay5.setText("Năm:");
        pnlThongKe.add(lblNgay5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 30));

        lblNgay6.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay6.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay6.setText("Đến:");
        pnlThongKe.add(lblNgay6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, 30));

        lblNgay7.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay7.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay7.setText("Tháng:");
        pnlThongKe.add(lblNgay7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, 30));

        lblNgay8.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 1, 14)); // NOI18N
        lblNgay8.setForeground(new java.awt.Color(255, 255, 255));
        lblNgay8.setText("Quý:");
        pnlThongKe.add(lblNgay8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, 30));

        pnlNamThang.setBackground(new java.awt.Color(255, 255, 255));
        pnlNamThang.setForeground(new java.awt.Color(255, 255, 255));
        pnlNamThang.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout pnlNamThangLayout = new javax.swing.GroupLayout(pnlNamThang);
        pnlNamThang.setLayout(pnlNamThangLayout);
        pnlNamThangLayout.setHorizontalGroup(
            pnlNamThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        pnlNamThangLayout.setVerticalGroup(
            pnlNamThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlThongKe.add(pnlNamThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 140, 30));

        pnlThang.setBackground(new java.awt.Color(255, 255, 255));
        pnlThang.setForeground(new java.awt.Color(255, 255, 255));
        pnlThang.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout pnlThangLayout = new javax.swing.GroupLayout(pnlThang);
        pnlThang.setLayout(pnlThangLayout);
        pnlThangLayout.setHorizontalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        pnlThangLayout.setVerticalGroup(
            pnlThangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlThongKe.add(pnlThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 140, -1));

        pnlQuy.setBackground(new java.awt.Color(255, 255, 255));
        pnlQuy.setForeground(new java.awt.Color(255, 255, 255));
        pnlQuy.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout pnlQuyLayout = new javax.swing.GroupLayout(pnlQuy);
        pnlQuy.setLayout(pnlQuyLayout);
        pnlQuyLayout.setHorizontalGroup(
            pnlQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        pnlQuyLayout.setVerticalGroup(
            pnlQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlThongKe.add(pnlQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 140, -1));

        pnlNamQuy.setBackground(new java.awt.Color(255, 255, 255));
        pnlNamQuy.setForeground(new java.awt.Color(255, 255, 255));
        pnlNamQuy.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout pnlNamQuyLayout = new javax.swing.GroupLayout(pnlNamQuy);
        pnlNamQuy.setLayout(pnlNamQuyLayout);
        pnlNamQuyLayout.setHorizontalGroup(
            pnlNamQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        pnlNamQuyLayout.setVerticalGroup(
            pnlNamQuyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlThongKe.add(pnlNamQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 140, -1));

        pnlNam.setBackground(new java.awt.Color(255, 255, 255));
        pnlNam.setForeground(new java.awt.Color(255, 255, 255));
        pnlNam.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout pnlNamLayout = new javax.swing.GroupLayout(pnlNam);
        pnlNam.setLayout(pnlNamLayout);
        pnlNamLayout.setHorizontalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        pnlNamLayout.setVerticalGroup(
            pnlNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pnlThongKe.add(pnlNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 140, -1));

        lblChuongTrinhKMNgay.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChuongTrinhKMNgay.setForeground(new java.awt.Color(255, 255, 255));
        lblChuongTrinhKMNgay.setText("1213414134");
        pnlThongKe.add(lblChuongTrinhKMNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        lblChiTietKMNgay.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChiTietKMNgay.setForeground(new java.awt.Color(255, 255, 255));
        lblChiTietKMNgay.setText("123456");
        pnlThongKe.add(lblChiTietKMNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, -1, -1));

        lblChuongTrinhKMTuDen.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChuongTrinhKMTuDen.setForeground(new java.awt.Color(255, 255, 255));
        lblChuongTrinhKMTuDen.setText("123456");
        pnlThongKe.add(lblChuongTrinhKMTuDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        lblChiTietKMTuDen.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChiTietKMTuDen.setForeground(new java.awt.Color(255, 255, 255));
        lblChiTietKMTuDen.setText("123456");
        pnlThongKe.add(lblChiTietKMTuDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, -1, -1));

        lblChuongTrinhKMNamThang.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChuongTrinhKMNamThang.setForeground(new java.awt.Color(255, 255, 255));
        lblChuongTrinhKMNamThang.setText("0");
        pnlThongKe.add(lblChuongTrinhKMNamThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, -1, 20));

        lblChiTietKMNamThang.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChiTietKMNamThang.setForeground(new java.awt.Color(255, 255, 255));
        lblChiTietKMNamThang.setText("0");
        pnlThongKe.add(lblChiTietKMNamThang, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 180, -1, -1));

        lblChiTietKMNamQuy.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChiTietKMNamQuy.setForeground(new java.awt.Color(255, 255, 255));
        lblChiTietKMNamQuy.setText("0");
        pnlThongKe.add(lblChiTietKMNamQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 250, -1, -1));

        lblChuongTrinhKMNamQuy.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChuongTrinhKMNamQuy.setForeground(new java.awt.Color(255, 255, 255));
        lblChuongTrinhKMNamQuy.setText("0");
        pnlThongKe.add(lblChuongTrinhKMNamQuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        lblChuongTrinhKMNam.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChuongTrinhKMNam.setForeground(new java.awt.Color(255, 255, 255));
        lblChuongTrinhKMNam.setText("0");
        pnlThongKe.add(lblChuongTrinhKMNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, -1, -1));

        lblChiTietKMNam.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        lblChiTietKMNam.setForeground(new java.awt.Color(255, 255, 255));
        lblChiTietKMNam.setText("0");
        pnlThongKe.add(lblChiTietKMNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, -1, -1));

        add(pnlThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 870, 340));

        pnlShowChart.setBackground(new java.awt.Color(45, 47, 62));
        pnlShowChart.setForeground(new java.awt.Color(53, 55, 70));

        pnlChart.setBackground(new java.awt.Color(53, 55, 70));
        pnlChart.setLayout(new javax.swing.BoxLayout(pnlChart, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout pnlShowChartLayout = new javax.swing.GroupLayout(pnlShowChart);
        pnlShowChart.setLayout(pnlShowChartLayout);
        pnlShowChartLayout.setHorizontalGroup(
            pnlShowChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowChartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChart, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlShowChartLayout.setVerticalGroup(
            pnlShowChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlShowChartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlChart, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(pnlShowChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 280));

        pnlXemChiTiet.setBackground(new java.awt.Color(45, 47, 62));
        pnlXemChiTiet.setForeground(new java.awt.Color(238, 38, 63));
        pnlXemChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlXemChiTietMouseClicked(evt);
            }
        });

        lblQuayVe1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblQuayVe1.setForeground(new java.awt.Color(255, 255, 255));
        lblQuayVe1.setText("Xem chi tiết thống kê");

        javax.swing.GroupLayout pnlXemChiTietLayout = new javax.swing.GroupLayout(pnlXemChiTiet);
        pnlXemChiTiet.setLayout(pnlXemChiTietLayout);
        pnlXemChiTietLayout.setHorizontalGroup(
            pnlXemChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlXemChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQuayVe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlXemChiTietLayout.setVerticalGroup(
            pnlXemChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblQuayVe1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        add(pnlXemChiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlQuayVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuayVeMouseClicked
        
        if (SwingUtilities.isLeftMouseButton(evt)){
            this.removeAll();
            this.setLayout(new BorderLayout());
            this.add(new ThongKeJPanel());
            this.validate();
            this.repaint();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_pnlQuayVeMouseClicked

    private void dateTuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateTuPropertyChange
        dateDen.setDate(dateTu.getDate());
        dateDen.setMinSelectableDate(dateTu.getDate());
    }//GEN-LAST:event_dateTuPropertyChange

    private void dateNgayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateNgayPropertyChange
        int[] khuyenMai=ThongKeKhuyenMaiNgay(dateNgay.getDate());
        lblChuongTrinhKMNgay.setText(changeCurrency(Integer.toString(khuyenMai[0])));
        lblChiTietKMNgay.setText(changeCurrency(Integer.toString(khuyenMai[1])));
    }//GEN-LAST:event_dateNgayPropertyChange

    private void dateDenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateDenPropertyChange
        int[] khuyenMai =ThongKeKhuyenMaiTuDen(dateTu.getDate(),dateDen.getDate());
        lblChuongTrinhKMTuDen.setText(changeCurrency(Integer.toString(khuyenMai[0])));
        lblChiTietKMTuDen.setText(changeCurrency(Integer.toString(khuyenMai[1])));
    }//GEN-LAST:event_dateDenPropertyChange

    private void pnlXemChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlXemChiTietMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt))
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new ChiTietThongKeKhuyenMaiJPanel());
        this.validate();
        this.repaint();  
    }//GEN-LAST:event_pnlXemChiTietMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateDen;
    private com.toedter.calendar.JDateChooser dateNgay;
    private com.toedter.calendar.JDateChooser dateTu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblChiTietKMNam;
    private javax.swing.JLabel lblChiTietKMNamQuy;
    private javax.swing.JLabel lblChiTietKMNamThang;
    private javax.swing.JLabel lblChiTietKMNgay;
    private javax.swing.JLabel lblChiTietKMTuDen;
    private javax.swing.JLabel lblChuongTrinhKMNam;
    private javax.swing.JLabel lblChuongTrinhKMNamQuy;
    private javax.swing.JLabel lblChuongTrinhKMNamThang;
    private javax.swing.JLabel lblChuongTrinhKMNgay;
    private javax.swing.JLabel lblChuongTrinhKMTuDen;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblNgay1;
    private javax.swing.JLabel lblNgay3;
    private javax.swing.JLabel lblNgay4;
    private javax.swing.JLabel lblNgay5;
    private javax.swing.JLabel lblNgay6;
    private javax.swing.JLabel lblNgay7;
    private javax.swing.JLabel lblNgay8;
    private javax.swing.JLabel lblQuayVe;
    private javax.swing.JLabel lblQuayVe1;
    private javax.swing.JPanel pnlChart;
    private javax.swing.JPanel pnlNam;
    private javax.swing.JPanel pnlNamQuy;
    private javax.swing.JPanel pnlNamThang;
    private GUI.Rounded pnlQuayVe;
    private javax.swing.JPanel pnlQuy;
    private GUI.Rounded pnlShowChart;
    private javax.swing.JPanel pnlThang;
    private GUI.Rounded pnlThongKe;
    private GUI.Rounded pnlXemChiTiet;
    // End of variables declaration//GEN-END:variables
}
