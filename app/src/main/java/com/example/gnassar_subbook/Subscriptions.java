package com.example.gnassar_subbook;

/**
 * Created by firew on 2018-01-31.
 */

/**
 * This class represents a subscription
 *
 * @author George Nassar
 *
 * @version 1
 *
 */

public class Subscriptions{
    protected String subName;
    protected String subDate;
    protected float subCost;
    protected String subComment;

    @Override
    /**
     * Function to consolidate variables into string
     */
    public String toString() {
        return "Subscriptions{" +
                "subName='" + subName + '\'' +
                ", subDate='" + subDate + '\'' +
                ", subCost=" + subCost + '}';
    }

    /**
     * Function that creates a subscription object
     * @param subName is the subscription name
     * @param subDate is the subscription date
     * @param subCost is the subscription cost
     * @param subComment is the subscription comment
     */
    public Subscriptions(String subName, String subDate, float subCost, String subComment){
        this.subName = subName;
        this.subDate = subDate;
        this.subCost = subCost;
        this.subComment = subComment;
    }

    /**
     * Subscription name getter
     * @return subscription name
     */
    public String getSubName(){
        return this.subName;
    }

    /**
     * Subscription date getter
     * @return subscription date
     */
    public String getSubDate(){
        return this.subDate;
    }

    /**
     * Subscription cost getter
     * @return subscription cost
     */
    public float getSubCost(){
        return this.subCost;
    }

    /**
     * Subscription comment getter
     * @return subscription comment
     */
    public String getSubComment(){
        return this.subComment;
    }

    /**
     * Subscription name setter
     * @param subName is the subscription name
     */
    public void setSubName(String subName){
        this.subName = subName;
    }

    /**
     * Subscription date setter
     * @param subDate is the subscription date
     */
    public void setSubDate(String subDate){
        this.subDate = subDate;
    }

    /**
     * Subscription cost setter
     * @param subCost is the subscription cost
     */
    public void setSubCost(float subCost){
        this.subCost = subCost;
    }

    /**
     * Subscription comment setter
     * @param subComment is the subscription comment
     */
    public void setSubComment(String subComment){
        this.subComment = subComment;
    }


}
