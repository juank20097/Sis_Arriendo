/***********************************************************************
 * Module:  GEN_Modo.java
 * Author:  jestevez
 * Purpose: Defines the Class GEN_Modo
 ***********************************************************************/

package arriendo.entidades;

import java.util.*;

/** @pdOid 32390640-33d5-4d78-9514-9018d1873fff */
public class GEN_Modo {
   /** @pdOid 2051e979-a7c0-44fa-a6d1-cb2431bf7b6e */
   private Integer mod_id;
   /** @pdOid 148a0105-e2b8-493a-a603-530b0406e2c8 */
   private String mod_nombre;
   /** @pdOid 59031077-986f-45f9-9593-9698f55f975d */
   private String mod_descripcion;
   
   /** @pdOid 8b24ec4c-b2e2-4701-b4e5-77ca514e1416 */
   protected void finalize() {
      // TODO: implement
   }
   
   /** @pdRoleInfo migr=no name=GEN_Sitios assc=association8 coll=java.util.List mult=* */
   public java.util.List<GEN_Sitios> sit;
   
   /** @pdOid 2b39200f-2098-47cf-98f0-c757e6bbf927 */
   public GEN_Modo() {
      // TODO: implement
   }
   
   /** @pdOid 4658d3ec-5a45-48dd-baf2-68b699325d0b */
   public Integer getMod_id() {
      return mod_id;
   }
   
   /** @param newMod_id
    * @pdOid 7fa19216-9699-4c05-80f0-bb4294ccb0c9 */
   public void setMod_id(Integer newMod_id) {
      mod_id = newMod_id;
   }
   
   /** @pdOid 352ad770-c2fc-482d-bd45-558e14b97bd8 */
   public String getMod_nombre() {
      return mod_nombre;
   }
   
   /** @param newMod_nombre
    * @pdOid 67fda370-d573-47bb-9151-f29171008fa2 */
   public void setMod_nombre(String newMod_nombre) {
      mod_nombre = newMod_nombre;
   }
   
   /** @pdOid 4d770dd9-1c53-4cd2-aafe-6666e3f7f4c8 */
   public String getMod_descripcion() {
      return mod_descripcion;
   }
   
   /** @param newMod_descripcion
    * @pdOid 64a97e72-ec90-4267-bdc4-d2d54270b30a */
   public void setMod_descripcion(String newMod_descripcion) {
      mod_descripcion = newMod_descripcion;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<GEN_Sitios> getSit() {
      if (sit == null)
         sit = new java.util.Vector<GEN_Sitios>();
      return sit;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSit() {
      if (sit == null)
         sit = new java.util.Vector<GEN_Sitios>();
      return sit.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSit */
   public void setSit(java.util.List<GEN_Sitios> newSit) {
      removeAllSit();
      for (java.util.Iterator iter = newSit.iterator(); iter.hasNext();)
         addSit((GEN_Sitios)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newGEN_Sitios */
   public void addSit(GEN_Sitios newGEN_Sitios) {
      if (newGEN_Sitios == null)
         return;
      if (this.sit == null)
         this.sit = new java.util.Vector<GEN_Sitios>();
      if (!this.sit.contains(newGEN_Sitios))
      {
         this.sit.add(newGEN_Sitios);
         newGEN_Sitios.setMod(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldGEN_Sitios */
   public void removeSit(GEN_Sitios oldGEN_Sitios) {
      if (oldGEN_Sitios == null)
         return;
      if (this.sit != null)
         if (this.sit.contains(oldGEN_Sitios))
         {
            this.sit.remove(oldGEN_Sitios);
            oldGEN_Sitios.setMod((GEN_Modo)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSit() {
      if (sit != null)
      {
         GEN_Sitios oldGEN_Sitios;
         for (java.util.Iterator iter = getIteratorSit(); iter.hasNext();)
         {
            oldGEN_Sitios = (GEN_Sitios)iter.next();
            iter.remove();
            oldGEN_Sitios.setMod((GEN_Modo)null);
         }
      }
   }

}