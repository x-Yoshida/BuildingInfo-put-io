package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Implementacja klasy Budynek
 */
public class Budynek extends Lokacja{

    private List<Poziom> poziomy = new ArrayList<Poziom>();

    /**
     * Konstruktor klasy Budynek wywołujący konstruktor klasy nadrzędnej
     */
    @JsonCreator
    public Budynek(@JsonProperty("id") int id, @JsonProperty("nazwa") String nazwa) {
        super(id, nazwa);
    }

    public List<Poziom> getPoziomy(){
         return poziomy;
    }


    public Poziom getPoziomById(int id) {
        for (Poziom poziom : poziomy) {
            if (poziom.getId() == id) {
                return poziom;
            }
        }
        return null;
    }

    /**
     * @return sum - suma powierzchni na wszystkich poziomach budynku
     */
    public double getPowierzchnia() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getPowierzchnia();
        }
        return sum;
    }
    /**
     * @return sum - suma kubatur na wszystkich poziomach budynku
     */
    public double getKubatura() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getKubatura();
        }
        return sum;
    }
}
