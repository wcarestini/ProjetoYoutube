/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import conn.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Wagner Carestini
 */
public class GafanhotoDAO {

    public static boolean checkLogin(String loginPass) {
        boolean verify = false;
        if (loginPass.equals("") || loginPass.equals("")) {
            return verify = false;
        } else {
            String sql = "SELECT login FROM youtube.espectador where login=?";
            try (Connection con = ConnectionFactory.getConnection();
                    PreparedStatement ps = con.prepareStatement(sql)){
                ps.setString(1,loginPass);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String login = rs.getString("login");
                    if (loginPass.equals(login)) {
                        return verify = true;
                    } else {
                        return verify = false;
                    }
                }
                ConnectionFactory.close(con,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace(); 
                JOptionPane.showMessageDialog(null, "Erro na conexão, com o banco de dados!", "ERROR CONNECTION DB", JOptionPane.WARNING_MESSAGE);
            } 
        }
        return verify;
    }
    
    public static void cadastrar(String nome, int idade, String sexo, String login){
        if(nome == null || sexo == null || login == null){
            JOptionPane.showMessageDialog(null, "Dados incompletos, verifique se preenqcheu todos os dados e tente novamente","ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sql = "INSERT INTO `youtube`.`espectador` (`nome`, `idade`, `sexo`, `login`) VALUES ( ? , ? , ? , ?)";
        try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,nome);
            ps.setInt(2,idade);
            ps.setString(3,sexo);
            ps.setString(4,login);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Pronto, cadastro criado com sucesso");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String searchByLogin(String login) {
        String sql = "SELECT nome FROM youtube.espectador where login=`?`";
            String name = "";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, login );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("nome");
            }
            ConnectionFactory.close(conn, ps, rs);
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
}
