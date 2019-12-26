package by.victor.greenhouse.entity;

import java.util.Objects;

public class FlowerData {
    public String title;
    private String origin;
    private String height;
    private String leafColor;
    private String stickColor;
    private String heliophilous;
    private String watering;
    private String minTemperature;
    private String maxTemperature;
    private String startFloweringTime;
    private String endFloweringTime;
    private String inflorescenceColor;
    private String multiplying;
    private String soil;
    private String capriciousness;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(String leafColor) {
        this.leafColor = leafColor;
    }

    public String getStickColor() {
        return stickColor;
    }

    public void setStickColor(String stickColor) {
        this.stickColor = stickColor;
    }

    public String getHeliophilous() {
        return heliophilous;
    }

    public void setHeliophilous(String heliophilous) {
        this.heliophilous = heliophilous;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getStartFloweringTime() {
        return startFloweringTime;
    }

    public void setStartFloweringTime(String startFloweringTime) {
        this.startFloweringTime = startFloweringTime;
    }

    public String getEndFloweringTime() {
        return endFloweringTime;
    }

    public void setEndFloweringTime(String endFloweringTime) {
        this.endFloweringTime = endFloweringTime;
    }

    public String getInflorescenceColor() {
        return inflorescenceColor;
    }

    public void setInflorescenceColor(String inflorescenceColor) {
        this.inflorescenceColor = inflorescenceColor;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getCapriciousness() {
        return capriciousness;
    }

    public void setCapriciousness(String capriciousness) {
        this.capriciousness = capriciousness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerData that = (FlowerData) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(origin, that.origin) &&
                Objects.equals(height, that.height) &&
                Objects.equals(leafColor, that.leafColor) &&
                Objects.equals(stickColor, that.stickColor) &&
                Objects.equals(heliophilous, that.heliophilous) &&
                Objects.equals(watering, that.watering) &&
                Objects.equals(minTemperature, that.minTemperature) &&
                Objects.equals(maxTemperature, that.maxTemperature) &&
                Objects.equals(startFloweringTime, that.startFloweringTime) &&
                Objects.equals(endFloweringTime, that.endFloweringTime) &&
                Objects.equals(inflorescenceColor, that.inflorescenceColor) &&
                Objects.equals(multiplying, that.multiplying) &&
                Objects.equals(soil, that.soil) &&
                Objects.equals(capriciousness, that.capriciousness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, origin, height, leafColor, stickColor, heliophilous, watering, minTemperature, maxTemperature, startFloweringTime, endFloweringTime, inflorescenceColor, multiplying, soil, capriciousness);
    }
}
