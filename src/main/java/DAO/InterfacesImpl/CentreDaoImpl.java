package DAO.InterfacesImpl;

import DAO.DAOFactory;
import DAO.Interfaces.CentreDao;
import Models.Centre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentreDaoImpl implements CentreDao {
    private DAOFactory daoFactory;

    public CentreDaoImpl(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Centre getCentre(int idCentre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Centre centre=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from centre WHERE id_centre=?");
            preparedStatement.setInt(1,idCentre);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                centre=new Centre();
                centre.setIdCentre(rs.getInt("id_centre"));
                centre.setNameCentre(rs.getString("nom_centre"));
                centre.setEmailCentre(rs.getString("email_centre"));
                centre.setPasswordCentre(rs.getString("password_centre"));
                centre.setAdresseCentre(rs.getString("addresse_centre"));
                centre.setTeleCentre(rs.getString("tele_centre"));
                centre.setIdAdmin(rs.getInt("id_admin"));
                centre.setIdVille(rs.getInt("id_ville"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return centre;
    }

    @Override
    public Centre getCentre(String email, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Centre centre = null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from centre WHERE email_centre=? AND password_centre  = ?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                centre=new Centre();
                centre.setIdCentre(rs.getInt("id_centre"));
                centre.setNameCentre(rs.getString("nom_centre"));
                centre.setEmailCentre(rs.getString("email_centre"));
                centre.setPasswordCentre(rs.getString("password_centre"));
                centre.setAdresseCentre(rs.getString("addresse_centre"));
                centre.setTeleCentre(rs.getString("tele_centre"));
                centre.setIdAdmin(rs.getInt("id_admin"));
                centre.setIdVille(rs.getInt("id_ville"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return centre;
    }

    @Override
    public boolean insertCentre(Centre centre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("insert into centre(nom_centre,email_centre,password_centre,addresse_centre,id_admin,id_ville,tele_centre) values (?,?,?,?,?,?,?)");
//            preparedStatement.setInt(1,centre.getIdCentre());
            preparedStatement.setString(1,centre.getNameCentre());
            preparedStatement.setString(2,centre.getEmailCentre());
            preparedStatement.setString(3,centre.getPasswordCentre());
            preparedStatement.setString(4,centre.getAdresseCentre());
            preparedStatement.setInt(5,centre.getIdAdmin());
            preparedStatement.setInt(6,centre.getIdVille());
            preparedStatement.setString(7,centre.getTeleCentre());
            preparedStatement.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCentre(Centre centre) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("update centre set nom_centre=? , email_centre=?, password_centre=?, addresse_centre=?, id_admin=?, id_ville=?, tele_centre=? where id_centre=?");
            preparedStatement.setString(1,centre.getNameCentre());
            preparedStatement.setString(2,centre.getEmailCentre());
            preparedStatement.setString(3,centre.getPasswordCentre());
            preparedStatement.setString(4,centre.getAdresseCentre());
            preparedStatement.setInt(5,centre.getIdAdmin());
            preparedStatement.setInt(6,centre.getIdVille());
            preparedStatement.setString(7,centre.getTeleCentre());
            preparedStatement.setInt(8,centre.getIdCentre());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteCentreByEmail(String email) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from centre WHERE email_centre=?");
//            preparedStatement.setInt(1,idCentre);
            preparedStatement.setString(1,email);
            preparedStatement.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean searchCentreByEmail(String email) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Centre centre = null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from centre WHERE email_centre=?");
            preparedStatement.setString(1,email);
            ResultSet rs=preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCentre(int idCentre){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("delete from centre WHERE id_centre=?");
            preparedStatement.setInt(1,idCentre);
            preparedStatement.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Centre> getAllCentre() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        List<Centre> centres=null;
        try{
            connection=daoFactory.getConnection();
            preparedStatement=connection.prepareStatement("SELECT * from centre");
            ResultSet rs=preparedStatement.executeQuery();
            centres=new ArrayList<>();
            while (rs.next()){
                Centre centre=new Centre();
                centre.setIdCentre(rs.getInt("id_centre"));
                centre.setNameCentre(rs.getString("nom_centre"));
                centre.setEmailCentre(rs.getString("email_centre"));
                centre.setPasswordCentre(rs.getString("password_centre"));
                centre.setAdresseCentre(rs.getString("addresse_centre"));
                centre.setTeleCentre(rs.getString("tele_centre"));
                centre.setIdAdmin(rs.getInt("id_admin"));
                centre.setIdVille(rs.getInt("id_ville"));
                centres.add(centre);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return centres;
    }
}
