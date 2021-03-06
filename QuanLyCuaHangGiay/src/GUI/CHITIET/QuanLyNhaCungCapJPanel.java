/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CHITIET;
import java.util.Vector;
import DTO.NhaCungCapDTO;
import static GUI.CHITIET.QuanLyMauJPanel.fetchAll;
import GUI.POPUP.SuaJFrame;
import GUI.POPUP.SuaNhaCungCapJFrame;
import GUI.QuanLyJPanel;
import GUI.RenderTable;
import GUI.Sweet.SweetAlert;
import GUI.Sweet.SweetFileChooser;
import static GUI.TongQuanJPanel.customTable;
import static GUI.TongQuanJPanel.setJTableColumnsWidth;
import GUI.changeColorOfCellTable;
import IO.Excel.NhaCungCapExcel;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
public class QuanLyNhaCungCapJPanel extends javax.swing.JPanel {
    static DefaultTableModel listTableModel;
    Object[] columnNames ={"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Địa chỉ",""};
    /**
     * Creates new form QuanLyMauJPanel
     */
    public NhaCungCapDTO currentNhaCungCap = new NhaCungCapDTO();
    
        public void ShowTable(JTable table,Object[] columnName){
        listTableModel = new DefaultTableModel(columnNames,0);
        table.setDefaultRenderer(Object.class, new RenderTable());
        fetchAll();
        lblMaNhaCungCap.setText(quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.getLatest());
    }  
        
            public static void fetchAll(){
            String edit ="Sửa";
            listTableModel.setRowCount(0);
            quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.NhaCungCapList.forEach(NhaCungCap ->{
                Vector row = new Vector();
                row.add(NhaCungCap.getMaNhaCungCap());
                row.add(NhaCungCap.getTenNhaCungCap());
                row.add(NhaCungCap.getSoDienThoai());
                row.add(NhaCungCap.getDiaChi());
                row.add(edit);
                listTableModel.addRow(row);
            });
            tblNhaCungCap.setModel(listTableModel);
        }
    
    public void changeCell4(){
        
        for(int j = 0 ; j<tblNhaCungCap.getRowCount();j++){
            
                
                tblNhaCungCap.getColumnModel().getColumn(4).setCellRenderer(new changeColorOfCellTable(tblNhaCungCap,j,4));

            
            
        }
        
    }        
    public QuanLyNhaCungCapJPanel() {
        initComponents();
        customTable(tblNhaCungCap,scpNhaCungCap);
        ShowTable(tblNhaCungCap,columnNames);
        setJTableColumnsWidth(tblNhaCungCap,890,15,25,25,25,10);   
        changeCell4();
        pnlThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlQuayVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
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
        scpNhaCungCap = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }

        };
        lblThongTinHoaDon1 = new javax.swing.JLabel();
        pnlThongTinHoaDon = new javax.swing.JPanel();
        lblTenNhaCungCap = new javax.swing.JLabel();
        lblTitleDiaChi = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        lblTitleMaNhaCungCap = new javax.swing.JLabel();
        lblMaNhaCungCap = new javax.swing.JLabel();
        pnlThem = new GUI.Rounded();
        lblThem = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenNhaCungCap = new javax.swing.JTextField();
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
        lblThongTinHoaDon.setText("Thêm nhà cung cấp");

        scpNhaCungCap.setBackground(new java.awt.Color(53, 55, 70));
        scpNhaCungCap.setForeground(new java.awt.Color(53, 55, 70));

        tblNhaCungCap.setAutoCreateRowSorter(true);
        tblNhaCungCap.setBackground(new java.awt.Color(53, 55, 70));
        tblNhaCungCap.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tblNhaCungCap.setForeground(new java.awt.Color(255, 255, 255));
        tblNhaCungCap.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblNhaCungCap.setFocusable(false);
        tblNhaCungCap.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblNhaCungCap.setRowHeight(25);
        tblNhaCungCap.setSelectionBackground(new java.awt.Color(72, 74, 89));
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        scpNhaCungCap.setViewportView(tblNhaCungCap);

        lblThongTinHoaDon1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblThongTinHoaDon1.setForeground(new java.awt.Color(210, 48, 44));
        lblThongTinHoaDon1.setText("Sản phẩm");

        pnlThongTinHoaDon.setBackground(new java.awt.Color(53, 55, 70));
        pnlThongTinHoaDon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenNhaCungCap.setForeground(new java.awt.Color(192, 192, 192));
        lblTenNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenNhaCungCap.setText("Tên nhà cung cấp:");
        pnlThongTinHoaDon.add(lblTenNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblTitleDiaChi.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleDiaChi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleDiaChi.setText("Địa chỉ:");
        pnlThongTinHoaDon.add(lblTitleDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lblSoDienThoai.setForeground(new java.awt.Color(192, 192, 192));
        lblSoDienThoai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSoDienThoai.setText("Số điện thoại:");
        pnlThongTinHoaDon.add(lblSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblTitleMaNhaCungCap.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaNhaCungCap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaNhaCungCap.setText("Mã nhà cung cấp:");
        pnlThongTinHoaDon.add(lblTitleMaNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, -1));

        lblMaNhaCungCap.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblMaNhaCungCap.setForeground(new java.awt.Color(210, 48, 44));
        lblMaNhaCungCap.setText("MAGIAMGIA2020");
        pnlThongTinHoaDon.add(lblMaNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

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
                .addComponent(lblThem, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlThemLayout.setVerticalGroup(
            pnlThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        pnlThongTinHoaDon.add(pnlThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 90, 40));

        txtSoDienThoai.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtSoDienThoai.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSoDienThoai.setBorder(null);
        txtSoDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoDienThoaiKeyPressed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 290, 20));

        txtDiaChi.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtDiaChi.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDiaChi.setBorder(null);
        txtDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiaChiKeyPressed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, 20));

        txtTenNhaCungCap.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtTenNhaCungCap.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenNhaCungCap.setBorder(null);
        txtTenNhaCungCap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenNhaCungCapKeyPressed(evt);
            }
        });
        pnlThongTinHoaDon.add(txtTenNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 290, 20));

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

        pnlThongTinHoaDon.add(pnlXuatDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 30));

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

        pnlThongTinHoaDon.add(pnlNhapDuLieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, 30));

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(scpNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(pnlThongTinLayout.createSequentialGroup()
                        .addComponent(lblThongTinHoaDon1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinLayout.createSequentialGroup()
                        .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlThongTinLayout.createSequentialGroup()
                                .addComponent(lblThongTinHoaDon)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE))
                        .addGap(17, 17, 17))))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblThongTinHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlThongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblThongTinHoaDon1)
                .addGap(18, 18, 18)
                .addComponent(scpNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        this.repaint();          // TODO add your handling code here:
    }//GEN-LAST:event_pnlQuayVeMouseClicked

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
        int column = tblNhaCungCap.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblNhaCungCap.getRowHeight();

        if(row < tblNhaCungCap.getRowCount() && row >= 0 && column < tblNhaCungCap.getColumnCount() && column >= 0){
                currentNhaCungCap = quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.getByMaNhaCungCap(tblNhaCungCap.getModel().getValueAt(row,0).toString());
                
            if(tblNhaCungCap.getValueAt(row,column).toString().equalsIgnoreCase("Sửa")){ 
                    
                           new SuaNhaCungCapJFrame(currentNhaCungCap).setVisible(true);

            }  
        }
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void txtTenNhaCungCapKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNhaCungCapKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           txtSoDienThoai.requestFocus();
       }
    }//GEN-LAST:event_txtTenNhaCungCapKeyPressed

    private void txtSoDienThoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKeyPressed
       if(evt.getKeyCode()== KeyEvent.VK_ENTER){
           txtDiaChi.requestFocus();
       }
    }//GEN-LAST:event_txtSoDienThoaiKeyPressed

    private boolean isFill(){
    if(txtTenNhaCungCap.getText().equals("")) return false;
    if(txtSoDienThoai.getText().equals("")) return false;
    if(txtDiaChi.getText().equals("")) return false;
    return true;
    }
    private void txtDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiKeyPressed
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(!isFill()){GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Lỗi","Không được bỏ trống",1); return;}
            add();
        }
    }//GEN-LAST:event_txtDiaChiKeyPressed

    private void lblThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThemMouseClicked
               if (SwingUtilities.isLeftMouseButton(evt))
            add();
        
    }//GEN-LAST:event_lblThemMouseClicked

    private void lblThem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThem1MouseClicked
        try {
            String path = SweetFileChooser.ExcelFileChooser();
            if(path==null){
                SweetAlert.showSweetAlert(new JFrame(), "Lỗi", "Vui lòng chọn file phù hợp", 1);
                return;
            }
            NhaCungCapExcel.ExportExcelFile(path, quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.NhaCungCapList);
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
            NhaCungCapExcel.ImportExcelFile(path, 4).forEach(ncc->{
                if(quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.add(ncc)==false);
                    ncc.setMaNhaCungCap(quanlycuahanggiay.quanlycuahanggiay.MauBUS.getLatest());
                    quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.add(ncc);
            });
            SweetAlert.showSweetAlert(new JFrame(), "Hoàn tất", "Nhập dữ liệu thành công", 0);
        } catch (IOException ex) {
            SweetAlert.showSweetAlert(new JFrame(), "Lỗi", ex.getMessage(), 1);
        }
        fetchAll();
    }//GEN-LAST:event_lblThem2MouseClicked

    public void setCurrentNhaCungCap(){
        currentNhaCungCap.setMaNhaCungCap(lblMaNhaCungCap.getText());
        currentNhaCungCap.setTenNhaCungCap(txtTenNhaCungCap.getText());
        currentNhaCungCap.setDiaChi(txtDiaChi.getText());
        currentNhaCungCap.setSoDienThoai(txtSoDienThoai.getText());
    }
    public void add(){
        if(GUI.Sweet.SweetAlert.showSweetOption(new javax.swing.JFrame(), "Xác nhận", "Thêm mới?",0)==1){
        if(!isFill()){GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Lỗi","Không được bỏ trống",1); return;}
        setCurrentNhaCungCap();
        if(quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.add(currentNhaCungCap))
        {
        fetchAll();
        GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Thành công","Thêm mới thành công",1);
        lblMaNhaCungCap.setText(quanlycuahanggiay.quanlycuahanggiay.NhaCungCapBUS.getLatest());
        fillBlank();
        }
        }
    }

    public void fillBlank(){
        txtTenNhaCungCap.setText("");
    txtSoDienThoai.setText("");
    txtDiaChi.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMaNhaCungCap;
    private javax.swing.JLabel lblQuayVe;
    private javax.swing.JLabel lblSoDienThoai;
    private javax.swing.JLabel lblTenNhaCungCap;
    private javax.swing.JLabel lblThem;
    private javax.swing.JLabel lblThem1;
    private javax.swing.JLabel lblThem2;
    private javax.swing.JLabel lblThongTinHoaDon;
    private javax.swing.JLabel lblThongTinHoaDon1;
    private javax.swing.JLabel lblTitleDiaChi;
    private javax.swing.JLabel lblTitleMaNhaCungCap;
    private GUI.Rounded pnlNhapDuLieu;
    private GUI.Rounded pnlQuayVe;
    private GUI.Rounded pnlThem;
    private GUI.Rounded pnlThongTin;
    private javax.swing.JPanel pnlThongTinHoaDon;
    private GUI.Rounded pnlXuatDuLieu;
    private javax.swing.JScrollPane scpNhaCungCap;
    private static javax.swing.JTable tblNhaCungCap;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhaCungCap;
    // End of variables declaration//GEN-END:variables
}
