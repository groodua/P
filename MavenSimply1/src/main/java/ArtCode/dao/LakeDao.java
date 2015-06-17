package ArtCode.dao;

import ArtCode.lakeANDfish.Lake;

import java.util.List;

public interface LakeDao  {

    Lake findLakeByName(String nameLake);

    Lake findLakeByFish(String nameFish);

    Lake createHimLake(Lake lakeName);

    List<Lake> showAllLakes(String name);
}
