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
public class kullaniciBean {

     public String kayitekle(){
     return "kayitekle?faces-redirect=true";
     }
      public String kayitsil(){
     return "kayitsil?faces-redirect=true";
     }
       public String kayitguncelle(){
     return "kayitguncelle?faces-redirect=true";
     }
        public String kayitgetir(){
     return "kayitgetir?faces-redirect=true";
     }
         public String onay(){
     return "onay";
     }
      public String index(){
     return "index?faces-redirect=true";
     }
      
    public kullaniciBean() {
        
    }

     
     String ad,soyad,email,adres;
     int tel,id;

   
    
   

    
  

     public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    public String veritabaniekle(){
        String kisiekle="INSERT INTO public.kullanici(\n" +
"	ad, email, soyad, tel, adres)\n" +
"	VALUES (?, ?,?, ?, ?);";    
        Connection con = null;
        PreparedStatement preparedstatement=null;
        int i=0;
		      try {
                          Class.forName("org.postgresql.Driver");
                          con=DriverManager.getConnection(
					"jdbc:postgresql://localhost/adresdefter",
					"postgres",
					"123fb654");
                          preparedstatement=con.prepareStatement(kisiekle);
                          preparedstatement.setString(1, ad);                          
                          preparedstatement.setString(2, email);
                          preparedstatement.setString(3, soyad);                          
                          preparedstatement.setInt(4, tel);
                          preparedstatement.setString(5, adres); 
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
                      if(i>0)
                          return "onay?faces-redirect=true";
                      else
                          return "index?faces-redirect=true";
                      
    }
    
    
}
