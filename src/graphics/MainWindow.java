package graphics;


import Utilities.Database;
import Utilities.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;


public class MainWindow
{
	

	DefaultListModel<User> listmodel = new DefaultListModel<>();
	JList<User> list = new JList<>();

	JFrame frame1;
	JPanel panel;
	JTextField meno;
	JLabel zoznam;
	JButton addButtonuser;
	JButton selectButton;
	JButton removeButton;
	JMenuBar menuBar;
	JMenu aboutMenu;
	JMenu authorMenu;
	JMenuItem authorMenuItem;
	JMenuItem aboutMenuItem;
	
	public MainWindow()
	{
		
	
		list.removeAll();
		listmodel.removeAllElements();
		listmodel.addAll(Database.loadUserFromFile());

		
		menuBar = new JMenuBar(); 
		
		aboutMenu = new JMenu("Info"); 
		aboutMenuItem = new JMenuItem("Navod na pozitie");		
		aboutMenuItem.addActionListener((e) -> JOptionPane.showMessageDialog(frame1,
				"BMI kaloricka kalkulacka\n"
				+ "1,Vyber uzivatela kliknutim na meno a nasledne na talcidlo vybrat\n"
				+ "v dalsom okne nacita udaje zadane pri vytvarany uzivatela\n"
				+ "a vypocta BMI index a pocet kalorii,nasledne si vyskladaj svoj jedalnicek\n"
				+ "po vybrani jedal stlac prepocitat aby sa prepocitali kalorie vybraneho jedalnicka\n"
				+ "2, Vytvor si uzivatela\n"
				+ "Stlac pridaj profil a zadaj udaje do okienka\n"
				+ "3, zmaz uzivatela\n"
				+ "oznac uzivatela a stlac vymaz uzivatela pre zmazanie"
				));	
		
		
		authorMenu = new JMenu("About");
		authorMenuItem = new JMenuItem("Autor"); 
		authorMenuItem.addActionListener((e) -> JOptionPane.showMessageDialog(frame1,"Version 1.0\n"
		                                                                            +"Autor:\n"
                                                                                    +"Tomas Mati"));
		aboutMenu.add(aboutMenuItem);											
		authorMenu.add(authorMenuItem);      
		menuBar.add(aboutMenu);	
		menuBar.add(authorMenu);     
		
		
		
		
		
		frame1 = new JFrame("Jedalnicek");
		panel = new JPanel();
		meno = new JTextField();
		
		zoznam = new JLabel("Zoznam Profilov");
		zoznam.setBounds(10, 20, 120, 25);
		
		addButtonuser = new JButton("Pridaj Profil");
		addButtonuser.setBounds(220, 130, 150, 50);
	    addButtonuser.addActionListener(e -> {
			newUserwindow();
			listmodel.removeAllElements();
		});
	       
	    selectButton = new JButton("Vyber Uzivatela");
	    selectButton.setBounds(220, 60, 150, 50);
	    selectButton.addActionListener(new ActionListener() {
	    
			@Override
			public void actionPerformed(ActionEvent e) {
				User selctedvalue = list.getSelectedValue();
				System.out.println(selctedvalue);
				if(selctedvalue != null)
				{	
				new FinalWindow(selctedvalue);
				frame1.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(frame1,"Nevybral si Uzivatela");
				}
			}
		});
	
	    
	    removeButton = new JButton("Vymaz Uzivatela");
	    removeButton.setBounds(220, 200, 150, 50);
	    removeButton.addActionListener(e -> {
					User selctedvalue = list.getSelectedValue();
					if(selctedvalue != null)
					{
						Database.deleteUser(selctedvalue);
						frame1.dispose();
						listmodel.removeAllElements();
						new MainWindow();
					}
					else
					{
						JOptionPane.showMessageDialog(frame1,"Nevybral si Uzivatela");
					}
		});
	   
	    
	    list.setModel(listmodel);
	    list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    list.setLayoutOrientation(JList.VERTICAL);
	    list.setVisibleRowCount(-1);
	    list.setBounds(10, 60, 100, 200);

	    panel.setLayout(null);
	  	panel.add(list);
	  	panel.add(addButtonuser);
		panel.add(selectButton);
		panel.add(removeButton);
	  	panel.add(zoznam);
		panel.add(list);
	  	panel.add(addButtonuser);
		panel.add(zoznam);
		
		frame1.setJMenuBar(menuBar);
		frame1.add(panel);
		frame1.setSize(400,400);
		frame1.setResizable(false);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);

	}

	public void newUserwindow()
	{
		new CreateUserWindow();
		frame1.dispose();
	}





}