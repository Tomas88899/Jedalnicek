package graphics;

import Calculation.Kaloriescal;
import Calculation.PrepoctyBmiKal;
import Utilities.Database;
import Utilities.FoodRecipe;
import Utilities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FinalWindow 
{


	private User user;
	private String height;
	private String name;
	private String weight;
	private String bmi;
	private String maintain;
	private String loose;
	private String message;
	private String gender;
	private String lifeStyleIndex;
	private String strrecepie1;
	private String strrecepie2;
	private String strrecepie3;
	private String strrecepie4;
	private String strrecepie5;
	private int calCount1;
	private int calCount2;
	private int calCount3;
	private int calCount4;
	private int calCount5;
	private Integer totalCount;
	private String genderstr;
	
	private JComboBox <FoodRecipe> foodLisBox1 = new JComboBox<>();
	private JComboBox <FoodRecipe> foodLisBox2 = new JComboBox<>();
	private JComboBox <FoodRecipe> foodLisBox3 = new JComboBox<>();
	private JComboBox <FoodRecipe> foodLisBox4 = new JComboBox<>();
	private JComboBox <FoodRecipe> foodLisBox5 = new JComboBox<>();
	private JFrame frame3;
	private JPanel panel;
	private JLabel labelname;
	private JLabel labelheight;
	private JLabel labelweight;
	private JLabel labelbmi;
	protected JLabel labelpkl;
	private JLabel labelMaintain;
	private JLabel labelLoose;
	private JLabel labelGender;
	private JLabel breakfast;
	private JLabel snack1;
	private JLabel lunch;
	private JLabel snack2;
	private JLabel dinner;
	private JLabel calCountTotal;
	
	private JTextField textfieldname;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JTextField textfielDBmi;
	private JTextField textfieldPkl;
	private JTextField textfielMaintain;
	private JTextField textFieldLoose;
	private JTextField textFieldGender;
	private JTextField textFieldMessage;
	private JTextField textFieldTotalKcal;

	private JButton recipe1;
	private JButton recipe2;
	private JButton recipe3;
	private JButton recipe4;
	private JButton recipe5;
	private JButton countButton;
	private JButton backButton;
	
	
	public FinalWindow(User user)
	{
		this.user = user;
		loadAllRecepies();
		loadInfo();



		recipe1 = new JButton("Recept");
		recipe2 = new JButton("Recept");
		recipe3 = new JButton("Recept");
		recipe4 = new JButton("Recept");
		recipe5 = new JButton("Recept");
		countButton = new JButton("Prepocitaj");
		backButton = new JButton("Naspat");
		
		textfieldname = new JTextField(10);
		textFieldHeight = new JTextField(10);
		textFieldWeight = new JTextField(10);
		textfielDBmi = new JTextField(10);
		textfieldPkl = new JTextField(10);
		textfielMaintain = new JTextField(10);
		textFieldLoose = new JTextField(10);
		textFieldGender = new JTextField(10);
		textFieldMessage = new JTextField(60);
		textFieldTotalKcal = new JTextField(10);
				
		frame3 = new JFrame("Jedalnicek");
		panel = new JPanel();
		panel.setLayout(null);
		labelname = new JLabel("Meno: ");
		labelheight = new JLabel("Vyska: ");
		labelweight = new JLabel("Vaha: ");
		labelbmi = new JLabel("BMI Index: ");
		labelpkl = new JLabel("Denny prijem Kcal ");
		labelMaintain = new JLabel("Na udrzanie vahy: ");
		labelLoose = new JLabel("Na schudnutie: ");
		labelGender = new JLabel("Pohlavie ");
		breakfast = new JLabel("Ranajky");
		snack1 = new JLabel("Desiata");
		lunch = new JLabel("Obed");
		snack2 = new JLabel("Olovrant");
		dinner = new JLabel("Vecera");
		calCountTotal = new JLabel("Celkovy pocet Kcal");
		
		countButton.setBounds(650, 350, 100, 25);
		countButton.addActionListener(e -> countcalories());
		
		backButton.setBounds(10, 350, 100, 25);
		backButton.addActionListener(e -> stepBack());
		
		breakfast.setBounds(400, 20, 320, 25);
		recipe1.setBounds(650, 50, 100, 25);
		recipe1.addActionListener(e -> recepieWindow(strrecepie1));
		foodLisBox1.setBounds(400, 50, 220, 25);
		foodLisBox1.setBackground(Color.white);
		foodLisBox1.setSelectedItem(null);
		foodLisBox1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie1 = ((FoodRecipe) foodLisBox1.getSelectedItem()).getRecipe();
				calCount1 = ((FoodRecipe) foodLisBox1.getSelectedItem()).getCalories();
			}
		});
		
		snack1.setBounds(400, 80, 320, 25);
		recipe2.setBounds(650, 110, 100, 25);
		recipe2.addActionListener(e -> recepieWindow(strrecepie2));
		foodLisBox2.setBounds(400, 110, 220, 25);
		foodLisBox2.setBackground(Color.white);
		foodLisBox2.setSelectedItem(null);
		foodLisBox2.addActionListener(e -> {
			strrecepie2 = ((FoodRecipe) foodLisBox2.getSelectedItem()).getRecipe();
			calCount2 = ((FoodRecipe) foodLisBox2.getSelectedItem()).getCalories();
        });
		
		lunch.setBounds(400, 140, 320, 25);
		recipe3.setBounds(650, 170, 100, 25);
		recipe3.addActionListener(e -> recepieWindow(strrecepie3));
		foodLisBox3.setBounds(400, 170, 220, 25);
		foodLisBox3.setBackground(Color.white);
		foodLisBox3.setSelectedItem(null);
		foodLisBox3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie3 = ((FoodRecipe) foodLisBox3.getSelectedItem()).getRecipe();
				calCount3 = ((FoodRecipe) foodLisBox3.getSelectedItem()).getCalories();
			}
		});
		
		snack2.setBounds(400, 200, 320, 25);
		recipe4.setBounds(650,230, 100, 25);
		recipe4.addActionListener(e -> recepieWindow(strrecepie4));
		foodLisBox4.setBounds(400, 230, 220, 25);
		foodLisBox4.setBackground(Color.white);
		foodLisBox4.setSelectedItem(null);
		foodLisBox4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				strrecepie4 = ((FoodRecipe)(foodLisBox4.getSelectedItem())).getRecipe();
				calCount4 = ((FoodRecipe)(foodLisBox4.getSelectedItem())).getCalories();
			}
		});
		
		dinner.setBounds(400, 260, 320, 25);
		recipe5.setBounds(650, 290, 100, 25);
		recipe5.addActionListener(e -> recepieWindow(strrecepie5));
		foodLisBox5.setBounds(400, 290, 220, 25);
		foodLisBox5.setBackground(Color.white);
		foodLisBox5.setSelectedItem(null);
		foodLisBox5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				strrecepie5 = ((FoodRecipe)(foodLisBox5.getSelectedItem())).getRecipe();
				calCount5 = ((FoodRecipe)(foodLisBox5.getSelectedItem())).getCalories();
			}
		});
		
		calCountTotal.setBounds(400, 350, 320, 25);
		textFieldTotalKcal.setBounds(520, 350, 120, 25);
								
		labelname.setBounds(10, 20, 120, 25);
		textfieldname.setText(name);
		textfieldname.setBounds(130, 20, 120, 25);
		textfieldname.setBackground(Color.WHITE);
		textfieldname.setEditable(false);
		
		labelheight.setBounds(10, 50, 120, 25);
		textFieldHeight.setText(height);
		textFieldHeight.setBounds(130, 50, 120, 25);
		textFieldHeight.setBackground(Color.WHITE);
		textFieldHeight.setEditable(false);
		
		labelweight.setBounds(10, 80, 120, 25);
		textFieldWeight.setText(weight);
		textFieldWeight.setBounds(130, 80, 120, 25);
		textFieldWeight.setBackground(Color.WHITE);
		textFieldWeight.setEditable(false);
		
		labelbmi.setBounds(10,140, 120, 25);
		textfielDBmi.setText(bmi);
		textfielDBmi.setBounds(130, 140, 120, 25);
		textfielDBmi.setBackground(Color.WHITE);
		textfielDBmi.setEditable(false);
		
		textFieldMessage.setText(message);
		textFieldMessage.setBackground(Color.WHITE);
		textFieldMessage.setBounds(10, 170, 120, 25);
		
		labelpkl.setBounds(10,200, 120, 25);	
		labelMaintain.setBounds(10,230, 120, 25);
		textfielMaintain.setText(maintain);
		textfielMaintain.setBounds(130, 230, 120, 25);
		textfielMaintain.setBackground(Color.WHITE);
		textfielMaintain.setEditable(false);
		
		labelLoose.setBounds(10,260, 120, 25);
		textFieldLoose.setText(loose);
		textFieldLoose.setBounds(130, 260, 120, 25);
		textFieldLoose.setBackground(Color.WHITE);
		textFieldLoose.setEditable(false);
		
		labelGender.setBounds(10,110, 120, 25);
		textFieldGender.setText(genderstr);
		textFieldGender.setBounds(130, 110, 120, 25);
		textFieldGender.setBackground(Color.WHITE);
		textFieldGender.setEditable(false);
		
		
		panel.add(recipe1);
		panel.add(recipe2);
		panel.add(recipe3);
		panel.add(recipe4);
		panel.add(recipe5);
		panel.add(countButton);
		panel.add(backButton);
		panel.add(breakfast);
		panel.add(snack1);
		panel.add(lunch);
		panel.add(snack2);
		panel.add(dinner);
		panel.add(foodLisBox1);
		panel.add(foodLisBox2);
		panel.add(foodLisBox3);
		panel.add(foodLisBox4);
		panel.add(foodLisBox5);
		
		panel.add(labelname);
		panel.add(textfieldname);
		panel.add(labelheight);
		panel.add(textFieldHeight);
		panel.add(labelweight);
		panel.add(textFieldWeight);
		panel.add(labelbmi);
		panel.add(textfielDBmi);
		panel.add(labelpkl);
		panel.add(textfieldPkl);
		panel.add(labelMaintain);
		panel.add(textfielMaintain);
		panel.add(labelLoose);
		panel.add(textFieldLoose);
		panel.add(labelGender);
		panel.add(textFieldGender);
		panel.add(textFieldMessage);
		panel.add(calCountTotal);
		panel.add(textFieldTotalKcal);
		
		
		frame3.add(panel);
		frame3.setSize(800,470);
		frame3.setResizable(false);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setLocationRelativeTo(null);
		frame3.setVisible(true);
}		

		private void loadInfo()
		{
			name = user.getName();
			height = String.valueOf(user.getHeight());
			weight = String.valueOf(user.getWeight());
			gender = user.getGender();
			lifeStyleIndex = user.getLifeStyleIndex();
			bmi = PrepoctyBmiKal.bmi(user);
			message = PrepoctyBmiKal.getMessage();
			Kaloriescal kal = new Kaloriescal(Integer.parseInt(weight),Integer.parseInt(gender),Integer.parseInt(lifeStyleIndex));
			genderstr = kal.getGender();
			loose = "" + kal.getLooseweight();
			maintain = "" + kal.getMaitainweight();
		}
		private  void loadAllRecepies()
		{
			ArrayList<FoodRecipe> recipes = Database.loadRecipeFromFile();

			recipes.forEach(recipe ->{
				foodLisBox1.addItem(recipe);
				foodLisBox2.addItem(recipe);
				foodLisBox3.addItem(recipe);
				foodLisBox4.addItem(recipe);
				foodLisBox5.addItem(recipe);

			});



		}

		private void recepieWindow(String recepie)
		{
			if(recepie != null)
			{
				JFrame frame4 = new JFrame();
				JTextArea menu = new JTextArea();
				menu.setEditable(false);
				menu.append(recepie);
				menu.setSize(800,400);
				frame4.add(menu);
				frame4.setSize(800,300);
				frame4.setResizable(true);
				frame4.setDefaultCloseOperation(1);
				frame4.setLocationRelativeTo(null);
				frame4.setVisible(true);
			}
			else
				{
				JOptionPane.showMessageDialog(null,"nevybral si jedlo");
				}
		}

		private  void countcalories()
		{
			totalCount = (calCount1 + calCount2 + calCount3 + calCount4 + calCount5 );
			textFieldTotalKcal.setText(totalCount.toString());
		}

		private void stepBack()
		{
			frame3.dispose();
			new MainWindow();
		}





}
