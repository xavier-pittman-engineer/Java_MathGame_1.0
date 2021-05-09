package com.mycompany.mathgame;

public class Listing
{
   String name;      // Key Field


   public Listing( String n)
   {
      name = n;
         }  // End of Listing, Constructor
   
   public void setName(String n){
   name = n;}

   public String toString( )
   {
      return( "The problem " + name);
   }  // End of toString


   public Listing deepCopy( )
   {
      Listing clone = new Listing( name);
      return clone;
   }  // End of deepCopy


   public int compareTo( String targetKey )
   {
      return( name.compareTo( targetKey ) );
   }  // End of compareTo

}  // End of Listing