package by.victor.greenhouse.entity;

public enum GreenHouseField {
    PLANT("plant"),
    FLOWER("flower"),
    FLOWERS("flowers"),
    TITLE("title"),
    ORIGIN("origin"),
    VISUAL_PARAMETERS("visual-parameters"),
    HEIGHT("height"),
    LEAF_COLOR("leaf-color"),
    STICK_COLOR("stick-color"),
    GROWING_TIPS("growing-tips"),
    HELIOPHILOUS("heliophilous"),
    WATERING("watering"),
    MIN_TEMPERATURE("min-temperature"),
    MAX_TEMPERATURE("max-temperature"),
    FLOWERING_TIME("flowering-time"),
    START_MONTH("start-month"),
    END_MONTH("end-mont"),
    POSSIBLE_INFLORESCENCE_COLOR("possible-inflorescence-color"),
    MULTIPLYING("multiplying"),
    SOIL("soil"),
    COLOR("color"),
    CAPRICIOUSNESS("capriciousness");
    private final String value;
    GreenHouseField( String v){
    value=v;
    }


    public String value() {
        return value;
    }

    public static GreenHouseField fromValue(String v) {
        for (GreenHouseField c: GreenHouseField.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
