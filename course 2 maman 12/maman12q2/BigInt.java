/**
 * @Author Yam chernichovski
 * @Version 4.7
 * Maman 12, Question 2, a
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;
import static java.lang.Math.*;

public class BigInt implements Comparable<BigInt> {

    private ArrayList<Integer> num;
    private String string;
    private int sign;  //1 for positive, 0 for negative
    private Object o;

    public BigInt(String str) {  //constructor
        string = str;
        if (str.charAt(0) == '-')
            sign = 0;
        else if (str.charAt(0) == '+')
            sign = 1;
        else
            throw new IllegalArgumentException("Number must start with - or +");

        char arr[] = str.substring(1).toCharArray();
        num = new ArrayList<>();

        for (char c : arr) {
            if (c <= 57 && c >= 48)
                num.add(Character.getNumericValue(c));
            else
                throw new IllegalArgumentException("Only numbers aloud");

        }
    }

    public int getSign() { //return 1 if the sign is +, 0 if -
        return sign;
    }

    public void setSign(int s) { //change the sign of the number
        this.sign = s;
        if (s == 0) {
            this.string = "-" + this.string.substring(1);
        } else
            this.string = "+" + this.string.substring(1);
    }

    public int getSize() { //return the size of the number without the sign
        return num.size();
    }

    public ArrayList<Integer> getArr() { //return the array that represent the number
        return num;
    }

    public void setValue(int index, int value) { //set value of digit in the number
        num.add(index, value);
        num.remove(index + 1);
    }

    public void addToStart() { //add 1 to beginning of the number
        num.add(0, 1);
    }
    public void addToStartZ() { //add 0 to beginning of the number
        num.add(0, 0);
    }

    public void print() { //print the number
        System.out.println();
        if (sign == 0)
            System.out.print("-");
        else
            System.out.print("+");
        for (int i : num)
            System.out.print(i);
    }

    private String getString() { //return the string of the number
        return string;
    }

    public int getValue(int index) { //return the value of digit in index.
        return num.get(index);
    }

    public void remove(int index) { //remove digit in index
        num.remove(index);
        strUpdate();
    }

    public BigInt plus(BigInt other) { //return new big number that equals to plus of this and that numbers
        BigInt a = new BigInt(string); // a = this
        BigInt b = new BigInt(other.getString()); //b = other

        if (a.getSign() == 1 && b.getSign() == 1){ ;
            a.addToMe(b);
            return a;
        }
        else if (a.getSign() == 1 && b.getSign() == 0) {//positive + negative
            b.setSign(1);
            return a.minus(b);
        } else if (a.getSign() == 0 && b.getSign() == 1) {//negative + positive
            a.setSign(1);
            return b.minus(a);
        } else{ //negative+negative
            a.addToMe(b);
            return  a;
        }
    }

    public BigInt minus(BigInt other) { //simular to plus but minus
        BigInt a = new BigInt(string); // a = this
        BigInt b = new BigInt(other.getString()); //b = other

        if (a.getSign() == 1 && b.getSign() == 1) { //positive - positive

            if (a.compareTo(b) == -1)
                return b.minusHelper(a, 0);
            else
                return a.minusHelper(b, 1);
        } else if (a.getSign() == 1 && b.getSign() == 0) { //positive - negative
            b.setSign(1);
            b.addToMe(a);
            return b;
        } else if (a.getSign() == 0 && b.getSign() == 1) { //negative - positive
            b.setSign(0);
            b.addToMe(a);
            return b;
        } else {                                 //negative - negative
            b.setSign(1);
            a.setSign(1);
            return b.minus(a);
        }
    }

    public void makeSameSize(BigInt a,BigInt b){ //add zeros to the small number to make them same length
        int ti = a.getSize()-1; //make same size
        int oi = b.getSize()-1;
        for(;ti>=0 || oi >=0; ti--,oi--){
            if (oi<0)
                b.addToStartZ();
            if (ti<0)
                a.addToStartZ();
        }
    }

    public BigInt minusHelper(BigInt other, int ansSign) { //do only the regular minus
        makeSameSize(this,other);
        int index = this.getSize() - 1;
        while (index >= 0) {
            if ((this.getValue(index) - other.getValue(index)) < 0) {
                this.setValue(index, this.getValue(index) + 10);
                this.setValue(index - 1, this.getValue(index - 1) - 1);
            } else {
                this.setValue(index, this.getValue(index) - other.getValue(index));
                index--;
            }
        }
        for (int j = 0; j < this.getSize() - 1; j++) { //remove 0 from beginning
            if (this.getValue(j) != 0)
                break;
            else
                this.remove(j);
        }
        this.setSign(ansSign);
        this.strUpdate();
        return this;
    }

    public BigInt multiply(BigInt other) { //multiply tow numbers and teruen new one.
        BigInt ans = new BigInt("+0");
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < other.getSize(); j++) {
                StringJoiner s = new StringJoiner("");
                s.add("+");
                s.add(Integer.toString(this.getValue(i) * other.getValue(j)));
                for (int k = 0; k < ((this.getSize() - 1 - i) + (other.getSize() - 1 - j)); k++)
                    s.add("0");
                ans.addToMe(new BigInt(s.toString()));
            }
        }
        if (this.getSign()!=other.getSign())
            ans.setSign(0);
        ans.strUpdate();
        return ans;
    }

    public BigInt divide (BigInt other){ //divide two numbers and return new one.
        BigInt count = new BigInt("+0");
        BigInt a= new BigInt("+0");

        if (other.compareTo(a)==0) //if devide by zero throoe exception
            throw new ArithmeticException("Eror: Cant divide by zero.");
        else {
        while (a.compareWithoutSign(this)<0){
            a.addToMe(other);
            count.addToMe(new BigInt("+1"));
        }
        if (a.compareWithoutSign(this)==1)
            throw new ArithmeticException("Eror: No tinteger answer value");
        }
        if (this.getSign()!=other.getSign())
            count.setSign(0);
        count.strUpdate();
        return count;
    }

    @Override
    public int compareTo(BigInt o) { //like regular compare
        if (this.sign > o.getSign())                //this positive other nagative
            return 1;
        else if (this.sign < o.getSign())            //this negative other positive
            return -1;
        else if (this.sign == 1) {                      //both positive
            if (this.getSize() > o.getSize())              //this is longer
                return 1;
            else if (this.getSize() < o.getSize())        //other is longer
                return -1;
            else                                         //same length
                return this.compareSameLength(o);
        } else {                                          //both negative
            if (this.getSize() > o.getSize())             //this is longer
                return -1;
            else if (this.getSize() < o.getSize())         //other is longer
                return 1;
            else
                return (this.compareSameLength(o) * (-1));
        }
    }


    public int compareWithoutSign(BigInt o) { //compare only the numbers values

        if (this.getSize() > o.getSize())              //this is longer
            return 1;
        else if (this.getSize() < o.getSize())        //other is longer
            return -1;
        else                                         //same length
            return this.compareSameLength(o);
    }

    private int compareSameLength(BigInt o) { // compare if the numbers are same length
        int len = (this.getSize() - 1);
        int temp = 0;
        for (int i = 0; i <= len && temp == 0; i++) { //look for first bigger number
            if (this.getValue(i) > o.getValue(i))
                return 1;
            else if (this.getValue(i) < o.getValue(i))
                return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BigInt)) {
            return false;
        }
        BigInt b = (BigInt) o;

        if (this.compareTo(b) == 0) //use compare
            return true;
        else
            return false;
    }
    @Override
    public String toString(){
        return string;
        /**StringJoiner s = new StringJoiner("");
        if (this.sign==0)
            s.add("-");
        else
            s.add("+");
        for (int i=0; i<=this.getSize()-1;i++)
            s.add(Integer.toString(this.getValue(i)));
        return String.valueOf(s);
         **/
    }

    public void addToMe (BigInt other) { //ads other number to this number
         makeSameSize(this,other);
         int index = this.getSize()-1;
         while (index >= 0) {
         int x = (this.getValue(index) + other.getValue(index));
         if (index > 0) {
         this.setValue(index, x % 10);
         if (x > 9)
         this.setValue(index - 1, this.getValue(index - 1) + 1);
         } else {
         this.setValue(index, x % 10);
         if (x > 9)
         this.addToStart();
         }
         index--;
         }
         this.strUpdate();
    }
    public void strUpdate(){
        StringJoiner s = new StringJoiner("");
        if (this.sign==0)
            s.add("-");
        else
            s.add("+");
        for (int i=0; i<=this.getSize()-1;i++)
            s.add(Integer.toString(this.getValue(i)));
        this.string = String.valueOf(s);

    }

}







