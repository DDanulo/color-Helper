package com.example.colorhelper;

public class History {


    private String colorHex;
    private String colorRGB;
    private int colorResourse;


    public History(String colorHex, String colorRGB, int colorResourse) {
        this.colorHex = colorHex;
        this.colorRGB = colorRGB;
        this.colorResourse = colorResourse;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getColorRGB() {
        return colorRGB;
    }

    public void setColorRGB(String colorRGB) {
        this.colorRGB = colorRGB;
    }

    public int getColorResourse() {
        return colorResourse;
    }

    public void setColorResourse(int colorResourse) {
        this.colorResourse = colorResourse;
    }

}
