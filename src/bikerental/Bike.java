/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerental;

/**
 *
 * @author anupongpummok
 */
public class Bike {
    String bikeId;
    String bikeStatus;

    public Bike(String bikeId, String bikeStatus) {
        this.bikeId = bikeId;
        this.bikeStatus = bikeStatus;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String id) {
        this.bikeId = id;
    }

    public String getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(String status) {
        this.bikeStatus = status;
    }
    
}
