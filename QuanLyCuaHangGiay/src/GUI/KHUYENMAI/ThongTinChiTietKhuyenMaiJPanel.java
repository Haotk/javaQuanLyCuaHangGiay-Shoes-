/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.KHUYENMAI;

import DTO.ChiTietDonHangDTO;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.DonHangDTO;
import DTO.KhachHangDTO;
import DTO.SanPhamKhuyenMaiDTO;
import GUI.CHITIET.ChiTietDonHangJPanel;
import GUI.CHITIET.ChiTietDonHangTrongChiTietKMJPanel;
import GUI.POPUP.XemSanPhamKhuyenMaiTrongChiTietKMJFrame;
import GUI.RenderTable;
import GUI.THEMMOI.SuaMaKhuyenMaiJPanel;
import GUI.THEMMOI.TaoMaKhuyenMaiJPanel;
import static GUI.TongQuanJPanel.customTable;
import static GUI.TongQuanJPanel.setJTableColumnsWidth;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import static quanlycuahanggiay.DateTime.TimestampToDateString;
import static quanlycuahanggiay.Currency.changeCurrency;

/**
 *
 * @author admin
 */
public class ThongTinChiTietKhuyenMaiJPanel extends javax.swing.JPanel {
    static DefaultTableModel listTableModel;
    /**
     * Creates new form ThongTinKhuyenMaiJPanel
     */
    Object[] columnNames ={"Mã đơn hàng","Tạm tính","Giảm giá","Tổng","Ngày mua"};
    /**
     * Creates new form SanPhamJPanel
     */
    public static ArrayList<String> MaSanPhamList;
    public static DonHangDTO currentDonHang;
    public static KhachHangDTO currentKhachHang;
    public static ChiTietDonHangDTO currentChiTietDonHang;
    public void ShowTable(JTable table,Object[] columnName){
        listTableModel = new DefaultTableModel(columnNames,0);
        table.setDefaultRenderer(Object.class, new RenderTable());
        fetchAll();  
    }   
    
    public static void fetchAll(){
        listTableModel.setRowCount(0);
        quanlycuahanggiay.quanlycuahanggiay.DonHangBUS.DonHangList.forEach(DonHang ->{
            
            if( DonHang.getMaCode()!=null && DonHang.getMaCode().equals(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getMaCode())){
            Vector row = new Vector();
            row.add(DonHang.getMaDonHang());
            row.add(changeCurrency(DonHang.getTamTinh()));
            row.add(changeCurrency(DonHang.getGiamGia()));
            row.add(changeCurrency(DonHang.getTongTien()));
            row.add(TimestampToDateString(DonHang.getNgayXuat(),1));
            listTableModel.addRow(row);
            }
        });
        tblDonHang.setModel(listTableModel);
    }
    
    public ThongTinChiTietKhuyenMaiJPanel() {
        initComponents();
        
        customTable(tblDonHang,scpDonHang);
        ShowTable(tblDonHang,columnNames);
        
        setJTableColumnsWidth(tblDonHang,890,20,20,20,20,20);   
        pnlQuayVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
        lblXem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setData();
    }
    
    private int conlai(String soluong,String dasudung){
        return Integer.parseInt(soluong)-Integer.parseInt(dasudung);
    }
    private void setData(){
        
        lblMaChuongTrinhKhuyenMai.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getMaChuongTrinhKhuyenMai());
        lblMaChiTietKhuyenMai.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getMaChiTietKhuyenMai());
        lblMaKhuyenMai.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getMaCode());
        lblSoLuong.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getSoLuong());
        int conlai = conlai(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getSoLuong(),GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getSoLuongDaDung());
        lblConLai.setText(Integer.toString(conlai));
        lblDaDung.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getSoLuongDaDung());
        lblPhanTramKhuyenMai1.setText(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getPhanTramKhuyenMai()+" %");
        lblGiaTienKhuyenMai.setText(changeCurrency(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getGiaTienKhuyenMai()));
        lblGiaTriSuDungToiThieu.setText(changeCurrency(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getGiaTriToiThieuSuDung())+" đ");
        lblGiaTriGiamToiDa.setText(changeCurrency(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getGiaTriGiamToiDa())+" đ");
        lblThoiGianBatDau.setText(TimestampToDateString(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getThoiGianBatDauSuDung(),1));
        lblThoiGianKetThuc.setText(TimestampToDateString(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChiTietKhuyenMai.getThoiGianKetThucSuDung(),1));
        lblThoiGianTaoMa.setText(TimestampToDateString(GUI.KHUYENMAI.ChiTietKhuyenMaiJPanel.currentChuongTrinhKhuyenMai.getNgayTao(),1));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlThongTin = new GUI.Rounded();
        lblThongTinMaKhuyenMai = new javax.swing.JLabel();
        scpDonHang = new javax.swing.JScrollPane();
        tblDonHang = new javax.swing.JTable(){
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }

        };
        lblDonHang = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitleMaKhuyenMai = new javax.swing.JLabel();
        lblTitleDaDung = new javax.swing.JLabel();
        lblTitleNgayNhap = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();
        lblXem = new javax.swing.JLabel();
        lblTitleMaPhieuNhao = new javax.swing.JLabel();
        lblMaKhuyenMai = new javax.swing.JLabel();
        lblConLai = new javax.swing.JLabel();
        lblTitleSoLuong = new javax.swing.JLabel();
        lblDaDung = new javax.swing.JLabel();
        lblTitleConLai = new javax.swing.JLabel();
        lblGiaTienKhuyenMai = new javax.swing.JLabel();
        lblTitleMaChiTietKhuyenMai = new javax.swing.JLabel();
        lblMaChiTietKhuyenMai = new javax.swing.JLabel();
        lblTitlePhanTramKhuyenMai = new javax.swing.JLabel();
        lblTitleMaPhieuNhao3 = new javax.swing.JLabel();
        lblTitleMaPhieuNhao4 = new javax.swing.JLabel();
        lblTitleMaPhieuNhao5 = new javax.swing.JLabel();
        lblTitleMaPhieuNhao6 = new javax.swing.JLabel();
        lblThoiGianKetThuc = new javax.swing.JLabel();
        lblGiaTriSuDungToiThieu = new javax.swing.JLabel();
        lblGiaTriGiamToiDa = new javax.swing.JLabel();
        lblThoiGianTaoMa = new javax.swing.JLabel();
        lblTitleMaPhieuNhao7 = new javax.swing.JLabel();
        lblThoiGianBatDau = new javax.swing.JLabel();
        lblTitleMaChuongTrinhKhuyenMai = new javax.swing.JLabel();
        lblMaChuongTrinhKhuyenMai = new javax.swing.JLabel();
        lblPhanTramKhuyenMai1 = new javax.swing.JLabel();
        pnlQuayVe = new GUI.Rounded();
        lblQuayVe = new javax.swing.JLabel();

        setBackground(new java.awt.Color(45, 47, 62));

        pnlThongTin.setBackground(new java.awt.Color(45, 47, 62));
        pnlThongTin.setForeground(new java.awt.Color(53, 55, 70));
        pnlThongTin.setPreferredSize(new java.awt.Dimension(920, 750));

        lblThongTinMaKhuyenMai.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblThongTinMaKhuyenMai.setForeground(new java.awt.Color(210, 48, 44));
        lblThongTinMaKhuyenMai.setText("Thông tin chi tiết khuyến mãi");

        scpDonHang.setBackground(new java.awt.Color(53, 55, 70));
        scpDonHang.setForeground(new java.awt.Color(53, 55, 70));

        tblDonHang.setAutoCreateRowSorter(true);
        tblDonHang.setBackground(new java.awt.Color(53, 55, 70));
        tblDonHang.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tblDonHang.setForeground(new java.awt.Color(255, 255, 255));
        tblDonHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDonHang.setFocusable(false);
        tblDonHang.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblDonHang.setRowHeight(25);
        tblDonHang.setSelectionBackground(new java.awt.Color(72, 74, 89));
        tblDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonHangMouseClicked(evt);
            }
        });
        scpDonHang.setViewportView(tblDonHang);

        lblDonHang.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblDonHang.setForeground(new java.awt.Color(210, 48, 44));
        lblDonHang.setText("Đơn hàng sử dụng");

        jPanel1.setBackground(new java.awt.Color(53, 55, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitleMaKhuyenMai.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaKhuyenMai.setText("Mã khuyến mãi:");
        jPanel1.add(lblTitleMaKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lblTitleDaDung.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleDaDung.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleDaDung.setText("Đã dùng:");
        jPanel1.add(lblTitleDaDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        lblTitleNgayNhap.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleNgayNhap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleNgayNhap.setText("Sản phẩm được phép sử dụng:");
        jPanel1.add(lblTitleNgayNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        lblSoLuong.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setText("500");
        jPanel1.add(lblSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, 20));

        lblXem.setForeground(new java.awt.Color(192, 192, 192));
        lblXem.setText("Xem");
        lblXem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(192, 192, 192)));
        lblXem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblXemMouseClicked(evt);
            }
        });
        jPanel1.add(lblXem, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, 20));

        lblTitleMaPhieuNhao.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao.setText("Thời gian kết thúc:");
        jPanel1.add(lblTitleMaPhieuNhao, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 150, -1));

        lblMaKhuyenMai.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblMaKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblMaKhuyenMai.setText("MAGIAMGIA2020");
        jPanel1.add(lblMaKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        lblConLai.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblConLai.setForeground(new java.awt.Color(255, 255, 255));
        lblConLai.setText("0");
        jPanel1.add(lblConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        lblTitleSoLuong.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleSoLuong.setText("Số lượng:");
        jPanel1.add(lblTitleSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        lblDaDung.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblDaDung.setForeground(new java.awt.Color(255, 255, 255));
        lblDaDung.setText("500");
        jPanel1.add(lblDaDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 90, -1));

        lblTitleConLai.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleConLai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleConLai.setText("Còn lại:");
        jPanel1.add(lblTitleConLai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        lblGiaTienKhuyenMai.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblGiaTienKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblGiaTienKhuyenMai.setText("50.000đ");
        jPanel1.add(lblGiaTienKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, -1, 30));

        lblTitleMaChiTietKhuyenMai.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaChiTietKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaChiTietKhuyenMai.setText("Mã chi tiết khuyến mãi:");
        jPanel1.add(lblTitleMaChiTietKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 30));

        lblMaChiTietKhuyenMai.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblMaChiTietKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblMaChiTietKhuyenMai.setText("KM123");
        jPanel1.add(lblMaChiTietKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 30));

        lblTitlePhanTramKhuyenMai.setForeground(new java.awt.Color(192, 192, 192));
        lblTitlePhanTramKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitlePhanTramKhuyenMai.setText("Phần trăm khuyến mãi:");
        jPanel1.add(lblTitlePhanTramKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 150, -1));

        lblTitleMaPhieuNhao3.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao3.setText("Giá tiền khuyến mãi:");
        jPanel1.add(lblTitleMaPhieuNhao3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 150, 30));

        lblTitleMaPhieuNhao4.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao4.setText("Giá trị sử dụng tối thiểu:");
        jPanel1.add(lblTitleMaPhieuNhao4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 170, -1));

        lblTitleMaPhieuNhao5.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao5.setText("Giá trị giảm tối đa:");
        jPanel1.add(lblTitleMaPhieuNhao5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 150, 30));

        lblTitleMaPhieuNhao6.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao6.setText("Thời gian tạo mã:");
        jPanel1.add(lblTitleMaPhieuNhao6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 120, 20));

        lblThoiGianKetThuc.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblThoiGianKetThuc.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGianKetThuc.setText("01/05/2000");
        jPanel1.add(lblThoiGianKetThuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, -1, -1));

        lblGiaTriSuDungToiThieu.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblGiaTriSuDungToiThieu.setForeground(new java.awt.Color(255, 255, 255));
        lblGiaTriSuDungToiThieu.setText("300.000đ");
        jPanel1.add(lblGiaTriSuDungToiThieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, -1, -1));

        lblGiaTriGiamToiDa.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblGiaTriGiamToiDa.setForeground(new java.awt.Color(255, 255, 255));
        lblGiaTriGiamToiDa.setText("50.000đ");
        jPanel1.add(lblGiaTriGiamToiDa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, 30));

        lblThoiGianTaoMa.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblThoiGianTaoMa.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGianTaoMa.setText("01/05/2000");
        jPanel1.add(lblThoiGianTaoMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, -1, -1));

        lblTitleMaPhieuNhao7.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaPhieuNhao7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaPhieuNhao7.setText("Thời gian bắt đầu:");
        jPanel1.add(lblTitleMaPhieuNhao7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 150, 30));

        lblThoiGianBatDau.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblThoiGianBatDau.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGianBatDau.setText("01/05/2000");
        jPanel1.add(lblThoiGianBatDau, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, -1, -1));

        lblTitleMaChuongTrinhKhuyenMai.setForeground(new java.awt.Color(192, 192, 192));
        lblTitleMaChuongTrinhKhuyenMai.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitleMaChuongTrinhKhuyenMai.setText("Mã chương trình khuyến mãi:");
        jPanel1.add(lblTitleMaChuongTrinhKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 190, -1));

        lblMaChuongTrinhKhuyenMai.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblMaChuongTrinhKhuyenMai.setForeground(new java.awt.Color(255, 255, 255));
        lblMaChuongTrinhKhuyenMai.setText("CT123");
        jPanel1.add(lblMaChuongTrinhKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, -1, -1));

        lblPhanTramKhuyenMai1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPhanTramKhuyenMai1.setForeground(new java.awt.Color(255, 255, 255));
        lblPhanTramKhuyenMai1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhanTramKhuyenMai1.setText("15%");
        jPanel1.add(lblPhanTramKhuyenMai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        javax.swing.GroupLayout pnlThongTinLayout = new javax.swing.GroupLayout(pnlThongTin);
        pnlThongTin.setLayout(pnlThongTinLayout);
        pnlThongTinLayout.setHorizontalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scpDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThongTinMaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDonHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        pnlThongTinLayout.setVerticalGroup(
            pnlThongTinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblThongTinMaKhuyenMai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDonHang)
                .addGap(18, 18, 18)
                .addComponent(scpDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        pnlQuayVe.setBackground(new java.awt.Color(45, 47, 62));
        pnlQuayVe.setForeground(new java.awt.Color(210, 48, 44));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonHangMouseClicked
        int column = tblDonHang.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblDonHang.getRowHeight();

        if(row < tblDonHang.getRowCount() && row >= 0 && column < tblDonHang.getColumnCount() && column >= 0){
            if (SwingUtilities.isLeftMouseButton(evt)){
            this.removeAll();
            this.setLayout(new BorderLayout());
            currentDonHang = quanlycuahanggiay.quanlycuahanggiay.DonHangBUS.getByMaDonHang((String) tblDonHang.getModel().getValueAt(row, 0));
            currentKhachHang = quanlycuahanggiay.quanlycuahanggiay.KhachHangBUS.getByMaKhachHang(currentDonHang.getMaKhachHang());
            currentChiTietDonHang = quanlycuahanggiay.quanlycuahanggiay.ChiTietDonHangBUS.getByMaDonHang(currentDonHang.getMaDonHang());
            this.add(new ChiTietDonHangTrongChiTietKMJPanel());
            this.validate();
            this.repaint();
            }
        }
    }//GEN-LAST:event_tblDonHangMouseClicked

    private void lblXemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblXemMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)){
         new XemSanPhamKhuyenMaiTrongChiTietKMJFrame().setVisible(true);
        }
    }//GEN-LAST:event_lblXemMouseClicked

    private void pnlQuayVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlQuayVeMouseClicked
       if (SwingUtilities.isLeftMouseButton(evt)){ 
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(new ChiTietKhuyenMaiJPanel());
        this.validate();
        this.repaint();
       }        // TODO add your handling code here:
    }//GEN-LAST:event_pnlQuayVeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConLai;
    private javax.swing.JLabel lblDaDung;
    private javax.swing.JLabel lblDonHang;
    private javax.swing.JLabel lblGiaTienKhuyenMai;
    private javax.swing.JLabel lblGiaTriGiamToiDa;
    private javax.swing.JLabel lblGiaTriSuDungToiThieu;
    private javax.swing.JLabel lblMaChiTietKhuyenMai;
    private javax.swing.JLabel lblMaChuongTrinhKhuyenMai;
    private javax.swing.JLabel lblMaKhuyenMai;
    private javax.swing.JLabel lblPhanTramKhuyenMai1;
    private javax.swing.JLabel lblQuayVe;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblThoiGianBatDau;
    private javax.swing.JLabel lblThoiGianKetThuc;
    private javax.swing.JLabel lblThoiGianTaoMa;
    private javax.swing.JLabel lblThongTinMaKhuyenMai;
    private javax.swing.JLabel lblTitleConLai;
    private javax.swing.JLabel lblTitleDaDung;
    private javax.swing.JLabel lblTitleMaChiTietKhuyenMai;
    private javax.swing.JLabel lblTitleMaChuongTrinhKhuyenMai;
    private javax.swing.JLabel lblTitleMaKhuyenMai;
    private javax.swing.JLabel lblTitleMaPhieuNhao;
    private javax.swing.JLabel lblTitleMaPhieuNhao3;
    private javax.swing.JLabel lblTitleMaPhieuNhao4;
    private javax.swing.JLabel lblTitleMaPhieuNhao5;
    private javax.swing.JLabel lblTitleMaPhieuNhao6;
    private javax.swing.JLabel lblTitleMaPhieuNhao7;
    private javax.swing.JLabel lblTitleNgayNhap;
    private javax.swing.JLabel lblTitlePhanTramKhuyenMai;
    private javax.swing.JLabel lblTitleSoLuong;
    private javax.swing.JLabel lblXem;
    private GUI.Rounded pnlQuayVe;
    private GUI.Rounded pnlThongTin;
    private javax.swing.JScrollPane scpDonHang;
    private static javax.swing.JTable tblDonHang;
    // End of variables declaration//GEN-END:variables
}
