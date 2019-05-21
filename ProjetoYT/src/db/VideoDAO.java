/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import classes.Video;
import conn.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wagner Carestini
 */
public class VideoDAO {
        
    public static List<Video> selectAll(){
        String sql = "SELECT id, titulo,  views, curtidas FROM youtube.video";
        List<Video> listVideo = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                listVideo.add(new Video(rs.getInt("id"), rs.getString("titulo"),
                        rs.getInt("views"),rs.getInt("curtidas")));
            }
            return listVideo;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Video> searchByName(){
        String sql = "SELECT id, titulo,  views, curtidas FROM youtube.video";
        List<Video> listVideo = new ArrayList<>();
        try(Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                listVideo.add(new Video(rs.getString("titulo")));
            }
            return listVideo;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    public static void update(String titulo){
        String sql = "INSERT INTO `youtube`.`video` (`titulo`, `avaliacao`, `views`, `curtidas`) VALUES ( ? , '0' , '0' , '0')";
        if(titulo == ""){
            JOptionPane.showMessageDialog(null, "Certifique que preencheu os campos obrigatorios", "ERROR UPLOAD", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, titulo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Pronto, video upado com sucesso");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }   
        public static String searchByTitulo(String titulo) {
        String sql = "SELECT id, titulo, views, curtidas FROM youtube.video where titulo like ?";
            String videoListInformation = "";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                videoListInformation = "ID = "+rs.getInt("id")+" | "+" TITULO = "+rs.getString("titulo")+" | "+" VIEWS = "+rs.getInt("views")+
                        " | "+" CURTIDAS = "+rs.getInt("curtidas");
            }
            ConnectionFactory.close(conn, ps, rs);
            return videoListInformation;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
        
    public static void like(String titulo){
        String sql = "SELECT curtidas FROM youtube.video WHERE titulo like ?";
        int lk = 0;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lk = rs.getInt("curtidas");
                System.out.println(lk);
            }
            ConnectionFactory.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlUpdate = "UPDATE `youtube`.`video` SET `curtidas`= ? WHERE `titulo`= ? ";
        try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlUpdate)){
            lk +=1;
            ps.setInt(1, lk);
            ps.setString(2, titulo);
            ps.executeUpdate();
        }catch(SQLException e){
             e.printStackTrace();
        }
    }
    
    public static void view(String titulo){
        String sql = "SELECT views FROM youtube.video WHERE titulo like ?";
        int view = 0;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, titulo );
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                view = rs.getInt("views");
                System.out.println(view);
            }
            ConnectionFactory.close(conn, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlUpdate = "UPDATE `youtube`.`video` SET `views`= ? WHERE `titulo`= ? ";
        try(Connection conn = ConnectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlUpdate)){
            view +=1;
            ps.setInt(1, view);
            ps.setString(2, titulo);
            ps.executeUpdate();
        }catch(SQLException e){
             e.printStackTrace();
        }
    }
          
}
