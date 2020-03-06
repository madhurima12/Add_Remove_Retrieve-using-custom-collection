package custom_collection;
import java.util.Arrays;
import java.util.Scanner;
 class TheList<L>
{
public int size=0;
public static final int initial_capacity=10;
public Object elements[];
public TheList(){
elements=new Object[initial_capacity];
}
public void add(L e)
{
int numlength=0;
if(size==elements.length)
{
ensureCapacity();
}
elements[size++]=e;
}
public L get(int i)
{
if(i>=size || i<0)
{
throw new IndexOutOfBoundsException("Index:"+i+",Size"+i);
}
return (L) elements[i];
}
public L remove(int i)
{
if(i>=size || i<0)
{
throw new IndexOutOfBoundsException("Index:"+i+",Size"+i);
}
Object item=elements[i];
int numlength=elements.length-(i+1);
System.arraycopy(elements,i+1,elements,i,numlength);
size--;
return (L) item;
}
public String toString()
{
StringBuilder sb=new StringBuilder();
sb.append('[');
for(int i=0;i<size;i++)
{
sb.append(elements[i].toString());
if(i<size-1)
{
sb.append(",");
}
}
sb.append(']');
return sb.toString();
}
public void ensureCapacity()
{
int newSize=0;
newSize=elements.length*2;
elements=Arrays.copyOf(elements,newSize);
}
}
public class Task_collection
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int x=1,choice;
TheList<Integer> list=new TheList<>();
while(x!=0)
{
System.out.println("Choose from the options:");
System.out.println("1:Add");
System.out.println("2:Remove");
System.out.println("3:Retrieve");
System.out.println("Enter choice");
choice=sc.nextInt();
if(choice==1)
{
int num;
System.out.println("Enter a number");
num=sc.nextInt();
list.add(num);
System.out.println(list);
}
else if(choice==2)
{
int position_rem;
System.out.println("Enter the position of the number you want to remove");//position start from zero//
position_rem=sc.nextInt();
list.remove(position_rem);
System.out.println(list);
}
else if(choice==3)
{
int position_ret;
System.out.println("Enter the position of the number you want to retrieve");
position_ret=sc.nextInt();
System.out.println(list.get(position_ret));
}
else
{
x=0;
}
}
}
}