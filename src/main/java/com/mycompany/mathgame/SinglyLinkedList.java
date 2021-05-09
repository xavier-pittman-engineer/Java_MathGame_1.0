package com.mycompany.mathgame;


public class SinglyLinkedList {

    private Node h;   // List Header


   public SinglyLinkedList( )
   {
      h = new Node( );   // Dummy Node
      h.l = null;
      h.next = null;
   }  // End of SinglyLinkedList, Constructor


   public boolean insert( Listing newListing )
   {
      Node n = new Node( );
    
      if ( n == null )   // Out of Memory
        return false;
      else
      {
         n.next = h.next;
         h.next = n;
         n.l = newListing.deepCopy( );
         return true;
      }  // End of else
   }  // End of insert


   public Listing fetch( String targetKey )
   {
      Node p = h.next;
      
      while( p != null && !(p.l.compareTo( targetKey ) == 0 ) )
      {
         p = p.next;
      }

      if ( p != null )
        return p.l.deepCopy( );
      else return null;
   }  // End of fetch


   public boolean delete( String targetKey )
   {
      Node q = h;
      Node p = h.next;
      
      while( p != null && !(p.l.compareTo( targetKey ) == 0 ) )
      {
         q = p;
         p = p.next;
      }

      if ( p != null )
      {
        q.next = p.next;
        return true;
      }
      else return false;

   }  // End of delete


   public boolean update( String targetKey, Listing newListing )
   {
      if ( delete( targetKey ) == false )
        return false;
      else if ( insert( newListing ) == false )
             return false;
      
      return true;
   }  // End of update


   public void showAll( )
   {
      Node p = h.next;

      while( p != null )   // Continue to traverse the list.
      {
         System.out.println( p.l.toString( ) );
         p = p.next;
      }  // End of while
   }  // End of showAll


   public class Node
   {
      private Listing l;
      private Node    next;

      public Node( ) { }
   }  // End of Inner Class Node
}  // End of SinglyLinkedList