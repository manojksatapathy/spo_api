package com.ibm.spo.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class NDA   {
  
  private String id = null;
  private String idNda = null;
  private String assetOid = null;
  private String assetName = null;
  private String assetMrid = null;
  private String assetDs = null;
  private String assetType = null;
  private String assetTypeDs = null;
  private String status = null;
  private String substation = null;
  private String maintenanceArea = null;
  private String geographicalArea = null;
  private String nda_type = null;
  private String nda_type_ds = null;
  private javax.xml.datatype.XMLGregorianCalendar startDate = null;
  private javax.xml.datatype.XMLGregorianCalendar endDate = null;

  /**
   **/
  public NDA id(String id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  
  /**
   **/
  public NDA idNda(String idNda) {
    this.idNda = idNda;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getIdNda() {
    return idNda;
  }
  public void setIdNda(String idNda) {
    this.idNda = idNda;
  }

  /**
   **/
  public NDA assetOid(String assetOid) {
    this.assetOid = assetOid;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getAssetOid() {
    return assetOid;
  }
  public void setAssetOid(String assetOid) {
    this.assetOid = assetOid;
  }

  /**
   **/
  public NDA assetName(String assetName) {
    this.assetName = assetName;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", value = "")
  public String getAssetName() {
    return assetName;
  }
  public void setAssetName(String assetName) {
    this.assetName = assetName;
  }

  /**
   **/
  public NDA assetMrid(String assetMrid) {
    this.assetMrid = assetMrid;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", value = "")
  public String getAssetMrid() {
    return assetMrid;
  }
  public void setAssetMrid(String assetMrid) {
    this.assetMrid = assetMrid;
  }

  /**
   **/
  public NDA assetDs(String assetDs) {
    this.assetDs = assetDs;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", value = "")
  public String getAssetDs() {
    return assetDs;
  }
  public void setAssetDs(String assetDs) {
    this.assetDs = assetDs;
  }

  /**
   **/
  public NDA assetType(String assetType) {
    this.assetType = assetType;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", value = "")
  public String getAssetType() {
    return assetType;
  }
  public void setAssetType(String assetType) {
    this.assetType = assetType;
  }

  /**
   **/
  public NDA assetTypeDs(String assetTypeDs) {
    this.assetTypeDs = assetTypeDs;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", value = "")
  public String getAssetTypeDs() {
    return assetTypeDs;
  }
  public void setAssetTypeDs(String assetTypeDs) {
    this.assetTypeDs = assetTypeDs;
  }

  /**
   **/
  public NDA status(String status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  
  /**
   **/
  public NDA substation(String substation) {
    this.substation = substation;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getSubstation() {
    return substation;
  }
  public void setSubstation(String substation) {
    this.substation = substation;
  }
  
  /**
   **/
  public NDA maintenanceArea(String maintenanceArea) {
    this.maintenanceArea = maintenanceArea;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getMaintenanceArea() {
    return maintenanceArea;
  }
  public void setMaintenanceArea(String maintenanceArea) {
    this.maintenanceArea = maintenanceArea;
  }
  
  /**
   **/
  public NDA geographicalArea(String geographicalArea) {
    this.geographicalArea = geographicalArea;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getGeographicalArea() {
    return geographicalArea;
  }
  public void setGeographicalArea(String geographicalArea) {
    this.geographicalArea = geographicalArea;
  }
  
  /**
   **/
  public NDA nda_type(String nda_type) {
    this.nda_type = nda_type;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getNda_type() {
    return nda_type;
  }
  public void setNda_type(String nda_type) {
    this.nda_type = nda_type;
  }
  
  /**
   **/
  public NDA nda_type_ds(String nda_type_ds) {
    this.nda_type_ds = nda_type_ds;
    return this;
  }

  
  @ApiModelProperty(example = "AC", value = "")
  public String getNda_type_ds() {
    return nda_type_ds;
  }
  public void setNda_type_ds(String nda_type_ds) {
    this.nda_type_ds = nda_type_ds;
  }

  /**
   **/
  public NDA startDate(javax.xml.datatype.XMLGregorianCalendar startDate) {
    this.startDate = startDate;
    return this;
  }

  
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getStartDate() {
    return startDate;
  }
  public void setStartDate(javax.xml.datatype.XMLGregorianCalendar startDate) {
    this.startDate = startDate;
  }

  /**
   **/
  public NDA endDate(javax.xml.datatype.XMLGregorianCalendar endDate) {
    this.endDate = endDate;
    return this;
  }

  
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getEndDate() {
    return endDate;
  }
  public void setEndDate(javax.xml.datatype.XMLGregorianCalendar endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NDA NDA = (NDA) o;
    return Objects.equals(id, NDA.id) &&
    	Objects.equals(idNda, NDA.idNda) &&
        Objects.equals(assetOid, NDA.assetOid) &&
        Objects.equals(assetName, NDA.assetName) &&
        Objects.equals(assetMrid, NDA.assetMrid) &&
        Objects.equals(assetDs, NDA.assetDs) &&
        Objects.equals(assetType, NDA.assetType) &&
        Objects.equals(assetTypeDs, NDA.assetTypeDs) &&
        Objects.equals(status, NDA.status) &&
        Objects.equals(substation, NDA.substation) &&
        Objects.equals(maintenanceArea, NDA.maintenanceArea) &&
        Objects.equals(geographicalArea, NDA.geographicalArea) &&
        Objects.equals(nda_type, NDA.nda_type) &&
        Objects.equals(nda_type_ds, NDA.nda_type_ds) &&
        Objects.equals(startDate, NDA.startDate) &&
        Objects.equals(endDate, NDA.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idNda, assetOid, assetName, assetMrid, assetDs, assetType, assetTypeDs, status, substation, maintenanceArea, geographicalArea, nda_type, nda_type_ds, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NDA {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idNda: ").append(toIndentedString(idNda)).append("\n");
    sb.append("    assetOid: ").append(toIndentedString(assetOid)).append("\n");
    sb.append("    assetName: ").append(toIndentedString(assetName)).append("\n");
    sb.append("    assetMrid: ").append(toIndentedString(assetMrid)).append("\n");
    sb.append("    assetDs: ").append(toIndentedString(assetDs)).append("\n");
    sb.append("    assetType: ").append(toIndentedString(assetType)).append("\n");
    sb.append("    assetTypeDs: ").append(toIndentedString(assetTypeDs)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    substation: ").append(toIndentedString(substation)).append("\n");
    sb.append("    maintenanceArea: ").append(toIndentedString(maintenanceArea)).append("\n");
    sb.append("    geographicalArea: ").append(toIndentedString(geographicalArea)).append("\n");
    sb.append("    nda_type: ").append(toIndentedString(nda_type)).append("\n");
    sb.append("    nda_type_ds: ").append(toIndentedString(nda_type_ds)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
