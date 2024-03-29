package pl.put.poznan.informer.logic;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Implementacja abstrakcyjnej klasy Lokacja
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Budynek.class, name = "budynek"),
        @JsonSubTypes.Type(value = Poziom.class, name = "poziom"),
        @JsonSubTypes.Type(value = Pomieszczenie.class, name = "pomieszczenie")
})


public abstract class Lokacja {
    private int id;
    private String nazwa;


    /**
     * Konstruktor klasy Lokacja
     */
    public Lokacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
    /**
     * Konstruktor klasy Lokacja
     */
    public Lokacja(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public abstract double getPowierzchnia();
    public abstract double getKubatura();

    public abstract double getLight();
    public abstract double getLightPower();

    public abstract double getHeating();
    public abstract double getHeatingPower();
}
