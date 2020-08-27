package com.learnplanbuilder.app.model;
/**
 * Created by Sunil gowroji
 */

import android.view.View;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Item {

    private String price;
    private String pledgePrice;
    private String fromAddress;
    private String toAddress;
    private int requestsCount;
    private String date;
    private String time;

    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    public Item(String price, String pledgePrice, String fromAddress, String toAddress, int requestsCount, String date, String time) {
        this.price = price;
        this.pledgePrice = pledgePrice;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.requestsCount = requestsCount;
        this.date = date;
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPledgePrice() {
        return pledgePrice;
    }

    public void setPledgePrice(String pledgePrice) {
        this.pledgePrice = pledgePrice;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public int getRequestsCount() {
        return requestsCount;
    }

    public void setRequestsCount(int requestsCount) {
        this.requestsCount = requestsCount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (requestsCount != item.requestsCount) return false;
        if (price != null ? !price.equals(item.price) : item.price != null) return false;
        if (pledgePrice != null ? !pledgePrice.equals(item.pledgePrice) : item.pledgePrice != null)
            return false;
        if (fromAddress != null ? !fromAddress.equals(item.fromAddress) : item.fromAddress != null)
            return false;
        if (toAddress != null ? !toAddress.equals(item.toAddress) : item.toAddress != null)
            return false;
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        return !(time != null ? !time.equals(item.time) : item.time != null);

    }

    @Override
    public int hashCode() {
        int result = price != null ? price.hashCode() : 0;
        result = 31 * result + (pledgePrice != null ? pledgePrice.hashCode() : 0);
        result = 31 * result + (fromAddress != null ? fromAddress.hashCode() : 0);
        result = 31 * result + (toAddress != null ? toAddress.hashCode() : 0);
        result = 31 * result + requestsCount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("$25", "33", "Advance English", "World-class English courses and classes. Whether you want to accelerate your career,..", 56, "CREATED DATE", "28/09/2020"));
        items.add(new Item("$23", "44", "Keyboard Music", "Learning the keyboard is a great foundation for learning other instruments in the future", 46, "CREATED DATE", "08/12/2015"));
        items.add(new Item("$63", "12", "Digital Mathematics", "Fun and interactive online maths practice kids love! Master topics", 36, "CREATED DATE", "12/05/2019"));
        items.add(new Item("$19", "9", "Physical Science", "Physics the study of matter, motion, energy, and force", 64, "CREATED DATE", "18/02/2012"));
        items.add(new Item("$156", "89", "Computer Science", "Online distance learning gives you the flexibility of when and where to study", 26, "CREATED DATE", "25/11/2020"));
        items.add(new Item("$245", "99", "Advance Java", "World-class English courses and classes. Whether you want to accelerate your career,..", 56, "CREATED DATE", "28/09/2020"));
        items.add(new Item("$123", "44", "Guitar Music", "Learning the keyboard is a great foundation for learning other instruments in the future", 46, "CREATED DATE", "08/12/2015"));
        items.add(new Item("$63", "132", "Digital Money", "Fun and interactive online maths practice kids love! Master topics", 36, "CREATED DATE", "12/05/2019"));
        items.add(new Item("$104", "239", "Environmental Science", "Physics the study of matter, motion, energy, and force", 64, "CREATED DATE", "18/02/2012"));
        items.add(new Item("$78", "89", "Body Language", "Online distance learning gives you the flexibility of when and where to study", 26, "CREATED DATE", "25/11/2020"));

        return items;

    }

}
