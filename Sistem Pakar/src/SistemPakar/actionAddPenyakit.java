try {
    String sql = "INSERT INTO penyakit VALUES ('"+txt_kode.getText()+"','"+txt_nama.getText()+"','"+txt_deskripsi.getText()+"','"+txt_solusi.getText()+"')";
    java.sql.Connection conn=(Connection)config.configDB();
    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
    pst.execute();
    JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e.getMessage());
}