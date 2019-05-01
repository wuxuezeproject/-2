package cn.window.java;
import java.lang.String;
public class test {
	private int max,kuohao,xiaoshu;
	private double[] shuji=new double[10],shu_new=new double[10];
	public String fuhao=" ",ti,daan,fuhao_sel,fuhaoji=" ",fuhao_new=" ";
	
	
	public test(int Max,int tyle)
	{
		max=Max;
		if ((tyle & 1)==1) fuhao=fuhao+"+";
		if ((tyle & 2)==2) fuhao=fuhao+"-";
		if ((tyle & 4)==4) fuhao=fuhao+"*";
		if ((tyle & 8)==8) fuhao=fuhao+"/";
		if ((tyle & 16)==16) kuohao=1;
		if ((tyle & 32)==32) xiaoshu=1;
	}
	
	
	public void creat()
	{	
		shuji[0]=getnum();
		for(int i=1;i<=(int)(Math.random()*3)+1;i++)
		{
			shuji[i]=getnum();
			getchar();
			fuhaoji=fuhaoji+fuhao_sel;
		}
		creatf();
		show();
		count();
		ti=ti+"=";
	}
	
	private void count()
	{
		int no=1,ni=0,top1=0,top2=0;
		double a[]={0,0,0,0};
		char[] b=new char[5];
		a[top1]=shu_new[ni];
		top1++;
		ni++;
		while(true)
		{
			if (no>=fuhao_new.length()) break;
			  char ch=fuhao_new.charAt(no);
			  no++;
			   if (ch=='*'||ch=='/')
			  {
				  double s=shu_new[ni];
				  ni++;
				  if (ch=='*') a[top1-1]=a[top1-1]*s;
				  else if (ch=='/') a[top1-1]=a[top1-1]/s;
				  
			  }
			  else if (ch=='+'||ch=='-')
			  {
				  double s=shu_new[ni];
				  ni++;
				  if (top2==1&&top1==2)
				  {
					  if (b[0]=='+') a[0]=a[0]+a[1];
					  else if (b[0]=='-') a[0]=a[0]-a[1];
					  
					  b[1]=ch;
					  a[1]=s;
				  }
				  else
				  {
					  b[top2]=ch;
					  top2++;
					  a[top1]=s;
					  top1++;
				  }
			  }
			 // else if (fuhaoji.charAt(no+1)!='(');
		}
	if (top2==1&&top1==2)
	{
		if (b[0]=='+') a[0]=a[0]+a[1];
		  else if (b[0]=='-') a[0]=a[0]-a[1];
	}
	if (xiaoshu==1) daan=String.valueOf(a[0]);
	else daan=String.valueOf((int)a[0]);
	}
	
 	private void show()
	{
		int no=1,ni=0;
		ti=" ";
		if (kuohao==1&&fuhaoji.charAt(1)=='(')
		{
			  while(true)
			  {
				  if (no>=fuhaoji.length()) break;
				  ti=ti+fuhaoji.substring(no,no+1);
				  if (fuhaoji.charAt(no)==')')
				  {
					  no++;
					  if (no>=fuhaoji.length()) break;
					  ti=ti+fuhaoji.substring(no,no+1);
			      }
				  if (xiaoshu==1) ti=ti+String.valueOf(shuji[ni]);
				  else ti=ti+String.valueOf((int)shuji[ni]);
				  ni++;no++;
				  if (no==fuhaoji.length()) break;
			  }
		}
		else if (kuohao==1&&fuhaoji.charAt(1)!='(')
		{
			if (xiaoshu==1) ti=ti+String.valueOf(shuji[0]);
			  else ti=ti+String.valueOf((int)shuji[0]);
			ni++;
			while(true)
			  {
				if (no>=fuhaoji.length()) break;
				ti=ti+fuhaoji.substring(no,no+1);
				no++;
				if (no>=fuhaoji.length()) break;
				  if (fuhaoji.charAt(no)=='(')
				  {
					  //no++;
					  ti=ti+fuhaoji.substring(no,no+1);
			      }
				  else no--;
				  if (fuhaoji.charAt(no)==')'&&no<fuhaoji.length())
				  {
					  no++;
					  ti=ti+fuhaoji.substring(no,no+1);
			      }
				  if (xiaoshu==1) ti=ti+String.valueOf(shuji[ni]);
				  else ti=ti+String.valueOf((int)shuji[ni]);
				  ni++;no++;
				  if (no==fuhaoji.length()) break;
			  }
		}
		else if(kuohao==0)
		{
			if (xiaoshu==1) ti=ti+String.valueOf(shuji[ni]);
			  else ti=ti+String.valueOf((int)shuji[ni]);
			ni++;
			while(true)
			  {
				if (no>=fuhaoji.length()) break;
				ti=ti+fuhaoji.substring(no,no+1);
				if (xiaoshu==1) 
					{ti=ti+String.valueOf(shuji[ni]);}
				  else 
					  {ti=ti+String.valueOf((int)shuji[ni]);}
				 ni++;
				 no++;
				 if (no>=fuhaoji.length()) break;
			  }
		}
	}
	
	private void creatf()
	{
		if (kuohao==1)
		{
		int id=Math.abs((int)(Math.random()*(fuhaoji.length()-1)));
		String a,b,c;
		a=fuhaoji.substring(0, id+1);
		b=fuhaoji.substring(id+1,id+2);
		if ((id+2) < (fuhaoji.length()))  c=fuhaoji.substring(id+2,fuhaoji.length());
		else c="";
		fuhaoji=a+"("+b+")"+c;
		fuhao_new=a+c;
		if (id==1)
		{
			if (fuhaoji.charAt(1)=='+') shu_new[0]=shuji[0]+shuji[1];
			else if (fuhaoji.charAt(1)=='-') shu_new[0]=shuji[0]-shuji[1];
			else if (fuhaoji.charAt(1)=='*') shu_new[0]=shuji[0]*shuji[1];
			else if (fuhaoji.charAt(1)=='/') shu_new[0]=shuji[0]/shuji[1];
			for (int i=2;i<shuji.length;i++)
			{
				shu_new[i-1]=shuji[i];
			}
		}
		else if (id==2)
		{
			shu_new[0]=shuji[0];
			if (fuhaoji.charAt(3)=='+') shu_new[1]=shuji[1]+shuji[2];
			else if (fuhaoji.charAt(3)=='-') shu_new[1]=shuji[1]-shuji[2];
			else if (fuhaoji.charAt(3)=='*') shu_new[1]=shuji[1]*shuji[2];
			else if (fuhaoji.charAt(3)=='/') shu_new[1]=shuji[1]/shuji[2];
			for (int i=3;i<shuji.length;i++)
			{
				shu_new[i-1]=shuji[i];
			}
			
		}
		else if (id==3)
		{
			shu_new[0]=shuji[0];
			shu_new[1]=shuji[1];
			if (fuhaoji.charAt(3)=='+') shu_new[2]=shuji[2]+shuji[3];
			else if (fuhaoji.charAt(3)=='-') shu_new[2]=shuji[2]-shuji[3];
			else if (fuhaoji.charAt(3)=='*') shu_new[2]=shuji[2]*shuji[3];
			else if (fuhaoji.charAt(3)=='/') shu_new[2]=shuji[2]/shuji[3];
		}
		}
		else
		{
			fuhao_new=fuhaoji;
			for (int i=0;i<shuji.length;i++)
			{
				shu_new[i]=shuji[i];
			}
		}
		if (xiaoshu==0)
		{
			for (int i=0;i<shu_new.length;i++)
				shu_new[i]=(int) shu_new[i];
		}
	}
	
	private double getnum()
	{
		double a=(Math.random()*max)+1;
		a=((int)(a*100))/100.0;
		return (a);
	}
	
	public void getchar()
	{
		int le=(int)(Math.random()*(fuhao.length()-1))+1;
		fuhao_sel=fuhao.substring(le, le+1);
	}
}



