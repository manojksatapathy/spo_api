package com.ibm.spo.model;

import com.ibm.spo.model.Category;
import com.ibm.spo.model.Tag;
import com.ibm.spo.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class Scenario   {
  
  private String id = null;
  private User author = null;
  private Category category = null;
  private String name = null;
  private javax.xml.datatype.XMLGregorianCalendar createdDate = null;
  private javax.xml.datatype.XMLGregorianCalendar lastModified = null;
  private javax.xml.datatype.XMLGregorianCalendar temporalHorizon = null;
  private List<Tag> tags = new ArrayList<Tag>();

public enum StatusEnum {

    AVAILABLE(String.valueOf("available")), READY(String.valueOf("ready"));


    private String value;

    StatusEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static StatusEnum fromValue(String v) {
        for (StatusEnum b : StatusEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  private StatusEnum status = null;

  /**
   **/
  public Scenario id(String id) {
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
  public Scenario author(User author) {
    this.author = author;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public User getAuthor() {
    return author;
  }
  public void setAuthor(User author) {
    this.author = author;
  }

  /**
   **/
  public Scenario category(Category category) {
    this.category = category;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Category getCategory() {
    return category;
  }
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   **/
  public Scenario name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(example = "doggie", required = true, value = "")
  @NotNull
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public Scenario createdDate(javax.xml.datatype.XMLGregorianCalendar createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(javax.xml.datatype.XMLGregorianCalendar createdDate) {
    this.createdDate = createdDate;
  }

  /**
   **/
  public Scenario lastModified(javax.xml.datatype.XMLGregorianCalendar lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getLastModified() {
    return lastModified;
  }
  public void setLastModified(javax.xml.datatype.XMLGregorianCalendar lastModified) {
    this.lastModified = lastModified;
  }

  /**
   **/
  public Scenario temporalHorizon(javax.xml.datatype.XMLGregorianCalendar temporalHorizon) {
    this.temporalHorizon = temporalHorizon;
    return this;
  }

  
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")
  public javax.xml.datatype.XMLGregorianCalendar getTemporalHorizon() {
    return temporalHorizon;
  }
  public void setTemporalHorizon(javax.xml.datatype.XMLGregorianCalendar temporalHorizon) {
    this.temporalHorizon = temporalHorizon;
  }

  /**
   **/
  public Scenario tags(List<Tag> tags) {
    this.tags = tags;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public List<Tag> getTags() {
    return tags;
  }
  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  /**
   * scenario status in the store
   **/
  public Scenario status(StatusEnum status) {
    this.status = status;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "scenario status in the store")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Scenario scenario = (Scenario) o;
    return Objects.equals(id, scenario.id) &&
        Objects.equals(author, scenario.author) &&
        Objects.equals(category, scenario.category) &&
        Objects.equals(name, scenario.name) &&
        Objects.equals(createdDate, scenario.createdDate) &&
        Objects.equals(lastModified, scenario.lastModified) &&
        Objects.equals(temporalHorizon, scenario.temporalHorizon) &&
        Objects.equals(tags, scenario.tags) &&
        Objects.equals(status, scenario.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, category, name, createdDate, lastModified, temporalHorizon, tags, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scenario {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
    sb.append("    lastModified: ").append(toIndentedString(lastModified)).append("\n");
    sb.append("    temporalHorizon: ").append(toIndentedString(temporalHorizon)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
