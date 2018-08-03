import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstCalculator
{
	public static void main(String[] args)
	{
		MiniCalculator test=new MiniCalculator();
		test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		test.setSize(280, 270);
		test.setResizable(false);
		test.setVisible(true);
	}
}

class MiniCalculator extends JFrame
{
	private JButton plusB,minusB,multiplyB,divideB;
	TextField num1,num2;
	JLabel label1,label2;
	MiniCalculator()
	{
		super("Mini Calculator");
		setLayout(new FlowLayout());

		label1=new JLabel("Enter 1st number:");
		add(label1);
		num1=new TextField(10);
		add(num1);
		label2=new JLabel("Enter 2nd number:");
		add(label2);
		num2=new TextField(10);
		add(num2);

		Icon plus=new ImageIcon(getClass().getResource("plus.png"));
		plusB=new JButton(plus);
		plusB.setToolTipText("Add");
		add(plusB);

		Icon minus=new ImageIcon(getClass().getResource("minus.png"));
		minusB=new JButton(minus);
		minusB.setToolTipText("Subtract");
		add(minusB);

		Icon multiply=new ImageIcon(getClass().getResource("multiply.png"));
		multiplyB=new JButton(multiply);
		multiplyB.setToolTipText("Multiply");
		add(multiplyB);

		Icon divide=new ImageIcon(getClass().getResource("divide.png"));
		divideB=new JButton(divide);
		divideB.setToolTipText("Divide");
		add(divideB);

		ActionHandler handler=new ActionHandler();
		plusB.addActionListener(handler);
		minusB.addActionListener(handler);
		multiplyB.addActionListener(handler);
		divideB.addActionListener(handler);
	}

	class ActionHandler implements ActionListener
	{
		@Override public void actionPerformed(ActionEvent e)
		{
			double n1=Double.parseDouble(num1.getText());
			double n2=Double.parseDouble(num2.getText());
			if(e.getSource()==plusB)
				JOptionPane.showMessageDialog(null,"Addition of "+n1+" and "+n2+" is "+(n1+n2),"Addition of Numbers",JOptionPane.INFORMATION_MESSAGE);
			if(e.getSource()==minusB)
				JOptionPane.showMessageDialog(null,"Subtraction of "+n1+" and "+n2+" is "+(n1-n2),"Subtraction of Numbers",JOptionPane.INFORMATION_MESSAGE);
			if(e.getSource()==multiplyB)
				JOptionPane.showMessageDialog(null,"Multiplication of "+n1+" and "+n2+" is "+(n1*n2),"Multiplication of Numbers",JOptionPane.INFORMATION_MESSAGE);
			if(e.getSource()==divideB)
				JOptionPane.showMessageDialog(null,String.format("Division of "+n1+" and "+n2+" is %.4f", n1/n2),"Division of Numbers",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
