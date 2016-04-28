package com.kulart05gmail.lesson_1.HomeWorks.Homework_10.Homework_10_4.rest.models;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Address
{
  @SerializedName("Address")
  private String address;
  private String objectId;
  private Date updated;
  private Date created;
  private String ownerId;


  public String getObjectId()
  {
    return objectId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getOwnerId()
  {
    return ownerId;
  }



  public void setAddress( String address )
  {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public Date getCreated()
  {
    return created;
  }

                                                    

}