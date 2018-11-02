/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bikerental;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

/**
 *
 * @author anupongpummok
 */
public class ServiceRent {
    Bike bike;
    Customer cus;
    FindIterable<Bike> listBike;
    BikeDao bikeDao;
    CustomerDao cusDao;
    InvoiceDao invDao;
    
    public ServiceRent() {
        cusDao = new CustomerDao();
        bikeDao = new BikeDao();
        invDao = new InvoiceDao();
    }
    
    
    public boolean isCitizenIdValid(Customer cus) {
        if (cus.getCusCitizenId().length()!=13){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cus.getCusCitizenId().charAt(i))*(13-i);
        }
        return (11-sum%11)%10 == Character.getNumericValue(cus.getCusCitizenId().charAt(12));
    }
    
    public boolean isBikeAvailable(Bike bike) {
        if (bike.getBikeStatus().equals("ว่าง")) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isTelFieldFill(String telField) {
        if (telField.length() == 10) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFill(String field) {
        if (field.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void isFieldAllFill() {
        
    }

    public void Rent(String bikeId, String bikeStatus,
            Customer customer,Invoice invoice) {
        
        bikeDao.switchStatusById(bikeId, bikeStatus);
        
        if (cusDao.getCusById(customer.getCusCitizenId()) == null) {
                cusDao.addCustomer(customer);
        }
        
        invDao.insertVoice(invoice);
    }
    
    public Bike findBikeById(String bikeId) {
        return bikeDao.getBikeById(bikeId);
    }
    
    public MongoCursor<Bike> getAllBikeItr() {
        return bikeDao.getAllBike().iterator();
    }
        
}
