package ArtCode.dao;


import ArtCode.lakeANDfish.Fish;

import java.util.List;

public interface FishDao {

    Fish createNewFish (String name);

    Fish deleteFish(String name);

    List<Fish> showAll ();
}
