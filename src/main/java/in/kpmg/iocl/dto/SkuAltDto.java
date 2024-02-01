package in.kpmg.iocl.dto;

import in.kpmg.iocl.skuapi.SkuAltConversion;

public class SkuAltDto extends SkuAltConversion {

    private String materialNo;
    private String baseUnitOfMeasure;
    private String unitOfMeasureDisplay;
    private String numeratorConversion;
    private String denominatorConversion;
    private String materialDescription;

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getBaseUnitOfMeasure() {
        return baseUnitOfMeasure;
    }

    public void setBaseUnitOfMeasure(String baseUnitOfMeasure) {
        this.baseUnitOfMeasure = baseUnitOfMeasure;
    }

    public String getUnitOfMeasureDisplay() {
        return unitOfMeasureDisplay;
    }

    public void setUnitOfMeasureDisplay(String unitOfMeasureDisplay) {
        this.unitOfMeasureDisplay = unitOfMeasureDisplay;
    }

    public String getNumeratorConversion() {
        return numeratorConversion;
    }

    public void setNumeratorConversion(String numeratorConversion) {
        this.numeratorConversion = numeratorConversion;
    }

    public String getDenominatorConversion() {
        return denominatorConversion;
    }

    public void setDenominatorConversion(String denominatorConversion) {
        this.denominatorConversion = denominatorConversion;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public SkuAltDto(String materialNo, String baseUnitOfMeasure, String unitOfMeasureDisplay, String Seprtr,String numeratorConversion, String denominatorConversion, String materialDescription )
    {
        this.materialNo= materialNo;
        this.baseUnitOfMeasure=baseUnitOfMeasure;
        this.unitOfMeasureDisplay=unitOfMeasureDisplay;
       // this.seprtr=seprtr;
        this.numeratorConversion=numeratorConversion;
        this.denominatorConversion=denominatorConversion;
        this.materialDescription=materialDescription;
    }

    public SkuAltDto() {
    }
}
