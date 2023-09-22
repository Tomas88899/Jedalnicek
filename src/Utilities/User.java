package Utilities;

public class User
{
    private String name;
    private int height;
    private int weight;
    private String gender;
    private String lifeStyleIndex;



    public User(String name, int height, int weight,String gender,String lifeStyleIndex)
    {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.lifeStyleIndex = lifeStyleIndex;
    }

    public String getName()
    {
        return name;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWeight()
    {
        return weight;
    }

    public String getGender()
    {
        return gender;
    }

    public String getLifeStyleIndex()
    {
        return lifeStyleIndex;
    }

    @Override
    public String toString() {
        return name;
    }
}
