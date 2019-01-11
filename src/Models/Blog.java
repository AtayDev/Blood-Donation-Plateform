package Models;

import java.io.Serializable;
import java.sql.Date;

public class Blog implements Serializable {

    private int idBlog;
    private String titreBlog;
    private String contenueBlog;
    private String pathImgBlog;
    private Date dateBlog;
    private int idDonateur;

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getTitreBlog() {
        return titreBlog;
    }

    public void setTitreBlog(String titreBlog) {
        this.titreBlog = titreBlog;
    }

    public String getContenueBlog() {
        return contenueBlog;
    }

    public void setContenueBlog(String contenueBlog) {
        this.contenueBlog = contenueBlog;
    }

    public String getPathImgBlog() {
        return pathImgBlog;
    }

    public void setPathImgBlog(String pathImgBlog) {
        this.pathImgBlog = pathImgBlog;
    }

    public Date getDateBlog() {
        return dateBlog;
    }

    public void setDateBlog(Date dateBlog) {
        this.dateBlog = dateBlog;
    }

    public int getIdDonateur() {
        return idDonateur;
    }

    public void setIdDonateur(int idDonateur) {
        this.idDonateur = idDonateur;
    }
}