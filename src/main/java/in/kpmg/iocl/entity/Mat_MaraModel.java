package in.kpmg.iocl.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="yv_material_master_all_views_e_mara",schema = "pricing_tool")
public class Mat_MaraModel
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String bism;
    private String brgew;
    private String ersda;
    private String ferth;
    private String groes;
    private String laeda;
    private String maktx;
    private String matnr;
    private String meins;
    private String normt;
    private String ntgew;
    private String tragr;
    private String wrkst;
    private String createddate;
    private String is_active;
    private String modifieddate;


    public String getBism() {
        return bism;
    }

    public void setBism(String bism) {
        this.bism = bism;
    }

    public String getBrgew() {
        return brgew;
    }

    public void setBrgew(String brgew) {
        this.brgew = brgew;
    }

    public String getErsda() {
        return ersda;
    }

    public void setErsda(String ersda) {
        this.ersda = ersda;
    }

    public String getFerth() {
        return ferth;
    }

    public void setFerth(String ferth) {
        this.ferth = ferth;
    }

    public String getGroes() {
        return groes;
    }

    public void setGroes(String groes) {
        this.groes = groes;
    }

    public String getLaeda() {
        return laeda;
    }

    public void setLaeda(String laeda) {
        this.laeda = laeda;
    }

    public String getMaktx() {
        return maktx;
    }

    public void setMaktx(String maktx) {
        this.maktx = maktx;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getNormt() {
        return normt;
    }

    public void setNormt(String normt) {
        this.normt = normt;
    }

    public String getNtgew() {
        return ntgew;
    }

    public void setNtgew(String ntgew) {
        this.ntgew = ntgew;
    }

    public String getTragr() {
        return tragr;
    }

    public void setTragr(String tragr) {
        this.tragr = tragr;
    }

    public String getWrkst() {
        return wrkst;
    }

    public void setWrkst(String wrkst) {
        this.wrkst = wrkst;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(String modifieddate) {
        this.modifieddate = modifieddate;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

}
