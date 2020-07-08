/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feetinches;

import javax.swing.JFrame;

/**
 *
 * @author 18660
 */
public class FeetInches {
    private int feet;
    private int inch;
    
    FeetInches(){
        this.feet = 0;
        this.inch = 0;
    }
    FeetInches(int f , int i){
        this.feet = f;
        this.inch = i;
        this.simplify();
    }
    FeetInches(FeetInches c){
        this.feet = c.feet;
        this.inch = c.inch;
        
    }
    /*simplify This method adjusts any set of values where the inches field is greater than 11. For example, 3 feet 14 inches would be adjusted to read 4 feet 2 inches.*/
    public void simplify(){
        int val = this.inch;
        do{
            if(val>11){
                this.feet++;
                this.inch-=12;
            }
        }while(this.inch>11);
    }
    /*add This method accepts a FeetInches object as its argument. It returns a reference to a FeetInches object that is the sum of the calling object and the object that was passed as the argument. */
    public FeetInches add(FeetInches obj1){
        FeetInches obj2 = new FeetInches();
        obj2.feet = this.feet + obj1.feet;
        obj2.inch = this.inch + obj2.inch;
        
        return obj2;
    }
    /*This method accepts a FeetInches object as its argument. It returns the boolean value true if the calling object and the argument object hold the same data. Otherwise it returns false. */
    public boolean equals(FeetInches obj1){
        if(this.feet == obj1.feet && this.inch == obj1.inch){
            return true;
        }
        else return false;   
    }
    /*copy This method returns a reference to a new FeetInches object that is a copy of the calling object. */
    public FeetInches copy(){
        return new FeetInches(this.feet,this.inch);
    }
    
    public void setFeet(int f){
        this.feet = f;
    }
    public void setInches(int i){
        this.inch = i;
    }
    
    public int getFeet(){
        return this.feet;
    }
    public int getInches(){
        return this.inch ;
    }
    
    public String toString(){
        String str = this.feet + " feet " + this.inch + " inches";
        return str;
    }
      
}

