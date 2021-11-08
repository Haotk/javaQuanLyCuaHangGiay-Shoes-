/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CHITIET;

import DTO.ThuongHieuDTO;
import BUS.ThuongHieuBUS;
import static GUI.CHITIET.QuanLyMauJPanel.fetchAll;
import java.util.ArrayList;
import GUI.POPUP.SuaJFrame;
import GUI.QuanLyJPanel;
import GUI.RenderTable;
import GUI.Sweet.SweetAlert;
import GUI.Sweet.SweetFileChooser;
import static GUI.TongQuanJPanel.customTable;
import GUI.changeColorOfCellTable;
import IO.Excel.ThuongHieuExcel;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class QuanLyThuongHieuJPanel extends javax.swing.JPanel {

    public ThuongHieuDTO currentThuongHieu = new ThuongHieuDTO();
    Object[] columnNames = {"Mã thương hiệu", "Thương hiệu", ""};
    public static DefaultTableModel listTableModel;

    /**
     * Creates new form QuanLyMauJPanel
     */
    public void ShowTable(JTable table, Object[] columnName) {
        listTableModel = new DefaultTableModel(columnNames, 0);
        table.setDefaultRenderer(Object.class, new RenderTable());
        fetchAll();
    }

    public static void fetchAll() {
        String edit = "Sửa";
        listTableModel.setRowCount(0);

        quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.ThuongHieuList.forEach(ThuongHieu -> {
            Vector row = new Vector();
            row.add(ThuongHieu.getMaThuongHieu());
            row.add(ThuongHieu.getTenThuongHieu());
            row.add(edit);
            listTableModel.addRow(row);
        });
        tblThuongHieu.setModel(listTableModel);
    }

    public void changeCell3() {
        for (int j = 0; j < tblThuongHieu.getRowCount(); j++) {
            tblThuongHieu.getColumnModel().getColumn(2).setCellRenderer(new changeColorOfCellTable(tblThuongHieu, j, 2));
        }
    }

    public QuanLyThuongHieuJPanel() {
        initComponents();
        customTable(tblThuongHieu, scpThuongHieu);
        ShowTable(tblThuongHieu, columnNames);
        changeCell3();
        pnlThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlQuayVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        lblMaThuongHieu.setText(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getLatest());
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
        pnlThongTin = new GUI.Rounded();
        lblThongTinHoaDon = new javax.swing.JLabel();
        scpThuongHieu = new javax.swing.JScrollPane();
        tblThuongHieu = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }

        };
        lblThongTinHoaDon1 = new javax.swing.JLabel();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        lblTitleThuongHieu = new javax.swing.JLabel();
        lblTitleThuonghieu = new javax.swing.JLabel();
        lblMaThuongHieu = new javax.swing.JLabel();
        pnlThem = new GUI.Rounded();
        lblThem = new javax.swing.JLabel();
        txtThuongHieu = new javax.swing.JTextField();
        pnlXuatDuLieu = new GUI.Rounded();
        lblThem1 = new javax.swing.JLabel();
        pnlNhapDuLieu = new GUI.Rounded();
        lblThem2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 47, 62));

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

        pnlThongTin.setBackground(new java.awt.Color(45, 47, 62));
        pnlThongTin.setForeground(new java.awt.Color(53, 55, 70));
        pnlThongTin.setPreferredSize(new java.awt.Dimension(920, 750));

        lblThongTinHoaDon.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblThongTinHoaDon.setForeground(new java.awt.Color(210, 48, 44));
        lblThongTinHoaDon.setText("Thêm thương hiệu");

        scpThuongHieu.setBackground(new java.awt.Color(53, 55, 70));
        scpThuongHieu.setForeground(new java.awt.Color(53, 55, 70));

        tblThuongHieu.setAutoCreateRowSorter(true);
        tblThuongHieu.setBackground(new java.awt.Color(53, 55, 70));
        tblThuongHieu.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tblThuongHieu.setForeground(new java.awt.Color(255, 255, 255));
        tblThuongHieu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblThuongHieu.setFocusable(false);
        tblThuongHieu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblThuongHieu.setRowHeight(25);
        tblThuongHieu.setSelectionBackground(new java.awt.Color(72, 74, 89));
        tblThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThuongHieuMouseClicked(evt);
            }
        });
        scpThuongHieu.setViewportView(tblThuongHieu);

        lblThongTinHoaDon1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblThongTinHoaDon1.setForeground(new java.awt.Color(210, 48, 44));
        lblThongTinHoaDon1.setText("Danh sách thương hiệu");

        pnlThongTinHoaDon.setBackground(new java.awt.Color(53, 55, 70));
        pnlThongTinHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleThuongHieu.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleThuongHieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleThuongHieu.setText("Thương hiệu:");
        pnlThongTinHoaDon.add(lblTitleThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblTitleThuonghieu.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleThuonghieu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleThuonghieu.setText("Mã thương hiệu:");
        pnlThongTinHoaDon.add(lblTitleThuonghieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, -1));

        lblMaThuongHieu.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblMaThuongHieu.setForeground(new java.awt.Color(210, 48, 44));
        lblMaThuongHieu.setText("#SIZE1234");
        lblMaThuongHieu.setRequestFocusEnabled(false);
        pnlThongTinHoaDon.add(lblMaThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 30));

        pnlThem.setBackground(new java.awt.Color(53, 55, 70));
        pnlThem.setForeground(new java.awt.Color(210, 48, 44));

        lblThem.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblThem.setForeground(new java.awt.Color(255, 255, 255));
        lblThem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem.setText("Thêm");
        lblThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlThemLayout = new javax.swing.GroupLayout(pnlThem);
        pnlThem.setLayout(pnlThemLayout);
        pnlThemLayout.setHorizontalGroup(
            pnlThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlThemLayout.setVerticalGroup(
            pnlThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlThongTinHoaDon.add(pnlThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 30));

        txtThuongHieu.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtThuongHieu.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtThuongHieu.setBorder(null);
        txtThuongHieu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThuongHieuKeyPressed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 20));

        pnlXuatDuLieu.setBackground(new java.awt.Color(53, 55, 70));
        pnlXuatDuLieu.setForeground(new java.awt.Color(210, 48, 44));

        lblThem1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblThem1.setForeground(new java.awt.Color(255, 255, 255));
        lblThem1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem1.setText("Xuất dữ liệu");
        lblThem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThem1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlXuatDuLieuLayout = new javax.swing.GroupLayout(pnlXuatDuLieu);
        pnlXuatDuLieu.setLayout(pnlXuatDuLieuLayout);
        pnlXuatDuLieuLayout.setHorizontalGroup(
            pnlXuatDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlXuatDuLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThem1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlXuatDuLieuLayout.setVerticalGroup(
            pnlXuatDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlThongTinHoaDon.add(pnlXuatDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, -1, 30));

        pnlNhapDuLieu.setBackground(new java.awt.Color(53, 55, 70));
        pnlNhapDuLieu.setForeground(new java.awt.Color(210, 48, 44));

        lblThem2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblThem2.setForeground(new java.awt.Color(255, 255, 255));
        lblThem2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThem2.setText("Nhập dữ liệu");
        lblThem2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThem2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlNhapDuLieuLayout = new javax.swing.GroupLayout(pnlNhapDuLieu);
        pnlNhapDuLieu.setLayout(pnlNhapDuLieuLayout);
        pnlNhapDuLieuLayout.setHorizontalGroup(
            pnlNhapDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNhapDuLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThem2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNhapDuLieuLayout.setVerticalGroup(
            pnlNhapDuLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        pnlThongTinHoaDon.add(pnlNhapDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, 30));

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(scpThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(lblThongTinHoaDon1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinLayout.createSequentialGroup()
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlThongTinLayout.createSequentialGroup()
                                .addComponent(lblThongTinHoaDon)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblThongTinHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThongTinHoaDon1)
                .addGap(18, 18, 18)
                .addComponent(scpThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlQuayVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlQuayVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pnlQuayVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuayVeMouseClicked
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new QuanLyJPanel());
        this.validate();
        this.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_pnlQuayVeMouseClicked

    private void tblThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThuongHieuMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            int column = tblThuongHieu.getColumnModel().getColumnIndexAtX(evt.getX());
            int row = evt.getY() / tblThuongHieu.getRowHeight();
            if (row < tblThuongHieu.getRowCount() && row >= 0 && column < tblThuongHieu.getColumnCount() && column >= 0) {
                currentThuongHieu = quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getByMaThuongHieu(tblThuongHieu.getModel().getValueAt(row, 0).toString());

                if (tblThuongHieu.getValueAt(row, column).toString().equalsIgnoreCase("Sửa")) {
                    new SuaJFrame(0, currentThuongHieu).setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_tblThuongHieuMouseClicked

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt))
            add();
        
    }//GEN-LAST:event_lblThemMouseClicked

    private void txtThuongHieuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThuongHieuKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(txtThuongHieu.getText().equals("")){GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Lỗi","Không được bỏ trống",1); return;}
            add();
        }
    }//GEN-LAST:event_txtThuongHieuKeyPressed

    private void lblThem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThem1MouseClicked
        try {
            String path = SweetFileChooser.ExcelFileChooser();
            if(path==null){
                SweetAlert.showSweetAlert(new JFrame(), "Lỗi", "Vui lòng chọn file phù hợp", 1);
                return;
            }
            ThuongHieuExcel.ExportExcelFile(path, quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.ThuongHieuList);
            SweetAlert.showSweetAlert(new JFrame(), "Hoàn tất", "xuất dữ liệu thành công", 0);
        } catch (IOException ex) {
            SweetAlert.showSweetAlert(new JFrame(), "Lỗi", ex.getMessage(), 1);
        }
    }//GEN-LAST:event_lblThem1MouseClicked

    private void lblThem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThem2MouseClicked
        try {
            String path = SweetFileChooser.ExcelFileChooser();
            if(path==null){
                SweetAlert.showSweetAlert(new JFrame(), "Lỗi", "Vui lòng chọn file phù hợp", 1);
                return;
            }
            ThuongHieuExcel.ImportExcelFile(path,2).forEach(th->{
                if(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.add(th)==false);
                    th.setMaThuongHieu(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getLatest());
                    quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.add(th);
            });
            SweetAlert.showSweetAlert(new JFrame(), "Hoàn tất", "Nhập dữ liệu thành công", 0);
        } catch (IOException ex) {
            SweetAlert.showSweetAlert(new JFrame(), "Lỗi", ex.getMessage(), 1);
        }
        fetchAll();
    }//GEN-LAST:event_lblThem2MouseClicked
    private void add() {
        if (GUI.Sweet.SweetAlert.showSweetOption(new javax.swing.JFrame(), "Xác nhận", "Thêm mới?", 0) == 1) {
            if(txtThuongHieu.getText().equals("")){GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Lỗi","Không được bỏ trống",1); return;}
        
            setCurrentThuongHieu();
            if(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.add(currentThuongHieu)){
            fetchAll();
            lblMaThuongHieu.setText(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getLatest());
        }
        }
    }
    private void fillBlank(){
    txtThuongHieu.setText("");
    }
    private void setCurrentThuongHieu(){
            currentThuongHieu.setMaThuongHieu(lblMaThuongHieu.getText());
            currentThuongHieu.setTenThuongHieu(txtThuongHieu.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMaThuongHieu;
    private javax.swing.JLabel lblQuayVe;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblThem1;
    private javax.swing.JLabel lblThem2;
    private javax.swing.JLabel lblThongTinHoaDon;
    private javax.swing.JLabel lblThongTinHoaDon1;
    private javax.swing.JLabel lblTitleThuongHieu;
    private javax.swing.JLabel lblTitleThuonghieu;
    private GUI.Rounded pnlNhapDuLieu;
    private GUI.Rounded pnlQuayVe;
    private GUI.Rounded pnlThem;
    private GUI.Rounded pnlThongTin;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private GUI.Rounded pnlXuatDuLieu;
    private javax.swing.JScrollPane scpThuongHieu;
    private static javax.swing.JTable tblThuongHieu;
    private javax.swing.JTextField txtThuongHieu;
    // End of variables declaration//GEN-END:variables
}
