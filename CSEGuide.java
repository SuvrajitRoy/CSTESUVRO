package com.cste.nstu06.suvro.database;

/**
 * Created by mosharrofrubel on 11/27/15.
 */
public class CSEGuide {

    //private variables
    int _id;
    String _topic;
    String _detals;

    // Empty constructor
    public CSEGuide(){

    }
    // constructor
    public CSEGuide(int id, String topic, String details){
        this._id = id;
        this._topic = topic;
        this._detals = details;
    }

    // constructor
    public CSEGuide(String topic, String details){
        this._topic = topic;
        this._detals = details;
    }
    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting topic
    public String getTopic(){
        return this._topic;
    }

    // setting topic
    public void setTopic(String name){
        this._topic = name;
    }

    // getting details
    public String getDetails(){
        return this._detals;
    }

    // setting details
    public void setDetails(String details){
        this._detals = details;
    }

}
