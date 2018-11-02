/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerental;

import org.bson.types.ObjectId;

/**
 *
 * @author anupongpummok
 */
public final class Customer {
    private ObjectId cusCitizenId;
    private String cusTel;
    private String cusFName;
    private String cusLName;

    public ObjectId getCusCitizenId() {
        return cusCitizenId;
    }

    public void setCusCitizenId(final ObjectId cusCitizenId) {
        this.cusCitizenId = cusCitizenId;
    }

    public String getCusTel() {
        return cusTel;
    }

    public void setCusTel(final String cusTel) {
        this.cusTel = cusTel;
    }

    public String getCusFName() {
        return cusFName;
    }

    public void setCusFName(final String cusFName) {
        this.cusFName = cusFName;
    }

    public String getCusLName() {
        return cusLName;
    }

    public void setCusLName(final String cusLName) {
        this.cusLName = cusLName;
    }
    
    
}
