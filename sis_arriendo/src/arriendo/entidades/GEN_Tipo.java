/***********************************************************************
 * Module:  GEN_Tipo.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Tipo
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 59c240b7-00c5-4fff-a366-dad0c8a5606f */
public class GEN_Tipo {
   /** @pdOid a34bc114-1f3f-425e-aac3-d0c81757fd77 */
   private Integer tip_id;
   /** @pdOid 832f165e-6a04-46f3-9d5d-4ce8f9f1aeb3 */
   private String tip_tipo;
   /** @pdOid fe371cc5-e085-4cdc-8265-47f3714bea30 */
   private String tip_descripcion;
   
   /** @pdOid 6820a2f2-2cf5-4be6-806e-a0c7f9804a58 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Persona assc=association7 coll=java.util.List mult=* side=A */
   public java.util.List<GEN_Persona> per;
   
   /** @pdOid 89990068-e2f6-4bb6-b8db-2a474b5bb34d */
   public GEN_Tipo() {
      // TODO: implement
   }
   
   /** @pdOid a1d9223c-394b-4359-9fcd-57779881eccd */
   public Integer getTip_id() {
      return tip_id;
   }
   
   /** @param newTip_id
    * @pdOid f7e27978-4e29-4df9-b421-7b552a1a3928 */
   public void setTip_id(Integer newTip_id) {
      tip_id = newTip_id;
   }
   
   /** @pdOid 4c83922f-4de0-464b-9d05-059a08e0efd9 */
   public String getTip_tipo() {
      return tip_tipo;
   }
   
   /** @param newTip_tipo
    * @pdOid d3344688-44d4-44dd-87c5-f7d5bab789ca */
   public void setTip_tipo(String newTip_tipo) {
      tip_tipo = newTip_tipo;
   }
   
   /** @pdOid dec1af90-2a09-4637-86d7-24d43aa7cff5 */
   public String getTip_descripcion() {
      return tip_descripcion;
   }
   
   /** @param newTip_descripcion
    * @pdOid 0556f77d-b1c2-443c-9dcc-dcf5c18fd946 */
   public void setTip_descripcion(String newTip_descripcion) {
      tip_descripcion = newTip_descripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Persona> getPer() {
      if (per == null)
         per = new java.util.Vector<GEN_Persona>();
      return per;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorPer() {
      if (per == null)
         per = new java.util.Vector<GEN_Persona>();
      return per.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newPer */
   public void setPer(java.util.List<GEN_Persona> newPer) {
      removeAllPer();
      for (java.util.Iterator iter = newPer.iterator(); iter.hasNext();)
         addPer((GEN_Persona)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Persona */
   public void addPer(GEN_Persona newGEN_Persona) {
      if (newGEN_Persona == null)
         return;
      if (this.per == null)
         this.per = new java.util.Vector<GEN_Persona>();
      if (!this.per.contains(newGEN_Persona))
      {
         this.per.add(newGEN_Persona);
         newGEN_Persona.setTip(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Persona */
   public void removePer(GEN_Persona oldGEN_Persona) {
      if (oldGEN_Persona == null)
         return;
      if (this.per != null)
         if (this.per.contains(oldGEN_Persona))
         {
            this.per.remove(oldGEN_Persona);
            oldGEN_Persona.setTip((GEN_Tipo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllPer() {
      if (per != null)
      {
         GEN_Persona oldGEN_Persona;
         for (java.util.Iterator iter = getIteratorPer(); iter.hasNext();)
         {
            oldGEN_Persona = (GEN_Persona)iter.next();
            iter.remove();
            oldGEN_Persona.setTip((GEN_Tipo)null);
         }
      }
   }

}