package Utilities;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Database
{
    private static ArrayList<FoodRecipe> foodRecipes= new ArrayList<>();
    private static ArrayList<User> users= new ArrayList<>();




    public static ArrayList<User> loadUserFromFile()
    {
        users.clear();
        String line = "";
        String [] newUser;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Source\\Users.csv"));
            while ((line = reader.readLine()) != null)
            {
                 newUser = line.split(";");

                users.add(new User(newUser[0],
                        Integer.parseInt(newUser[1]),
                        Integer.parseInt(newUser[2]),
                        newUser[3],
                        newUser[4]));

            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Nepodarilo sa nacitat uzivatelov");
        }
        return users;
    }


    public static void addNewUser(User user)
    {
        users.add(user);
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("Source\\Users.csv"));
            users.forEach(user1 -> {
                try {
                    writer.write(user1.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
            System.out.println("funguje");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void deleteUser(User user)
    {
        users.remove(user);
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("Source\\Users.csv"));
            users.forEach(user1 -> {
                try {
                    writer.write(user1.toString() + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            writer.close();
            System.out.println("funguje");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<Path> loadRecepieList()
    {

        try {

            return  Files.walk(Paths.get("Source\\Recipes"))
                    .filter(Files::isRegularFile)
                    .toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<FoodRecipe> loadRecipeFromFile()
    {
        foodRecipes.clear();
        List<Path> path = loadRecepieList();


        for (Path path1 : path)
        {
                    String line = "";
                    StringBuilder builder = new StringBuilder();
                    String[] newRecipe;


                    newRecipe = path1.getFileName().toString().split("\\.");

                    try {
                        BufferedReader reader2 = new BufferedReader(new FileReader(path1.toString(), StandardCharsets.UTF_8));
                        while ((line = reader2.readLine()) != null) {
                            builder.append(line + "\n");

                        }
                        reader2.close();
                    } catch (IOException e) {
                        System.out.println("Subor preco nenajdeny");
                    }
            foodRecipes.add(new FoodRecipe(newRecipe[0],
                    Integer.parseInt(newRecipe[1]),
                    builder.toString()));

        }
        return foodRecipes;
    }
    }
