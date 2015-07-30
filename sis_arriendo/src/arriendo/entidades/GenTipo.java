/***********************************************************************
 * Module:  GenTipo.java
 * Author:  jestevez
 * Purpose: Defines the Class GenTipo
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 59c240b7-00c5-4fff-a366-dad0c8a5606f */
public class GenTipo {
   /** @pdOid a34bc114-1f3f-425e-aac3-d0c81757fd77 */
   private Integer tipId;
   /** @pdOid 832f165e-6a04-46f3-9d5d-4ce8f9f1aeb3 */
   private String tipTipo;
   /** @pdOid fe371cc5-e085-4cdc-8265-47f3714bea30 */
   private String tipDescripcion;
   
   /** @pdOid 6820a2f2-2cf5-4be6-806e-a0c7f9804a58 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GenPersona assc=association7 coll=java.util.List mult=* side=A */
   public java.util.List<GenPersona> per;
   
   /** @pdOid 89990068-e2f6-4bb6-b8db-2a474b5bb34d */
   public GenTipo() {
      // TODO: implement
   }
   
   /** @pdOid a1d9223c-394b-4359-9fcd-57779881eccd */
   public Integer getTipId() {
      return tipId;
   }
   
   /** @param newTipId
    * @pdOid f7e27978-4e29-4df9-b421-7b552a1a3928 */
   public void setTipId(Integer newTipId) {
      tipId = newTipId;
   }
   
   /** @pdOid 4c83922f-4de0-464b-9d05-059a08e0efd9 */
   public String getTipTipo() {
      return tipTipo;
   }
   
   /** @param newTipTipo
    * @pdOid d3344688-44d4-44dd-87c5-f7d5bab789ca */
   public void setTipTipo(String newTipTipo) {
      tipTipo = newTipTipo;
   }
   
   /** @pdOid dec1af90-2a09-4637-86d7-24d43aa7cff5 */
   public String getTipDescripcion() {
      return tipDescripcion;
   }
   
   /** @param newTipDescripcion
    * @pdOid 0556f77d-b1c2-443c-9dcc-dcf5c18fd946 */
   public void setTipDescripcion(String newTipDescripcion) {
      tipDescripcion = newTipDescripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GenPersona> getPer() {
      if (per == null)
         per = new java.util.Vector<GenPersona>();
      return per;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPer() {
      if (per == null)
         per = new java.util.Vector<GenPersona>();
      return per.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPer */
   public void setPer(java.util.List<GenPersona> newPer) {
      removeAllPer();
      for (java.util.Iterator iter = newPer.iterator(); iter.hasNext();)
         addPer((GenPersona)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGenPersona */
   public void addPer(GenPersona newGenPersona) {
      if (newGenPersona == null)
         return;
      if (this.per == null)
         this.per = new java.util.Vector<GenPersona>();
      if (!this.per.contains(newGenPersona))
      {
         this.per.add(newGenPersona);
         newGenPersona.setTip(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGenPersona */
   public void removePer(GenPersona oldGenPersona) {
      if (oldGenPersona == null)
         return;
      if (this.per != null)
         if (this.per.contains(oldGenPersona))
         {
            this.per.remove(oldGenPersona);
            oldGenPersona.setTip((GenTipo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPer() {
      if (per != null)
      {
         GenPersona oldGenPersona;
         for (java.util.Iterator iter = getIteratorPer(); iter.hasNext();)
         {
            oldGenPersona = (GenPersona)iter.next();
            iter.remove();
            oldGenPersona.setTip((GenTipo)null);
         }
      }
   }

}