/***********************************************************************
 * Module:  ARR_Clausulas.java
 * Author:  jestevez
 * Purpose: Defines the Class ARR_Clausulas
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid b5403d3b-29f6-4b3f-a800-0871eb83db32 */
public class ARR_Clausulas {
   /** @pdOid ec1c86d6-7ca9-42cb-93ca-de673bb26718 */
   private Integer cla_id;
   /** @pdOid b86c73ce-c488-48d4-ad4b-63e4da5fc1ae */
   private String cla_nombre;
   /** @pdOid dab99436-4422-43d7-ad7e-e5141f26e012 */
   private String cla_descripcion;
   
   /** @pdOid 8bc2836c-5402-45ce-9f56-be74abf39212 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=ARR_Items assc=association6 coll=java.util.List mult=* */
   public java.util.List<ARR_Items> ite;
   /** @pdRoleInfo migr=no name=ARR_Inter_Cla assc=association5 coll=java.util.List mult=* side=A */
   public java.util.List<ARR_Inter_Cla> intc;
   
   /** @pdOid 437fc6c9-2f48-4165-9af7-f324cd8c1c1c */
   public ARR_Clausulas() {
      // TODO: implement
   }
   
   /** @pdOid 8a4503c1-e886-479c-9521-cdad551955a3 */
   public Integer getCla_id() {
      return cla_id;
   }
   
   /** @param newCla_id
    * @pdOid 406d9b0a-003e-4efa-b9b8-18280e034496 */
   public void setCla_id(Integer newCla_id) {
      cla_id = newCla_id;
   }
   
   /** @pdOid 0bec3b45-ef07-4850-b995-320a34442202 */
   public String getCla_nombre() {
      return cla_nombre;
   }
   
   /** @param newCla_nombre
    * @pdOid e30d2952-bae2-472e-8eaf-5158599cba5a */
   public void setCla_nombre(String newCla_nombre) {
      cla_nombre = newCla_nombre;
   }
   
   /** @pdOid ed665e86-df04-4a35-b07e-da06c2d7b08c */
   public String getCla_descripcion() {
      return cla_descripcion;
   }
   
   /** @param newCla_descripcion
    * @pdOid 8582c2c7-ed2e-44c1-86ce-8f830b745df6 */
   public void setCla_descripcion(String newCla_descripcion) {
      cla_descripcion = newCla_descripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<ARR_Items> getIte() {
      if (ite == null)
         ite = new java.util.Vector<ARR_Items>();
      return ite;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIte() {
      if (ite == null)
         ite = new java.util.Vector<ARR_Items>();
      return ite.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIte */
   public void setIte(java.util.List<ARR_Items> newIte) {
      removeAllIte();
      for (java.util.Iterator iter = newIte.iterator(); iter.hasNext();)
         addIte((ARR_Items)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Items */
   public void addIte(ARR_Items newARR_Items) {
      if (newARR_Items == null)
         return;
      if (this.ite == null)
         this.ite = new java.util.Vector<ARR_Items>();
      if (!this.ite.contains(newARR_Items))
      {
         this.ite.add(newARR_Items);
         newARR_Items.setCla(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Items */
   public void removeIte(ARR_Items oldARR_Items) {
      if (oldARR_Items == null)
         return;
      if (this.ite != null)
         if (this.ite.contains(oldARR_Items))
         {
            this.ite.remove(oldARR_Items);
            oldARR_Items.setCla((ARR_Clausulas)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIte() {
      if (ite != null)
      {
         ARR_Items oldARR_Items;
         for (java.util.Iterator iter = getIteratorIte(); iter.hasNext();)
         {
            oldARR_Items = (ARR_Items)iter.next();
            iter.remove();
            oldARR_Items.setCla((ARR_Clausulas)null);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<ARR_Inter_Cla> getIntc() {
      if (intc == null)
         intc = new java.util.Vector<ARR_Inter_Cla>();
      return intc;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorIntc() {
      if (intc == null)
         intc = new java.util.Vector<ARR_Inter_Cla>();
      return intc.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newIntc */
   public void setIntc(java.util.List<ARR_Inter_Cla> newIntc) {
      removeAllIntc();
      for (java.util.Iterator iter = newIntc.iterator(); iter.hasNext();)
         addIntc((ARR_Inter_Cla)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newARR_Inter_Cla */
   public void addIntc(ARR_Inter_Cla newARR_Inter_Cla) {
      if (newARR_Inter_Cla == null)
         return;
      if (this.intc == null)
         this.intc = new java.util.Vector<ARR_Inter_Cla>();
      if (!this.intc.contains(newARR_Inter_Cla))
      {
         this.intc.add(newARR_Inter_Cla);
         newARR_Inter_Cla.setCla(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldARR_Inter_Cla */
   public void removeIntc(ARR_Inter_Cla oldARR_Inter_Cla) {
      if (oldARR_Inter_Cla == null)
         return;
      if (this.intc != null)
         if (this.intc.contains(oldARR_Inter_Cla))
         {
            this.intc.remove(oldARR_Inter_Cla);
            oldARR_Inter_Cla.setCla((ARR_Clausulas)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllIntc() {
      if (intc != null)
      {
         ARR_Inter_Cla oldARR_Inter_Cla;
         for (java.util.Iterator iter = getIteratorIntc(); iter.hasNext();)
         {
            oldARR_Inter_Cla = (ARR_Inter_Cla)iter.next();
            iter.remove();
            oldARR_Inter_Cla.setCla((ARR_Clausulas)null);
         }
      }
   }

}