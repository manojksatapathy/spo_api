package com.ibm.spo.model;

import javax.validation.constraints.*;


import io.swagger.annotations.*;
import java.util.Objects;


public class User   {
  
  private Long id = null;
  private String username = null;
  private String firstName = null;
  private String lastName = null;
  private String email = null;
  private Integer userStatus = null;

  /**
   **/
  public User id(Long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  /**
   **/
  public User username(String username) {
    this.username = username;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   **/
  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   **/
  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   **/
  public User email(String email) {
    this.email = email;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * User Status
   **/
  public User userStatus(Integer userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  
  @ApiModelProperty(example = "null", value = "User Status")
  public Integer getUserStatus() {
    return userStatus;
  }
  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) &&
        Objects.equals(username, user.username) &&
        Objects.equals(firstName, user.firstName) &&
        Objects.equals(lastName, user.lastName) &&
        Objects.equals(email, user.email) &&
        Objects.equals(userStatus, user.userStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, firstName, lastName, email, userStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    userStatus: ").append(toIndentedString(userStatus)).append("\n");
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
