package ArtCode.lakeANDfish;


import javax.persistence.*;

@Entity
@Table (name = "Fish")
public class Fish extends GenerateIdLake{

    @Column (nullable = false, unique = true)
    private String name;

    @Column (nullable = false)
    private int minWeight;

    @ManyToMany
    @JoinColumn (name = "fish_id", referencedColumnName = "id")
    private Lake fish;

    public Fish() {
    }

    public Fish(Long id, String name, int minWeight, Lake fish) {
        setId(id);
        this.name = name;
        this.minWeight = minWeight;
        this.fish = fish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public Lake getFish() {
        return fish;
    }

    public void setFish(Lake fish) {
        this.fish = fish;
    }
}
