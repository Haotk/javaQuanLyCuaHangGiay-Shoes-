/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.CHITIET;

import DTO.SanPhamDTO;
import GUI.Sweet.SweetComboBox;
import static GUI.Sweet.SweetFileChooser.FileExists;
import static GUI.Sweet.SweetFileChooser.PATH_SANPHAM;
import GUI.Sweet.SweetImage;
import static GUI.Sweet.SweetImage.readImageFromFilePath;
import static GUI.Sweet.SweetImage.resizeImage;
import static GUI.Sweet.SweetImage.saveImage;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import static GUI.SanPhamJPanel.currentSanPham;
import static quanlycuahanggiay.Currency.changeCurrency;

/**
 *
 * @author admin
 */
public class SuaSanPhamJPanel extends javax.swing.JPanel {
    SweetComboBox cbxMau, cbxSize, cbxThuongHieu;
    
    public ImageIcon imgAnhDaiDien;
    /**
     * Creates new form SuaSanPhamJPanel
     */
    public void setComboBox(){
        String[] mau = quanlycuahanggiay.quanlycuahanggiay.MauBUS.getTenKhongTieuDeStringArray();
        cbxMau = new SweetComboBox("#ffffff","#000000",0,0,120,30,mau);
        pnlMau.add(cbxMau);  
        String[] size = quanlycuahanggiay.quanlycuahanggiay.SizeBUS.getTenKhongTieuDeStringArray();
        cbxSize = new SweetComboBox("#ffffff","#000000",0,0,90,30,size);
        pnlSize.add(cbxSize);       
        String[] thuonghieu = quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getTenKhongTieuDeStringArray();
        cbxThuongHieu = new SweetComboBox("#ffffff","#000000",0,0,190,30,thuonghieu);
        pnlThuongHieu.add(cbxThuongHieu);       
        
    }     
    public SuaSanPhamJPanel(SanPhamDTO currentSanPham) {
        initComponents();
        setComboBox();
        setData();
        
        pnlCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnlHuyBo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblAddImage1 = new javax.swing.JLabel();
        lblTitleMaSanPham = new javax.swing.JLabel();
        lblTitleTenSanPham = new javax.swing.JLabel();
        lblTitleDonGia = new javax.swing.JLabel();
        lblTitleMau = new javax.swing.JLabel();
        lblTitleSize = new javax.swing.JLabel();
        lblTitleThuongHieu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        lblMaSanPham = new javax.swing.JLabel();
        pnlCapNhat = new GUI.Rounded();
        lblCapNhat = new javax.swing.JLabel();
        pnlHuyBo = new GUI.Rounded();
        lblHuyBo = new javax.swing.JLabel();
        pnlSize = new javax.swing.JPanel();
        pnlMau = new javax.swing.JPanel();
        pnlThuongHieu = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(45, 47, 62));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddImage1.setFont(new java.awt.Font("#9Slide03 Source Sans Pro", 0, 14)); // NOI18N
        lblAddImage1.setForeground(new java.awt.Color(255, 255, 255));
        lblAddImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddImage1.setText("Thêm hình ảnh");
        lblAddImage1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        lblAddImage1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblAddImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddImage1MouseClicked(evt);
            }
        });
        jPanel1.add(lblAddImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 100, -1));

        lblTitleMaSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleMaSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleMaSanPham.setText("Mã sản phẩm:");
        lblTitleMaSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jPanel1.add(lblTitleMaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 100, 40));

        lblTitleTenSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleTenSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleTenSanPham.setText("Tên sản phẩm:");
        lblTitleTenSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTitleTenSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleTenSanPhamMouseClicked(evt);
            }
        });
        jPanel1.add(lblTitleTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 110, 40));

        lblTitleDonGia.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleDonGia.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleDonGia.setText("Đơn giá:");
        lblTitleDonGia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTitleDonGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleDonGiaMouseClicked(evt);
            }
        });
        jPanel1.add(lblTitleDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 100, 40));

        lblTitleMau.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleMau.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleMau.setText("Màu:");
        lblTitleMau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTitleMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleMauMouseClicked(evt);
            }
        });
        jPanel1.add(lblTitleMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 40, 30));

        lblTitleSize.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleSize.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleSize.setText("Size:");
        lblTitleSize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTitleSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleSizeMouseClicked(evt);
            }
        });
        jPanel1.add(lblTitleSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 40, 30));

        lblTitleThuongHieu.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitleThuongHieu.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleThuongHieu.setText("Thương hiệu:");
        lblTitleThuongHieu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblTitleThuongHieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleThuongHieuMouseClicked(evt);
            }
        });
        jPanel1.add(lblTitleThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 100, 40));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(210, 57, 44));
        jLabel1.setText("đ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 30, 30));

        txtDonGia.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDonGia.setBorder(null);
        jPanel1.add(txtDonGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 190, 30));

        txtTenSanPham.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        txtTenSanPham.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenSanPham.setBorder(null);
        jPanel1.add(txtTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 190, 30));

        lblMaSanPham.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblMaSanPham.setForeground(new java.awt.Color(210, 57, 44));
        lblMaSanPham.setText("#213");
        jPanel1.add(lblMaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        pnlCapNhat.setBackground(new java.awt.Color(45, 47, 62));
        pnlCapNhat.setForeground(new java.awt.Color(34, 212, 52));
        pnlCapNhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCapNhatMouseClicked(evt);
            }
        });

        lblCapNhat.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        lblCapNhat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCapNhat.setText("Cập nhật");

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCapNhatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(pnlCapNhat, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 650, 130, -1));

        pnlHuyBo.setBackground(new java.awt.Color(45, 47, 62));
        pnlHuyBo.setForeground(new java.awt.Color(238, 38, 64));
        pnlHuyBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlHuyBoMouseClicked(evt);
            }
        });

        lblHuyBo.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblHuyBo.setForeground(new java.awt.Color(255, 255, 255));
        lblHuyBo.setText("Hủy bỏ");

        javax.swing.GroupLayout pnlHuyBoLayout = new javax.swing.GroupLayout(pnlHuyBo);
        pnlHuyBo.setLayout(pnlHuyBoLayout);
        pnlHuyBoLayout.setHorizontalGroup(
            pnlHuyBoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHuyBoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHuyBo)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlHuyBoLayout.setVerticalGroup(
            pnlHuyBoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel1.add(pnlHuyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 650, -1, -1));

        pnlSize.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlSizeLayout = new javax.swing.GroupLayout(pnlSize);
        pnlSize.setLayout(pnlSizeLayout);
        pnlSizeLayout.setHorizontalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
        pnlSizeLayout.setVerticalGroup(
            pnlSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 90, 30));

        pnlMau.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlMauLayout = new javax.swing.GroupLayout(pnlMau);
        pnlMau.setLayout(pnlMauLayout);
        pnlMauLayout.setHorizontalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );
        pnlMauLayout.setVerticalGroup(
            pnlMauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlMau, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, -1, -1));

        pnlThuongHieu.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlThuongHieuLayout = new javax.swing.GroupLayout(pnlThuongHieu);
        pnlThuongHieu.setLayout(pnlThuongHieuLayout);
        pnlThuongHieuLayout.setHorizontalGroup(
            pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        pnlThuongHieuLayout.setVerticalGroup(
            pnlThuongHieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(pnlThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 220, -1, -1));
        jPanel1.add(lblAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 240, 310));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 933, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddImage1MouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            try {
                File file =  GUI.Sweet.SweetFileChooser.ImageFileChooser();
                if(file!=null)
                lblAnh.setIcon(resizeImage(ImageIO.read(file),240,310));
            } catch (IOException ex) {
                Logger.getLogger(SuaSanPhamJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lblAddImage1MouseClicked

    private void lblTitleTenSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleTenSanPhamMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitleTenSanPhamMouseClicked

    private void lblTitleDonGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleDonGiaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitleDonGiaMouseClicked

    private void lblTitleMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMauMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitleMauMouseClicked

    private void lblTitleSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleSizeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitleSizeMouseClicked

    private void lblTitleThuongHieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleThuongHieuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblTitleThuongHieuMouseClicked

    private void pnlCapNhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCapNhatMouseClicked
        if(SwingUtilities.isLeftMouseButton(evt))
            if(GUI.Sweet.SweetAlert.showSweetOption(new javax.swing.JFrame(), "Thông báo", "Cập nhật chỉnh sửa?", 0) == 1)
                if(isNotFill()){
                    GUI.Sweet.SweetAlert.showSweetAlert(new javax.swing.JFrame(), "Lỗi", "Không được bỏ trống", 0);
                }
                else{
                    setSanPham();
                    if(quanlycuahanggiay.quanlycuahanggiay.SanPhamBUS.edit(currentSanPham)){
                        
                        paint();       
                    }
                }

    }//GEN-LAST:event_pnlCapNhatMouseClicked
    private boolean isNotFill(){
        if(txtDonGia.getText().equals("") || txtTenSanPham.getText().equals("")){
            return true;
        }
        return false;
    }
    
    private void paint(){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new ChiTietSanPhamJPanel(currentSanPham));
        this.validate();
        this.repaint();
    }
    
    private void setSanPham(){
       currentSanPham.setTenSanPham(txtTenSanPham.getText());
       currentSanPham.setDonGia(txtDonGia.getText().replace(".",""));
       currentSanPham.setMaMau(quanlycuahanggiay.quanlycuahanggiay.MauBUS.getMaMau(cbxMau.getSelectedItem().toString()));
       currentSanPham.setMaSize(quanlycuahanggiay.quanlycuahanggiay.SizeBUS.getMaSize(cbxSize.getSelectedItem().toString()));
       currentSanPham.setMaThuongHieu(quanlycuahanggiay.quanlycuahanggiay.ThuongHieuBUS.getMaThuongHieu(cbxThuongHieu.getSelectedItem().toString()));
       currentSanPham.setImgSource(saveImage(lblMaSanPham.getText()));
    }
    
    public void setData(){
        lblMaSanPham.setText(currentSanPham.getMaSanPham());
        txtTenSanPham.setText(currentSanPham.getTenSanPham());
        txtDonGia.setText(changeCurrency(currentSanPham.getDonGia()));
        cbxMau.setSelectedItem(GUI.CHITIET.ChiTietSanPhamJPanel.currentMau.getTenMauByMaMau(currentSanPham.getMaMau()));
        cbxSize.setSelectedItem(GUI.CHITIET.ChiTietSanPhamJPanel.currentSize.getTenSizeByMaSize(currentSanPham.getMaSize()));
        cbxThuongHieu.setSelectedItem(GUI.CHITIET.ChiTietSanPhamJPanel.currentThuongHieu.getTenThuongHieuByMaThuongHieu(currentSanPham.getMaThuongHieu()));
        if (!FileExists(PATH_SANPHAM + currentSanPham.getImgSource())) {
            currentSanPham.setImgSource("default.jpg");
        }
        
        Image imageScale = readImageFromFilePath(PATH_SANPHAM + currentSanPham.getImgSource(), 240, 310);
        imgAnhDaiDien = new ImageIcon(imageScale);
        lblAnh.setIcon(imgAnhDaiDien);
        currentSanPham.setImgSource(saveImage(lblAnh.getIcon(), lblMaSanPham.getText()));
        
    }
    
    private void pnlHuyBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuyBoMouseClicked
        if(SwingUtilities.isLeftMouseButton(evt)){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new ChiTietSanPhamJPanel(currentSanPham));
        this.validate();
        this.repaint();
        }
    }//GEN-LAST:event_pnlHuyBoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddImage1;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCapNhat;
    private javax.swing.JLabel lblHuyBo;
    private javax.swing.JLabel lblMaSanPham;
    private javax.swing.JLabel lblTitleDonGia;
    private javax.swing.JLabel lblTitleMaSanPham;
    private javax.swing.JLabel lblTitleMau;
    private javax.swing.JLabel lblTitleSize;
    private javax.swing.JLabel lblTitleTenSanPham;
    private javax.swing.JLabel lblTitleThuongHieu;
    private GUI.Rounded pnlCapNhat;
    private GUI.Rounded pnlHuyBo;
    private javax.swing.JPanel pnlMau;
    private javax.swing.JPanel pnlSize;
    private javax.swing.JPanel pnlThuongHieu;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtTenSanPham;
    // End of variables declaration//GEN-END:variables
}
