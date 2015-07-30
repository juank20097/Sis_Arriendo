/***********************************************************************
 * Module:  GenModo.java
 * Author:  jestevez
 * Purpose: Defines the Class GenModo
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 32390640-33d5-4d78-9514-9018d1873fff */
public class GenModo {
   /** @pdOid 2051e979-a7c0-44fa-a6d1-cb2431bf7b6e */
   private int modId;
   /** @pdOid 148a0105-e2b8-493a-a603-530b0406e2c8 */
   private int modNombre;
   /** @pdOid 59031077-986f-45f9-9593-9698f55f975d */
   private int modDescripcion;
   
   /** @pdOid 8b24ec4c-b2e2-4701-b4e5-77ca514e1416 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenSitios assc=association8 coll=java.util.List mult=* */
   public java.util.List<GenSitios> sit;
   
   /** @pdOid 2b39200f-2098-47cf-98f0-c757e6bbf927 */
   public GenModo() {
      // TODO: implement
   }
   
   /** @pdOid 4658d3ec-5a45-48dd-baf2-68b699325d0b */
   public int getModId() {
      return modId;
   }
   
   /** @param newModId
    * @pdOid 7fa19216-9699-4c05-80f0-bb4294ccb0c9 */
   public void setModId(int newModId) {
      modId = newModId;
   }
   
   /** @pdOid 352ad770-c2fc-482d-bd45-558e14b97bd8 */
   public int getModNombre() {
      return modNombre;
   }
   
   /** @param newModNombre
    * @pdOid 67fda370-d573-47bb-9151-f29171008fa2 */
   public void setModNombre(int newModNombre) {
      modNombre = newModNombre;
   }
   
   /** @pdOid 4d770dd9-1c53-4cd2-aafe-6666e3f7f4c8 */
   public int getModDescripcion() {
      return modDescripcion;
   }
   
   /** @param newModDescripcion
    * @pdOid 64a97e72-ec90-4267-bdc4-d2d54270b30a */
   public void setModDescripcion(int newModDescripcion) {
      modDescripcion = newModDescripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GenSitios> getSit() {
      if (sit == null)
         sit = new java.util.Vector<GenSitios>();
      return sit;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSit() {
      if (sit == null)
         sit = new java.util.Vector<GenSitios>();
      return sit.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSit */
   public void setSit(java.util.List<GenSitios> newSit) {
      removeAllSit();
      for (java.util.Iterator iter = newSit.iterator(); iter.hasNext();)
         addSit((GenSitios)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGenSitios */
   public void addSit(GenSitios newGenSitios) {
      if (newGenSitios == null)
         return;
      if (this.sit == null)
         this.sit = new java.util.Vector<GenSitios>();
      if (!this.sit.contains(newGenSitios))
      {
         this.sit.add(newGenSitios);
         newGenSitios.setMod(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGenSitios */
   public void removeSit(GenSitios oldGenSitios) {
      if (oldGenSitios == null)
         return;
      if (this.sit != null)
         if (this.sit.contains(oldGenSitios))
         {
            this.sit.remove(oldGenSitios);
            oldGenSitios.setMod((GenModo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSit() {
      if (sit != null)
      {
         GenSitios oldGenSitios;
         for (java.util.Iterator iter = getIteratorSit(); iter.hasNext();)
         {
            oldGenSitios = (GenSitios)iter.next();
            iter.remove();
            oldGenSitios.setMod((GenModo)null);
         }
      }
   }

}