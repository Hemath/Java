
// Java Program to create a text editor using java 

import java.awt.*; 

import javax.swing.*; 

import java.io.*; 

import java.awt.event.*; 

import javax.swing.plaf.*;

import javax.swing.plaf.metal.*; 

import javax.swing.text.*;

import java.awt.Font;




class WhiteSatinTheme extends DefaultMetalTheme
{
	public String getName() { return "White Satin"; }
	
		// white and off hite shades
	//private final ColorUIResource primary1 		= new ColorUIResource(0xD9, 0xD9, 0xAA); 
	private final ColorUIResource primary1         = new ColorUIResource(0xD9, 0xD9, 0xAA); 
    private final ColorUIResource primary2 		= new ColorUIResource(108, 183, 244);
    private final ColorUIResource primary3      = new ColorUIResource(0xF0, 0xF0, 0xE0);
    
    private final ColorUIResource secondary1    = new ColorUIResource(0x6F, 0x6F, 0x6F);
    private final ColorUIResource secondary2    = new ColorUIResource(0x9F, 0x9F, 0x9F);
    private final ColorUIResource secondary3    = new ColorUIResource(0xDD, 0xDD, 0xCC);
    	// different fonts
    private final FontUIResource windowTitleFont = new FontUIResource("Comic Sans MS", Font.BOLD, 15);
    private final FontUIResource controlFont 	 = new FontUIResource("Comic Sans MS", Font.BOLD, 12);

		// the functions overridden from the base class => DefaultMetalTheme

    protected ColorUIResource getPrimary1() { return primary1; }  
    protected ColorUIResource getPrimary2() { return primary2; } 
    protected ColorUIResource getPrimary3() { return primary3; } 
    
    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }
    
    public FontUIResource getWindowTitleFont() { return windowTitleFont;}
    public FontUIResource getMenuTextFont() { return controlFont;}
    public FontUIResource getControlTextFont() { return controlFont;}
	
}

class Notepad extends JFrame implements ActionListener {

    // Text component 

    JTextArea t; 

  

    // Frame 

    JFrame f; 

  

    // Constructor 

    Notepad() 

    { 

        // Create a frame 

        f = new JFrame("NoteX"); 

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.getContentPane().setBackground(Color.red);
 

        try { 

            // Set metl look and feel 

          //  UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
  

            // Set theme to ocean 

            //MetalLookAndFeel.setCurrentTheme(new WhiteSatinTheme());

            MetalTheme theme = new WhiteSatinTheme();

            MetalLookAndFeel.setCurrentTheme(theme);
 		
		   try{
		        
		        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

		        SwingUtilities.updateComponentTreeUI(this);
		   }
		   catch(Exception e)
		   {
		    	System.out.println(e);
		   }

        } 

        catch (Exception e) { 

        	System.out.print(e);

        } 

  

        // Text component 

        t = new JTextArea(); 

  

        // Create a menubar 

        JMenuBar mb = new JMenuBar(); 

  

        // Create amenu for menu 

        JMenu m1 = new JMenu("File"); 

  

        // Create menu items 

        JMenuItem mi1 = new JMenuItem("New"); 

        JMenuItem mi2 = new JMenuItem("Open"); 

        JMenuItem mi3 = new JMenuItem("Save"); 

        JMenuItem mi9 = new JMenuItem("Print"); 

  

        // Add action listener 

        mi1.addActionListener(this); 

        mi2.addActionListener(this); 

        mi3.addActionListener(this); 

        mi9.addActionListener(this); 

  

        m1.add(mi1); 

        m1.add(mi2); 

        m1.add(mi3); 

        m1.add(mi9); 

  

        // Create amenu for menu 

        JMenu m2 = new JMenu("Edit"); 

  

        // Create menu items 

        JMenuItem mi4 = new JMenuItem("Cut"); 

        JMenuItem mi5 = new JMenuItem("Copy"); 

        JMenuItem mi6 = new JMenuItem("Paste"); 

  

        // Add action listener 

        mi4.addActionListener(this); 

        mi5.addActionListener(this); 

        mi6.addActionListener(this); 

  

        m2.add(mi4); 

        m2.add(mi5); 

        m2.add(mi6); 

  

        JMenu mc = new JMenu("Close"); 

        JMenuItem mc1 = new JMenuItem("Close");

        mc.add(mc1);

  

        mc1.addActionListener(this); 

  

        mb.add(m1); 

        mb.add(m2); 

        mb.add(mc);

  

        f.setJMenuBar(mb); 

        f.add(t); 

        f.setSize(500, 500); 

        f.show();

    } 

  

    // If a button is pressed 

    public void actionPerformed(ActionEvent e) 

    { 

        String s = e.getActionCommand(); 

  

        if (s.equals("Cut")) { 

            t.cut(); 

        } 

        else if (s.equals("Copy")) { 

            t.copy(); 

        } 

        else if (s.equals("Paste")) { 

            t.paste(); 

        } 

        else if (s.equals("Save")) { 

            // Create an object of JFileChooser class 

            JFileChooser j = new JFileChooser("d:"); 

  

            // Invoke the showsSaveDialog function to show the save dialog 

            int r = j.showSaveDialog(null); 

  

            if (r == JFileChooser.APPROVE_OPTION) { 

  

                // Set the label to the path of the selected directory 

                File fi = new File(j.getSelectedFile().getAbsolutePath()); 

  

                try { 

                    // Create a file writer 

                    FileWriter wr = new FileWriter(fi, false); 

  

                    // Create buffered writer to write 

                    BufferedWriter w = new BufferedWriter(wr); 

  

                    // Write 

                    w.write(t.getText()); 

  

                    w.flush(); 

                    w.close(); 

                } 

                catch (Exception evt) { 

                    JOptionPane.showMessageDialog(f, evt.getMessage()); 

                } 

            } 

            // If the user cancelled the operation 

            else

                JOptionPane.showMessageDialog(f, "You cancelled the operation"); 

        } 

        else if (s.equals("Print")) { 

            try { 

                // print the file 

                t.print(); 

            } 

            catch (Exception evt) { 

                JOptionPane.showMessageDialog(f, evt.getMessage()); 

            } 

        } 

        else if (s.equals("Open")) { 

            // Create an object of JFileChooser class 

            JFileChooser j = new JFileChooser("d:"); 

  

            // Invoke the showsOpenDialog function to show the save dialog 

            int r = j.showOpenDialog(null); 

  

            // If the user selects a file 

            if (r == JFileChooser.APPROVE_OPTION) { 

                // Set the label to the path of the selected directory 

                File fi = new File(j.getSelectedFile().getAbsolutePath()); 

  

                try { 

                    // String 

                    String s1 = "", sl = ""; 

  

                    // File reader 

                    FileReader fr = new FileReader(fi); 

  

                    // Buffered reader 

                    BufferedReader br = new BufferedReader(fr); 

  

                    // Initilize sl 

                    sl = br.readLine(); 

  

                    // Take the input from the file 

                    while ((s1 = br.readLine()) != null) { 

                        sl = sl + "\n" + s1; 

                    } 

  

                    // Set the text 

                    t.setText(sl); 

                } 

                catch (Exception evt) { 

                    JOptionPane.showMessageDialog(f, evt.getMessage()); 

                } 

            } 

            // If the user cancelled the operation 

            else

                JOptionPane.showMessageDialog(f, "the user cancelled the operation"); 

        } 

        else if (s.equals("New")) { 

            t.setText(""); 

        } 

        else if (s.equals("Close")) { 

            f.setVisible(false); 

            System.exit(1);

        } 

    } 

  

    // Main class 

    public static void main(String args[]) 

    { 

        new Notepad();

    } 
} 
