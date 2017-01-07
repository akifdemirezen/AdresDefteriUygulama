/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author akif
 */
@ManagedBean
@RequestScoped
public class Kayitsil {

    public void kayitsil(kullaniciBean kisiler){
        String silmemesaji="";
        String kisisil="delete from kullanici Where id=?";
        Connection con = null;
        PreparedStatement preparedstatement=null;
        int i=0;
		      try {
                          Class.forName("org.postgresql.Driver");
                          con=DriverManager.getConnection(
					"jdbc:postgresql://localhost/adresdefter",
					"postgres",
					"123fb654");
                          preparedstatement=con.prepareStatement(kisisil);
                          preparedstatement.setInt(1, kisiler.getID());                          
                          
                          i=preparedstatement.executeUpdate();
                          
            
        } catch (Exception e) {
                          System.out.println(e);
        }finally{
                          try {
                              con.close();
                              preparedstatement.close();
                          } catch (Exception e) {
                              System.out.println(e);
                          }
                      }
                      if(i>0){
                          silmemesaji="Silme işlemi başarıyla tamamlandı";
                      }else{
                          silmemesaji="Silme işlemi gerçekleşmedi anasayfaya dönün";}
                      System.out.println(silmemesaji);
    }

    
    
    public Kayitsil() {
        
    }
    
}
