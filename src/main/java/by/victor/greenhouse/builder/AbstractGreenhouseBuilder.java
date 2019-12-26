package by.victor.greenhouse.builder;

import by.victor.greenhouse.entity.Plant;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGreenhouseBuilder {
    protected Set<Plant> plants;
    public AbstractGreenhouseBuilder() {
        plants = new HashSet<>();
    }
    public AbstractGreenhouseBuilder(Set<Plant> plants) {
        this.plants = plants;
    }
    public Set<Plant> getPlants() {
        return plants;
    }


    abstract public void buildSetFlowers(String fileName);
}
