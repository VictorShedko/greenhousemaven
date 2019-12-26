package by.victor.greenhouse.action;

import by.victor.greenhouse.entity.Flower;
import by.victor.greenhouse.entity.FlowerData;
import by.victor.greenhouse.entity.Plant;



public class FlowerDataAction {


    public FlowerData toFlowerData(Plant plant) {
        FlowerData flowerData = new FlowerData();
        flowerData.setTitle(plant.getTitle());
        flowerData.setOrigin(plant.getOrigin());
        if (plant.getCapriciousness() != null) {
            flowerData.setCapriciousness(plant.getCapriciousness().toString());
        }
        plant.getGrowingTips().forEach(t -> {
            if (t.getMaxTemperature() != null) {
                flowerData.setMaxTemperature(t.getMaxTemperature().toString());
            }
            if (t.getMinTemperature() != null) {
                flowerData.setMinTemperature(t.getMinTemperature().toString());
            }
            if (t.isHeliophilous() != null) {
                flowerData.setHeliophilous(t.isHeliophilous().toString());
            }
            if (t.getWatering() != null) {
                flowerData.setWatering(t.getWatering().toString());
            }
        });


        plant.getVisualParameters().forEach(t -> {
            if (t.getLeafColor() != null) {
                flowerData.setLeafColor(t.getLeafColor().toString());
            }
            if (t.getStickColor() != null) {
                flowerData.setStickColor(t.getStickColor().toString());
            }
            if (t.getHeight() != null) {
                flowerData.setHeight(t.getHeight().toString());
            }
        });

        plant.getSoil().forEach(t->{
            if(flowerData.getSoil()!=null){
            flowerData.setSoil(flowerData.getSoil()+t);
            }else{
                flowerData.setSoil(t.toString());
            }
        });

        plant.getMultiplying().forEach(t->{
            if(flowerData.getMultiplying()!=null){
                flowerData.setMultiplying(flowerData.getMultiplying()+t);
            }else {
                flowerData.setMultiplying(t.value());
            }
        });

        if(plant instanceof Flower){
            StringBuilder inferenceColorBuilder=new StringBuilder();
            ((Flower)plant).getPossibleInflorescenceColor().getColor().forEach(t->{
                inferenceColorBuilder.append(t.value());
                inferenceColorBuilder.append(" ");
            });
            flowerData.setInflorescenceColor(inferenceColorBuilder.toString());
        }
        return flowerData;
    }
}
