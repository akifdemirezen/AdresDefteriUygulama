/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author akif
 */
@ManagedBean
@RequestScoped
public class Kullanicilaricek  {
    List<kullaniciBean> sorgusonucu; 

    public List<kullaniciBean> getSorgusonucu() {
        return sorgusonucu;
    }

    public void setSorgusonucu(List<kullaniciBean> sorgusonucu) {
        this.sorgusonucu = sorgusonucu;
    }
    
    public List<kullaniciBean> getkayitlar(){
        String kisilerigetir="Select*From kullanici";
        Connection con = null;
        PreparedStatement preparedstatement=null;
        ResultSet resultset=null;
        sorgusonucu = new ArrayList<>();
		      try {
                          Class.forName("org.postgresql.Driver");
                          con=DriverManager.getConnection(
					"jdbc:postgresql://localhost/adresdefter",
					"postgres",
					"123fb654");
                          preparedstatement=con.prepareStatement(kisilerigetir);
                          resultset=preparedstatement.executeQuery();
                          while(resultset.next()){
                              kullaniciBean kisiler=new kullaniciBean();
                              kisiler.setID(resultset.getInt("id"));
                              kisiler.setAd(resultset.getString("ad"));
                              kisiler.setSoyad(resultset.getString("soyad"));
                              kisiler.setEmail(resultset.getString("email"));
                              kisiler.setTel(resultset.getInt("tel"));
                              kisiler.setAdres(resultset.getString("adres"));
                              sorgusonucu.add(kisiler);
                              
                          }
            
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
    
    return sorgusonucu;
    }
    
    
    public Kullanicilaricek() {
       
        
    }
    
}
