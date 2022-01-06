import java.util.GregorianCalendar;
import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.TimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


class DayOfYear {
    private int julianDay = -1;
    
    public DayOfYear() {
	final int julianDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        System.out.println("DEBUG: day = " + julianDay);
	this.julianDay = julianDay;
    }
    
    public int getJulianDay() {
	return this.julianDay;
    }
    
}


 // Create a simple GUI window
 public class DOY {
	static JLabel textLabelA;
	static JLabel textLabelB;
    static JLabel convLabel;
	static JLabel convLabel1;
	static JTextField editTextArea;
	static JTextField editTextArea1;
	static JFrame frame;
    private static void createWindow() {
	
	DayOfYear doy = new DayOfYear();
    TimeZone tz  = TimeZone.getTimeZone("GMT");
	Calendar now = Calendar.getInstance(tz);
    
    //Create and set up the window.
	String todayJulian = String.format("%04d/%03d", now.get(Calendar.YEAR), now.get(Calendar.DAY_OF_YEAR), doy.getJulianDay());
	String todayJulianTitle = String.format("%04d/%03d", now.get(Calendar.YEAR), now.get(Calendar.DAY_OF_YEAR), doy.getJulianDay());

    frame = new JFrame(todayJulianTitle);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setPreferredSize(new Dimension(240, 165));
 
	SimpleDateFormat dateFormatGmt = new SimpleDateFormat("HH:mm:ss");
	dateFormatGmt.setTimeZone(tz);
    String textDateA = String.format("%04d/%02d/%02d | week %d", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE), now.get(Calendar.WEEK_OF_YEAR));
	String textDateB = String.format("%s UTC | day %03d", dateFormatGmt.format(now.getTime()), now.get(Calendar.DAY_OF_YEAR));

	textLabelA = new JLabel(textDateA, SwingConstants.LEFT);
	textLabelA.setFont (textLabelA.getFont().deriveFont(16.0f));
	textLabelA.setHorizontalAlignment(SwingConstants.LEFT);
	textLabelA.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	textLabelB = new JLabel(textDateB, SwingConstants.LEFT);
	textLabelB.setFont (textLabelB.getFont().deriveFont(16.0f));
	textLabelB.setHorizontalAlignment(SwingConstants.LEFT);
	textLabelB.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
	
	
	editTextArea = new JTextField(todayJulian);
	editTextArea.setFont (editTextArea.getFont().deriveFont(16.0f));
        convLabel = new JLabel("conv", SwingConstants.LEFT);
	convLabel.setFont(convLabel.getFont().deriveFont(16.0f));
	
   
	String todayNormal = String.format("%04d/%02d/%02d", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE));
	editTextArea1 = new JTextField(todayNormal);
	editTextArea1.setFont (editTextArea1.getFont().deriveFont(16.0f));
	editTextArea1.setPreferredSize(new Dimension(10, 25));
	convLabel1 = new JLabel("conv1", SwingConstants.LEFT);
	convLabel1.setFont(convLabel1.getFont().deriveFont(16.0f));
	//convLabel1.setPreferredSize(new Dimension(100, 25)); 
	
    frame.getContentPane().setLayout(
       new GridLayout(4,1)
    );
	
    frame.add(textLabelA);
	frame.add(textLabelB);


    JPanel convPane = new JPanel();
    convPane.setLayout(new BoxLayout(convPane, BoxLayout.LINE_AXIS));
    convPane.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
    convPane.add(Box.createHorizontalGlue());
    convPane.add(editTextArea);
    convPane.add(Box.createRigidArea(new Dimension(10, 0)));
    convPane.add(convLabel, BoxLayout.PAGE_AXIS);
	
	frame.add(convPane);
	
	JPanel convPane1 = new JPanel();
	convPane1.setLayout(new BoxLayout(convPane1, BoxLayout.LINE_AXIS));
	convPane1.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));
	convPane1.add(Box.createHorizontalGlue());
	convPane1.add(editTextArea1);
	convPane1.add(Box.createRigidArea(new Dimension(10, 0)));
	convPane1.add(convLabel1, BoxLayout.PAGE_AXIS);
	
	frame.add(convPane1);
	
	//Display the window. 
	frame.setLocationRelativeTo(null); 
	frame.pack();
	frame.setResizable(false);
	frame.setVisible(true);
	}


	public static String fromJulian(String injulian) {
	TimeZone tz  = TimeZone.getTimeZone("GMT");
	Calendar gc = Calendar.getInstance(tz);
	gc.set(Calendar.YEAR, Integer.parseInt(injulian.substring(0,4)));
	gc.set(Calendar.DAY_OF_YEAR, Integer.parseInt(injulian.substring(4,7)));
	String textDate = String.format("%04d/%02d/%02d", gc.get(Calendar.YEAR), gc.get(Calendar.MONTH) + 1, gc.get(Calendar.DATE), gc.get(Calendar.DAY_OF_YEAR));
	System.out.println(textDate);
	return textDate;
	}
	
	public static String fromGregorian(String ingreg) {
	TimeZone tz  = TimeZone.getTimeZone("GMT");
	Calendar gc = Calendar.getInstance(tz);
	gc.set(Calendar.YEAR, Integer.parseInt(ingreg.substring(0,4)));
	gc.set(Calendar.MONTH, Integer.parseInt(ingreg.substring(5,7)) - 1);
	gc.set(Calendar.DATE, Integer.parseInt(ingreg.substring(8,10)));
	String textDate = String.format("%04d/%03d", gc.get(Calendar.YEAR), gc.get(Calendar.DAY_OF_YEAR));
	System.out.println(textDate);
	return textDate;
	}
	
	private static void updatemylabel() {

	DayOfYear doy = new DayOfYear();
        TimeZone tz  = TimeZone.getTimeZone("GMT");
	Calendar now = Calendar.getInstance(tz);
         
	SimpleDateFormat dateFormatGmt = new SimpleDateFormat("HH:mm:ss");
	dateFormatGmt.setTimeZone(tz);

	String textDateA = String.format("%04d/%02d/%02d | week %d", now.get(Calendar.YEAR), now.get(Calendar.MONTH) + 1, now.get(Calendar.DATE), now.get(Calendar.WEEK_OF_YEAR));
	String textDateB = String.format("%s UTC | day %03d", dateFormatGmt.format(now.getTime()), now.get(Calendar.DAY_OF_YEAR));
	textLabelA.setText(textDateA);
	textLabelB.setText(textDateB);
	String todayJulianTitle = String.format("%04d/%03d", now.get(Calendar.YEAR), now.get(Calendar.DAY_OF_YEAR), doy.getJulianDay());
	frame.setTitle(todayJulianTitle); 
	
	
	System.out.println(editTextArea.getText());
	try {
	  String convDate = fromJulian(editTextArea.getText().trim().replace("/", ""));
	  convLabel.setText(convDate);
	  String convDate1 = fromGregorian(editTextArea1.getText().trim());
	  convLabel1.setText(convDate1);
	} catch (Exception e) {
		System.err.println("Input date malformed, required YYYYJJJ");
    }
	}
 
    public static void main(String[] args) {
       createWindow();
	   while(true) {
	   try {
		updatemylabel();
        TimeUnit.SECONDS.sleep(1);
       } catch (InterruptedException e) {
        System.err.println(e);
       }
     }	   
   }
}


