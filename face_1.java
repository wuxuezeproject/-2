package cn.window.java;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;

public class face_1 extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox checkbox[];
	private JComboBox<Integer> comb_num,comb_max;
	private int num=1;
	private int max=10;
	private int style =0;
	private int iss=0;
	private JButton bcreat,bput;
	private JButton[] submit = new JButton[20];
	private JTextField[] timu=new JTextField[20],ans1=new JTextField[20],ans2=new JTextField[20],ans3=new JTextField[20];
	private test[] t=new test[20];
	
	public face_1()
	{
		super("简单四则运算");
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		JToolBar toolbar = new JToolBar();
		this.getContentPane().add(toolbar, "North");
		String str[][]={{"题目个数 ："},{"+","-","*","/","()","小数"},{" 最大值："}};
		toolbar.add(new JLabel("   "));
		toolbar.add(new JLabel(str[0][0]));
		Integer num1[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		this.comb_num=new JComboBox<Integer>(num1);
		this.comb_num.addActionListener(this);
		toolbar.add(this.comb_num);
		toolbar.add(new JLabel("      选择运算符和数据类型："));
		this.checkbox=new JCheckBox[str[1].length];
		for (int i=0;i<str[1].length;i++)
		{
			this.checkbox[i]=new JCheckBox(str[1][i]);
			toolbar.add(this.checkbox[i]);
			this.checkbox[i].addActionListener(this);
		}
		toolbar.add(new JLabel("       "));
		toolbar.add(new JLabel(str[2][0]));
		Integer max1[]={10,50,100,1000,10000};
		this.comb_max=new JComboBox<Integer>(max1);
		this.comb_max.addActionListener(this);
		toolbar.add(this.comb_max);
		toolbar.add(new JLabel("     "));
		this.bcreat=new JButton("      生成        ");
		this.bcreat.addActionListener(this);
		toolbar.add(bcreat);
		toolbar.add(new JLabel("     "));
		this.bput=new JButton("      打印        ");
		this.bput.addActionListener(this);
		toolbar.add(bput);
		toolbar.add(new JLabel("     "));
		JPanel equ=new JPanel();
		this.getContentPane().add(equ, "Center");		
		equ.setLayout(new GridLayout(21, 7, 5, 5));
		equ.add(new JLabel("                题号") );
		equ.add(new JLabel("                题目") );
		equ.add(new JLabel("           我的答案") );
		equ.add(new JLabel("                提交") );
		equ.add(new JLabel("                结果") );
		equ.add(new JLabel("          正确答案") );
		String no[]={"                1","                2","                3","                4","                5","                6","                7","                8","                9","                10","                11","                12","                13","                14","                15","                16","                17","                18","                19","                20"};
		for (int i=0;i<20;i++)
		{			
			equ.add(new JLabel (no[i]));
			this.timu[i]=new JTextField ("题目在这儿！");
			equ.add(this.timu[i]);
			this.ans1[i]=new JTextField ();
			this.ans1[i].addActionListener(this);
			equ.add(this.ans1[i]);
			this.submit[i]=new JButton("提交");
			this.submit[i].addActionListener(this);
			equ.add(this.submit[i]);
			this.ans2[i]=new JTextField ("对不对提交一下才知道");
			this.ans2[i].addActionListener(this);
			equ.add(this.ans2[i]);
			this.ans3[i]=new JTextField ("正确答案看这儿！");
			this.ans3[i].addActionListener(this);
			equ.add(this.ans3[i]);
		}

		this.setVisible(true);
		
	}
	
	private void submit(int n)
	{
		if (n>=num) 
		{
			JOptionPane.showMessageDialog(this, "此处没有题目哦，不能提交！");
			return;
		}
		String str=this.ans1[n].getText();
		if (str.equals(""))
		{
			JOptionPane.showMessageDialog(this, "不写答案还有勇气提交？");
			return;
		}
		String s=t[n].daan;
		if (str.equals(s)) //
		{
			this.ans2[n].setCaretColor(Color.blue);
			this.ans2[n].setText("正确");
		}
		else 
		{
			this.ans2[n].setCaretColor(Color.red);
			this.ans2[n].setText("错误");
		}
		this.ans3[n].setText(t[n].daan);
		this.ans3[n].setCaretColor(Color.darkGray);
		
	}
	
	public void bcreatsx()
	{
		if (style==0) 
		{
			JOptionPane.showMessageDialog(this, "还没有选择符号哦，不能生成！");
			return;
		}
		if (style==16||style==32) 
		{
			if (style==16)JOptionPane.showMessageDialog(this, "小朋友，只有括号是不行滴！");
			if (style==32)JOptionPane.showMessageDialog(this, "小朋友，只有小数是不行滴！");
			return;
		}
		JOptionPane.showMessageDialog(this, "原有题目就没有了哦！");
		for (int i=0;i<num;i++)
		{
			this.ans1[i].setText("");
			this.ans2[i].setText("对不对提交一下才知道");
			this.ans3[i].setText("正确答案看这儿！");
			t[i]=new test(max,style);//
			t[i].creat();
			this.timu[i].setText(t[i].ti);
		}
		iss++;
	}
	
    public  void charOutStream() throws Exception{
        // 1：利用File类找到要操作的对象
            File file = new File("D:" + File.separator + "JAVA" + File.separator + "test.txt");
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            Writer out = new FileWriter(file);
            for (int i=0;i<num;i++)
            {
            	out.write("题目：");
            	out.write(t[i].ti);
            	out.write("         正确答案：");
            	out.write(t[i].daan);
            	out.write("         我的答案：");
            	out.write(this.ans1[i].getText());
            	out.write("\r\n");
            }
            out.close();
            JOptionPane.showMessageDialog(this, "已经打印成功了！在D:JAVA:test.txt中。");
        }
	
	
	public void actionPerformed(ActionEvent ev)
	{
		if (ev.getSource()==this.bcreat)
		{
			bcreatsx();//
		}
		if (ev.getSource()==this.bput)
		{
			if (iss==0) 
				{
				JOptionPane.showMessageDialog(this, "还没有题目哦，不能打印！");
				return ;
				}
			try {
				charOutStream();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//dayin
		}
		if (ev.getSource()instanceof JComboBox<?>||ev.getSource()instanceof JCheckBox||ev.getSource()instanceof JMenuItem)
		{
			Object obj1=this.comb_num.getSelectedItem();
			num=((Integer)obj1).intValue();
			Object obj2=this.comb_max.getSelectedItem();
			max=((Integer)obj2).intValue();
			if (ev.getActionCommand().equals("+")) style=style^1; 
			if (ev.getActionCommand().equals("-")) style=style^2; 
			if (ev.getActionCommand().equals("*")) style=style^4; 
			if (ev.getActionCommand().equals("/")) style=style^8; 
			if (ev.getActionCommand().equals("()")) style=style^16; 
			if (ev.getActionCommand().equals("小数")) style=style^32;
		}
		
		if (ev.getSource()==submit[0]) submit(0); 
		else if (ev.getSource()==submit[1]) submit(1); //
		else if (ev.getSource()==submit[2]) submit(2); 
		else if (ev.getSource()==submit[3]) submit(3); 
		else if (ev.getSource()==submit[4]) submit(4); 
		else if (ev.getSource()==submit[5]) submit(5); 
		else if (ev.getSource()==submit[6]) submit(6); 
		else if (ev.getSource()==submit[7]) submit(7); 
		else if (ev.getSource()==submit[8]) submit(8); 
		else if (ev.getSource()==submit[9]) submit(9); 
		else if (ev.getSource()==submit[10]) submit(10); 
		else if (ev.getSource()==submit[11]) submit(11); 
		else if (ev.getSource()==submit[12]) submit(12); 
		else if (ev.getSource()==submit[13]) submit(13); 
		else if (ev.getSource()==submit[14]) submit(14); 
		else if (ev.getSource()==submit[15]) submit(15); 
		else if (ev.getSource()==submit[16]) submit(16); 
		else if (ev.getSource()==submit[17]) submit(17); 
		else if (ev.getSource()==submit[18]) submit(18); 
		else if (ev.getSource()==submit[19]) submit(19); 
		
	}

	public static void main(String args[])
	{
		new face_1();
	}
}


