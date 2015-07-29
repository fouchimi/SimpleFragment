package example.com.fragments.data;

import android.os.Bundle;

/**
 * Created by LeBoss on 7/27/2015.
 */
public class Flower {

    public static final String FLOWER_NAME = "flowerName";
    public static final String IMAGE_RESOURCE = "imageResource";
    public static final String PRICE = "price";
    public static final String INSTRUCTIONS = "instructions";

    //private fields
    private String flowerName;
    private int imageResource;
    private double price;
    private String instructions;

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    //Used when creating the data object
    public Flower(String id, int imageResource, double price, String instructions) {

        this.flowerName = id;
        this.imageResource = imageResource;
        this.price = price;
        this.instructions = instructions;
    }

    //Create from bundle
    public Flower(Bundle b) {
        if(b != null) {
            this.flowerName = b.getString(FLOWER_NAME);
            this.imageResource = b.getInt(IMAGE_RESOURCE);
            this.price = b.getDouble(PRICE);
            this.instructions = b.getString(INSTRUCTIONS);
        }
    }

    // Package data to transfer between activities
    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString(FLOWER_NAME, this.flowerName);
        b.putInt(IMAGE_RESOURCE, this.imageResource);
        b.putDouble(PRICE, this.price);
        b.putString(INSTRUCTIONS, this.instructions);
        return b;
    }

    //	Output flower data
    @Override
    public String toString() {
        return flowerName;
    }
}
