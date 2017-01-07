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
public class Kayitguncelle {

    /**
     * Creates a new instance of Kayitguncelle
     */
    String guncellemesaj;

    public String getGuncellemesaj() {
        return guncellemesaj;
    }

    public void setGuncellemesaj(String guncellemesaj) {
        this.guncellemesaj = guncellemesaj;
    }
    
    public void kaydiguncelle(kullaniciBean kisiler){
    
                    String kisiguncelle="UPDATE public.kullanici SET ad=?, email=?, soyad=?, tel=?, adres=? WHERE id=?;";
                    
                    Connection con = null;
                    PreparedStatement preparedstatement=null;
                    int i=0;
		      try {
                          
                          Class.forName("org.postgresql.Driver");
                          con=DriverManager.getConnection(
					"jdbc:postgresql://localhost/adresdefter",
					"postgres",
					"123fb654");
                          
                          preparedstatement=con.prepareStatement(kisiguncelle);
                          preparedstatement.setString(1, kisiler.getAd());                          
                          preparedstatement.setString(2, kisiler.getEmail());
                          preparedstatement.setString(3, kisiler.getSoyad());                          
                          preparedstatement.setInt(4, kisiler.getTel());
                          preparedstatement.setString(5, kisiler.getAdres()); 
                          preparedstatement.setInt(6, kisiler.getID());
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
                          guncellemesaj="Guncelleme işlemi tamamlandı";
                      }else{
                          guncellemesaj="Guncelleme yapılamadı";
                      }
                      System.out.println(guncellemesaj);
    
    
    
    }
    
    
    public Kayitguncelle() {
  
}
    
}
