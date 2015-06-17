package ArtCode.lakeANDfish;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Lake")
public class Lake extends GenerateIdLake{

    @Column (nullable = false, unique = true)
    private String name;

    @OneToMany (mappedBy = "fish"
            , cascade = {CascadeType.PERSIST})
    private List<Fish> fishList = new ArrayList<Fish>();

    public Lake() {
    }

    public Lake(Long id, String name, List<Fish> fishList) {
        setId(id);
        this.name = name;
        this.fishList = fishList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void setFishList(List<Fish> fishList) {
        this.fishList = fishList;
    }
}